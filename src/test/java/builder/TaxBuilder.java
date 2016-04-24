package builder;

import pl.com.bottega.ecommerce.sales.domain.invoicing.Tax;
import pl.com.bottega.ecommerce.sharedkernel.Money;

/**
 * Created by mariusz on 09.04.16.
 */
public class TaxBuilder {
    private Money amount = new Money(1,"EUR");

    private String description = "Test tax";

    public TaxBuilder() {
    }

    public TaxBuilder withAmount(Money amount) {
        this.amount = amount;
        return this;
    }

    public TaxBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public Tax build() {
        return new Tax(amount, description);
    }
}
