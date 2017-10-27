package id.co.telkomsigma.tgf.swing.component.sidebar;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
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

    @PostConstruct
    @Override
    public void initComponents() {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setContinuousLayout(false);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerSize((int) (splitPane.getDividerSize() * 1.5));

        Toolkit kit = Toolkit.getDefaultToolkit();
        Icon iconCal24 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/Calendar/Calendar_24x24.png")));
        Icon iconMail16 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/Mail/Mail_16x16.png")));
        Icon iconMail24 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/Mail/Mail_24x24.png")));
        Icon iconGlobe24 = new ImageIcon(kit.getImage(getClass().getClassLoader().getResource("assets/Data-Information-24.png")));

        SideBar sideBar = new SideBar(SideBar.SideBarMode.TOP_LEVEL, false, 300, true);
        JTree tree = new JTree();
        SidebarSection ss1 = new SidebarSection(sideBar, "Calendars", tree, iconCal24);
        sideBar.addSection(ss1);
        SideBar innerSideBar = new SideBar(SideBar.SideBarMode.INNER_LEVEL, true, -1, true);

        JPanel ap = new JPanel(new BorderLayout());
        ap.add(new JTextField("American Partners"));
        innerSideBar.addSection(new SidebarSection(innerSideBar, ap, getInner1(), iconMail16));
        innerSideBar.addSection(new SidebarSection(innerSideBar, "Internal", getInner2(), iconMail16));
        innerSideBar.addSection(new SidebarSection(innerSideBar, "Promotions", getInner3(), iconMail16));

        SidebarSection ss2 = new SidebarSection(sideBar, "Mail Groups",  innerSideBar, iconMail24);
        sideBar.addSection(ss2);

        SidebarSection ss3 = new SidebarSection(sideBar, "Logistics Partners", getInner4(), iconGlobe24);
        sideBar.addSection(ss3);

        splitPane.setLeftComponent(sideBar);

        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BorderLayout());
        centralPanel.setMinimumSize(new Dimension(kit.getScreenSize().width-sideBar.getWidth(), kit.getScreenSize().height));
        centralPanel.add(new JLabel("<html><body><h1>central panel</html>", JLabel.CENTER));

        splitPane.setRightComponent(centralPanel);

        this.setLayout(new BorderLayout());
        this.add(splitPane);
    }



    private static JList<String> getInner4() {
        DefaultListModel<String> model = new DefaultListModel<>();
        model.add(0, "Bill Gates");
        model.add(1, "Steven Spielberg");
        model.add(2, "Donald Trump");
        model.add(3, "Steve Jobs");

        JList<String> list = new JList<>();

        list.setModel(model);
        return list;
    }


    private static JComponent getInner2() {
        JList<String> list = getInner4();
        return list;
    }

    private static JComponent getInner1() {
        DefaultListModel<String> model = new DefaultListModel<>();
        model.add(0, "Bill Gates");
        model.add(1, "Steven Spielberg");

        JList<String> list = new JList<>();

        list.setModel(model);
        return list;
    }

    private static JComponent getInner3() {
        DefaultListModel<String> model = new DefaultListModel<>();
        model.add(0, "Steve Jobs");

        JList<String> list = new JList<>();

        list.setModel(model);
        return list;
    }
}
