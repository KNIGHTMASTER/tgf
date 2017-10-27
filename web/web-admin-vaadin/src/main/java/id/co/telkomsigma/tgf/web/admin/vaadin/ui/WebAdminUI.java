package id.co.telkomsigma.tgf.web.admin.vaadin.ui;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import id.co.telkomsigma.tgf.util.UIConstant.Common.Punctuation;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.button.menu.MenuUserSetting;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.layout.MenuCssLayout;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.layout.ValoMenuLayout;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.menu.MenuBuilder;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.panel.PanelAppName;
import id.co.telkomsigma.tgf.web.admin.vaadin.constant.TGFConstant;
import id.co.telkomsigma.tgf.web.admin.vaadin.constant.TGFValoTheme;
import id.co.telkomsigma.tgf.web.admin.vaadin.dto.MenuDTO;
import id.co.telkomsigma.tgf.web.admin.vaadin.dto.MenuItemDTO;
import id.co.telkomsigma.tgf.web.admin.vaadin.theme.ValoThemeSessionInitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.util.LinkedList;

/**
 * Created on 9/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Title("Application Web Backend")
@Theme(value = "tgf")
@SpringUI(path = "/admin")
@Scope(scopeName = "prototype")
@PreserveOnRefresh
public class WebAdminUI extends UI {
    /**
     *
     *
     */
    private static final long serialVersionUID = 8873273007871074028L;

    @Autowired
    private SpringViewProvider springViewProvider;

    @Autowired
    private ValoMenuLayout root;

    @Autowired
    private MenuBuilder menuBuilder;

    @Autowired
    private MenuCssLayout menuCssLayout;

    @Autowired
    private PanelAppName panelAppName;

    @Autowired
    private MenuUserSetting menuUserSetting;

    private MenuDTO menuDTO;

    @Value("${app.title}")
    private String appTitle;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = WebAdminUI.class)
    public static class Servlet extends VaadinServlet {
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
        CssLayout menuItemsLayout = new CssLayout();

        menuCssLayout.setId("testMenu");

        if (getPage().getWebBrowser().isIE() && getPage().getWebBrowser().getBrowserMajorVersion() == 9) {
            menuCssLayout.setWidth("320px");
        }
        Responsive.makeResponsive(this);
        getPage().setTitle(appTitle);
        setContent(root);


        menuCssLayout.addComponent(panelAppName);

        menuDTO = new MenuDTO();
        LinkedList<MenuItemDTO> menuItemDTOs = new LinkedList<>();
        MenuItemDTO menuDashboard = new MenuItemDTO();
        menuDashboard.setName("Dashboard");
        menuDashboard.setKey(TGFConstant.ViewNames.DASHBOARD_VIEW);
        menuDashboard.setIcon(TGFConstant.Icons.DASHBOARD);
        menuDashboard.setViewName(TGFConstant.ViewNames.DASHBOARD_VIEW);

        MenuItemDTO menuLogin = new MenuItemDTO();
        menuLogin.setName("Login");
        menuLogin.setKey(TGFConstant.ViewNames.LOGIN_VIEW);
        menuLogin.setIcon(TGFConstant.Icons.SAFE_LOCK);
        menuLogin.setViewName(TGFConstant.ViewNames.LOGIN_VIEW);

        menuItemDTOs.add(menuDashboard);
        menuItemDTOs.add(menuLogin);

        menuDTO.setMenuItemDTOs(menuItemDTOs);

        menuCssLayout.addComponent(menuUserSetting);

        root.addMenu(menuBuilder.build(menuCssLayout, menuItemsLayout, menuDTO, getUI()));

        addStyleName(ValoTheme.UI_WITH_MENU);

        Navigator navigator = new Navigator(this, root.getViewDisplay());
        navigator.addProvider(springViewProvider);

        String f = Page.getCurrent().getUriFragment();
        if ((f == null) || f.equals(Punctuation.EMPTY)) {
            getUI().getNavigator().navigateTo(TGFConstant.ViewNames.DASHBOARD_VIEW);
        }

        navigator.setErrorView(CommonParts.class);

        navigator.addViewChangeListener(new ViewChangeListener() {
            /**
             *
             *
             */
            private static final long serialVersionUID = -160946546177404031L;

            @Override
            public boolean beforeViewChange(ViewChangeEvent event) {
                return true;
            }

            @Override
            public void afterViewChange(ViewChangeEvent event) {
                for (Component aMenuItemsLayout : menuItemsLayout) {
                    aMenuItemsLayout.removeStyleName(TGFValoTheme.SELECTED);
                }
                for (MenuItemDTO item : menuDTO.getMenuItemDTOs()) {
                    if (event.getViewName().equals(item.getKey())) {
                        for (Component c : menuItemsLayout) {
                            if (c.getCaption() != null && c.getCaption().startsWith(item.getName())) {
                                c.addStyleName(TGFValoTheme.SELECTED);
                                break;
                            }
                        }
                        break;
                    }
                }
                menuCssLayout.removeStyleName(TGFValoTheme.VALO_MENU_VISIBLE);
            }
        });
    }
}
