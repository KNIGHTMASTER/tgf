package id.co.telkomsigma.tgf.web.admin.vaadin.dto.response;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created on 10/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@XmlRootElement
public class ResponseData implements Serializable {

    /**
     *
     *
     */
    private static final long serialVersionUID = 4838859848024990861L;
    private String responseCode;
    private String responseMsg;

    public ResponseData() {}

    public ResponseData(String responseCode, String responseMsg) {
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((responseCode == null) ? 0 : responseCode.hashCode());
        result = prime * result
                + ((responseMsg == null) ? 0 : responseMsg.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResponseData other = (ResponseData) obj;
        if (responseCode == null) {
            if (other.responseCode != null)
                return false;
        } else if (!responseCode.equals(other.responseCode))
            return false;
        if (responseMsg == null) {
            if (other.responseMsg != null)
                return false;
        } else if (!responseMsg.equals(other.responseMsg))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ResponseData [responseCode=" + responseCode + ", responseMsg="
                + responseMsg + "]";
    }

}
