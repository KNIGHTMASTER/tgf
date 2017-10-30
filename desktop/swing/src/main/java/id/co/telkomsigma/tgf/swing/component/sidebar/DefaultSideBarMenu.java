package id.co.telkomsigma.tgf.swing.component.sidebar;

import id.co.telkomsigma.tgf.swing.component.list.*;
import id.co.telkomsigma.tgf.swing.view.desktoppane.DesktopPaneMain;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created on 10/24/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class DefaultSideBarMenu extends JPanel implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1355033836513959613L;

    @Autowired
    private DesktopPaneMain desktopPaneMain;

    @Autowired
    private DashboardSubSideBarMenu dashboardSubSideBarMenu;

    @Autowired
    private PosSubSideBarMenu posSubSideBarMenu;

    @Autowired
    private SecuritySubSideBarMenu securitySubSideBarMenu;

    @Autowired
    private CompanySubSideBarMenu companySubSideBarMenu;

    @Autowired
    private FinanceAccountSubSideBarMenu financeAccountSubSideBarMenu;

    @Autowired
    private ProductSubSideBarMenu productSubSideBarMenu;

    @Autowired
    private ProfileSubSideBarMenu profileSubSideBarMenu;

    private Toolkit kit = Toolkit.getDefaultToolkit();

    @PostConstruct
    @Override
    public void initComponents() {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setContinuousLayout(false);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerSize((int) (splitPane.getDividerSize() * 1.5));

        Icon iconShoppingCart24 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/ShoppingCart/Shopping-cart-24.png")));
        Icon iconDashboard24 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/Dashboard/Dashboard-24.png")));
        Icon iconMaster24 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/Database/Database-24.png")));
        Icon iconGlobe24 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/Protection/Protection-24.png")));
        Icon iconHome16 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/Home/home-16.png")));
        Icon iconUser16 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/User/user-16.png")));
        Icon iconWallet16 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/Wallet/wallet-16.png")));
        Icon iconBox16 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/Box/box-16.png")));

        SideBar sideBar = new SideBar(SideBar.SideBarMode.TOP_LEVEL, false, 300, true);

        SidebarSection sideBarDashboard = new SidebarSection(sideBar, "Dashboard", dashboardSubSideBarMenu, iconDashboard24);
        sideBar.addSection(sideBarDashboard);

        SidebarSection sectionPos = new SidebarSection(sideBar, "Pos", posSubSideBarMenu, iconShoppingCart24);
        sideBar.addSection(sectionPos);

        SideBar innerSideBarMasterData = new SideBar(SideBar.SideBarMode.INNER_LEVEL, true, -1, true);
        innerSideBarMasterData.addSection(new SidebarSection(innerSideBarMasterData, "Company", companySubSideBarMenu, iconHome16));
        innerSideBarMasterData.addSection(new SidebarSection(innerSideBarMasterData, "Finance", financeAccountSubSideBarMenu, iconWallet16));
        innerSideBarMasterData.addSection(new SidebarSection(innerSideBarMasterData, "Product", productSubSideBarMenu, iconBox16));
        innerSideBarMasterData.addSection(new SidebarSection(innerSideBarMasterData, "Profile", profileSubSideBarMenu, iconUser16));

        SidebarSection sectionMasterData = new SidebarSection(sideBar, "Master Data",  innerSideBarMasterData, iconMaster24);
        sideBar.addSection(sectionMasterData);

        SidebarSection sectionSecurity = new SidebarSection(sideBar, "Security", securitySubSideBarMenu, iconGlobe24);
        sideBar.addSection(sectionSecurity);

        splitPane.setLeftComponent(sideBar);
        splitPane.setRightComponent(desktopPaneMain);
        this.setLayout(new BorderLayout());
        this.add(splitPane);
    }
}
