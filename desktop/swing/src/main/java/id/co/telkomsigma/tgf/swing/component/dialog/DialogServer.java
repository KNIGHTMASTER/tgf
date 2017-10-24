package id.co.telkomsigma.tgf.swing.component.dialog;

import id.co.telkomsigma.tgf.swing.component.base.ICentralizePositionComponent;
import id.co.telkomsigma.tgf.swing.component.base.IComponentMenuCallable;
import id.co.telkomsigma.tgf.swing.controller.dialog.ControllerDialogServer;
import id.co.telkomsigma.tgf.swing.view.tab.TabSettings;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class DialogServer extends JDialog implements IComponentInitializer, IComponentAction, IComponentMenuCallable {

    /**
     *
     *
     */
    private static final long serialVersionUID = 6858232016968301160L;

    private static final Logger LOGGER = LoggerFactory.getLogger(DialogServer.class);

    @Autowired
    private TabSettings tabSettings;

    @Autowired
    private ICentralizePositionComponent centralizePositionComponent;

    @Autowired
    private ControllerDialogServer controllerDialogServer;

    public boolean isInitialized = false;

    @Override
    public void initComponents() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image dialogServiceIcon = kit.getImage(getClass().getClassLoader().getResource("assets/jframeicon.png"));
        this.setIconImage(dialogServiceIcon);
        this.setTitle("Application Settings");
        this.setModal(true);
        this.setResizable(false);
        this.setSize(500, 250);
        centralizePositionComponent.setDialogToCenter(this);

        this.add(tabSettings);

        isInitialized = true;
    }
    
    @Override
    public void initAction() {
    }

    @Override
    public void setMainFrame(JFrame p_MainFrame) {

    }

    @Override
    public boolean isInitialized() {
        return isInitialized;
    }
}
