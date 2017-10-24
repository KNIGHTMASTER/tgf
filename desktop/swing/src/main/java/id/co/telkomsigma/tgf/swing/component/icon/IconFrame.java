package id.co.telkomsigma.tgf.swing.component.icon;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class IconFrame implements IIconFrame{
    
    @Override
    public void setIconFrame(JFrame p_JFrame){
        Toolkit kit = Toolkit.getDefaultToolkit();        
        Image frameIcon = kit.getImage(getClass().getClassLoader().getResource("assets/jframeicon.png"));
        p_JFrame.setIconImage(frameIcon);
    }
    
}
