package id.co.telkomsigma.tgf.swing.controller.panel;

import id.co.telkomsigma.tgf.swing.component.dialog.DialogProgress;
import id.co.telkomsigma.tgf.swing.dto.param.DataSourceParam;
import id.co.telkomsigma.tgf.swing.util.IPropertyModifier;
import id.co.telkomsigma.tgf.swing.util.TesterDS;
import id.co.telkomsigma.tgf.util.IParameterizedComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.concurrent.ExecutionException;

/**
 * Created on 6/15/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ControllerPanelTabSettingDatabase implements IParameterizedComponent<DataSourceParam> {

    @Autowired
    TesterDS testerDS;

    @Autowired
    DialogProgress dialogProgress;

    @Autowired
    IPropertyModifier propertyModifier;

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerPanelTabSettingDatabase.class);

    private DataSourceParam dataSourceParam;

    public void btTestPanelTabSettingDatabase() throws ExecutionException, InterruptedException {
        testerDS.setParam(getParam());
        SwingWorker<?,?> worker = new SwingWorker<Integer,Integer>(){
            @Override
            protected Integer doInBackground() throws InterruptedException{
                return testerDS.testMysqlConnection();
            }

            @Override
            protected void done(){
                dialogProgress.dispose();
            }
        };
        worker.execute();
        dialogProgress.setVisible(true);
        if (Integer.valueOf(String.valueOf(worker.get())) == 1){
            JOptionPane.showMessageDialog(null,  "Success", "Testing Data Source Connection", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Failed", "Testing Data Source Connection", JOptionPane.WARNING_MESSAGE);
        }
    }

    public DataSourceParam btSavePanelTabSettingDatabase()  {
        propertyModifier.updateValue("db.host", getParam().getHost());
        propertyModifier.updateValue("db.port", getParam().getPort());
        propertyModifier.updateValue("db.schema", getParam().getSchema());
        propertyModifier.updateValue("db.username", getParam().getUserName());
        propertyModifier.updateValue("db.password", getParam().getPassword());

        return propertyModifier.loadDataSourceSetting();
    }
    @Override
    public void setParam(DataSourceParam p_Param) {
        this.dataSourceParam = p_Param;
    }

    @Override
    public DataSourceParam getParam() {
        return dataSourceParam;
    }
}
