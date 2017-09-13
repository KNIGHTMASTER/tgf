package id.co.telkomsigma.tgf.web.admin.vaadin.dto;

import java.io.Serializable;

/**
 * Created on 9/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class MenuItemDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 743173099152237606L;

    private String name;
    private String key;
    private String viewName;
    private String icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
