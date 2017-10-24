package id.co.telkomsigma.tgf.swing.dto.param;

import java.io.Serializable;

/**
 * Created on 10/24/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class SplashScreenParam implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2006523447984978241L;

    private String splashScreenImageUrl;
    private String iconImageUrl;

    public String getSplashScreenImageUrl() {
        return splashScreenImageUrl;
    }

    public void setSplashScreenImageUrl(String splashScreenImageUrl) {
        this.splashScreenImageUrl = splashScreenImageUrl;
    }

    public String getIconImageUrl() {
        return iconImageUrl;
    }

    public void setIconImageUrl(String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
    }
}
