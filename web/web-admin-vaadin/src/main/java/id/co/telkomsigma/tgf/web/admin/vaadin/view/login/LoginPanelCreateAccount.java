package id.co.telkomsigma.tgf.web.admin.vaadin.view.login;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.button.login.CreateAccountButton;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.image.ImageAppIcon;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.label.LabelNeedAccount;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created on 9/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class LoginPanelCreateAccount extends HorizontalLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1335375439970879366L;

    @Autowired
    private ImageAppIcon imageAppIcon;

    @Autowired
    LabelNeedAccount labelNeedAccount;

    @Autowired
    CreateAccountButton createAccountButton;



    @PostConstruct
    @Override
    public void initComponents() {
        this.setSizeFull();
        this.addStyleName("valo-base-color");
        this.setSpacing(true);
        this.setHeight(70F, Unit.PIXELS);
        this.setResponsive(true);

        HorizontalLayout imagePanel = new HorizontalLayout();
        imagePanel.setMargin(new MarginInfo(false, false, false, true));
        imagePanel.addComponent(imageAppIcon);

        HorizontalLayout createAccountFields = new HorizontalLayout();
        createAccountFields.setMargin(new MarginInfo(false, true, false, false));
        createAccountFields.addComponent(labelNeedAccount);
        createAccountFields.addComponent(createAccountButton);


        this.addComponent(imagePanel);
        this.addComponent(createAccountFields);

        this.setComponentAlignment(imagePanel, Alignment.MIDDLE_LEFT);
        this.setComponentAlignment(createAccountFields, Alignment.MIDDLE_RIGHT);

        createAccountFields.setComponentAlignment(labelNeedAccount, Alignment.MIDDLE_RIGHT);
        createAccountFields.setComponentAlignment(createAccountButton, Alignment.MIDDLE_RIGHT);
    }
}
