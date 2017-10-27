package id.co.telkomsigma.tgf.swing.dto.param;

import id.co.telkomsigma.tgf.swing.component.sidebar.SidebarSection;

import javax.swing.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created on 10/25/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ParamSideBarMenu implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 6883428822907567684L;

    private List<Icon> iconList;
    private Map<String, SidebarSection> sectionMap;

    public List<Icon> getIconList() {
        return iconList;
    }

    public void setIconList(List<Icon> iconList) {
        this.iconList = iconList;
    }

    public Map<String, SidebarSection> getSectionMap() {
        return sectionMap;
    }

    public void setSectionMap(Map<String, SidebarSection> sectionMap) {
        this.sectionMap = sectionMap;
    }
}
