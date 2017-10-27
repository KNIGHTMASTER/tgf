package id.co.telkomsigma.tgf.swing.component.menubar.theme;

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
public class MenuTheme extends JMenuItem implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5686901130189899197L;

    @Autowired
    private IResourceBundleLocator rb;

    @Value("${menu.themes.imageurl}")
    private String menuThemesImageUrl;

    @Autowired
    private ControllerFrameMain controllerFrameMain;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText(rb.getValue("menu.themes.name"));
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(menuThemesImageUrl)));
        this.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        this.addActionListener(e -> controllerFrameMain.subMenuThemeActionPerformed());
    }
}
