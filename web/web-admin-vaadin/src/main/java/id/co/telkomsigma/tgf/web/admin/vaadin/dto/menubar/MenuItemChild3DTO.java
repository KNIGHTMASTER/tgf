package id.co.telkomsigma.tgf.web.admin.vaadin.dto.menubar;

import com.vaadin.ui.MenuBar;

import java.io.Serializable;

/**
 * Created on 8/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class MenuItemChild3DTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -712103530883336878L;

    private String caption;
    private String icon;
    private MenuBar.Command command;

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
}
