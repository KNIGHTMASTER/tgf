package id.co.telkomsigma.tgf.swing.view.tab;

import id.co.telkomsigma.tgf.swing.controller.tab.ControllerTabSettings;
import id.co.telkomsigma.tgf.swing.view.panel.tab.settings.database.PanelTabSettingDatabase;
import id.co.telkomsigma.tgf.swing.view.panel.tab.settings.language.PanelTabSettingLanguage;
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
public class TabSettings extends JTabbedPane implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 8837090291134162688L;

    @Autowired
    private PanelTabSettingDatabase panelTabSettingDatabase;

    @Autowired
    private PanelTabSettingLanguage panelTabSettingLanguage;

    @Autowired
    ControllerTabSettings controllerTabSettings;

    @PostConstruct
    @Override
    public void initComponents() {
        this.add("Database", panelTabSettingDatabase);
        this.add("Language", panelTabSettingLanguage);
        this.addChangeListener(e -> {
            controllerTabSettings.tabSettingChangePerformed(this);
        });
    }


    public PanelTabSettingDatabase getPanelTabSettingDatabase() {
        return panelTabSettingDatabase;
    }

    public PanelTabSettingLanguage getPanelTabSettingLanguage() {
        return panelTabSettingLanguage;
    }

    public ControllerTabSettings getControllerTabSettings() {
        return controllerTabSettings;
    }
}
