package id.co.telkomsigma.tgf.web.admin.vaadin.dto.menubar;

import com.vaadin.ui.MenuBar;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 8/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class MenuItemParentDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -3818096398240841062L;
    private String caption;
    private String icon;
    private MenuBar.Command command;

    private List<MenuItemChild1DTO> menuItemChild1DTOList;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public MenuBar.Command getCommand() {
        return command;
    }

    public void setCommand(MenuBar.Command command) {
        this.command = command;
    }

    public List<MenuItemChild1DTO> getMenuItemChild1DTOList() {
        return menuItemChild1DTOList;
    }

    public void setMenuItemChild1DTOList(List<MenuItemChild1DTO> menuItemChild1DTOList) {
        this.menuItemChild1DTOList = menuItemChild1DTOList;
    }
}
