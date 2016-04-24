package builder;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.RequestItem;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

/**
 * Created by mariusz on 09.04.16.
 */
public class RequestItemBuilder {
    private ProductData productData = new ProductData(Id.generate(),
            new MoneyBuilder().build(), "Test Item", ProductType.DRUG, new Date());

    private int quantity = 1;

    private Money totalCost = new MoneyBuilder().build();

    public RequestItemBuilder() {

    }

    public RequestItemBuilder withProductData(ProductData productData) {
        this.productData = productData;
        return this;
    }

    public RequestItemBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public RequestItemBuilder withTotalCost(Money totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    public RequestItem build() {
        return new RequestItem(productData, quantity, totalCost);
    }
}
