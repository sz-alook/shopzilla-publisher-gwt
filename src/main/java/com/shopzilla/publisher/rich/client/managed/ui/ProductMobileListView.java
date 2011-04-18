package com.shopzilla.publisher.rich.client.managed.ui;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.text.client.DateTimeFormatRenderer;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.AbstractSafeHtmlRenderer;
import com.google.gwt.text.shared.Renderer;
import com.shopzilla.publisher.rich.client.managed.request.ProductProxy;
import com.shopzilla.publisher.rich.client.scaffold.ScaffoldMobileApp;
import com.shopzilla.publisher.rich.client.scaffold.ui.MobileProxyListView;
import java.util.HashSet;
import java.util.Set;

public class ProductMobileListView extends ProductMobileListView_Roo_Gwt {

    private static com.shopzilla.publisher.rich.client.managed.ui.ProductMobileListView instance;

    public ProductMobileListView() {
        super("New Product", new CellRenderer());
        init();
    }

    public static com.shopzilla.publisher.rich.client.managed.ui.ProductMobileListView instance() {
        if (instance == null) {
            instance = new ProductMobileListView();
        }
        return instance;
    }

    public String[] getPaths() {
        return paths.toArray(new String[paths.size()]);
    }

    private static class CellRenderer extends AbstractSafeHtmlRenderer<ProductProxy> {

        private final String dateStyle = ScaffoldMobileApp.getMobileListResources().cellListStyle().dateProp();

        private final String secondaryStyle = ScaffoldMobileApp.getMobileListResources().cellListStyle().secondaryProp();

        private final Renderer<String> primaryRenderer = new AbstractRenderer<String>() {

            public String render(java.lang.String obj) {
                return obj == null ? "" : String.valueOf(obj);
            }
        };

        private final Renderer<String> secondaryRenderer = new AbstractRenderer<String>() {

            public String render(java.lang.String obj) {
                return obj == null ? "" : String.valueOf(obj);
            }
        };

        @Override
        public SafeHtml render(ProductProxy value) {
            if (value == null) {
                return SafeHtmlUtils.EMPTY_SAFE_HTML;
            }
            SafeHtmlBuilder sb = new SafeHtmlBuilder();
            if (value.getTitle() != null) {
                sb.appendEscaped(primaryRenderer.render(value.getTitle()));
            }
            sb.appendHtmlConstant("<div style=\"position:relative;\">");
            sb.appendHtmlConstant("<div class=\"" + secondaryStyle + "\">");
            if (value.getUrl() != null) {
                sb.appendEscaped(secondaryRenderer.render(value.getUrl()));
            }
            sb.appendHtmlConstant("</div>");
            sb.appendHtmlConstant("<div class=\"" + dateStyle + "\">");
            sb.appendHtmlConstant("</div>");
            sb.appendHtmlConstant("</div>");
            return sb.toSafeHtml();
        }
    }
}
