package id.co.telkomsigma.tgf.util;

/**
 * Created on 10/9/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * @param <PARAM>
 */
public interface IParameterizedComponent<PARAM> {

    void setParam(PARAM p_Param);

    PARAM getParam();
}
