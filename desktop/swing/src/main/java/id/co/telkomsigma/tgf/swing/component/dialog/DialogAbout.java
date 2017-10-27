package id.co.telkomsigma.tgf.swing.component.dialog;

import id.co.telkomsigma.tgf.swing.component.base.ICentralizePositionComponent;
import id.co.telkomsigma.tgf.swing.component.base.IResourceBundleLocator;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class DialogAbout extends JDialog implements IComponentInitializer {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5546517331962931229L;

    @Autowired
    IResourceBundleLocator rb;

    @Autowired
    ICentralizePositionComponent centralizePositionComponent;

    @Value("${splashscreen.icon.imageurl}")
    private String iconDialogAbout;

    @Value("${dialog.about.imageurl}")
    private String dialogAboutImageUrl;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setModal(true);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image dialogIcon = kit.getImage(getClass().getClassLoader().getResource(iconDialogAbout));
        this.setIconImage(dialogIcon);

        centralizePositionComponent.setDialogCustomToCenter(this, 3, 2);
        this.setSize(700, 180);
        this.setTitle(rb.getValue("ui.dialog.about.title"));
        this.setLayout(new BorderLayout());

        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new BorderLayout());
        JLabel imgIcon = new JLabel();
        imgIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource(dialogAboutImageUrl)));
        panelLeft.add(imgIcon, BorderLayout.CENTER);

        JScrollPane scroller = new JScrollPane();
        JTextArea textAreaInformation = new JTextArea();
        textAreaInformation.setText(rb.getValue("ui.dialog.about.message")
                +System.getProperty("java.vm.version")+" "
                +System.getProperty("java.vm.vendor")+" "
                +System.getProperty("java.vm.name")+"\n\n"
                +rb.getValue("ui.dialog.about.copyright"));
        textAreaInformation.setEditable(false);

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        textAreaInformation.setColumns(20);
        textAreaInformation.setRows(7);
        scroller.setViewportView(textAreaInformation);
        this.getContentPane().add(scroller, BorderLayout.CENTER);
        this.getContentPane().add(panelLeft, BorderLayout.WEST);

        this.setResizable(false);
    }

    
}
