package id.co.telkomsigma.tgf.web.admin.vaadin.component.button.creator;

import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created on 7/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ButtonGenerator {

    public static Button generateNavigatorButton(String p_Caption, UI p_UI, String p_ViewName){
        Button button = new Button(p_Caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        button.addClickListener(e -> p_UI.getNavigator().navigateTo(p_ViewName));
        return button;
    }
}
