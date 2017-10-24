package id.co.telkomsigma.tgf.swing.view.panel.tab.settings.database;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created on 5/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelTabSettingDatabaseLeft extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6347210917533527136L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new java.awt.GridLayout(5, 0));

        JLabel lblHost = new JLabel();
        lblHost.setText("Host");
        this.add(lblHost);

        JLabel lblPort = new JLabel();
        lblPort.setText("Port");
        this.add(lblPort);

        JLabel lblUserName = new JLabel();
        lblUserName.setText("User Name");
        this.add(lblUserName);

        JLabel lblPassword = new JLabel();
        lblPassword.setText("Password");
        this.add(lblPassword);

        JLabel lblSchemaName = new JLabel();
        lblSchemaName.setText("Schema Name");
        this.add(lblSchemaName);

    }
}
