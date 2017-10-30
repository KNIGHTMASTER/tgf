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
public class ProductSubSideBarMenu extends MultipleListSideBarMenu {
    /**
     *
     *
     */
    private static final long serialVersionUID = -4393760998277041502L;

    @Autowired
    private InternalFrameProduct internalFrameProduct;

    @Autowired
    private InternalFrameProductBrand internalFrameProductBrand;

    @Autowired
    private InternalFrameProductCategory internalFrameProductCategory;

    @Autowired
    private InternalFrameProductType internalFrameProductType;

    @Autowired
    private InternalFrameProductStock internalFrameProductStock;

    @Autowired
    private InternalFrameProductUnit internalFrameProductUnit;

    @PostConstruct
    @Override
    public void initComponents() {
        super.initComponents();
    }

    @Override
    public Map<String, SideBarInternalFrame> getMapPreventionInternalFrame() {
        Map<String, SideBarInternalFrame> result = new HashMap<>();
        result.put(getListData()[0], internalFrameProduct);
        result.put(getListData()[1], internalFrameProductBrand);
        result.put(getListData()[2], internalFrameProductCategory);
        result.put(getListData()[3], internalFrameProductType);
        result.put(getListData()[4], internalFrameProductStock);
        result.put(getListData()[5], internalFrameProductUnit);
        return result;
    }

    @Override
    public String[] getListData() {
        return new String[] {"Product", "Product Brand", "Category", "Type", "Stock", "Unit"};
    }
}
