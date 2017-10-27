package id.co.telkomsigma.tgf.swing.view.panel.tab.settings.database;

import id.co.telkomsigma.tgf.swing.controller.panel.ControllerPanelTabSettingDatabase;
import id.co.telkomsigma.tgf.swing.dto.param.DataSourceParam;
import id.co.telkomsigma.tgf.util.IComponentAction;
import id.co.telkomsigma.tgf.util.IComponentInitializer;
import id.co.telkomsigma.tgf.util.UIConstant.Common.Punctuation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutionException;

/**
 * Created on 5/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelTabSettingDatabase extends JPanel implements IComponentInitializer, IComponentAction {
    /**
     *
     *
     */
    private static final long serialVersionUID = -3586816668647376686L;

    @Autowired
    private PanelTabSettingDatabaseTop panelTabSettingDatabaseTop;

    @Autowired
    private PanelTabSettingDatabaseBottom panelTabSettingDatabaseBottom;

    @Autowired
    private ControllerPanelTabSettingDatabase controllerPanelTabSettingDatabase;

    private DataSourceParam dataSourceParam;

    private static final Logger LOGGER = LoggerFactory.getLogger(PanelTabSettingDatabase.class);

    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new BorderLayout());
        this.add(panelTabSettingDatabaseTop, BorderLayout.CENTER);
        this.add(panelTabSettingDatabaseBottom, BorderLayout.PAGE_END);

        initAction();
    }


    @Override
    public void initAction() {
        panelTabSettingDatabaseBottom.getBtTestPanelTabSettingDatabase().addActionListener(e -> {
            if (validateDataSourceParam() == 1) {
                controllerPanelTabSettingDatabase.setParam(dataSourceParam);
                try {
                    controllerPanelTabSettingDatabase.btTestPanelTabSettingDatabase();
                } catch (ExecutionException | InterruptedException e1) {
                    e1.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fields must not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        panelTabSettingDatabaseBottom.getBtSavePanelTabSettingDatabase().addActionListener(e -> {
            if (validateDataSourceParam() == 1){
                controllerPanelTabSettingDatabase.setParam(dataSourceParam);
                DataSourceParam param = controllerPanelTabSettingDatabase.btSavePanelTabSettingDatabase();

                panelTabSettingDatabaseTop.getPanelTabSettingDatabaseRight().getTxtHost().setText(param.getHost());
                panelTabSettingDatabaseTop.getPanelTabSettingDatabaseRight().getTxtPort().setText(param.getPort());
                panelTabSettingDatabaseTop.getPanelTabSettingDatabaseRight().getTxtSchemaName().setText(param.getSchema());
                panelTabSettingDatabaseTop.getPanelTabSettingDatabaseRight().getTxtUserName().setText(param.getUserName());
                panelTabSettingDatabaseTop.getPanelTabSettingDatabaseRight().getTxtPassword().setText(param.getPassword());
            }else{
                JOptionPane.showMessageDialog(null, "Fields must not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        });
    }

    int validateDataSourceParam(){
        dataSourceParam = new DataSourceParam();
        int result = 0;
        if (!panelTabSettingDatabaseTop.getPanelTabSettingDatabaseRight().getTxtHost().getText().equals(Punctuation.EMPTY)){
            dataSourceParam.setHost(panelTabSettingDatabaseTop.getPanelTabSettingDatabaseRight().getTxtHost().getText());
            if (!panelTabSettingDatabaseTop.getPanelTabSettingDatabaseRight().getTxtPort().getText().equals(Punctuation.EMPTY)){
                dataSourceParam.setPort(panelTabSettingDatabaseTop.getPanelTabSettingDatabaseRight().getTxtPort().getText());
                if (!panelTabSettingDatabaseTop.getPanelTabSettingDatabaseRight().getTxtSchemaName().getText().equals(Punctuation.EMPTY)){
                    dataSourceParam.setSchema(panelTabSettingDatabaseTop.getPanelTabSettingDatabaseRight().getTxtSchemaName().getText());
                    if (!panelTabSettingDatabaseTop.getPanelTabSettingDatabaseRight().getTxtUserName().getText().equals(Punctuation.EMPTY)){
                        dataSourceParam.setUserName(panelTabSettingDatabaseTop.getPanelTabSettingDatabaseRight().getTxtUserName().getText());
                        if (!panelTabSettingDatabaseTop.getPanelTabSettingDatabaseRight().getTxtPassword().getText().equals(Punctuation.EMPTY)){
                            dataSourceParam.setPassword(panelTabSettingDatabaseTop.getPanelTabSettingDatabaseRight().getTxtPassword().getText());
                            result = 1;
                        }
                    }
                }
            }
        }
        return result;
    }

}
