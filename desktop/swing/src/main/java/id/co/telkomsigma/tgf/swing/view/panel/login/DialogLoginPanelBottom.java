package id.co.telkomsigma.tgf.swing.view.panel.login;

import id.co.telkomsigma.tgf.swing.component.button.login.ButtonLogin;
import id.co.telkomsigma.tgf.swing.component.button.login.ButtonReset;
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
public class DialogLoginPanelBottom extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 6471350826305995549L;
    
    @Autowired
    private ButtonLogin btLogin;
    
    @Autowired
    private ButtonReset btReset;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setPreferredSize(new java.awt.Dimension(100, 30));
        this.setLayout(new java.awt.GridLayout(1, 0));        
        this.add(btLogin);
        this.add(btReset);
    }

    public ButtonLogin getBtLogin() {
        return btLogin;
    }

    public ButtonReset getBtReset() {
        return btReset;
    }
    
    

}
