package id.co.telkomsigma.tgf.web.admin.vaadin.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.server.SpringVaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import id.co.telkomsigma.tgf.web.admin.vaadin.theme.ValoThemeSessionInitListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


/**
 * Created on 9/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Title("Access Denied")
@Theme("tgf")
@SpringUI(path = "/403")
public class AccessDeniedUI extends UI {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6619434669245765004L;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = AccessDeniedUI.class)
    public static class Servlet extends SpringVaadinServlet {
        /**
         *
         *
         */
        private static final long serialVersionUID = -6193754157357404543L;

        @Override
        protected void servletInitialized() throws ServletException {
            super.servletInitialized();
            getService().addSessionInitListener(new ValoThemeSessionInitListener());
        }
    }


    @Override
    protected void init(VaadinRequest request) {
        this.setSizeFull();
        this.setResponsive(true);

        VerticalLayout root = new VerticalLayout();
        root.setSpacing(true);
        root.setMargin(false);
        root.addComponent(new Label("You are accessing the protected page!"));

        setContent(root);
    }
}
