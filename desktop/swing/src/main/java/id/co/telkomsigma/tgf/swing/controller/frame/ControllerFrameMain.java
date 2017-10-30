package id.co.telkomsigma.tgf.swing.controller.frame;

import id.co.telkomsigma.tgf.swing.dto.param.ControllerFrameMainParam;
import id.co.telkomsigma.tgf.util.IParameterizedComponent;
import org.springframework.stereotype.Component;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ControllerFrameMain implements IParameterizedComponent<ControllerFrameMainParam> {
    private ControllerFrameMainParam controllerFrameMainParam;
    
    public void subMenuLoginActionPerformed(){
        if (!getParam().getDialogLogin().isInitiated()) {
            getParam().getDialogLogin().setMainFrame(controllerFrameMainParam.getMainFrame());
            getParam().getDialogLogin().initComponents();
        }
        getParam().getDialogLogin().setVisible(true);
    }
    
    public void subMenuThemeActionPerformed(){
        if (!getParam().getDialogTheme().isIsInitiated()){
            getParam().getDialogTheme().setComponent(controllerFrameMainParam.getMainFrame());
            getParam().getDialogTheme().initComponents();
        }
        getParam().getDialogTheme().setVisible(true);
    }
    
    public void subMenuServerActionPerformed(){
        if (!getParam().getDialogServer().isInitialized()){
            getParam().getDialogServer().setMainFrame(controllerFrameMainParam.getMainFrame());
            getParam().getDialogServer().initComponents();
        }
        getParam().getDialogServer().setVisible(true);
    }
    
    @Override
    public void setParam(ControllerFrameMainParam p_Param) {
        this.controllerFrameMainParam = p_Param;
    }

    @Override
    public ControllerFrameMainParam getParam() {
        return controllerFrameMainParam;
    }
}
