package id.co.telkomsigma.tgf.swing.component.button.panel.tab.settings.database;

import id.co.telkomsigma.tgf.swing.component.button.base.ButtonTest;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 5/31/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
@Qualifier("btTestPanelTabSettingDatabase")
public class ButtonTestPanelTabSettingDatabase extends ButtonTest implements IComponentInitializer {
    private static final long serialVersionUID = -6382210647668538553L;

    @PostConstruct
    @Override
    public void initComponents() {
        super.initComponents();
    }
}
