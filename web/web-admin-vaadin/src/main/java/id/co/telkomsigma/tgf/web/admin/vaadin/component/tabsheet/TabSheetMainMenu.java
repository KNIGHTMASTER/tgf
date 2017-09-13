package id.co.telkomsigma.tgf.web.admin.vaadin.component.tabsheet;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created on 8/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TabSheetMainMenu extends ATabSheet {
    /**
     *
     *
     */
    private static final long serialVersionUID = 4567088942811201917L;

    private static final String HOME = "Home";
    private static final String DATA = "Data";
    private static final String SECURITY = "Security";
    private static final String REPORT = "Report";

    @Override
    public String[] getTabNames() {
        return new String[] {HOME, DATA, SECURITY, REPORT};
    }

    @Override
    public SortedMap<String, com.vaadin.ui.Component> getTabComponents() {
        SortedMap<String, com.vaadin.ui.Component> result = new TreeMap<>();
        for (String s : getTabNames()){
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            /*Button dashboard = new Button("Dashboard");
            dashboard.setIcon(FontAwesome.DASHBOARD);

            Button pos = new Button("POS");
            pos.setIcon(FontAwesome.SHOPPING_BAG);
            horizontalLayout.addComponent(dashboard);*/
            MenuBar sample = new MenuBar();
            sample.setIcon(VaadinIcons.FACEBOOK);
            sample.setWidth(100.0f, Unit.PERCENTAGE);

            MenuBar.MenuItem menuHome = sample.addItem("Dashboard", null, null);
            menuHome.addItem("Pos", null, null);

            horizontalLayout.addComponent(sample);
            result.put(s, horizontalLayout);
        }
        return result;
    }

    @PostConstruct
    @Override
    public void initComponents() {
        super.initComponents();
    }
}
