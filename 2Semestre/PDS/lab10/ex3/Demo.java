package lab10.ex3;

public class Demo {
    public static void main(String[] args) {

        Mediator med = new Mediator();

        User user1 = new User("Pedro",med);
        User user2 = new User("André",med);

        user1.enviarMensagem("Olá André!");
        user2.enviarMensagem("Olá Pedro, tudo bem?");
        user1.enviarMensagem("Sim.");

    }
}
