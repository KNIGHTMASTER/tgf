package id.co.telkomsigma.tgf.swing.component.autocomplete;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DefaultModelAutoComplete implements AutoComplete {

    private final ArrayList<String> dataList;

    public DefaultModelAutoComplete(String[] dataList) {
        this.dataList = new ArrayList<>(Arrays.<String>asList(dataList));
    }

    public boolean add(String e) {
        return dataList.add(e);
    }

    public boolean remove(String o) {
        return dataList.remove(o);
    }

    @Override
    public String getAutoComplete(String key) {
        for (String data : dataList) {
            if (data.startsWith(key)) {
                return data;
            }
        }
        return null;
    }
}
