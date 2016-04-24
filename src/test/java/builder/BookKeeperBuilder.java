package builder;

import pl.com.bottega.ecommerce.sales.domain.invoicing.BookKeeper;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;

/**
 * Created by mariusz on 09.04.16.
 */
public class BookKeeperBuilder {

    private InvoiceFactory invoiceFactory = new InvoiceFactory();

    public BookKeeperBuilder() {
    }

    public BookKeeperBuilder withInvoiceFactory(InvoiceFactory invoiceFactory) {
        this.invoiceFactory = invoiceFactory;
        return this;
    }

    public BookKeeper build() {
        return new BookKeeper(invoiceFactory);
    }
}
