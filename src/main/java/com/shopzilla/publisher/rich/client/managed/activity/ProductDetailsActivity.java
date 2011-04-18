package com.shopzilla.publisher.rich.client.managed.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.shopzilla.publisher.rich.client.managed.request.ApplicationRequestFactory;
import com.shopzilla.publisher.rich.client.managed.request.ProductProxy;
import com.shopzilla.publisher.rich.client.scaffold.activity.IsScaffoldMobileActivity;
import com.shopzilla.publisher.rich.client.scaffold.place.ProxyDetailsView;
import com.shopzilla.publisher.rich.client.scaffold.place.ProxyListPlace;
import com.shopzilla.publisher.rich.client.scaffold.place.ProxyPlace;
import com.shopzilla.publisher.rich.client.scaffold.place.ProxyPlace.Operation;
import java.util.Set;

public class ProductDetailsActivity extends ProductDetailsActivity_Roo_Gwt {

    private final PlaceController placeController;

    private final ProxyDetailsView<ProductProxy> view;

    private AcceptsOneWidget display;

    public ProductDetailsActivity(EntityProxyId<com.shopzilla.publisher.rich.client.managed.request.ProductProxy> proxyId, ApplicationRequestFactory requests, PlaceController placeController, ProxyDetailsView<com.shopzilla.publisher.rich.client.managed.request.ProductProxy> view) {
        this.placeController = placeController;
        this.proxyId = proxyId;
        this.requests = requests;
        view.setDelegate(this);
        this.view = view;
    }

    public void deleteClicked() {
        if (!view.confirm("Really delete this entry? You cannot undo this change.")) {
            return;
        }
        requests.productRequest().remove().using(view.getValue()).fire(new Receiver<Void>() {

            public void onSuccess(Void ignore) {
                if (display == null) {
                    return;
                }
                placeController.goTo(getBackButtonPlace());
            }
        });
    }

    public void editClicked() {
        placeController.goTo(getEditButtonPlace());
    }

    public Place getBackButtonPlace() {
        return new ProxyListPlace(ProductProxy.class);
    }

    public String getBackButtonText() {
        return "Back";
    }

    public Place getEditButtonPlace() {
        return new ProxyPlace(view.getValue().stableId(), Operation.EDIT);
    }

    public String getTitleText() {
        return "View Product";
    }

    public boolean hasEditButton() {
        return true;
    }

    public void onCancel() {
        onStop();
    }

    public void onStop() {
        display = null;
    }

    public void start(AcceptsOneWidget displayIn, EventBus eventBus) {
        this.display = displayIn;
        Receiver<EntityProxy> callback = new Receiver<EntityProxy>() {

            public void onSuccess(EntityProxy proxy) {
                if (proxy == null) {
                    placeController.goTo(getBackButtonPlace());
                    return;
                }
                if (display == null) {
                    return;
                }
                view.setValue((ProductProxy) proxy);
                display.setWidget(view);
            }
        };
        find(callback);
    }
}
