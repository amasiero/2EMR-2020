package br.com.fiap.patterns.factory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

public class TesteConnectionFactory {

    public static void main(String[] args) {
        try {
            Connection connOracle = ConnectionFactory.getConnection(BancoDados.ORACLE);
            if (connOracle != null) {
                System.out.println("Conexão com o Oracle realizada com sucesso.");
                connOracle.close();
            }

            Connection connMySQL = ConnectionFactory.getConnection(BancoDados.MYSQL);
            if (connMySQL != null) {
                System.out.println("Conexão com o MySQL realizada com sucesso.");
                connMySQL.close();
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connOracle = ConnectionFactoryComReflection.getConnection(BancoDados.ORACLE);
            if (connOracle != null) {
                System.out.println("Conexão com o Oracle realizada com sucesso.");
                connOracle.close();
            }

            Connection connMySQL = ConnectionFactoryComReflection.getConnection(BancoDados.MYSQL);
            if (connMySQL != null) {
                System.out.println("Conexão com o MySQL realizada com sucesso.");
                connMySQL.close();
            }
        } catch (ClassNotFoundException | SQLException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            System.out.println(e.getMessage());
        }
    }
}


