package builder;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

/**
 * Created by mariusz on 09.04.16.
 */
public class ProductDataBuilder {
    private Id productId = Id.generate();
    private Money price = new MoneyBuilder().build();

    private String name = "Test Product";

    private Date snapshotDate = new Date();

    private ProductType type = ProductType.STANDARD;

    public ProductDataBuilder() {
    }

    public ProductDataBuilder withProductId(Id productId) {
        this.productId = productId;
        return this;
    }

    public ProductDataBuilder withPrice(Money price) {
        this.price = price;
        return this;
    }

    public ProductDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductDataBuilder withSnapshotDate(Date snapshotDate) {
        this.snapshotDate = snapshotDate;
        return this;
    }

    public ProductDataBuilder withType(ProductType type) {
        this.type = type;
        return this;
    }

    public ProductData build() {
        return new ProductData(productId, price, name, type, snapshotDate);
    }
}
