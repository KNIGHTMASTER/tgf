package id.co.telkomsigma.tgf.web.admin.vaadin.component.tabsheet;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.themes.ValoTheme;
import id.co.telkomsigma.tgf.util.IComponentInitializer;

import java.util.Map;

/**
 * Created on 8/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ATabSheet extends TabSheet implements IComponentInitializer, ITabSheetDataRetriever {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2877325908399579132L;

    @Override
    public void initComponents() {
        this.setHeight(100.0f, Unit.PERCENTAGE);
        this.addStyleName(ValoTheme.TABSHEET_FRAMED);
        this.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);

        for (Map.Entry<String, Component> entry : getTabComponents().entrySet()) {
            this.addTab(entry.getValue(), entry.getKey(), FontAwesome.HOME);
        }
    }


}
