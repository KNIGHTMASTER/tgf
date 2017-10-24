package id.co.telkomsigma.tgf.swing.controller.auth;

import id.co.telkomsigma.tgf.swing.component.dialog.DialogLogin;
import id.co.telkomsigma.tgf.swing.view.frame.MainFrame;
import org.springframework.stereotype.Component;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ControllerAuth {
    
    /*@Autowired
    private IAuthService authService;*/
    
    public void authenticateAndAuthorize(MainFrame p_MainFrame, DialogLogin p_DialogLogin, String p_Code, String p_Password){
        /*try{
            if (authService.login(p_Code, p_Password)){
                p_MainFrame.setMenuVisibility(true);
                p_DialogLogin.dispose();
            }else {
                JOptionPane.showMessageDialog(p_DialogLogin, "Login Failed, user name || password does not match DB record", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(p_DialogLogin, "Login Failed, user name || password does not match DB record", "Error", JOptionPane.ERROR_MESSAGE);
        }*/

        p_MainFrame.setMenuVisibility(true);
        p_DialogLogin.dispose();
    }
}
