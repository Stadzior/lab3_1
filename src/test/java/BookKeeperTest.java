import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.*;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;


import java.util.Date;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;

public class BookKeeperTest {
    InvoiceFactory invoicer;
    InvoiceRequest request;
    TaxPolicy policy;
    ClientData client;
    BookKeeper bookKeeper;
    ProductData data;
    RequestItem item;

    @Before
    public void initialize(){
        Money money = new Money(1);
        invoicer = Mockito.mock(InvoiceFactory.class);
        client = new ClientData(Id.generate(),"John");
        when(invoicer.create(client)).thenReturn(new Invoice(Id.generate(), client));

        bookKeeper = new BookKeeper(invoicer);
        data = new ProductData(Id.generate(),money,"Test", ProductType.DRUG,new Date());
        item = new RequestItem(data,1,data.getPrice());
        policy = Mockito.mock(TaxPolicy.class);
        when(policy.calculateTax(data.getType(),data.getPrice())).thenReturn(new Tax(money, ""));

        request = new InvoiceRequest(client);

    }

	@Test
	public void ShouldReturnSinglePositionInvoice_WhenRequestedSinglePositionInvoice(){
		
		//Arrange
        request.add(item);
		
		//Act
		Invoice invoice = bookKeeper.issuance(request,policy);

		//Assert
        Assert.assertThat(invoice.getItems().size(),equalTo(1));
	}

    @Test
    public void ShouldCallCalculateTaxTwice_WhenRequestedTwoPositionInvoice(){

        //Arrange
        request.add(item);
        request.add(item);

        //Act
        Invoice invoice = bookKeeper.issuance(request,policy);

        //Assert
        Mockito.verify(policy, Mockito.times(2)).calculateTax(data.getType(), data.getPrice());
    }

    @Test
    public void ShouldReturnEmptyInvoice_WhenRequestedInvoiceWithoutPositions(){

        //Arrange

        //Act
        Invoice invoice = bookKeeper.issuance(request,policy);

        //Assert
        Assert.assertThat(invoice.getItems().size(),equalTo(0));
    }

    @Test
    public void ShouldCallInvoiceFactoryCreate_WhetherOrNotRequestIncludesPositions(){

        //Arrange
        request.add(item);
        request.add(item);

        //Act
        Invoice invoice = bookKeeper.issuance(request,policy);

        //Assert
        Mockito.verify(invoicer, Mockito.atLeastOnce()).create(client);
    }
}
