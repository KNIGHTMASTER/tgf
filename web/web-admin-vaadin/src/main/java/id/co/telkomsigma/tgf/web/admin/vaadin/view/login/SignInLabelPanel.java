package id.co.telkomsigma.tgf.web.admin.vaadin.view.login;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.label.LabelSignIn;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created on 9/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class SignInLabelPanel extends HorizontalLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 24276049698215334L;

    @Autowired
    LabelSignIn labelSignIn;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setWidth("400px");
        this.setHeight("70px");
        this.setMargin(false);
        this.addComponent(labelSignIn);
        this.setComponentAlignment(labelSignIn, Alignment.MIDDLE_LEFT);
        this.addStyleName("valo-base-color");
    }
}
