package br.com.fiap.patterns.singleton;

public class ObjetoSingleton {

    private static ObjetoSingleton instance;

    private ObjetoSingleton() {
        System.out.println("Construtor chamado com suscesso!");
    }

    public synchronized static ObjetoSingleton getInstance() {
        if(instance == null) {
            instance = new ObjetoSingleton();
        }
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Não é possível clonar esse objeto.");
    }

}
