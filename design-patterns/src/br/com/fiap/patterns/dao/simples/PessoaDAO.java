package br.com.fiap.patterns.dao.simples;

import java.util.List;

public class PessoaDAO {

    public List<String> buscaTodos() {
        return List.of("Gloria Maria", "Maria Antunieta", "Tereza Cristina");
    }

    public String buscaPorId(long id) {
        return "Gloria Maria";
    }

    public String salva(String pessoa) {
        return pessoa;
    }

    public void atualiza(String pessoa) {
        System.out.println("Atualiza pessoa");
    }

    public void exclui(long id) {
        System.out.println("Exclui pessoa");
    }

}
