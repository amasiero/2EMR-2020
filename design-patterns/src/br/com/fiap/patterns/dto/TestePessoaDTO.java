package br.com.fiap.patterns.dto;

import br.com.fiap.patterns.dto.model.Pessoa;

public class TestePessoaDTO {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        System.out.println(new PessoaDTO(pessoa));
    }

}
