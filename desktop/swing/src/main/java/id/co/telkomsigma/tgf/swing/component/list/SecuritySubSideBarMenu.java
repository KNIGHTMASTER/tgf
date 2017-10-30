package id.co.telkomsigma.tgf.swing.component.list;

import id.co.telkomsigma.tgf.swing.view.internalframe.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 10/29/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class SecuritySubSideBarMenu extends MultipleListSideBarMenu {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4393760998277041502L;

    @Autowired
    private InternalFrameUser internalFrameUser;

    @Autowired
    private InternalFrameRole internalFrameRole;

    @Autowired
    private InternalFrameGroup internalFrameGroup;

    @PostConstruct
    @Override
    public void initComponents() {
        super.initComponents();
    }

    @Override
    public Map<String, SideBarInternalFrame> getMapPreventionInternalFrame() {
        Map<String, SideBarInternalFrame> result = new HashMap<>();
        result.put(getListData()[0], internalFrameUser);
        result.put(getListData()[1], internalFrameRole);
        result.put(getListData()[2], internalFrameGroup);
        return result;
    }

    @Override
    public String[] getListData() {
        return new String[] {"User", "Role", "Group"};
    }
}
