package id.co.telkomsigma.tgf.web.admin.vaadin.component.button.login;

import com.vaadin.event.ShortcutAction;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.web.admin.vaadin.rb.IResourceBundleLocator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created on 7/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class LoginButton extends Button implements IComponentInitializer {

    /**
     *
     *
     */
    private static final long serialVersionUID = 393406867854725781L;

    @Autowired
    IResourceBundleLocator rb;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setCaption(rb.getResourceBundle().getString("button.login.caption"));
        this.setClickShortcut(ShortcutAction.KeyCode.ENTER);
    }
}
