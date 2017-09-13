package id.co.telkomsigma.tgf.web.admin.vaadin.dto;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created on 9/13/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class MenuDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2590150716412383167L;

    private LinkedList<MenuItemDTO> menuItemDTOs;

    public LinkedList<MenuItemDTO> getMenuItemDTOs() {
        return menuItemDTOs;
    }

    public void setMenuItemDTOs(LinkedList<MenuItemDTO> menuItemDTOs) {
        this.menuItemDTOs = menuItemDTOs;
    }
}
