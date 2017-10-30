package id.co.telkomsigma.tgf.swing.component.base;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 5/29/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ICentralizePositionComponent {

    void setComponentToCenter(Component p_Component);

    void setDialogToCenter(JDialog p_JDialog);

    void setDialogCustomToCenter(JDialog p_JDialog, int p_XDivider, int p_YDivider);

    void setIFrameToCenter(JInternalFrame p_JInternalFrame);

    void setIFrameToCenter(JInternalFrame p_JInternalFrame, int p_XDivider, int p_YDivider);

    void setIFrameToPosition(JInternalFrame p_JInternalFrame, int p_XPosition, int p_YPosition);
}
