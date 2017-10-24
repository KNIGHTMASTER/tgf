package id.co.telkomsigma.tgf.swing.view.panel.tab.settings.database;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created on 5/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelTabSettingDatabaseRight extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2861009280458815728L;

    @Value("${db.host}")
    String dbHost;

    @Value("${db.port}")
    String dbPort;

    @Value("${db.schema}")
    String dbSchemaName;

    @Value("${db.username}")
    String dbUserName;

    @Value("${db.password}")
    String dbPassword;

    private JTextField txtHost;
    private JTextField txtPort;
    private JTextField txtUserName;
    private JTextField txtPassword;
    private JTextField txtSchemaName;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new java.awt.GridLayout(5, 0));

        txtHost = new JTextField();
        txtPort = new JTextField();
        txtUserName = new JTextField();
        txtPassword = new JTextField();
        txtSchemaName = new JTextField();

        txtHost.setText(dbHost);
        txtPort.setText(dbPort);
        txtUserName.setText(dbUserName);
        txtPassword.setText(dbPassword);
        txtSchemaName.setText(dbSchemaName);

        this.add(txtHost);
        this.add(txtPort);
        this.add(txtUserName);
        this.add(txtPassword);
        this.add(txtSchemaName);

    }

    public JTextField getTxtHost() {
        return txtHost;
    }

    public void setTxtHost(JTextField txtHost) {
        this.txtHost = txtHost;
    }

    public JTextField getTxtPort() {
        return txtPort;
    }

    public void setTxtPort(JTextField txtPort) {
        this.txtPort = txtPort;
    }

    public JTextField getTxtUserName() {
        return txtUserName;
    }

    public void setTxtUserName(JTextField txtUserName) {
        this.txtUserName = txtUserName;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(JTextField txtPassword) {
        this.txtPassword = txtPassword;
    }

    public JTextField getTxtSchemaName() {
        return txtSchemaName;
    }

    public void setTxtSchemaName(JTextField txtSchemaName) {
        this.txtSchemaName = txtSchemaName;
    }
}
