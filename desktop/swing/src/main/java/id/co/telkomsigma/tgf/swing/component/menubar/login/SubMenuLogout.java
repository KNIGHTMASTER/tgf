package id.co.telkomsigma.tgf.swing.component.menubar.login;

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
public class SubMenuLogout extends JMenuItem implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -302921316457860633L;

    @Autowired
    private IResourceBundleLocator rb;

    @Value("${submenu.logout.imageurl}")
    private String subMenuLogoutImageUrl;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText(rb.getValue("submenu.logout.name"));
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(subMenuLogoutImageUrl)));
        this.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
    }
}
