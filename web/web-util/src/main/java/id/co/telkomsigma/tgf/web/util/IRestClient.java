package id.co.telkomsigma.tgf.web.util;

/**
 * Created on 10/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */

import id.co.telkomsigma.tgf.util.IParameterizedComponent;
import org.springframework.util.MultiValueMap;

/**
 * created on 11/15/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <RESPONSE_DATA>
 * @param <REQUEST_DATA>
 */
public interface IRestClient<RESPONSE_DATA, REQUEST_DATA> extends IParameterizedComponent<String> {

    RESPONSE_DATA consume();

    RESPONSE_DATA queryClient();

    RESPONSE_DATA queryClient(MultiValueMap<String, String> p_HttpHeaders, REQUEST_DATA p_ObjectToPass);
}
