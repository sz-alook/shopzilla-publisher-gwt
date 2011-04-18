package com.shopzilla.publisher.rich.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.shopzilla.publisher.rich.client.managed.request.ApplicationRequestFactory;
import com.shopzilla.publisher.rich.client.managed.request.ProductProxy;
import com.shopzilla.publisher.rich.client.managed.request.ProductRequest;
import com.shopzilla.publisher.rich.client.managed.ui.ProductDetailsView;
import com.shopzilla.publisher.rich.client.managed.ui.ProductEditView;
import com.shopzilla.publisher.rich.client.managed.ui.ProductListView;
import com.shopzilla.publisher.rich.client.managed.ui.ProductMobileDetailsView;
import com.shopzilla.publisher.rich.client.managed.ui.ProductMobileEditView;
import com.shopzilla.publisher.rich.client.scaffold.ScaffoldApp;
import com.shopzilla.publisher.rich.client.scaffold.place.CreateAndEditProxy;
import com.shopzilla.publisher.rich.client.scaffold.place.FindAndEditProxy;
import com.shopzilla.publisher.rich.client.scaffold.place.ProxyPlace;

public class ProductActivitiesMapper {

    private final ApplicationRequestFactory requests;

    private final PlaceController placeController;

    public ProductActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new ProductDetailsActivity((EntityProxyId<ProductProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? ProductMobileDetailsView.instance() : ProductDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }

    @SuppressWarnings("unchecked")
    private EntityProxyId<com.shopzilla.publisher.rich.client.managed.request.ProductProxy> coerceId(ProxyPlace place) {
        return (EntityProxyId<ProductProxy>) place.getProxyId();
    }

    private Activity makeCreateActivity() {
        ProductEditView.instance().setCreating(true);
        final ProductRequest request = requests.productRequest();
        Activity activity = new CreateAndEditProxy<ProductProxy>(ProductProxy.class, request, ScaffoldApp.isMobile() ? ProductMobileEditView.instance() : ProductEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(ProductProxy proxy) {
                request.persist().using(proxy);
                return request;
            }
        };
        return new ProductEditActivityWrapper(requests, ScaffoldApp.isMobile() ? ProductMobileEditView.instance() : ProductEditView.instance(), activity, null);
    }

    private Activity makeEditActivity(ProxyPlace place) {
        ProductEditView.instance().setCreating(false);
        EntityProxyId<ProductProxy> proxyId = coerceId(place);
        Activity activity = new FindAndEditProxy<ProductProxy>(proxyId, requests, ScaffoldApp.isMobile() ? ProductMobileEditView.instance() : ProductEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(ProductProxy proxy) {
                ProductRequest request = requests.productRequest();
                request.persist().using(proxy);
                return request;
            }
        };
        return new ProductEditActivityWrapper(requests, ScaffoldApp.isMobile() ? ProductMobileEditView.instance() : ProductEditView.instance(), activity, proxyId);
    }
}
