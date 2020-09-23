package br.com.fiap.arquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class NovaEscritaMain {

    public static void main(String[] args) {

        try (
                FileWriter outputStream = new FileWriter("arquivo.txt");
                PrintWriter arquivo = new PrintWriter(outputStream)
             ) {

            arquivo.println("#--- Novo arquivo ---#");
            arquivo.println("- Agora fecho sozinho -");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }


}
