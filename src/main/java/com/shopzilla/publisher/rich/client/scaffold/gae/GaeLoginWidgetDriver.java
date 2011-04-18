package com.shopzilla.publisher.rich.client.scaffold.gae;

import com.shopzilla.publisher.rich.client.scaffold.ui.LoginWidget;
import com.shopzilla.publisher.rich.shared.gae.GaeUser;
import com.shopzilla.publisher.rich.shared.gae.GaeUserServiceRequest;
import com.shopzilla.publisher.rich.shared.gae.MakesGaeRequests;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.user.client.Window.Location;

/**
 * Makes GAE requests to drive a LoginWidget.
 */
public class GaeLoginWidgetDriver {
	private final MakesGaeRequests requests;

	public GaeLoginWidgetDriver(MakesGaeRequests requests) {
		this.requests = requests;
	}

	public void setWidget(final LoginWidget widget) {
		GaeUserServiceRequest request = requests.userServiceRequest();

		request.createLogoutURL(Location.getHref()).to(new Receiver<String>() {
			public void onSuccess(String response) {
				widget.setLogoutUrl(response);
			}
		});

		request.getCurrentUser().to(new Receiver<GaeUser>() {
			@Override
			public void onSuccess(GaeUser response) {
				widget.setUserName(response.getNickname());
			}
		});

		request.fire();
	}
}
