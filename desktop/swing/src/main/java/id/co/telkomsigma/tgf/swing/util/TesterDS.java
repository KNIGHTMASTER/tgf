package id.co.telkomsigma.tgf.swing.util;

import id.co.telkomsigma.tgf.swing.dto.param.DataSourceParam;
import id.co.telkomsigma.tgf.util.IParameterizedComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created on 10/24/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class TesterDS implements IParameterizedComponent<DataSourceParam> {

    private DataSourceParam dataSourceParam;

    @Value("${spring.datasource.driverClassName}")
    String mysqlDriver;

    private static final Logger LOGGER = LoggerFactory.getLogger(TesterDS.class);

    public int testMysqlConnection() {
        int result = 0;
        try {
            Class.forName(mysqlDriver);
        } catch (ClassNotFoundException e) {
            LOGGER.error("Mysql JDBC Not Found ".concat(e.toString()));
        }
        LOGGER.info("MySQL JDBC Driver Registered!");
        Connection connection = null;
        try {
            String connectionUrl = "jdbc:mysql://" + dataSourceParam.getHost() + ":" + dataSourceParam.getPort() + "/" + dataSourceParam.getSchema();
            connection = DriverManager.getConnection(connectionUrl, dataSourceParam.getUserName(), dataSourceParam.getPassword());
        } catch (SQLException e) {
            LOGGER.error("Connection Failed ".concat(e.toString()));
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            result = 1;
        } else {
            result = 0;
        }
        return result;
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
