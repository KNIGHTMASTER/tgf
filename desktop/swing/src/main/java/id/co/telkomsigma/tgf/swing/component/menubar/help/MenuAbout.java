package id.co.telkomsigma.tgf.swing.component.menubar.help;

import id.co.telkomsigma.tgf.swing.component.base.IResourceBundleLocator;
import id.co.telkomsigma.tgf.swing.component.dialog.DialogAbout;
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
public class MenuAbout extends JMenuItem implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 8948371116850015245L;

    @Autowired
    private DialogAbout dialogAbout;

    @Autowired
    private IResourceBundleLocator rb;

    @Value("${menu.about.imageurl}")
    private String menuAboutImageUrl;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText(rb.getValue("menu.about.name"));
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(menuAboutImageUrl)));
        this.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        this.addActionListener(e -> dialogAbout.setVisible(true));
    }
}
