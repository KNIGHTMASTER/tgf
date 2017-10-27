package id.co.telkomsigma.tgf.web.admin.vaadin.dto;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * Created on 10/26/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RoleDTO implements GrantedAuthority, Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 272224781901722658L;

    private Long id;
    private String name;
    private boolean status;

    @Override
    public String getAuthority() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
