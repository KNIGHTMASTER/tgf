package id.co.telkomsigma.tgf.swing.controller.dialog;

import id.co.telkomsigma.tgf.swing.component.dialog.DialogLogin;
import id.co.telkomsigma.tgf.swing.controller.auth.ControllerAuth;
import id.co.telkomsigma.tgf.swing.view.frame.MainFrame;
import id.co.telkomsigma.tgf.util.UIConstant.Common.Punctuation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ControllerDialogLogin {

    @Autowired
    private ControllerAuth controllerAuth;
    
    public void btLoginActionPerformed(java.awt.event.ActionEvent evt, JTextField txtUserName, MainFrame mainFrame, java.awt.Component rootPane, JPasswordField txtPassword, DialogLogin dialogLogin) {
        String userName = txtUserName.getText().trim();
        String password = String.valueOf(txtPassword.getPassword()).trim();
        txtUserName.setText(Punctuation.EMPTY);
        txtPassword.setText(Punctuation.EMPTY);
        controllerAuth.authenticateAndAuthorize(mainFrame, dialogLogin, userName, password);
    }
    
    public void btResetActionPerformed(java.awt.event.ActionEvent evt, JTextField txtUserName, JPasswordField txtPassword){
        txtUserName.setText(Punctuation.EMPTY);
        txtPassword.setText(Punctuation.EMPTY);
        txtUserName.requestFocus();
    }
}
