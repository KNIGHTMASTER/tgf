package id.co.telkomsigma.tgf.web.admin.vaadin.view;

import com.vaadin.ui.VerticalLayout;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.panel.PanelAppBottom;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.panel.PanelAppCenter;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.panel.PanelMenuBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 8/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class NavigationLayout extends VerticalLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 6477313317610754065L;

    @Autowired
    private PanelAppCenter panelAppCenter;

    @Autowired
    private PanelAppBottom panelAppBottom;

    @Autowired
    private PanelMenuBar panelMenuBar;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setSizeFull();
        this.setMargin(false);
        this.setSpacing(false);

        this.addComponent(panelMenuBar);
        this.addComponent(panelAppCenter);
        this.addComponent(panelAppBottom);

        this.setExpandRatio(panelMenuBar, 0.5f);
        this.setExpandRatio(panelAppCenter, 9.0f);
        this.setExpandRatio(panelAppBottom, 0.5f);
    }
}
