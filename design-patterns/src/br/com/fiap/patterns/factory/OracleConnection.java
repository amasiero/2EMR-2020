package br.com.fiap.patterns.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleConnection implements MyConnection {

    private Properties props;

    public OracleConnection() throws IOException {
        this.props = new Properties();
        this.props.load(new FileInputStream("application.properties"));
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(
                this.props.getProperty("oracle.url"),
                this.props.getProperty("oracle.user"),
                this.props.getProperty("oracle.password")
        );
    }

}
