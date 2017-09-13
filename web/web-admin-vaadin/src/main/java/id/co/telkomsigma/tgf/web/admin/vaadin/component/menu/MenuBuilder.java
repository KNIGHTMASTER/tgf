package id.co.telkomsigma.tgf.web.admin.vaadin.component.menu;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import id.co.telkomsigma.tgf.web.admin.vaadin.constant.TGFValoTheme;
import id.co.telkomsigma.tgf.web.admin.vaadin.dto.MenuDTO;
import id.co.telkomsigma.tgf.web.admin.vaadin.dto.MenuItemDTO;
import org.springframework.stereotype.Component;

/**
 * Created on 9/14/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class MenuBuilder {

    public CssLayout build(CssLayout p_Menu, CssLayout p_MenuItemsLayout, MenuDTO p_MenuDTO, UI p_UI) {
        p_MenuItemsLayout.setPrimaryStyleName(TGFValoTheme.VALO_MENU_ITEMS);
        p_Menu.addComponent(p_MenuItemsLayout);

        for (MenuItemDTO menuItem : p_MenuDTO.getMenuItemDTOs()) {
            Button b = new Button(menuItem.getName(), event -> p_UI.getNavigator().navigateTo(menuItem.getViewName()));
            b.setCaptionAsHtml(true);
            b.setPrimaryStyleName(ValoTheme.MENU_ITEM);
            b.setIcon(VaadinIcons.valueOf(menuItem.getIcon()));
            p_MenuItemsLayout.addComponent(b);
        }
        return p_Menu;
    }
}
