package id.co.telkomsigma.tgf.web.admin.vaadin.view.login;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created on 7/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class LoginPanelContainerRight extends VerticalLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1032962252930985094L;

    @Autowired
    LoginPanelFields loginPanelFields;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setMargin(false);
        this.addStyleName("layout-with-border");
        this.addStyleName("panel-white");
        this.addStyleName("panel-rounded");

        this.addComponent(loginPanelFields);
        this.setComponentAlignment(loginPanelFields, Alignment.MIDDLE_CENTER);
    }

    public LoginPanelFields getLoginPanelFields() {
        return loginPanelFields;
    }
}
