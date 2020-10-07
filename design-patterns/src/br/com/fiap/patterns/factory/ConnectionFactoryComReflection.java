package br.com.fiap.patterns.factory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryComReflection {

    public static Connection getConnection(BancoDados bd) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> classe = Class.forName("br.com.fiap.patterns.factory." + bd.getValor() + "Connection");
        MyConnection conn = (MyConnection) classe.getDeclaredConstructor().newInstance();
        return conn.getConnection();
    }
}
