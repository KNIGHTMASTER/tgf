package id.co.telkomsigma.tgf.swing.component.dialog;

import id.co.telkomsigma.tgf.swing.component.base.ICentralizePositionComponent;
import id.co.telkomsigma.tgf.swing.controller.dialog.ControllerDialogLogin;
import id.co.telkomsigma.tgf.swing.view.frame.MainFrame;
import id.co.telkomsigma.tgf.swing.view.panel.login.DialogLoginPanelBottom;
import id.co.telkomsigma.tgf.swing.view.panel.login.DialogLoginPanelTop;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class DialogLogin extends JDialog implements IComponentInitializer, IComponentAction {
    
    private static final long serialVersionUID = 6858232016968301160L;    
    
    @Autowired
    private ControllerDialogLogin controllerDialogLogin;
    
    @Autowired
    private DialogLoginPanelTop dialogLoginPanelTop;
    
    @Autowired
    private DialogLoginPanelBottom dialogLoginPanelBottom;

    @Autowired
    private ICentralizePositionComponent centralizePositionComponent;

    private MainFrame mainFrame;
    
    private boolean isInitiated = false;

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }            
    
    @Override
    public void initComponents() {
        this.setTitle("Login");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image dialogIcon = kit.getImage(getClass().getClassLoader().getResource("assets/jframeicon.png"));
        this.setIconImage(dialogIcon);

        this.getContentPane().add(dialogLoginPanelTop, BorderLayout.CENTER);
        this.getContentPane().add(dialogLoginPanelBottom, BorderLayout.PAGE_END);
        this.setModal(true);
        this.setSize(400, 150);
        centralizePositionComponent.setDialogToCenter(this);

        initAction();
        isInitiated = true;
    }                
    
    @Override
    public void initAction() {
        final JTextField txtUserName = dialogLoginPanelTop.getDialogLoginPanelRight().getTxtUserName();
        final JPasswordField txtPassword = dialogLoginPanelTop.getDialogLoginPanelRight().getTxtPassword();
        dialogLoginPanelBottom.getBtLogin().addActionListener(evt -> controllerDialogLogin.btLoginActionPerformed(evt, txtUserName, mainFrame, rootPane, txtPassword, DialogLogin.this));
        
        dialogLoginPanelBottom.getBtReset().addActionListener(evt -> controllerDialogLogin.btResetActionPerformed(evt, txtUserName, txtPassword));
    }           

    public boolean isInitiated() {
        return isInitiated;
    }
        
}
