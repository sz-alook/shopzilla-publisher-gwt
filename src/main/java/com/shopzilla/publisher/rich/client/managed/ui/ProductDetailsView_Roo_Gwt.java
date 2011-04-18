// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package com.shopzilla.publisher.rich.client.managed.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shopzilla.publisher.rich.client.managed.request.ProductProxy;
import com.shopzilla.publisher.rich.client.scaffold.place.ProxyDetailsView;
import com.shopzilla.publisher.rich.client.scaffold.place.ProxyListView;

public abstract class ProductDetailsView_Roo_Gwt extends Composite implements ProxyDetailsView<ProductProxy> {

    @UiField
    SpanElement id;

    @UiField
    SpanElement version;

    @UiField
    SpanElement title;

    @UiField
    SpanElement url;

    @UiField
    SpanElement imgUrl;

    ProductProxy proxy;

    @UiField
    SpanElement displayRenderer;

    public void setValue(ProductProxy proxy) {
        this.proxy = proxy;
        id.setInnerText(proxy.getId() == null ? "" : String.valueOf(proxy.getId()));
        version.setInnerText(proxy.getVersion() == null ? "" : String.valueOf(proxy.getVersion()));
        title.setInnerText(proxy.getTitle() == null ? "" : String.valueOf(proxy.getTitle()));
        url.setInnerText(proxy.getUrl() == null ? "" : String.valueOf(proxy.getUrl()));
        imgUrl.setInnerText(proxy.getImgUrl() == null ? "" : String.valueOf(proxy.getImgUrl()));
        displayRenderer.setInnerText(com.shopzilla.publisher.rich.client.managed.ui.ProductProxyRenderer.instance().render(proxy));
    }
}
