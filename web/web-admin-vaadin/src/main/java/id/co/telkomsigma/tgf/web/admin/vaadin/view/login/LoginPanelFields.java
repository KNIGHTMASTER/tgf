package id.co.telkomsigma.tgf.web.admin.vaadin.view.login;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.button.login.LoginButton;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.passwordfield.LoginPasswordField;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.textfield.login.UserNameTextField;
import id.co.telkomsigma.tgf.web.admin.vaadin.rb.IResourceBundleLocator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created on 7/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class LoginPanelFields extends VerticalLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4890373141046484869L;

    @Autowired
    LoginPasswordField loginPasswordField;

    @Autowired
    UserNameTextField userNameTextField;

    @Autowired
    LoginButton loginButton;

    @Autowired
    IResourceBundleLocator rb;

    @PostConstruct
    @Override
    public void initComponents() {
        this.addComponent(userNameTextField);
        this.addComponent(loginPasswordField);
        this.addComponent(loginButton);

        this.setCaption(rb.getResourceBundle().getString("panel.login.caption"));
        this.setSpacing(true);
        this.setMargin(new MarginInfo(true, true, true, false));
        this.setSizeUndefined();
    }

    public LoginPasswordField getLoginPasswordField() {
        return loginPasswordField;
    }

    public UserNameTextField getUserNameTextField() {
        return userNameTextField;
    }

    public LoginButton getLoginButton() {
        return loginButton;
    }
}
