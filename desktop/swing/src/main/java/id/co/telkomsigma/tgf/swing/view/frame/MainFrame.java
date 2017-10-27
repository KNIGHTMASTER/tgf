package id.co.telkomsigma.tgf.swing.view.frame;

import id.co.telkomsigma.tgf.swing.component.base.IResourceBundleLocator;
import id.co.telkomsigma.tgf.swing.component.dialog.DialogAbout;
import id.co.telkomsigma.tgf.swing.component.dialog.DialogLogin;
import id.co.telkomsigma.tgf.swing.component.dialog.DialogServer;
import id.co.telkomsigma.tgf.swing.component.dialog.DialogTheme;
import id.co.telkomsigma.tgf.swing.component.frame.IFrameSetup;
import id.co.telkomsigma.tgf.swing.component.menubar.AppSwingMenuBar;
import id.co.telkomsigma.tgf.swing.component.sidebar.DefaultSideBarMenu;
import id.co.telkomsigma.tgf.swing.controller.frame.ControllerFrameMain;
import id.co.telkomsigma.tgf.swing.dto.param.ParamControllerFrameMain;
import id.co.telkomsigma.tgf.swing.view.internalframe.dashboard.InternalFrameDashboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private InternalFrameDashboard internalFrameDashboard;

    @Autowired
    private ControllerFrameMain controllerFrameMain;

    @Autowired
    private DefaultSideBarMenu defaultSideBarMenu;

    @Autowired
    private AppSwingMenuBar appMenuBar;

    @Autowired
    private IResourceBundleLocator rb;

    @PostConstruct
    public void setupFrame(){
        frameSetup.doCompleteSetup(MainFrame.this, MainFrame.this);
        initParam();
        controllerFrameMain.setParam(paramControllerFrameMain);
        initComponents();
    }


    private void initParam(){
        paramControllerFrameMain = new ParamControllerFrameMain();

        paramControllerFrameMain.setScreenSizeHeight(screenSize.height);
        paramControllerFrameMain.setScreenSizeWidth(screenSize.width);
        paramControllerFrameMain.setObserverHeight(HEIGHT);
        paramControllerFrameMain.setObserverWidth(WIDTH);

        paramControllerFrameMain.setMainFrame(this);
        paramControllerFrameMain.setDialogAbout(dialogAbout);
        paramControllerFrameMain.setDialogLogin(dialogLogin);
        paramControllerFrameMain.setDialogServer(dialogServer);
        paramControllerFrameMain.setDialogTheme(dialogTheme);
    }

    public void setMenuVisibility(boolean b){
        internalFrameDashboard.setVisible(b);
        appMenuBar.setMenuVisibility(b);
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        setTitle(rb.getValue("ui.main.title"));
        setMenuVisibility(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setJMenuBar(appMenuBar);
        this.setLayout(new BorderLayout());
        this.add(defaultSideBarMenu, BorderLayout.CENTER);
        pack();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
