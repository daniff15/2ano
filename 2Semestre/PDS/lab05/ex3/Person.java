package lab05.ex3;

public class Person {
    private String nome;

    public Person(String nome) {
        this.nome = nome;
    }

    String getName() {
        return nome;
    }

    @Override
    public String toString() {
        return nome ;
    }

    
}