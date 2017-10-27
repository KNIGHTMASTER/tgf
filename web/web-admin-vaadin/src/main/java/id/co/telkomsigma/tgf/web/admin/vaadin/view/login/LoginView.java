package id.co.telkomsigma.tgf.web.admin.vaadin.view.login;

import com.vaadin.data.Binder;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.util.UIConstant;
import id.co.telkomsigma.tgf.util.UIConstant.Common.Punctuation;
import id.co.telkomsigma.tgf.web.admin.vaadin.constant.TGFConstant;
import id.co.telkomsigma.tgf.web.admin.vaadin.dto.RoleDTO;
import id.co.telkomsigma.tgf.web.admin.vaadin.dto.UserDTO;
import id.co.telkomsigma.tgf.web.admin.vaadin.dto.request.RequestLoginDTO;
import id.co.telkomsigma.tgf.web.admin.vaadin.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.PostConstruct;
import java.util.List;

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

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService userDetailsService;

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
                UserDetails userDetails = userDetailsService.loadUserByUsername(loginPanelTop.getLoginPanelContainerRight().getLoginPanelFields().getUserNameTextField().getValue());

                UsernamePasswordAuthenticationToken upat;
                upat = new UsernamePasswordAuthenticationToken(userDetails, loginPanelTop.getLoginPanelContainerRight().getLoginPanelFields().getLoginPasswordField().getValue(), userDetails.getAuthorities());

                try {
                    authenticationManager.authenticate(upat);
                    if(upat.isAuthenticated()) {
                        SecurityContextHolder.getContext().setAuthentication(upat);
                        UI.getCurrent().getSession().close();
                        UI.getCurrent().getSession().getService().closeSession(VaadinSession.getCurrent());
                        UI.getCurrent().close();
                        Page.getCurrent().setLocation(urlLoggedIn);
//                        getUI().getPage().setLocation(urlLoggedIn);
                    }else {
                        loginPanelTop.getLoginPanelContainerRight().getLoginPanelFields().getUserNameTextField().focus();
                        Notification.show("Wrong username | Password");
                    }
                }catch (Exception e){
                    loginPanelTop.getLoginPanelContainerRight().getLoginPanelFields().getUserNameTextField().focus();
                    Notification.show("Failed Authentication , Wrong username | Password");
                }
            }
        });
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.loginPanelTop.getLoginPanelContainerRight().getLoginPanelFields().getUserNameTextField().setCaption(Punctuation.EMPTY);
        this.loginPanelTop.getLoginPanelContainerRight().getLoginPanelFields().getLoginPasswordField().setCaption(Punctuation.EMPTY);
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
