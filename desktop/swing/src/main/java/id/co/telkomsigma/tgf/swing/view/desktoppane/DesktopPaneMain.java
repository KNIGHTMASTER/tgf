package id.co.telkomsigma.tgf.swing.view.desktoppane;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class DesktopPaneMain extends JDesktopPane implements IComponentInitializer {

    /**
     *
     *
     */
    private static final long serialVersionUID = 8027135626383207342L;

    @PostConstruct
    @Override
    public void initComponents() {
//        this.setLayout(new BorderLayout());
    }
}
