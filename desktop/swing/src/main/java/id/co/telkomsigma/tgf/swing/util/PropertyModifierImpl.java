package id.co.telkomsigma.tgf.swing.util;

import id.co.telkomsigma.tgf.swing.dto.param.DataSourceParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * Created on 10/24/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class PropertyModifierImpl implements IPropertyModifier {

    @Value("${app.property.path}")
    private String propertyFilePath;

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyModifierImpl.class);

    @Override
    public void updateValue( String p_Key, String p_Value) {
        try {
            FileInputStream in= new FileInputStream(propertyFilePath);
            SortedProperties props = new SortedProperties();
            props.load(in);
            in.close();

            FileOutputStream out = new FileOutputStream(propertyFilePath);
            props.setProperty(p_Key, p_Value);
            props.store(out, null);
            out.close();
        } catch (IOException e) {
            LOGGER.error("Error when modify property file {} ", e.toString());
        }
    }

    @Override
    public DataSourceParam loadDataSourceSetting() {
        Properties prop = new Properties();
        InputStream input = null;
        DataSourceParam result = new DataSourceParam();
        try {
            input = new FileInputStream(propertyFilePath);
            prop.load(input);
            result.setHost(prop.getProperty("db.host"));
            result.setPort(prop.getProperty("db.port"));
            result.setSchema(prop.getProperty("db.schema"));
            result.setUserName(prop.getProperty("db.username"));
            result.setPassword(prop.getProperty("db.password"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    class SortedProperties extends Properties {
        /**
         *
         *
         */
        private static final long serialVersionUID = -7196698422477886950L;

        public Enumeration keys() {
            Enumeration keysEnum = super.keys();
            Vector<String> keyList = new Vector<String>();
            while (keysEnum.hasMoreElements()) {
                keyList.add((String) keysEnum.nextElement());
            }
            Collections.sort(keyList);
            return keyList.elements();
        }
    }
}
