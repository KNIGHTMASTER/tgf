package id.co.telkomsigma.tgf.swing.view.panel.tab.settings.database;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created on 5/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelTabSettingDatabaseTop extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5989264536732045185L;

    @Autowired
    PanelTabSettingDatabaseLeft panelTabSettingDatabaseLeft;

    @Autowired
    PanelTabSettingDatabaseRight panelTabSettingDatabaseRight;


    @PostConstruct
    @Override
    public void initComponents() {
        this.setPreferredSize(new java.awt.Dimension(200, 200));
        this.setLayout(new java.awt.BorderLayout());
        this.add(panelTabSettingDatabaseLeft, java.awt.BorderLayout.WEST);
        this.add(panelTabSettingDatabaseRight, java.awt.BorderLayout.CENTER);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        this.setLayout(new java.awt.GridLayout(1, 2));
    }

    public PanelTabSettingDatabaseLeft getPanelTabSettingDatabaseLeft() {
        return panelTabSettingDatabaseLeft;
    }

    public void setPanelTabSettingDatabaseLeft(PanelTabSettingDatabaseLeft panelTabSettingDatabaseLeft) {
        this.panelTabSettingDatabaseLeft = panelTabSettingDatabaseLeft;
    }

    public PanelTabSettingDatabaseRight getPanelTabSettingDatabaseRight() {
        return panelTabSettingDatabaseRight;
    }

    public void setPanelTabSettingDatabaseRight(PanelTabSettingDatabaseRight panelTabSettingDatabaseRight) {
        this.panelTabSettingDatabaseRight = panelTabSettingDatabaseRight;
    }
}
