package id.co.telkomsigma.tgf.swing.dto.param;

import java.io.Serializable;

public class DataSourceParam implements Serializable {

    /**
     *
     *
     */
    private static final long serialVersionUID = -2016933822038136143L;

    private String host;
    private String port;
    private String schema;
    private String userName;
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
