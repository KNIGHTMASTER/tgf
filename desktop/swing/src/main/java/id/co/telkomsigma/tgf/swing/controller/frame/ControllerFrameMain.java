package id.co.telkomsigma.tgf.swing.controller.frame;

import id.co.telkomsigma.tgf.swing.dto.param.ParamControllerFrameMain;
import id.co.telkomsigma.tgf.util.IParameterizedComponent;
import org.springframework.stereotype.Component;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ControllerFrameMain implements IParameterizedComponent<ParamControllerFrameMain> {
    private ParamControllerFrameMain paramControllerFrameMain;
    
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
