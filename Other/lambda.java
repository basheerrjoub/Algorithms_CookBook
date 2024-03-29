import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Greeting greeting = (name -> {
            System.out.println("Hello " + name);
        });

        greeting.sayHello("Basheer");
    }
}

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}
