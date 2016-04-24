package builder;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceRequest;
import pl.com.bottega.ecommerce.sales.domain.invoicing.RequestItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mariusz on 09.04.16.
 */
public class InvoiceRequestBuilder {
    private ClientData client = new ClientData(Id.generate(),"Mariusz");
    private List<RequestItem> items = new ArrayList<RequestItem>();

    public InvoiceRequestBuilder() {
    }

    public InvoiceRequestBuilder withClientData(ClientData clientData){
        this.client = clientData;
        return this;
    }

    public InvoiceRequest build(){
        return new InvoiceRequest(client);
    }
}
