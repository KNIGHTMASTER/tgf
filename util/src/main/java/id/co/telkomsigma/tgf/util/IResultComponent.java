package id.co.telkomsigma.tgf.util;

/**
 * Created on 10/9/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <RESULT>
 */
public interface IResultComponent<RESULT> {

    void setResult(RESULT p_Result);

    RESULT getResult();
}
