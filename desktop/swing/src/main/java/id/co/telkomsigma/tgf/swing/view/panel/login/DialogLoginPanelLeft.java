package id.co.telkomsigma.tgf.swing.view.panel.login;

import id.co.telkomsigma.tgf.swing.component.base.IResourceBundleLocator;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class DialogLoginPanelLeft extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7271039294614896940L;

    @Autowired
    IResourceBundleLocator rb;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new java.awt.GridLayout(2, 0));
        
        JLabel lblUserName = new JLabel();
        lblUserName.setText(rb.getValue("ui.login.label.username"));
        this.add(lblUserName);

        JLabel lblPassword = new JLabel();
        lblPassword.setText(rb.getValue("ui.login.label.password"));
        this.add(lblPassword);
    }

}
