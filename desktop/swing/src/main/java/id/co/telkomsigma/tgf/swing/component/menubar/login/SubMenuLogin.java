package id.co.telkomsigma.tgf.swing.component.menubar.login;

import id.co.telkomsigma.tgf.swing.component.base.IResourceBundleLocator;
import id.co.telkomsigma.tgf.swing.controller.frame.ControllerFrameMain;
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
public class SubMenuLogin extends JMenuItem implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1068902021620896723L;

    @Autowired
    private IResourceBundleLocator rb;

    @Value("${submenu.login.imageurl}")
    private String subMenuLoginImageUrl;

    @Autowired
    private ControllerFrameMain controllerFrameMain;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText(rb.getValue("submenu.login.name"));
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(subMenuLoginImageUrl)));
        this.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        this.addActionListener(e -> controllerFrameMain.subMenuLoginActionPerformed());
    }
}
