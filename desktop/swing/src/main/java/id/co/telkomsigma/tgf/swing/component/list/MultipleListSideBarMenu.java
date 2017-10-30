package id.co.telkomsigma.tgf.swing.component.list;

import id.co.telkomsigma.tgf.swing.view.desktoppane.DesktopPaneMain;
import id.co.telkomsigma.tgf.swing.view.internalframe.SideBarInternalFrame;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on 10/29/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public abstract class MultipleListSideBarMenu extends JList<String> implements IComponentInitializer, IComponentAction {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5901978938946809737L;

    @Autowired
    private DesktopPaneMain desktopPaneMain;

    @Override
    public void initComponents() {
        this.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.setLayoutOrientation(JList.VERTICAL_WRAP);
        this.setVisibleRowCount(-1);
        this.setListData(getListData());

        initAction();
    }

    @Override
    public void initAction() {
        this.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                if (this.getSelectedIndex() != -1) {
                    SideBarInternalFrame selectedSideBar = getMapPreventionInternalFrame().get(this.getSelectedValue());
                    if (selectedSideBar.isVisible()) {
                        if (desktopPaneMain.getComponentCount() <= 0) {
                            desktopPaneMain.add(selectedSideBar);
                        } else {
                            for (java.awt.Component component : desktopPaneMain.getComponents()) {
                                for (String preventionComponentName : getPreventionComponentName()) {
                                    if (component.getName().equals(preventionComponentName)) {
                                        selectedSideBar.setVisible(true);
                                        break;
                                    } else {
                                        selectedSideBar.toFront();
                                        selectedSideBar.setVisible(true);
                                    }
                                }
                            }
                        }
                    } else {
                        if (desktopPaneMain.getComponentCount() <= 0){
                            selectedSideBar.resetComponent();
                            desktopPaneMain.add(selectedSideBar);
                            selectedSideBar.setVisible(true);
                        }else {
                            selectedSideBar.showNewComponent(desktopPaneMain.getComponentCount());
                            desktopPaneMain.add(selectedSideBar);
                            selectedSideBar.setVisible(true);
                        }
                    }
                    this.clearSelection();
                }
            }
        });
    }

    protected String[] getPreventionComponentName() {
        List<String> componentName = getMapPreventionInternalFrame().entrySet().stream().map(map -> map.getValue().getClass().getSimpleName()).collect(Collectors.toList());
        return componentName.toArray(new String[componentName.size()]);
    }
    public abstract Map<String, SideBarInternalFrame> getMapPreventionInternalFrame();
    public abstract String[] getListData();
}
