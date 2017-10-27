package id.co.telkomsigma.tgf.web.admin.vaadin.command;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import id.co.telkomsigma.tgf.util.IParameterizedComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created on 10/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class LogOutCommand implements MenuBar.Command, IParameterizedComponent<UI> {
    /**
     *
     *
     */
    private static final long serialVersionUID = 164316776829858477L;

    @Value("${url-logged-out}")
    private String urlLoggedOut;

    private UI ui;

    @Override
    public void menuSelected(MenuBar.MenuItem selectedItem) {
        if(selectedItem.getText().equals("Sign Out")){
            SecurityContextHolder.clearContext();
            UI.getCurrent().getSession().close();
            UI.getCurrent().getSession().getService().closeSession(VaadinSession.getCurrent());
            UI.getCurrent().close();

            VaadinService.getCurrentRequest().getWrappedSession().invalidate();
            Page.getCurrent().setLocation(urlLoggedOut);
        }
    }

    @Override
    public void setParam(UI p_Param) {
        this.ui = p_Param;
    }

    @Override
    public UI getParam() {
        return ui;
    }
}
