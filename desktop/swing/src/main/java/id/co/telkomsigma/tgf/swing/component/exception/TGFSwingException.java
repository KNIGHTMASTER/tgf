package id.co.telkomsigma.tgf.swing.component.exception;

import id.co.telkomsigma.tgf.util.exception.ATGFException;

/**
 * Created on 10/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TGFSwingException extends ATGFException {
    /**
     *
     *
     */
    private static final long serialVersionUID = 8194369902520512198L;

    public TGFSwingException(String message) {
        super(message);
    }

    public TGFSwingException(String message, Throwable cause) {
        super(message, cause);
    }
}
