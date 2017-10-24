package id.co.telkomsigma.tgf.swing.component.frame;

import id.co.telkomsigma.tgf.swing.component.icon.IIconFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class FrameSetupImpl implements IFrameSetup{

    @Autowired
    private IIconFrame iIconFrame;

    @Override
    public void doCompleteSetup(JFrame p_JFrame, java.awt.Component p_Component) {
        setView(p_JFrame);
        setIcon(p_JFrame);

        /**
         * Set UI to Nimbus as Default
         */
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                if ("Nimbus".equals(info.getName())){
                    try {
                        try {
                            UIManager.setLookAndFeel(info.getClassName());
                            SwingUtilities.updateComponentTreeUI(p_Component);
                            break;
                        } catch (UnsupportedLookAndFeelException e) {
                            e.printStackTrace();
                        }
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

    }

    @Override
    public void setView(JFrame p_JFrame) {
        p_JFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    @Override
    public void setIcon(JFrame p_JFrame) {
        iIconFrame.setIconFrame(p_JFrame);
    }


}
