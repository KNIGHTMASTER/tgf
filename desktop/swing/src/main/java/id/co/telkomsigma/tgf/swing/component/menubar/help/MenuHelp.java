package id.co.telkomsigma.tgf.swing.component.menubar.help;

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
public class MenuHelp extends JMenu implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 171816774720806010L;

    @Autowired
    private MenuAbout menuAbout;

    @Autowired
    private IResourceBundleLocator rb;

    @Value("${menu.help.imageurl}")
    private String menuHelpImageUrl;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText(rb.getValue("menu.help.name"));
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(menuHelpImageUrl)));
        this.add(menuAbout);
    }
}
