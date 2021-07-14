package lab10.ex3;

public class User {
    private String name;
    private Mediator med;

    public User(String name, Mediator med) {
        this.name = name;
        this.med = med;
    }

    public String getName() {
        return name;
    }

    public void enviarMensagem(String message) {
        med.mostrarMensagem(this, message);
    }
}
