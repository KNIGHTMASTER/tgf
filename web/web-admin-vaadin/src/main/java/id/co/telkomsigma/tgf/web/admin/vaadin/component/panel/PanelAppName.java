package id.co.telkomsigma.tgf.web.admin.vaadin.component.panel;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.label.LabelAppName;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created on 9/14/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class PanelAppName extends HorizontalLayout implements IComponentAction {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6831150810599749478L;

    @Autowired
    LabelAppName labelAppName;

    @PostConstruct
    @Override
    public void initAction() {
        this.setWidth("100%");
        this.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        this.addStyleName(ValoTheme.MENU_TITLE);
        this.addComponent(labelAppName);
        this.setExpandRatio(labelAppName, 1);
    }
}
