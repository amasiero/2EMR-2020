package br.com.fiap.patterns.factory;

public enum BancoDados {
    ORACLE("Oracle"),
    MYSQL("MySQL");

    private String valor;

    BancoDados(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
