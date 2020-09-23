package br.com.fiap.arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraMain {

    public static void main(String[] args) {

        try {
            FileReader inputStream = new FileReader("arquivo.txt");
            BufferedReader arquivo = new BufferedReader(inputStream);

            String linha;
            while((linha = arquivo.readLine()) != null) {
                System.out.println(linha);
            }

            arquivo.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
