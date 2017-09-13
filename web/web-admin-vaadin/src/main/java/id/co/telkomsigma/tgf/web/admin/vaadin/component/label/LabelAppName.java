package id.co.telkomsigma.tgf.web.admin.vaadin.component.label;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Label;
import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.annotation.PostConstruct;

/**
 * Created on 9/14/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class LabelAppName extends Label implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -529953304515422008L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setCaption("<h3>Vaadin <strong>Valo Theme</strong></h3>");
        this.setCaptionAsHtml(true);
        this.setSizeUndefined();
    }
}
