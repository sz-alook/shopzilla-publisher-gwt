package com.shopzilla.publisher.rich.client.managed.ui;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.CompositeCell;
import com.google.gwt.cell.client.HasCell;
import com.google.gwt.cell.client.ImageCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.text.client.DateTimeFormatRenderer;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.IdentityColumn;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.shopzilla.publisher.rich.client.managed.request.ProductProxy;
import com.shopzilla.publisher.rich.client.managed.ui.ProductListView.Binder;
import com.shopzilla.publisher.rich.client.scaffold.place.AbstractProxyListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductListView extends ProductListView_Roo_Gwt {

    private static final Binder BINDER = GWT.create(Binder.class);

    private static com.shopzilla.publisher.rich.client.managed.ui.ProductListView instance;

    @UiField
    Button newButton;

    public ProductListView() {
        init(BINDER.createAndBindUi(this), table, newButton);
        table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.DISABLED);
        init();
        
        //try adding image column
        addImageColumn();
    }
    
    /*
     * TODO: get image to work
     */
    private void addImageColumn() {
    	table.addColumn(new TextColumn<ProductProxy>() {
    		
    		SafeHtmlBuilder safeHtmlBuilder = new SafeHtmlBuilder();
    		ImageCell imageCell = new ImageCell();
    		

            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

                public String render(java.lang.String obj) {
                	String imgUrl = obj == null ? "" : String.valueOf(obj);
                	imageCell.render(null, imgUrl, safeHtmlBuilder);
                    return safeHtmlBuilder.toSafeHtml().asString();
                }
            };

            @Override
            public String getValue(ProductProxy object) {
                return renderer.render(object.getImgUrl());
            }
        }, "Img Url");
    }

    public static com.shopzilla.publisher.rich.client.managed.ui.ProductListView instance() {
        if (instance == null) {
            instance = new ProductListView();
        }
        return instance;
    }

    public String[] getPaths() {
        return paths.toArray(new String[paths.size()]);
    }

    interface Binder extends UiBinder<HTMLPanel, ProductListView> {
    }
}
