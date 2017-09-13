package id.co.telkomsigma.tgf.web.admin.vaadin.component.panel;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.themes.ValoTheme;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.menubar.AppMenuBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 8/21/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelMenuBar extends HorizontalLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1137187310798884419L;

    @Autowired
    private AppMenuBar appMenuBar;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setMargin(false);
        this.setSpacing(true);
        this.setHeight(100.0f, Unit.PERCENTAGE);
        this.setWidth(100.0f, Unit.PERCENTAGE);
        this.setStyleName("panel-app-top");

        Button btIcon = new NativeButton();
        btIcon.setStyleName("app-icon-borderless");
        this.addComponent(btIcon);
        this.setComponentAlignment(btIcon, Alignment.MIDDLE_LEFT);
        this.addComponent(appMenuBar);
        this.setComponentAlignment(appMenuBar, Alignment.MIDDLE_LEFT);
        this.setExpandRatio(appMenuBar, 5.0f);


        Button btRight = new NativeButton();
        btRight.setIcon(VaadinIcons.FACEBOOK);
//        btRight.setStyleName("borderless");
        btRight.addStyleName("notifications");
        btRight.addStyleName("unread");
        btRight.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        btRight.setCaption("7");
        this.addComponent(btRight);
        this.setComponentAlignment(btRight, Alignment.MIDDLE_RIGHT);
    }
}
