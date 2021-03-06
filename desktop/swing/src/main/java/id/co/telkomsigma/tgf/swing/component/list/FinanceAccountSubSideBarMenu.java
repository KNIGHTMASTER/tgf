package id.co.telkomsigma.tgf.swing.component.list;

import id.co.telkomsigma.tgf.swing.view.internalframe.InternalFrameFinanceAccount;
import id.co.telkomsigma.tgf.swing.view.internalframe.SideBarInternalFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 10/29/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class FinanceAccountSubSideBarMenu extends ListSideBarMenu {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4393760998277041502L;

    @Autowired
    private InternalFrameFinanceAccount internalFrameFinanceAccount;

    @PostConstruct
    @Override
    public void initComponents() {
        super.initComponents();
    }

    @Override
    public SideBarInternalFrame getPreventionInternalFrame() {
        return internalFrameFinanceAccount;
    }

    @Override
    public String[] getListData() {
        return new String[]{"Finance Account"};
    }
}
