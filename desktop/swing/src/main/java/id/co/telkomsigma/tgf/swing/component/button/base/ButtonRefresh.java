package id.co.telkomsigma.tgf.swing.component.button.base;

import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * Created on 6/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ButtonRefresh extends JButton implements IComponentInitializer {

    /**
     *
     *
     */
    private static final long serialVersionUID = -4586525469944550439L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText("Refresh");
        this.setMnemonic('R');
    }
}
