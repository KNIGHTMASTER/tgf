package id.co.telkomsigma.tgf.swing.controller.frame;

import id.co.telkomsigma.tgf.swing.dto.param.ParamControllerFrameMain;
import id.co.telkomsigma.tgf.util.IParameterizedComponent;
import org.springframework.stereotype.Component;

import java.awt.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ControllerFrameMain implements IParameterizedComponent<ParamControllerFrameMain> {
    Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
    private ParamControllerFrameMain paramControllerFrameMain;

    public void subMenuDashboardActionPerformed(){

        if (getParam().getInternalFrameDashboard() != null) {
            getParam().getInternalFrameDashboard().dispose();
        }        
        getParam().getDesktopPaneMain().add(getParam().getInternalFrameDashboard());
        int x = (getParam().getScreenSizeWidth() - getParam().getInternalFrameDashboard().getWidth()) / 30;
        int y = (getParam().getScreenSizeHeight() - getParam().getInternalFrameDashboard().getHeight()) / 30;
        getParam().getInternalFrameDashboard().setSize((int) screenSize.getWidth()-(int) (screenSize.getWidth()*5/100), (int) screenSize.getHeight()-(int) (screenSize.getHeight()*15/100));
        getParam().getInternalFrameDashboard().setLocation(x, y);
        getParam().getInternalFrameDashboard().setVisible(true);
    }
    
    public void subMenuLoginActionPerformed(){
        if (!getParam().getDialogLogin().isInitiated()) {
            getParam().getDialogLogin().setMainFrame(paramControllerFrameMain.getMainFrame());
            getParam().getDialogLogin().initComponents();
        }
        getParam().getDialogLogin().setVisible(true);
    }
    
    public void subMenuThemeActionPerformed(){
        if (!getParam().getDialogTheme().isIsInitiated()){
            getParam().getDialogTheme().setComponent(paramControllerFrameMain.getMainFrame());
            getParam().getDialogTheme().initComponents();
        }
        getParam().getDialogTheme().setVisible(true);
    }
    
    public void subMenuServerActionPerformed(){
        if (!getParam().getDialogServer().isInitialized()){
            getParam().getDialogServer().setMainFrame(paramControllerFrameMain.getMainFrame());
            getParam().getDialogServer().initComponents();
        }
        getParam().getDialogServer().setVisible(true);
    }
    
    @Override
    public void setParam(ParamControllerFrameMain p_Param) {
        this.paramControllerFrameMain = p_Param;
    }

    @Override
    public ParamControllerFrameMain getParam() {
        return paramControllerFrameMain;
    }
}
