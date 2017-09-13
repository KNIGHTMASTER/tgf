package id.co.telkomsigma.tgf.web.admin.vaadin.component.menubar;

import id.co.telkomsigma.tgf.web.admin.vaadin.dto.menubar.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 8/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class AppMenuBar extends AMenuBar {
    /**
     *
     *
     */
    private static final long serialVersionUID = -762348762750496015L;

    @PostConstruct
    @Override
    public void initComponents() {
        super.initComponents();
    }

    @Override
    public MenuBarDTO getMenuBarComponents() {
        MenuBarDTO result = new MenuBarDTO();

        MenuItemParentDTO menuItemParentDTO = new MenuItemParentDTO();
        menuItemParentDTO.setCaption("Parent");
        menuItemParentDTO.setIcon("DASHBOARD");
        menuItemParentDTO.setCommand(null);

        MenuItemParentDTO menuItemParentDTO2 = new MenuItemParentDTO();
        menuItemParentDTO2.setCaption("Parent");
        menuItemParentDTO2.setIcon("DASHBOARD");
        menuItemParentDTO2.setCommand(null);

        MenuItemParentDTO menuItemParentDTO3 = new MenuItemParentDTO();
        menuItemParentDTO3.setCaption("Parent");
        menuItemParentDTO3.setIcon("DASHBOARD");
        menuItemParentDTO3.setCommand(null);

        MenuItemParentDTO menuItemParentDTO4 = new MenuItemParentDTO();
        menuItemParentDTO4.setCaption("Parent");
        menuItemParentDTO4.setIcon("DASHBOARD");
        menuItemParentDTO4.setCommand(null);

        List<MenuItemParentDTO> menuItemParentDTOs = new ArrayList<>();
        menuItemParentDTOs.add(menuItemParentDTO);
        menuItemParentDTOs.add(menuItemParentDTO2);
        menuItemParentDTOs.add(menuItemParentDTO3);
        menuItemParentDTOs.add(menuItemParentDTO4);

        MenuItemChild1DTO menuItemChild1DTO_1 = new MenuItemChild1DTO();
        menuItemChild1DTO_1.setCaption("Child 1 Item 1");
        menuItemChild1DTO_1.setIcon("HOME");
        menuItemChild1DTO_1.setCommand(null);

        MenuItemChild1DTO menuItemChild1DTO_2 = new MenuItemChild1DTO();
        menuItemChild1DTO_2.setCaption("Child 1 Item 2");
        menuItemChild1DTO_2.setIcon("HOME");
        menuItemChild1DTO_2.setCommand(null);

        MenuItemChild2DTO menuItemChild2DTO_1 = new MenuItemChild2DTO();
        menuItemChild2DTO_1.setCaption("Child 2 item 1");
        menuItemChild2DTO_1.setIcon("HOME");
        menuItemChild2DTO_1.setCommand(null);

        MenuItemChild2DTO menuItemChild2DTO_2 = new MenuItemChild2DTO();
        menuItemChild2DTO_2.setCaption("Child 2 item 2");
        menuItemChild2DTO_2.setIcon("HOME");
        menuItemChild2DTO_2.setCommand(null);

        MenuItemChild3DTO menuItemChild3DTO_1 = new MenuItemChild3DTO();
        menuItemChild3DTO_1.setCaption("Child 3 item 1");
        menuItemChild3DTO_1.setIcon("HOME");
        menuItemChild3DTO_1.setCommand(null);

        MenuItemChild3DTO menuItemChild3DTO_2 = new MenuItemChild3DTO();
        menuItemChild3DTO_2.setCaption("Child 3 item 2");
        menuItemChild3DTO_2.setIcon("HOME");
        menuItemChild3DTO_2.setCommand(null);

        List<MenuItemChild1DTO> menuItemChild1DTOs = new ArrayList<>();
        menuItemChild1DTOs.add(menuItemChild1DTO_1);
        menuItemChild1DTOs.add(menuItemChild1DTO_2);

        List<MenuItemChild2DTO> menuItemChild2DTOs = new ArrayList<>();
        menuItemChild2DTOs.add(menuItemChild2DTO_1);
        menuItemChild2DTOs.add(menuItemChild2DTO_2);

        List<MenuItemChild3DTO> menuItemChild3DTOs = new ArrayList<>();
        menuItemChild3DTOs.add(menuItemChild3DTO_1);
        menuItemChild3DTOs.add(menuItemChild3DTO_2);

        menuItemChild1DTO_2.setMenuItemChild2DTOList(menuItemChild2DTOs);
        menuItemChild2DTO_2.setMenuItemChild3DTOList(menuItemChild3DTOs);
        menuItemParentDTO.setMenuItemChild1DTOList(menuItemChild1DTOs);
        result.setMenuList(menuItemParentDTOs);

        return result;
    }
}
