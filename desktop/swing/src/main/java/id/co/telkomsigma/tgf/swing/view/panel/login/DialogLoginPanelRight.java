package id.co.telkomsigma.tgf.swing.view.panel.login;

import id.co.telkomsigma.tgf.swing.component.button.login.ButtonLogin;
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
public class DialogLoginPanelRight extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6110242459623006348L;
    
    @Autowired
    private ButtonLogin btLogin;
    
    private JPasswordField txtPassword;
    private JTextField txtUserName;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setPreferredSize(new java.awt.Dimension(100, 100));
        this.setLayout(new java.awt.GridLayout(2, 0));

        txtUserName = new JTextField();
        txtUserName.addActionListener(evt -> txtPassword.requestFocus());
        this.add(txtUserName);

        txtPassword = new JPasswordField();
        txtPassword.addActionListener(evt -> btLogin.doClick());
        this.add(txtPassword);
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getTxtUserName() {
        return txtUserName;
    }
}
