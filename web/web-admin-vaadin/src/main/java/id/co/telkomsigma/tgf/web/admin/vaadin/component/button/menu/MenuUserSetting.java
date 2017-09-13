package id.co.telkomsigma.tgf.web.admin.vaadin.component.button.menu;

import com.vaadin.server.ClassResource;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.MenuBar;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.web.admin.vaadin.constant.TGFValoTheme;
import id.co.telkomsigma.tgf.web.admin.vaadin.ui.StringGenerator;

import javax.annotation.PostConstruct;

/**
 * Created on 9/14/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class MenuUserSetting extends MenuBar implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8878541442598640228L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.addStyleName(TGFValoTheme.USER_MENU);
        StringGenerator sg = new StringGenerator();
        MenuBar.MenuItem settingsItem = this.addItem(
                sg.nextString(true) + " " + sg.nextString(true) + sg.nextString(false),
                new ClassResource("classpath:profile-pic-300px.jpg"),
                null
        );
        settingsItem.addItem("Edit Profile", null);
        settingsItem.addItem("Preferences", null);
        settingsItem.addSeparator();
        settingsItem.addItem("Sign Out", null);
    }
}
