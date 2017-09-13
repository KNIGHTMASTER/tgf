package id.co.telkomsigma.tgf.web.admin.vaadin.rb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created on 7/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ResourceBundleLocatorImpl implements IResourceBundleLocator {

    @Value("${i18n.locale}")
    private String localeSetting;

    @Override
    public ResourceBundle getResourceBundle() {
        Locale locale = Locale.getDefault();
        if (locale.equals("FR")){
            return ResourceBundle.getBundle("I18N/message_fr", locale);
        }else{
            return ResourceBundle.getBundle("I18N/message_en", locale);
        }
    }
}
