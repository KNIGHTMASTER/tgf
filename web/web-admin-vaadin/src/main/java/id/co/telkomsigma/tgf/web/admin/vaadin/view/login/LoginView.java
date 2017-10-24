package id.co.telkomsigma.tgf.web.admin.vaadin.view.login;

import com.vaadin.data.Binder;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.web.admin.vaadin.constant.TGFConstant;
import id.co.telkomsigma.tgf.web.admin.vaadin.dto.request.RequestLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

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
    LoginPanelCreateAccount loginPanelCreateAccount;

    @Autowired
    private LoginPanelTop loginPanelTop;

    @Value("${url-logged-in}")
    private String urlLoggedIn;

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
                Binder<RequestLoginDTO> loginDTOBinder = new Binder<>();
                loginDTOBinder.bind(loginPanelTop.getLoginPanelContainerRight().getLoginPanelFields().getUserNameTextField(), RequestLoginDTO::getUserName, RequestLoginDTO::setUserName);

                RequestLoginDTO requestLoginDTO = new RequestLoginDTO();
                loginDTOBinder.setBean(requestLoginDTO);

                loginDTOBinder.forField(loginPanelTop.getLoginPanelContainerRight().getLoginPanelFields().getUserNameTextField()).withValidator(new StringLengthValidator("Name must not be empty", 2, 20))
                        .bind(RequestLoginDTO::getUserName, RequestLoginDTO::setUserName);

                Page.getCurrent().setLocation(urlLoggedIn);
            }
        });
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.loginPanelTop.getLoginPanelContainerRight().getLoginPanelFields().getUserNameTextField().focus();
    }

    @PostConstruct
    @Override
    public void initComponents() {
        this.setMargin(false);
        this.addComponent(loginPanelCreateAccount);
        this.addComponent(loginPanelTop);

        this.setComponentAlignment(loginPanelTop, Alignment.MIDDLE_CENTER);

        this.setExpandRatio(loginPanelCreateAccount, 0.2f);
        this.setExpandRatio(loginPanelTop, 0.8f);

        initAction();
    }
}
