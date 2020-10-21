package br.com.fiap.patterns.singleton;

public class TesteSingleton {

    public static void main(String[] args) {
        ObjetoSingleton obj1 = ObjetoSingleton.getInstance();
        ObjetoSingleton obj2 = ObjetoSingleton.getInstance();
        try {
            obj1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(
                obj1 == obj2 ?
                "Os objetos são iguais" :
                "Objetos diferentes"
        );
    }

}
