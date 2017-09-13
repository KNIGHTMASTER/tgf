package id.co.telkomsigma.tgf.web.admin.vaadin.component.passwordfield;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.PasswordField;
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
public class LoginPasswordField extends PasswordField implements IComponentInitializer {

    /**
     *
     *
     */
    private static final long serialVersionUID = 5835015726918475987L;

    @Autowired
    IResourceBundleLocator rb;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setCaption(rb.getResourceBundle().getString("passwordfield.login.caption"));
        this.setWidth("300px");
        this.setRequiredIndicatorVisible(true);
        this.setValue("");
    }
}
