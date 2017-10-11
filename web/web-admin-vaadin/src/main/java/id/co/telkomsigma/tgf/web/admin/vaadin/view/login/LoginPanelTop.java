package id.co.telkomsigma.tgf.web.admin.vaadin.view.login;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.HorizontalLayout;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created on 9/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class LoginPanelTop extends HorizontalLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6355047059963083993L;

    /*@Autowired
    LoginPanelContainerLeft loginPanelContainerLeft;*/

    @Autowired
    LoginPanelContainerRight loginPanelContainerRight;


    @PostConstruct
    @Override
    public void initComponents() {
//        this.addComponent(loginPanelContainerLeft);
        this.setMargin(new MarginInfo(true, false, false, false));
        this.addComponent(loginPanelContainerRight);
        this.setSpacing(true);
    }

    /*public LoginPanelContainerLeft getLoginPanelContainerLeft() {
        return loginPanelContainerLeft;
    }

    public void setLoginPanelContainerLeft(LoginPanelContainerLeft loginPanelContainerLeft) {
        this.loginPanelContainerLeft = loginPanelContainerLeft;
    }*/

    public LoginPanelContainerRight getLoginPanelContainerRight() {
        return loginPanelContainerRight;
    }

    public void setLoginPanelContainerRight(LoginPanelContainerRight loginPanelContainerRight) {
        this.loginPanelContainerRight = loginPanelContainerRight;
    }
}
