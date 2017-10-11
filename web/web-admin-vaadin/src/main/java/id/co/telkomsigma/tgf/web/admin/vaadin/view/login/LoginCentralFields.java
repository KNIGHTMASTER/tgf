package id.co.telkomsigma.tgf.web.admin.vaadin.view.login;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.checkbox.CheckBoxStaySignedIn;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.link.LinkForgotPassword;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.passwordfield.LoginPasswordField;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.textfield.login.UserNameTextField;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created on 10/6/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class LoginCentralFields extends VerticalLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 503855646119985763L;

    @Autowired
    LoginPasswordField loginPasswordField;

    @Autowired
    UserNameTextField userNameTextField;

    @Autowired
    CheckBoxStaySignedIn checkBoxStaySignedIn;

    @Autowired
    LinkForgotPassword linkForgotPassword;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setSpacing(true);
        this.setMargin(false);
        this.addComponent(userNameTextField);
        this.addComponent(loginPasswordField);
        this.addComponent(checkBoxStaySignedIn);
        this.addComponent(linkForgotPassword);
    }

    public LoginPasswordField getLoginPasswordField() {
        return loginPasswordField;
    }

    public void setLoginPasswordField(LoginPasswordField loginPasswordField) {
        this.loginPasswordField = loginPasswordField;
    }

    public UserNameTextField getUserNameTextField() {
        return userNameTextField;
    }

    public void setUserNameTextField(UserNameTextField userNameTextField) {
        this.userNameTextField = userNameTextField;
    }

    public CheckBoxStaySignedIn getCheckBoxStaySignedIn() {
        return checkBoxStaySignedIn;
    }

    public void setCheckBoxStaySignedIn(CheckBoxStaySignedIn checkBoxStaySignedIn) {
        this.checkBoxStaySignedIn = checkBoxStaySignedIn;
    }

    public LinkForgotPassword getLinkForgotPassword() {
        return linkForgotPassword;
    }

    public void setLinkForgotPassword(LinkForgotPassword linkForgotPassword) {
        this.linkForgotPassword = linkForgotPassword;
    }
}
