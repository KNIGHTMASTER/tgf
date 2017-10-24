package id.co.telkomsigma.tgf.swing.component.base;

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

    @Override
    public ResourceBundle getResourceBundle(String p_I18N) {
        Locale locale = Locale.getDefault();
        if (p_I18N.equals("FR")){
            return ResourceBundle.getBundle("I18N/message_fr_CA", locale);
        }else{
            return ResourceBundle.getBundle("I18N/message_en_US", locale);
        }
    }
}
