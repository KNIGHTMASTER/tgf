package id.co.telkomsigma.tgf.web.admin.vaadin.view.login;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.web.admin.vaadin.constant.TGFConstant;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created on 7/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringView(name = TGFConstant.ViewNames.LOGIN_VIEW)
@UIScope
public class LoginView extends VerticalLayout implements View, IComponentInitializer, IComponentAction {

    /**
     *
     *
     */
    private static final long serialVersionUID = 8682971569973011022L;

    @Autowired
    private LoginPanelTop loginPanelTop;

    private Navigator navigator;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setSizeFull();
        this.addComponent(loginPanelTop);

        this.navigator = UI.getCurrent().getNavigator();
        this.initAction();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        this.loginPanelTop.loginPanelFields.getUserNameTextField().focus();
    }


    @Override
    public void initAction() {
        this.loginPanelTop.loginPanelFields.getLoginButton().addClickListener(new Button.ClickListener() {
            /**
             *
             *
             */
            private static final long serialVersionUID = 8621095041579762097L;

            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                navigator.navigateTo(TGFConstant.ViewNames.DASHBOARD_VIEW);
            }
        });
    }
}
