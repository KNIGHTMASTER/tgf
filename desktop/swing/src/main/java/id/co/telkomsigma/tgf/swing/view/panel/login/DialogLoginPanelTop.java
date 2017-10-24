package id.co.telkomsigma.tgf.swing.view.panel.login;

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
public class DialogLoginPanelTop extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5008424482762613192L;
    
    @Autowired
    private DialogLoginPanelLeft dialogLoginPanelLeft;
    
    @Autowired
    private DialogLoginPanelRight dialogLoginPanelRight;
    
    @PostConstruct
    @Override
    public void initComponents() {
        this.setPreferredSize(new java.awt.Dimension(200, 200));
        this.setLayout(new java.awt.BorderLayout());
        this.add(dialogLoginPanelLeft, java.awt.BorderLayout.WEST);
        this.add(dialogLoginPanelRight, java.awt.BorderLayout.CENTER);
        this.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        this.setLayout(new java.awt.GridLayout(1, 2));       
    }

    public DialogLoginPanelLeft getDialogLoginPanelLeft() {
        return dialogLoginPanelLeft;
    }

    public DialogLoginPanelRight getDialogLoginPanelRight() {
        return dialogLoginPanelRight;
    }
    
}
