package com.shopzilla.publisher.rich.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.shopzilla.publisher.rich.client.managed.activity.ProductEditActivityWrapper.View;
import com.shopzilla.publisher.rich.client.managed.request.ApplicationRequestFactory;
import com.shopzilla.publisher.rich.client.managed.request.ProductProxy;
import com.shopzilla.publisher.rich.client.scaffold.activity.IsScaffoldMobileActivity;
import com.shopzilla.publisher.rich.client.scaffold.place.ProxyEditView;
import com.shopzilla.publisher.rich.client.scaffold.place.ProxyListPlace;
import com.shopzilla.publisher.rich.client.scaffold.place.ProxyPlace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProductEditActivityWrapper extends ProductEditActivityWrapper_Roo_Gwt {

    private final EntityProxyId<ProductProxy> proxyId;

    public ProductEditActivityWrapper(ApplicationRequestFactory requests, View<?> view, Activity activity, EntityProxyId<com.shopzilla.publisher.rich.client.managed.request.ProductProxy> proxyId) {
        this.requests = requests;
        this.view = view;
        this.wrapped = activity;
        this.proxyId = proxyId;
    }

    public Place getBackButtonPlace() {
        return (proxyId == null) ? new ProxyListPlace(ProductProxy.class) : new ProxyPlace(proxyId, ProxyPlace.Operation.DETAILS);
    }

    public String getBackButtonText() {
        return "Cancel";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return (proxyId == null) ? "New Product" : "Edit Product";
    }

    public boolean hasEditButton() {
        return false;
    }

    @Override
    public String mayStop() {
        return wrapped.mayStop();
    }

    @Override
    public void onCancel() {
        wrapped.onCancel();
    }

    @Override
    public void onStop() {
        wrapped.onStop();
    }

    public interface View<V extends com.shopzilla.publisher.rich.client.scaffold.place.ProxyEditView<com.shopzilla.publisher.rich.client.managed.request.ProductProxy, V>> extends View_Roo_Gwt<V> {
    }
}
