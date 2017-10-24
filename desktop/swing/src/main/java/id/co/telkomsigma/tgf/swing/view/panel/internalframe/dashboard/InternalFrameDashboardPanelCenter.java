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
public class InternalFrameDashboardPanelCenter extends JPanel implements IComponentInitializer {

    /**
     *
     *
     */
    private static final long serialVersionUID = 3437494610626938548L;

    /*@Autowired
    private CardPanelDashboard cardPanelDashboard;
    
    @Autowired
    private CardPanelMaster cardPanelMaster;

    @Autowired
    private CardPanelTransaction cardPanelTransaction;

    @Autowired
    private CardPanelReport cardPanelReport;

    @Autowired
    private CardPanelMaintenance cardPanelMaintenance;*/

    @PostConstruct
    @Override
    public void initComponents() {
        this.setOpaque(false);
        this.setLayout(new java.awt.CardLayout());

        /*this.add(cardPanelDashboard, "dashboard");
        this.add(cardPanelMaster, "master");
        this.add(cardPanelTransaction, "transaksi");
        this.add(cardPanelReport, "laporan");
        this.add(cardPanelMaintenance, "maintenance");*/
    }

/*    public CardPanelMaster getCardPanelMaster() {
        return cardPanelMaster;
    }*/
}
