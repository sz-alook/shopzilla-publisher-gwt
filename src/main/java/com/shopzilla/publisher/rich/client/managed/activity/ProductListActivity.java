package com.shopzilla.publisher.rich.client.managed.activity;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.view.client.Range;
import com.shopzilla.publisher.rich.client.managed.request.ApplicationRequestFactory;
import com.shopzilla.publisher.rich.client.managed.request.ProductProxy;
import com.shopzilla.publisher.rich.client.scaffold.ScaffoldMobileApp;
import com.shopzilla.publisher.rich.client.scaffold.activity.IsScaffoldMobileActivity;
import com.shopzilla.publisher.rich.client.scaffold.place.AbstractProxyListActivity;
import com.shopzilla.publisher.rich.client.scaffold.place.ProxyListView;
import java.util.List;

public class ProductListActivity extends AbstractProxyListActivity<ProductProxy> implements IsScaffoldMobileActivity {

    private final ApplicationRequestFactory requests;

    public ProductListActivity(ApplicationRequestFactory requests, ProxyListView<com.shopzilla.publisher.rich.client.managed.request.ProductProxy> view, PlaceController placeController) {
        super(placeController, view, ProductProxy.class);
        this.requests = requests;
    }

    public Place getBackButtonPlace() {
        return ScaffoldMobileApp.ROOT_PLACE;
    }

    public String getBackButtonText() {
        return "Entities";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return "Products";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<com.shopzilla.publisher.rich.client.managed.request.ProductProxy>> createRangeRequest(Range range) {
        return requests.productRequest().findProductEntries(range.getStart(), range.getLength());
    }

    protected void fireCountRequest(Receiver<Long> callback) {
        requests.productRequest().countProducts().fire(callback);
    }
}
