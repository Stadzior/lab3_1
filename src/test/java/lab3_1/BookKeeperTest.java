package lab3_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.sales.domain.invoicing.*;

import static org.mockito.Mockito.when;

public class BookKeeperTest {
    InvoiceFactory invoicer;
    InvoiceRequest request;
    TaxPolicy policy;
    ClientData client;
    Invoice invoice;
    InvoiceLine invoiceLine;
    @Before
    public void initialize(){
        invoicer = Mockito.mock(InvoiceFactory.class);
        request = Mockito.mock(InvoiceRequest.class);
        policy = Mockito.mock(TaxPolicy.class);
        client = Mockito.mock(ClientData.class);
        invoice = Mockito.mock(Invoice.class);
        invoiceLine = Mockito.mock(InvoiceLine.class);
    }
	@Test
	public void ShouldReturnSinglePositionInvoice_WhenRequestedSinglePositionInvoice(){
		
		//Arrange


		
		//Act
		
		invoicer.create(client);
		//when(request.)
		//Assert
		//assertThat(actual, matcher);
	}
}
