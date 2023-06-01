/*
The Decorator Design Pattern allows you to add new functionality to
an existing object without altering its structure. This pattern creates a decorator
class that wraps the original class and provides additional functionality,
keeping class methods signature intact.
 */

// First, define a common interface for both the original object and decorator classes:
interface Coffee {
    String getDescription();
    double getCost();
}
// Create the original object (ConcreteComponent) that implements the interface:
class SimpleCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 1.0;
    }
}

//Create an abstract decorator class (Decorator) that also implements the interface and has a reference to the Coffee interface:
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}
//Create concrete decorator classes that extend the abstract decorator class and add new functionality:
class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}

class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.2;
    }
}

//Now you can use these decorators to add new functionality to the original object:
public class Main {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getDescription() + " Cost: " + simpleCoffee.getCost());

        Coffee coffeeWithMilk = new MilkDecorator(simpleCoffee);
        System.out.println(coffeeWithMilk.getDescription() + " Cost: " + coffeeWithMilk.getCost());

        Coffee coffeeWithMilkAndSugar = new SugarDecorator(coffeeWithMilk);
        System.out.println(coffeeWithMilkAndSugar.getDescription() + " Cost: " + coffeeWithMilkAndSugar.getCost());
    }
}