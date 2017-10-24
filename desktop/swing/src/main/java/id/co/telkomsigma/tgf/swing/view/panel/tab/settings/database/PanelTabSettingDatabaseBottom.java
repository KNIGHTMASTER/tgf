package id.co.telkomsigma.tgf.swing.view.panel.tab.settings.database;

import id.co.telkomsigma.tgf.swing.component.button.panel.tab.settings.database.ButtonSavePanelTabSettingDatabase;
import id.co.telkomsigma.tgf.swing.component.button.panel.tab.settings.database.ButtonTestPanelTabSettingDatabase;
import id.co.telkomsigma.tgf.swing.util.IPropertyModifier;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created on 5/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelTabSettingDatabaseBottom extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1506200383903455098L;

    @Autowired
    @Qualifier("btTestPanelTabSettingDatabase")
    private ButtonTestPanelTabSettingDatabase btTestPanelTabSettingDatabase;

    @Autowired
    @Qualifier("btSavePanelTabSettingDatabase")
    private ButtonSavePanelTabSettingDatabase btSavePanelTabSettingDatabase;

    @Autowired
    private IPropertyModifier propertyModifier;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new java.awt.GridLayout(1, 1));

        this.add(btSavePanelTabSettingDatabase);
        this.add(btTestPanelTabSettingDatabase);
    }

    public ButtonTestPanelTabSettingDatabase getBtTestPanelTabSettingDatabase() {
        return btTestPanelTabSettingDatabase;
    }

    public ButtonSavePanelTabSettingDatabase getBtSavePanelTabSettingDatabase() {
        return btSavePanelTabSettingDatabase;
    }
}
