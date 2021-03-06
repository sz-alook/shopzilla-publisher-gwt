// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package com.shopzilla.publisher.rich.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.shopzilla.publisher.rich.client.managed.request.ApplicationEntityTypesProcessor;
import com.shopzilla.publisher.rich.client.managed.request.ApplicationRequestFactory;
import com.shopzilla.publisher.rich.client.managed.request.ProductProxy;
import com.shopzilla.publisher.rich.client.managed.ui.ProductListView;
import com.shopzilla.publisher.rich.client.managed.ui.ProductMobileListView;
import com.shopzilla.publisher.rich.client.scaffold.ScaffoldApp;
import com.shopzilla.publisher.rich.client.scaffold.place.ProxyListPlace;

public abstract class ApplicationMasterActivities_Roo_Gwt implements ActivityMapper {

    protected ApplicationRequestFactory requests;

    protected PlaceController placeController;

    public Activity getActivity(Place place) {
        if (!(place instanceof ProxyListPlace)) {
            return null;
        }
        ProxyListPlace listPlace = (ProxyListPlace) place;
        return new ApplicationEntityTypesProcessor<Activity>() {

            @Override
            public void handleProduct(ProductProxy isNull) {
                setResult(new ProductListActivity(requests, ScaffoldApp.isMobile() ? ProductMobileListView.instance() : ProductListView.instance(), placeController));
            }
        }.process(listPlace.getProxyClass());
    }
}
