package id.co.telkomsigma.tgf.web.admin.vaadin.component.checkbox;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.CheckBox;
import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.annotation.PostConstruct;

/**
 * Created on 9/28/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class CheckBoxStaySignedIn extends CheckBox implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2058273625477791167L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setCaption("Stay Signed in");
    }
}
