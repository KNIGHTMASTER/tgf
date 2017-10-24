package id.co.telkomsigma.tgf.swing.component.frame;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IFrameSetup {
    
    void doCompleteSetup(JFrame p_JFrame, Component p_Component);
    
    void setView(JFrame p_JFrame);
    
    void setIcon(JFrame p_JFrame);
}
