package br.com.fiap.arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NovaLeituraMain {

    public static void main(String[] args) {
        try ( // Java 8
                FileReader inputStream = new FileReader("arquivo.txt");
                BufferedReader arquivo = new BufferedReader(inputStream)
                ) {

            String linha;
            while ((linha = arquivo.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
