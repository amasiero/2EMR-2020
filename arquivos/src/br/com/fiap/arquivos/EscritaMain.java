package br.com.fiap.arquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscritaMain {

    public static void main(String[] args) {

        try {
            FileWriter outputStream = new FileWriter("arquivo.txt");
            PrintWriter arquivo = new PrintWriter(outputStream);

            arquivo.println("#--- Meu primeiro arquivo ---#");
            arquivo.println("- HELLO WORLD -");

            arquivo.close();
            outputStream.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
