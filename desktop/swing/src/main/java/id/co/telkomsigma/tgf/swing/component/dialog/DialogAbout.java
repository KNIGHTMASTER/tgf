package id.co.telkomsigma.tgf.swing.component.dialog;

import id.co.telkomsigma.tgf.swing.component.base.ICentralizePositionComponent;
import id.co.telkomsigma.tgf.swing.component.base.IResourceBundleLocator;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    private static final long serialVersionUID = -5546517331962931229L;

    @Autowired
    IResourceBundleLocator rb;

    @Autowired
    ICentralizePositionComponent centralizePositionComponent;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setModal(true);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image dialogIcon = kit.getImage(getClass().getClassLoader().getResource("assets/jframeicon.png"));
        this.setIconImage(dialogIcon);

        centralizePositionComponent.setDialogCustomToCenter(this, 3, 2);
        this.setSize(700, 150);
        this.setTitle(rb.getResourceBundle("").getString("ui.dialog.about.title"));
        this.setLayout(new BorderLayout());

        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new BorderLayout());
        JLabel imgIcon = new JLabel();
        imgIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("assets/etc.png")));
        panelLeft.add(imgIcon, BorderLayout.CENTER);

        JScrollPane scroller = new JScrollPane();
        JTextArea textAreaInformation = new JTextArea();
        textAreaInformation.setText("ETC (E- Toll Collection)\nVersion 1.0.0\nBuilt on July, 2017\nJVM "
                +System.getProperty("java.vm.version")+" "
                +System.getProperty("java.vm.vendor")+" "
                +System.getProperty("java.vm.name")+"\n\n"
                +"Copyright (c) 2017 Telkomsigma");
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
