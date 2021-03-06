package org.vaadin.alump.masonry.demo;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;

@Theme("demo")
@Title("Masonry Add-on Demo")
@SuppressWarnings("serial")
public class MasonryDemoUI extends UI
{

    private Navigator navigator;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MasonryDemoUI.class, widgetset = "org.vaadin.alump.masonry.demo.DemoWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        navigator = new Navigator(this, this);

        navigator.addView(MainMenuView.VIEW_NAME, new MainMenuView());
        navigator.addView(BasicTestsView.VIEW_NAME, new BasicTestsView());
        navigator.addView(DnDTestsView.VIEW_NAME, new DnDTestsView());
        navigator.addView(GridSizerTestsView.VIEW_NAME, new GridSizerTestsView());
    }
}
