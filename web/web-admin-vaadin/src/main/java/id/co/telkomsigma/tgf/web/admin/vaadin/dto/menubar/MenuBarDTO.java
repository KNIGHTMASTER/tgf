package id.co.telkomsigma.tgf.web.admin.vaadin.dto.menubar;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 8/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class MenuBarDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -463437281289601174L;

    private List<MenuItemParentDTO> menuList;

    public List<MenuItemParentDTO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuItemParentDTO> menuList) {
        this.menuList = menuList;
    }
}
