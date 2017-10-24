package id.co.telkomsigma.tgf.swing.controller.dialog;

import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.Properties;

/**
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ControllerDialogTheme {

    @Value("${general.dialog.sidebar.text}")
    private String generalDialogSidebarText;

    public void start(java.awt.event.ActionEvent evt, JComboBox p_ComboTheme, java.awt.Component p_Component) {
        String theme = "Default";
        try {
            Properties props = new Properties();
            props.put("logoString", generalDialogSidebarText);
            switch (p_ComboTheme.getSelectedIndex()) {
                case 0:
                    UIManager.setLookAndFeel(new NimbusLookAndFeel());
                    break;
                case 1:
                    UIManager.setLookAndFeel(new WindowsClassicLookAndFeel());
                    break;
                case 2:
                    UIManager.setLookAndFeel(new WindowsLookAndFeel());
                    break;
                case 3:
                    com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme(theme);
                    com.jtattoo.plaf.acryl.AcrylLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                    break;
                case 4:
                    com.jtattoo.plaf.aero.AeroLookAndFeel.setTheme(theme);
                    com.jtattoo.plaf.aero.AeroLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
                    break;
                case 5:
                    com.jtattoo.plaf.aluminium.AluminiumLookAndFeel.setTheme(theme);
                    com.jtattoo.plaf.aluminium.AluminiumLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                    break;
                case 6:
                    com.jtattoo.plaf.bernstein.BernsteinLookAndFeel.setTheme(theme);
                    com.jtattoo.plaf.bernstein.BernsteinLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
                    break;
                case 7:
                    com.jtattoo.plaf.fast.FastLookAndFeel.setTheme(theme);
                    com.jtattoo.plaf.fast.FastLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
                    break;
                case 8:
                    com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setTheme(theme);
                    com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
                    break;
                case 9:
                    com.jtattoo.plaf.hifi.HiFiLookAndFeel.setTheme(theme);
                    com.jtattoo.plaf.hifi.HiFiLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                    break;
                case 10:
                    com.jtattoo.plaf.luna.LunaLookAndFeel.setTheme(theme);
                    com.jtattoo.plaf.luna.LunaLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
                    break;
                case 11:
                    UIManager.setLookAndFeel(new MetalLookAndFeel());
                    break;
                case 12:
                    com.jtattoo.plaf.mcwin.McWinLookAndFeel.setTheme(theme);
                    com.jtattoo.plaf.mcwin.McWinLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
                    break;
                case 13:
                    com.jtattoo.plaf.mint.MintLookAndFeel.setTheme(theme);
                    com.jtattoo.plaf.mint.MintLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
                    break;
                case 14:
                    com.jtattoo.plaf.noire.NoireLookAndFeel.setTheme(theme);
                    com.jtattoo.plaf.noire.NoireLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
                    break;
                case 15:
                    com.jtattoo.plaf.smart.SmartLookAndFeel.setTheme(theme);
                    com.jtattoo.plaf.smart.SmartLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                    break;
                case 16:
                    com.jtattoo.plaf.texture.TextureLookAndFeel.setTheme(theme);
                    com.jtattoo.plaf.texture.TextureLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Theme is not supported" + e);
        } finally {
            SwingUtilities.updateComponentTreeUI(p_Component);
        }
    }

}
