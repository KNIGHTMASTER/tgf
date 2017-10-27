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
public class MenuDashboard extends JMenuItem implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 6957671563077409605L;

    @Autowired
    private IResourceBundleLocator rb;

    @Value("${menu.dashboard.imageurl}")
    private String menuDashboardImageUrl;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText(rb.getValue("menu.dashboard.name"));
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(menuDashboardImageUrl)));
        this.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
    }
}
