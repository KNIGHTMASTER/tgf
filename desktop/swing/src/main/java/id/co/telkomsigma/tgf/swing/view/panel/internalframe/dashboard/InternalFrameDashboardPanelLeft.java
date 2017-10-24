package id.co.telkomsigma.tgf.swing.view.panel.internalframe.dashboard;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class InternalFrameDashboardPanelLeft extends JPanel implements IComponentInitializer {

    /**
     *
     *
     */
    private static final long serialVersionUID = 1660104272255643289L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setMinimumSize(new java.awt.Dimension(64, 90));
        this.setOpaque(true);
        this.setLayout(new java.awt.GridLayout(1, 5, 150, 0));
    }
}
