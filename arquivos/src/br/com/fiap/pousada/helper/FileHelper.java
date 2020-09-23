package br.com.fiap.pousada.helper;

import br.com.fiap.pousada.exception.FileException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileHelper {

    public static Properties getProperties() throws FileException {
        try (
                FileInputStream fis = new FileInputStream("application.properties")
            ) {
            Properties props = new Properties();

            props.load(fis);
            return props;

        } catch (IOException e) {
            e.printStackTrace();
            throw new FileException("Não foi possível carregar as propriedades.");
        }
    }
}
