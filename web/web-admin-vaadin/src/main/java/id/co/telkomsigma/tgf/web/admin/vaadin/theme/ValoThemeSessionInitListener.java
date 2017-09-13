package id.co.telkomsigma.tgf.web.admin.vaadin.theme;

import com.vaadin.server.*;
import org.jsoup.nodes.Element;

public class ValoThemeSessionInitListener implements SessionInitListener {
    /**
     *
     *
     */
    private static final long serialVersionUID = 5214821954302388204L;

    @Override
    public void sessionInit(final SessionInitEvent event) throws ServiceException {
        event.getService().setSystemMessagesProvider(
                systemMessagesInfo -> {
                    CustomizedSystemMessages csm = new CustomizedSystemMessages();
                    csm.setSessionExpiredNotificationEnabled(false);
                    return csm;
                });
        event.getSession().addBootstrapListener(new BootstrapListener() {
            /**
             *
             *
             */
            private static final long serialVersionUID = -9048422096516466412L;

            @Override
            public void modifyBootstrapPage(final BootstrapPageResponse response) {
                final Element head = response.getDocument().head();
                head.appendElement("meta").attr("name", "viewport")
                        .attr("content", "width=device-width, initial-scale=1");
                head.appendElement("meta")
                        .attr("name", "apple-mobile-web-app-capable")
                        .attr("content", "yes");
                head.appendElement("meta")
                        .attr("name", "apple-mobile-web-app-status-bar-style")
                        .attr("content", "black");
            }

            @Override
            public void modifyBootstrapFragment(
                    final BootstrapFragmentResponse response) {
            }
        });
    }

}
