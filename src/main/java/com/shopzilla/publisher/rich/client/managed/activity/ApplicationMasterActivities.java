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

public final class ApplicationMasterActivities extends ApplicationMasterActivities_Roo_Gwt {

    @Inject
    public ApplicationMasterActivities(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }
}
