package lab3_1;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceRequest;
import static org.mockito.Mockito.when;
public class BookKeeperTest {
	@Test
	public void RequestForSinglePositionInvoiceShouldReturnIt(){
		
		//Arrange
		InvoiceFactory invoicer = Mockito.mock(InvoiceFactory.class);
		InvoiceRequest request = Mockito.mock(InvoiceRequest.class);
		ClientData client = Mockito.mock(ClientData.class);
		Invoice invoice = Mockito.mock(Invoice.class);
		//Act
		
		when(invoicer.create(client)).thenReturn(invoice);
		//when(request.)
		//Assert
		//assertThat(actual, matcher);
	}
}
