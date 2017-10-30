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
public class CompanySubSideBarMenu extends MultipleListSideBarMenu {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4393760998277041502L;

    @Autowired
    private InternalFrameCompany internalFrameCompany;

    @Autowired
    private InternalFrameBranch internalFrameBranch;

    @PostConstruct
    @Override
    public void initComponents() {
        super.initComponents();
    }

    @Override
    public Map<String, SideBarInternalFrame> getMapPreventionInternalFrame() {
        Map<String, SideBarInternalFrame> result = new HashMap<>();
        result.put(getListData()[0], internalFrameCompany);
        result.put(getListData()[1], internalFrameBranch);
        return result;
    }

    @Override
    public String[] getListData() {
        return new String[] {"Company", "Branch"};
    }
}
