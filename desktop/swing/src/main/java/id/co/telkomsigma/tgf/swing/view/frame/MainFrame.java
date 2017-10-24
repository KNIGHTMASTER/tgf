package id.co.telkomsigma.tgf.swing.view.frame;

import id.co.telkomsigma.tgf.swing.component.dialog.DialogAbout;
import id.co.telkomsigma.tgf.swing.component.dialog.DialogLogin;
import id.co.telkomsigma.tgf.swing.component.dialog.DialogServer;
import id.co.telkomsigma.tgf.swing.component.dialog.DialogTheme;
import id.co.telkomsigma.tgf.swing.component.frame.IFrameSetup;
import id.co.telkomsigma.tgf.swing.controller.frame.ControllerFrameMain;
import id.co.telkomsigma.tgf.swing.dto.param.ParamControllerFrameMain;
import id.co.telkomsigma.tgf.swing.view.desktoppane.DesktopPaneMain;
import id.co.telkomsigma.tgf.swing.view.internalframe.dashboard.InternalFrameDashboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class MainFrame extends JFrame {

    /**
     *
     *
     */
    private static final long serialVersionUID = -7864902051693765103L;

    private static final Logger LOGGER = LoggerFactory.getLogger(MainFrame.class);

    final Toolkit toolkit = Toolkit.getDefaultToolkit();
    final Dimension screenSize = toolkit.getScreenSize();

    private ParamControllerFrameMain paramControllerFrameMain;

    @Autowired
    private IFrameSetup frameSetup;

    @Autowired
    private DialogTheme dialogTheme;

    @Autowired
    private DialogLogin dialogLogin;

    @Autowired
    private DialogAbout dialogAbout;

    @Autowired
    private DialogServer dialogServer;

    @Autowired
    private DesktopPaneMain desktopPaneMain;

    @Autowired
    private InternalFrameDashboard internalFrameDashboard;

    @Autowired
    private ControllerFrameMain controllerFrameMain;

    @Value("${mainframe.title}")
    private String mainFrameTitle;

    private JMenu menuLogin;
    private JMenu menuMain;
    private JMenu menuSetting;
    private JMenuItem subMenuAbout;
    private JMenuItem subMenuDashboard;
    private JMenuItem subMenuLogin;
    private JMenuItem subMenuLogout;
    private JMenuItem subMenuServer;
    private JMenuItem subMenuTheme;

    @PostConstruct
    public void setupFrame(){
        frameSetup.doCompleteSetup(MainFrame.this, MainFrame.this);
        initButton();
        setMenuVisibility(false);
        setContentPane(desktopPaneMain);
        initParam();
        controllerFrameMain.setParam(paramControllerFrameMain);
    }


    private void initParam(){
        paramControllerFrameMain = new ParamControllerFrameMain();

        paramControllerFrameMain.setScreenSizeHeight(screenSize.height);
        paramControllerFrameMain.setScreenSizeWidth(screenSize.width);
        paramControllerFrameMain.setObserverHeight(HEIGHT);
        paramControllerFrameMain.setObserverWidth(WIDTH);

        paramControllerFrameMain.setMainFrame(this);
        paramControllerFrameMain.setDesktopPaneMain(desktopPaneMain);
        paramControllerFrameMain.setDialogAbout(dialogAbout);
        paramControllerFrameMain.setDialogLogin(dialogLogin);
        paramControllerFrameMain.setDialogServer(dialogServer);
        paramControllerFrameMain.setDialogTheme(dialogTheme);
        paramControllerFrameMain.setInternalFrameDashboard(internalFrameDashboard);

        /*Init Sub Controller that Require instance of Frame*/
        /*ParamCardPanelMaster paramCardPanelMaster = new ParamCardPanelMaster();
        paramCardPanelMaster.setDesktopPaneMain(desktopPaneMain);
        paramCardPanelMaster.setMainFrame(MainFrame.this);
        internalFrameDashboard.getPanelCenter().getCardPanelMaster().getCardPanelMasterTop().getControllerCardPanelMasterTop().setComponent(paramCardPanelMaster);*/
    }

    private void initButton(){
        menuMain.setIcon(new ImageIcon(getClass().getClassLoader().getResource("assets/menu-main.png")));
        subMenuDashboard.setIcon(new ImageIcon(getClass().getClassLoader().getResource("assets/dashboard-small.png")));
        menuLogin.setIcon(new ImageIcon(getClass().getClassLoader().getResource("assets/menu-login.png")));
        subMenuLogin.setIcon(new ImageIcon(getClass().getClassLoader().getResource("assets/sub-menu-login.png")));
        subMenuLogout.setIcon(new ImageIcon(getClass().getClassLoader().getResource("assets/menu-logout.png")));
        menuSetting.setIcon(new ImageIcon(getClass().getClassLoader().getResource("assets/menu-setting.png")));
        subMenuTheme.setIcon(new ImageIcon(getClass().getClassLoader().getResource("assets/menu-theme.png")));
        subMenuAbout.setIcon(new ImageIcon(getClass().getClassLoader().getResource("assets/menu-about.png")));
        subMenuServer.setIcon(new ImageIcon(getClass().getClassLoader().getResource("assets/bt-network.png")));
    }

    public void setMenuVisibility(boolean b){
        internalFrameDashboard.setVisible(b);
        menuMain.setVisible(b);
        subMenuDashboard.setVisible(b);
        subMenuLogin.setVisible(!b);
        subMenuLogout.setVisible(b);
    }

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        JMenuBar menuBar = new JMenuBar();
        menuMain = new JMenu();
        subMenuDashboard = new JMenuItem();
        menuLogin = new JMenu();
        subMenuLogin = new JMenuItem();
        subMenuLogout = new JMenuItem();
        menuSetting = new JMenu();
        subMenuTheme = new JMenuItem();
        subMenuAbout = new JMenuItem();
        subMenuServer = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(mainFrameTitle);

        menuMain.setText("Main");

        subMenuDashboard.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        subMenuDashboard.setText("Dashboard");
        subMenuDashboard.addActionListener(evt -> subMenuDashboardActionPerformed(evt));
        menuMain.add(subMenuDashboard);

        menuBar.add(menuMain);

        menuLogin.setText("Auth");

        subMenuLogin.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        subMenuLogin.setText("Login");
        subMenuLogin.addActionListener(evt -> subMenuLoginActionPerformed(evt));
        menuLogin.add(subMenuLogin);

        subMenuLogout.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        subMenuLogout.setText("Logout");
        subMenuLogout.addActionListener(evt -> subMenuLogoutActionPerformed(evt));
        menuLogin.add(subMenuLogout);

        menuBar.add(menuLogin);

        menuSetting.setText("setting");

        subMenuTheme.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        subMenuTheme.setText("Theme");
        subMenuTheme.addActionListener(evt -> subMenuThemeActionPerformed(evt));
        menuSetting.add(subMenuTheme);

        subMenuServer.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        subMenuServer.setText("Server");
        subMenuServer.addActionListener(evt -> subMenuServerActionPerformed(evt));
        menuSetting.add(subMenuServer);

        subMenuAbout.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        subMenuAbout.setText("About");
        subMenuAbout.addActionListener(evt -> subMenuAboutActionPerformed(evt));
        menuSetting.add(subMenuAbout);


        menuBar.add(menuSetting);

        setJMenuBar(menuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }

    private void subMenuDashboardActionPerformed(java.awt.event.ActionEvent evt) {
        controllerFrameMain.subMenuDashboardActionPerformed();
    }

    private void subMenuLoginActionPerformed(java.awt.event.ActionEvent evt) {
        controllerFrameMain.subMenuLoginActionPerformed();
    }

    private void subMenuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuLogoutActionPerformed
        setMenuVisibility(false);
    }

    private void subMenuThemeActionPerformed(java.awt.event.ActionEvent evt) {
        controllerFrameMain.subMenuThemeActionPerformed();
    }

    private void subMenuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAboutActionPerformed
        dialogAbout.setVisible(true);
    }

    private void subMenuServerActionPerformed(java.awt.event.ActionEvent evt) {
        controllerFrameMain.subMenuServerActionPerformed();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
