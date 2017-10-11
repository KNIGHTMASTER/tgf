package id.co.telkomsigma.tgf.web.admin.vaadin.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.data.Binder;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.web.admin.vaadin.constant.TGFConstant;
import id.co.telkomsigma.tgf.web.admin.vaadin.dto.LoginDTO;
import id.co.telkomsigma.tgf.web.admin.vaadin.view.dashboard.DashboardView;
import id.co.telkomsigma.tgf.web.admin.vaadin.view.login.LoginPanelCreateAccount;
import id.co.telkomsigma.tgf.web.admin.vaadin.view.login.LoginPanelTop;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created on 9/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Title("Login App")
@Theme("tgf")
@SpringUI(path = "/login")
@UIScope
public class LoginUI extends UI implements View , IComponentAction {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6619434669245765004L;

    @Autowired
    LoginPanelCreateAccount loginPanelCreateAccount;

    @Autowired
    private SpringViewProvider springViewProvider;

    @Autowired
    private LoginPanelTop loginPanelTop;

    private Navigator navigator;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        this.loginPanelTop.getLoginPanelContainerRight().getLoginPanelFields().getUserNameTextField().focus();
    }


    @Override
    public void initAction() {
        this.loginPanelTop.getLoginPanelContainerRight().getLoginPanelFields().getSignInButtonPanel().getLoginButton().addClickListener(new Button.ClickListener() {
            /**
             *
             *
             */
            private static final long serialVersionUID = 8621095041579762097L;

            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                Binder<LoginDTO> loginDTOBinder = new Binder<>();
                loginDTOBinder.bind(loginPanelTop.getLoginPanelContainerRight().getLoginPanelFields().getUserNameTextField(), LoginDTO::getUserName, LoginDTO::setUserName);

                LoginDTO loginDTO = new LoginDTO();
                loginDTOBinder.setBean(loginDTO);

                loginDTOBinder.forField(loginPanelTop.getLoginPanelContainerRight().getLoginPanelFields().getUserNameTextField()).withValidator(new StringLengthValidator("Name must not be empty", 2, 20))
                        .bind(LoginDTO::getUserName, LoginDTO::setUserName);

                navigator.navigateTo(TGFConstant.ViewNames.DASHBOARD_VIEW);
            }
        });
    }

    @Override
    protected void init(VaadinRequest request) {
        this.setSizeFull();
        this.setResponsive(true);

        VerticalLayout root = new VerticalLayout();
        root.setSpacing(true);
        root.setMargin(false);

        root.addComponent(loginPanelCreateAccount);
        root.addComponent(loginPanelTop);

        root.setComponentAlignment(loginPanelTop, Alignment.MIDDLE_CENTER);

        root.setExpandRatio(loginPanelCreateAccount, 0.2f);
        root.setExpandRatio(loginPanelTop, 0.8f);

        this.navigator = UI.getCurrent().getNavigator();
        this.initAction();

        setContent(root);

        navigator = getUI().getNavigator();
        navigator.addProvider(springViewProvider);
        navigator.addView(TGFConstant.ViewNames.DASHBOARD_VIEW, DashboardView.class);
    }
}
