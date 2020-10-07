package br.com.fiap.patterns.factory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection(BancoDados bd) throws IOException, SQLException, ClassNotFoundException {
        if(bd == BancoDados.MYSQL) return new MySQLConnection().getConnection();
        if(bd == BancoDados.ORACLE) return new OracleConnection().getConnection();
        return null;
    }
}
