package id.co.telkomsigma.tgf.swing.dto.param;

import id.co.telkomsigma.tgf.swing.component.dialog.DialogAbout;
import id.co.telkomsigma.tgf.swing.component.dialog.DialogLogin;
import id.co.telkomsigma.tgf.swing.component.dialog.DialogServer;
import id.co.telkomsigma.tgf.swing.component.dialog.DialogTheme;
import id.co.telkomsigma.tgf.swing.view.frame.MainFrame;

import java.io.Serializable;

/**
 * Created on 10/24/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ParamControllerFrameMain implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5049333533348088550L;

    private int screenSizeWidth;
    private int screenSizeHeight;
    private int observerWidth;
    private int observerHeight;

    private MainFrame mainFrame;
    private DialogLogin dialogLogin;
    private DialogAbout dialogAbout;
    private DialogServer dialogServer;
    private DialogTheme dialogTheme;

    public int getScreenSizeWidth() {
        return screenSizeWidth;
    }

    public void setScreenSizeWidth(int screenSizeWidth) {
        this.screenSizeWidth = screenSizeWidth;
    }

    public int getScreenSizeHeight() {
        return screenSizeHeight;
    }

    public void setScreenSizeHeight(int screenSizeHeight) {
        this.screenSizeHeight = screenSizeHeight;
    }

    public int getObserverWidth() {
        return observerWidth;
    }

    public void setObserverWidth(int observerWidth) {
        this.observerWidth = observerWidth;
    }

    public int getObserverHeight() {
        return observerHeight;
    }

    public void setObserverHeight(int observerHeight) {
        this.observerHeight = observerHeight;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public DialogLogin getDialogLogin() {
        return dialogLogin;
    }

    public void setDialogLogin(DialogLogin dialogLogin) {
        this.dialogLogin = dialogLogin;
    }

    public DialogAbout getDialogAbout() {
        return dialogAbout;
    }

    public void setDialogAbout(DialogAbout dialogAbout) {
        this.dialogAbout = dialogAbout;
    }

    public DialogServer getDialogServer() {
        return dialogServer;
    }

    public void setDialogServer(DialogServer dialogServer) {
        this.dialogServer = dialogServer;
    }

    public DialogTheme getDialogTheme() {
        return dialogTheme;
    }

    public void setDialogTheme(DialogTheme dialogTheme) {
        this.dialogTheme = dialogTheme;
    }
}
