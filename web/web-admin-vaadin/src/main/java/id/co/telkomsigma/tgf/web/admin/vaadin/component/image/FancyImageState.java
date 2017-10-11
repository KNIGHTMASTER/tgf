package id.co.telkomsigma.tgf.web.admin.vaadin.component.image;

import com.vaadin.shared.AbstractComponentState;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 9/28/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FancyImageState extends AbstractComponentState {
    /**
     *
     *
     */
    private static final long serialVersionUID = -1234270956651372339L;

    public int timeoutMs = 2000;

    public boolean autoBrowse = false;

    public List<String> imageResIds = new ArrayList<String>();

    public boolean fadeTransition = true;

    public RotateDirection rotateTransition = RotateDirection.NONE;

}
