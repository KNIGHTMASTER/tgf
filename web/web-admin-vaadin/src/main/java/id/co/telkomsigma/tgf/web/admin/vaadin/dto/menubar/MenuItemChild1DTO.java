package id.co.telkomsigma.tgf.web.admin.vaadin.dto.menubar;

import com.vaadin.ui.MenuBar;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 8/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class MenuItemChild1DTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -712103530883336878L;

    private String caption;
    private String icon;
    private MenuBar.Command command;

    private List<MenuItemChild2DTO> menuItemChild2DTOList;

    public List<MenuItemChild2DTO> getMenuItemChild2DTOList() {
        return menuItemChild2DTOList;
    }

    public void setMenuItemChild2DTOList(List<MenuItemChild2DTO> menuItemChild2DTOList) {
        this.menuItemChild2DTOList = menuItemChild2DTOList;
    }

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

    @Override
    public String toString() {
        return "MenuItemChild1DTO{" +
                "caption='" + caption + '\'' +
                ", icon='" + icon + '\'' +
                ", command=" + command +
                ", menuItemChild2DTOList=" + menuItemChild2DTOList +
                '}';
    }
}
