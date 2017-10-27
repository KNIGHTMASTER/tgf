package id.co.telkomsigma.tgf.swing.component.menubar.home;

import id.co.telkomsigma.tgf.swing.component.base.IResourceBundleLocator;
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
public class MenuHome extends JMenu implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5018262006136612691L;

    @Autowired
    private MenuDashboard menuDashboard;

    @Autowired
    private IResourceBundleLocator rb;

    @Value("${menu.home.imageurl}")
    private String menuHomeImageUrl;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText(rb.getValue("menu.home.name"));
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(menuHomeImageUrl)));
        this.add(menuDashboard);
    }

    public MenuDashboard getMenuDashboard() {
        return menuDashboard;
    }
}
