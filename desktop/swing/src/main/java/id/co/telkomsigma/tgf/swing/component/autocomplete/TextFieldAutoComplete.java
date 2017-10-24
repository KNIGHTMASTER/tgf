/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.telkomsigma.tgf.swing.component.autocomplete;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TextFieldAutoComplete extends JTextField {

    private static final long serialVersionUID = 3422400019554288760L;

    private AutoComplete autoComplete;

    public AutoComplete getAutoComplete() {
        return autoComplete;
    }

    public void setAutoComplete(AutoComplete autoComplete) {
        this.autoComplete = autoComplete;
    }

    public TextFieldAutoComplete() {
        super();
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setCaretPosition(getDocument().getLength());
            }
        });
    }

    @Override
    public void replaceSelection(String content) {
        if (getAutoComplete() == null) {
            super.replaceSelection(content);
        } else {
            try {
                super.replaceSelection(content);
                String AllText = getDocument().getText(0, getDocument().getLength());
                if (getAutoComplete().getAutoComplete(AllText) != null) {
                    setText(getAutoComplete().getAutoComplete(AllText)
                    );
                    setCaretPosition(getDocument().getLength());
                    moveCaretPosition(AllText.length());
                }
            } catch (BadLocationException ble) {
                JOptionPane.showMessageDialog(this, "An Error Occured \n" + ble.getMessage());
            }
        }
    }
}
