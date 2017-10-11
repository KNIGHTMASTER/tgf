package id.co.telkomsigma.tgf.web.admin.vaadin.view.login;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;
import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.annotation.PostConstruct;

/**
 * Created on 9/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class LoginPanelContainerLeft extends VerticalLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 7869097414836939148L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.addStyleName("panel-rounded");
        setMargin(true);
        setSpacing(true);
        setWidth("100%");

    }
}

