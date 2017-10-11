package id.co.telkomsigma.tgf.web.admin.vaadin.component.menubar;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.MenuBar;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.web.admin.vaadin.dto.menubar.MenuItemChild1DTO;
import id.co.telkomsigma.tgf.web.admin.vaadin.dto.menubar.MenuItemChild2DTO;
import id.co.telkomsigma.tgf.web.admin.vaadin.dto.menubar.MenuItemChild3DTO;
import id.co.telkomsigma.tgf.web.admin.vaadin.dto.menubar.MenuItemParentDTO;

/**
 * Created on 8/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * <p>
 *     MenuBar with maximum three sub menus
 * </p>
 */
public abstract class AMenuBar extends MenuBar implements IMenuBarDataRetriever, IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -3104033905481227579L;

    @Override
    public void initComponents() {
        this.setHeight(100.0f, Unit.PERCENTAGE);

        if (getMenuBarComponents().getMenuList().size() > 0){
            for (MenuItemParentDTO menuItemParentDTO : getMenuBarComponents().getMenuList()){
                MenuItem menuItemParent = this.addItem(menuItemParentDTO.getCaption(), VaadinIcons.valueOf(menuItemParentDTO.getIcon()), menuItemParentDTO.getCommand());
                if (menuItemParentDTO.getMenuItemChild1DTOList() != null) {
                    if (menuItemParentDTO.getMenuItemChild1DTOList().size() > 0){
                        for (MenuItemChild1DTO menuItemChild1DTO : menuItemParentDTO.getMenuItemChild1DTOList()){
                            MenuItem menuItemChild1 = menuItemParent.addItem(menuItemChild1DTO.getCaption(), VaadinIcons.valueOf(menuItemChild1DTO.getIcon()), menuItemChild1DTO.getCommand());
                            if (menuItemChild1DTO.getMenuItemChild2DTOList() != null){
                                if (menuItemChild1DTO.getMenuItemChild2DTOList().size() > 0){
                                    for (MenuItemChild2DTO menuItemChild2DTO : menuItemChild1DTO.getMenuItemChild2DTOList()){
                                        MenuItem menuItemChild2 = menuItemChild1.addItem(menuItemChild2DTO.getCaption(), VaadinIcons.valueOf(menuItemChild2DTO.getIcon()), menuItemChild2DTO.getCommand());
                                        if (menuItemChild2DTO.getMenuItemChild3DTOList() != null){
                                            if (menuItemChild2DTO.getMenuItemChild3DTOList().size() > 0){
                                                for (MenuItemChild3DTO menuItemChild3DTO : menuItemChild2DTO.getMenuItemChild3DTOList()){
                                                    menuItemChild2.addItem(menuItemChild3DTO.getCaption(), VaadinIcons.valueOf(menuItemChild3DTO.getIcon()), menuItemChild3DTO.getCommand());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

}
