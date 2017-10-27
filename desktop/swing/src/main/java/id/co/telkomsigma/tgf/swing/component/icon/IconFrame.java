package id.co.telkomsigma.tgf.swing.component.icon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class IconFrame implements IIconFrame{

    @Value("${splashscreen.icon.imageurl}")
    private String iconFrame;

    @Override
    public void setIconFrame(JFrame p_JFrame){
        Toolkit kit = Toolkit.getDefaultToolkit();        
        Image frameIcon = kit.getImage(getClass().getClassLoader().getResource(iconFrame));
        p_JFrame.setIconImage(frameIcon);
    }
    
}
