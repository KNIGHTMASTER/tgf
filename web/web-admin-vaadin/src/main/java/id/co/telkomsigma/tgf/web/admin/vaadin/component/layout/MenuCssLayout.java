package id.co.telkomsigma.tgf.web.admin.vaadin.component.layout;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.CssLayout;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.web.admin.vaadin.component.button.menu.MenuButton;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created on 9/14/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class MenuCssLayout extends CssLayout implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 6824490283093810180L;

    @Autowired
    private MenuButton menuButton;

    @PostConstruct
    @Override
    public void initComponents() {
        this.addComponent(menuButton);
    }
}
