package id.co.telkomsigma.tgf.swing.util;

import id.co.telkomsigma.tgf.swing.dto.param.DataSourceParam;

/**
 * Created on 10/24/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IPropertyModifier {

    void updateValue(String p_Key, String p_Value);

    DataSourceParam loadDataSourceSetting();
}
