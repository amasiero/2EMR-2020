package br.com.fiap.patterns.dto;

import br.com.fiap.patterns.dto.model.Pessoa;

public class PessoaDTO {

    private String nome;
    private String email;
    private String profissao;

    public PessoaDTO(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.email = pessoa.getEmail();
        this.profissao = pessoa.getProfissao();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getProfissao() {
        return profissao;
    }
}
