package com.shopzilla.publisher.rich.client.managed.ui;

import com.google.gwt.requestfactory.ui.client.ProxyRenderer;
import com.shopzilla.publisher.rich.client.managed.request.ProductProxy;

public class ProductProxyRenderer extends ProxyRenderer<ProductProxy> {

    private static com.shopzilla.publisher.rich.client.managed.ui.ProductProxyRenderer INSTANCE;

    protected ProductProxyRenderer() {
        super(new String[] { "title" });
    }

    public static com.shopzilla.publisher.rich.client.managed.ui.ProductProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new ProductProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(ProductProxy object) {
        if (object == null) {
            return "";
        }
        return object.getTitle() + " (" + object.getId() + ")";
    }
}
