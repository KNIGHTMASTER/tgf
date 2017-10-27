package id.co.telkomsigma.tgf.swing.component.menubar.settings;

import id.co.telkomsigma.tgf.swing.component.base.IResourceBundleLocator;
import id.co.telkomsigma.tgf.swing.component.menubar.theme.MenuTheme;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created on 10/25/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class MenuSettings extends JMenu implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1890318926476824632L;

    @Autowired
    private MenuServer menuServer;

    @Autowired
    private MenuTheme menuTheme;

    @Autowired
    private IResourceBundleLocator rb;

    @Value("${menu.settings.imageurl}")
    private String menuSettingsImageUrl;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText(rb.getValue("menu.settings.name"));
        this.add(menuServer);
        this.add(menuTheme);
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(menuSettingsImageUrl)));
    }
}
