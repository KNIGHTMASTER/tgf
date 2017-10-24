package id.co.telkomsigma.tgf.web.admin.vaadin.client;

import id.co.telkomsigma.tgf.web.admin.vaadin.dto.request.RequestLoginDTO;
import id.co.telkomsigma.tgf.web.admin.vaadin.dto.response.ResponseData;
import id.co.telkomsigma.tgf.web.util.ARestClient;
import org.springframework.stereotype.Component;

/**
 * Created on 10/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class LoginClient extends ARestClient<ResponseData, RequestLoginDTO> {
    @Override
    public Class<ResponseData> getObjectResultClass() {
        return ResponseData.class;
    }
}
