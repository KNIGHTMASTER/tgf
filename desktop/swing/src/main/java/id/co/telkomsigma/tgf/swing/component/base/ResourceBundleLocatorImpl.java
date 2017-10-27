package id.co.telkomsigma.tgf.swing.component.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created on 5/29/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ResourceBundleLocatorImpl implements IResourceBundleLocator {


    @Value("${general.app.language}")
    private String appLanguage;

    @Override
    public ResourceBundle getResourceBundle(String p_I18N) {
        Locale locale = Locale.getDefault();
        switch (p_I18N) {
            case "FR":
                return ResourceBundle.getBundle("I18N/message_fr_CA", locale);
            case "INA":
                return ResourceBundle.getBundle("I18N/message_ina", locale);
            default:
                return ResourceBundle.getBundle("I18N/message_en_US", locale);
        }
    }

    @Override
    public String getValue(String p_Key) {
        return getResourceBundle(appLanguage).getString(p_Key);
    }
}
