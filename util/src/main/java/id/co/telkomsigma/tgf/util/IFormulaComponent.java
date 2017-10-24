package id.co.telkomsigma.tgf.util;

/**
 * Created on 10/9/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <PARAM>
 * @param <RESULT>
 */
public interface IFormulaComponent<PARAM, RESULT> extends IParameterizedComponent<PARAM>, IResultComponent<RESULT> {

    /**
     * <p>
     *     Calculating formula through PARAM and set output RESULT
     * </p>
     *
     */
    void calculate();
}
