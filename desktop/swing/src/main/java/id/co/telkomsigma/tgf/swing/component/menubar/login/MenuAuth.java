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
public class MenuAuth extends JMenu implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -3468948049209449547L;

    @Autowired
    private SubMenuLogin menuLogin;

    @Autowired
    private SubMenuLogout menuLogout;

    @Autowired
    private IResourceBundleLocator rb;

    @Value("${menu.auth.imageurl}")
    private String menuAuthImageUrl;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText(rb.getValue("menu.auth.name"));
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(menuAuthImageUrl)));
        this.add(menuLogin);
        this.add(menuLogout);
    }

    public SubMenuLogin getMenuLogin() {
        return menuLogin;
    }

    public SubMenuLogout getMenuLogout() {
        return menuLogout;
    }
}
