package id.co.telkomsigma.tgf.swing.component.button.login;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ButtonReset extends JButton implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6973554628553837980L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("assets/bt-reset.png")));
        this.setMnemonic('R');
        this.setFocusable(false);
        this.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        this.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    }
}
