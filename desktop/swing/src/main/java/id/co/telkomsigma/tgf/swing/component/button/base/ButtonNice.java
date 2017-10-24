package id.co.telkomsigma.tgf.swing.component.button.base;

import id.co.telkomsigma.tgf.util.IComponentInitializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component(value = "button_nice")
public class ButtonNice extends JButton implements IComponentInitializer {

    private static final long serialVersionUID = 3544733510100385931L;

    private boolean focus;

    @PostConstruct
    @Override
    public void initComponents() {
        setOpaque(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setFocus(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setFocus(false);
            }

        });
    }

    public boolean isFocus() {
        return focus;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D grafis = (Graphics2D) g.create();
        Paint cat;
        if (isFocus()) {
            cat = new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0.01F), 0, getHeight(), new Color(1F, 1F, 1F, 0.5F));
        } else {
            cat = new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0.5F), 0, getHeight(), new Color(1F, 1F, 1F, 0.01F));
        }

        grafis.setPaint(cat);
        grafis.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
        grafis.dispose();
    }

}
