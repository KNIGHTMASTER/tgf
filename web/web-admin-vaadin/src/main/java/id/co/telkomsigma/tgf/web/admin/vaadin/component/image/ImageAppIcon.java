package id.co.telkomsigma.tgf.web.admin.vaadin.component.image;

import com.vaadin.server.FileResource;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Image;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * Created on 9/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class ImageAppIcon extends Image implements IComponentInitializer{
    /**
     *
     *
     */
    private static final long serialVersionUID = -8611182498454682197L;

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${app.default.icon}")
    private String appDefaultLoginPicture;

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageLoginIcon.class);

    @PostConstruct
    @Override
    public void initComponents() {
        File fileImg;
        try {
            fileImg = resourceLoader.getResource("classpath:"+appDefaultLoginPicture).getFile();
            assert fileImg != null;
            this.setSource(new FileResource(fileImg));
            this.setWidth(50, Unit.PIXELS);
            this.setHeight(50, Unit.PIXELS);
        } catch (IOException e) {
            LOGGER.error(e.toString());
        }
    }
}
