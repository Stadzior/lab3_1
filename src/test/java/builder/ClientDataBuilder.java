package builder;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

/**
 * Created by mariusz on 09.04.16.
 */
public class ClientDataBuilder {

    private Id id = Id.generate();
    private String name = "Kamil";

    public ClientDataBuilder() {

    }

    public ClientDataBuilder withId(Id id) {
        this.id = id;
        return this;
    }

    public ClientDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ClientData build() {
        return new ClientData(id, name);
    }
}
