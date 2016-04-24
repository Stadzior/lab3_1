package builder;

import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by mariusz on 09.04.16.
 */
public class MoneyBuilder {

    private BigDecimal denomination = new BigDecimal(1);

    private String currencyCode = "EUR";

    public MoneyBuilder() {
    }

    public MoneyBuilder withDenomination(BigDecimal denomination) {
        this.denomination = denomination;
        return this;
    }

    public MoneyBuilder withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public Money build() {
        return new Money(denomination, Currency.getInstance(currencyCode));
    }
}
