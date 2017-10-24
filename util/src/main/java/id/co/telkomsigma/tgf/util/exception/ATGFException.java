package id.co.telkomsigma.tgf.util.exception;

/**
 * Created on 10/11/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ATGFException extends Exception {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5221043932987066639L;

    public ATGFException(String message) {
        super(message);
    }

    public ATGFException(String message, Throwable cause) {
        super(message, cause);
    }
}
