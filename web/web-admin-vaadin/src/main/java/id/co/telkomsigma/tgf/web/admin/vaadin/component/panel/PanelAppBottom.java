package id.co.telkomsigma.tgf.web.admin.vaadin.component.panel;

import com.vaadin.ui.HorizontalLayout;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 8/21/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelAppBottom extends HorizontalLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1137187310798884419L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setStyleName("panel-app-top");
        this.setMargin(false);
        this.setSpacing(false);

        this.setHeight(100.0f, Unit.PERCENTAGE);
        this.setWidth(100.0f, Unit.PERCENTAGE);
    }
}
