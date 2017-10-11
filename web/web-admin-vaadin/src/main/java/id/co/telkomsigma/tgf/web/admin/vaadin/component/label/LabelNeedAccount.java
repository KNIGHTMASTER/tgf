package id.co.telkomsigma.tgf.web.admin.vaadin.component.label;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Label;
import id.co.telkomsigma.tgf.util.IComponentInitializer;

import javax.annotation.PostConstruct;

/**
 * Created on 9/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@SpringComponent
public class LabelNeedAccount extends Label implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2232673849179596138L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setCaption("<font size = \"3\" color=\"white\"> Need an Account ?");
        this.setCaptionAsHtml(true);
    }
}
