package com.shopzilla.publisher.rich.client.scaffold.ioc;

import com.shopzilla.publisher.rich.client.scaffold.ScaffoldApp;
import com.google.gwt.inject.client.Ginjector;

public interface ScaffoldInjector extends Ginjector {

	ScaffoldApp getScaffoldApp();
}
