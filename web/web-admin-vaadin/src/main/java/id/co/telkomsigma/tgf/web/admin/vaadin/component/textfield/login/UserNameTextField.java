package id.co.telkomsigma.tgf.web.admin.vaadin.component.textfield.login;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.TextField;
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
public class UserNameTextField extends TextField implements IComponentInitializer {

    /**
     *
     *
     */
    private static final long serialVersionUID = -5827329640555325468L;

    @Autowired
    IResourceBundleLocator rb;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setCaption(rb.getResourceBundle().getString("textfield.username.caption"));
        this.setWidth("300px");
        this.setRequiredIndicatorVisible(true);
        this.setPlaceholder(rb.getResourceBundle().getString("textfield.username.placeholder"));
    }
}
