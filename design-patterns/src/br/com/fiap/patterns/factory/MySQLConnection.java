package br.com.fiap.patterns.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnection implements MyConnection{

    private Properties props;

    public MySQLConnection() throws IOException {
        this.props = new Properties();
        this.props.load(new FileInputStream("application.properties"));
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                this.props.getProperty("mysql.url"),
                this.props.getProperty("mysql.user"),
                this.props.getProperty("mysql.password")
        );
    }

}
