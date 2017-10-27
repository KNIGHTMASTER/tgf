package id.co.telkomsigma.tgf.swing.component.dialog;

import id.co.telkomsigma.tgf.swing.component.base.ICentralizePositionComponent;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * Created on 6/15/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class DialogProgress extends JDialog implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = 6059142765721340819L;

    @Autowired
    ICentralizePositionComponent centralizePositionComponent;

    @Value("${dialog.progress.imageurl}")
    private String dialogProgressImageUrl;

    @PostConstruct
    @Override
    public void initComponents() {
        JLabel lbl1 = new JLabel();

        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setModal(true);
        centralizePositionComponent.setDialogToCenter(this);

        lbl1.setIcon(new ImageIcon(getClass().getClassLoader().getResource(dialogProgressImageUrl)));
        this.add(lbl1, BorderLayout.CENTER);
        this.setSize(100, 100);
        this.setPreferredSize(new Dimension(100, 100));
        this.setMinimumSize(new Dimension(100, 100));
    }
}
