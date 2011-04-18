// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package com.shopzilla.publisher.rich.client.managed.request;

import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;

@RooGwtMirroredFrom("com.shopzilla.publisher.rich.domain.Product")
@ProxyForName("com.shopzilla.publisher.rich.domain.Product")
public interface ProductProxy extends EntityProxy {

    abstract Long getId();

    abstract void setId(Long id);

    abstract Integer getVersion();

    abstract void setVersion(Integer version);

    abstract String getTitle();

    abstract void setTitle(String title);

    abstract String getUrl();

    abstract void setUrl(String url);

    abstract String getImgUrl();

    abstract void setImgUrl(String imgUrl);
}
