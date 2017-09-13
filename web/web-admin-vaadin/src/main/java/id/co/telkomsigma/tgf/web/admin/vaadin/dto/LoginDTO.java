package id.co.telkomsigma.tgf.web.admin.vaadin.dto;

import java.io.Serializable;

/**
 * Created on 7/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class LoginDTO implements Serializable{

    /**
     *
     *
     */
    private static final long serialVersionUID = -204808997700782996L;

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
