package id.co.telkomsigma.tgf.swing.component.list;

import id.co.telkomsigma.tgf.swing.view.internalframe.InternalFramePos;
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
public class PosSubSideBarMenu extends ListSideBarMenu {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4393760998277041502L;

    @Autowired
    private InternalFramePos internalFramePos;

    @PostConstruct
    @Override
    public void initComponents() {
        super.initComponents();
    }

    @Override
    public SideBarInternalFrame getPreventionInternalFrame() {
        return internalFramePos;
    }

    @Override
    public String[] getListData() {
        return new String[]{"Pos"};
    }
}
