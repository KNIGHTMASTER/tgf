package id.co.telkomsigma.tgf.swing.view.internalframe.dashboard;

import id.co.telkomsigma.tgf.swing.component.base.ICentralizePositionComponent;
import id.co.telkomsigma.tgf.swing.view.panel.internalframe.dashboard.InternalFrameDashboardPanelCenter;
import id.co.telkomsigma.tgf.swing.view.panel.internalframe.dashboard.InternalFrameDashboardPanelLeft;
import id.co.telkomsigma.tgf.util.IComponentAction;
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
public class InternalFrameDashboard extends JInternalFrame implements IComponentInitializer, IComponentAction {

    /**
     *
     *
     */
    private static final long serialVersionUID = -7054309726946051212L;

    @Autowired
    private InternalFrameDashboardPanelLeft panelLeft;

    @Autowired
    private InternalFrameDashboardPanelCenter panelCenter;


    @Autowired
    private ICentralizePositionComponent centralizePositionComponent;

    @PostConstruct
    @Override
    public void initComponents() {
//        this.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Menu"));
        this.setTitle("Menu");
        this.setMaximizable(true);
        this.setResizable(true);
        this.setClosable(true);
        this.setIconifiable(true);
        
        initButton();
        initAction();

        this.add(panelLeft, java.awt.BorderLayout.PAGE_END);                
        this.getContentPane().add(panelCenter, java.awt.BorderLayout.CENTER);


        centralizePositionComponent.setIFrameToCenter(this);
    }
    
    private void initButton(){
    }

    @Override
    public void initAction(){
    }

    public InternalFrameDashboardPanelCenter getPanelCenter() {
        return panelCenter;
    }
}
