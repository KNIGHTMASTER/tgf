package id.co.telkomsigma.tgf.web.admin.vaadin.view.dashboard;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import id.co.telkomsigma.tgf.web.admin.vaadin.constant.TGFConstant;
import id.co.telkomsigma.tgf.web.admin.vaadin.view.NavigationLayout;

/**
 * Created on 8/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringView(name = TGFConstant.ViewNames.DASHBOARD_VIEW)
@UIScope
public class DashboardView extends NavigationLayout implements View {
    /**
     *
     *
     */
    private static final long serialVersionUID = -585817829297756597L;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        this.addComponent(new Label("Oke"));
    }
}
