package id.co.telkomsigma.tgf.web.admin.vaadin.component.tabsheet;

import com.vaadin.ui.Component;

import java.util.SortedMap;

/**
 * Created on 8/20/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ITabSheetDataRetriever {

    String[] getTabNames();

    SortedMap<String, Component> getTabComponents();
}
