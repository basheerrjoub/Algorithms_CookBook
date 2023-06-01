// 1. Create an interface CloneablePrototype with a method to clone objects.
interface CloneablePrototype {
    CloneablePrototype clone();
}

// 2. Create a class implementing the CloneablePrototype interface.
class SimpleCar implements CloneablePrototype {
    private String color;
    private int motorPower;

    public SimpleCar(String color, int motorPower) {
        this.color = color;
        this.motorPower = motorPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public CloneablePrototype clone() {
        return new SimpleCar(color, motorPower);
    }

    @Override
    public String toString() {
        return "SimpleCar{" +
                "color='" + color + '\'' + " Power='" + motorPower + '\'' +
                '}';
    }

    public void setMotorPower(int motorPower) {
        this.motorPower = motorPower;
    }
}

// 3. Use the prototype pattern to create a new object by cloning an existing one.
public class Main {
    public static void main(String[] args) {
        SimpleCar originalCar = new SimpleCar("Blue", 2000);
        System.out.println("Original car: " + originalCar);

        SimpleCar clonedCar = (SimpleCar) originalCar.clone();
        System.out.println("Cloned car: " + clonedCar);

        // Modify the cloned car's color
        clonedCar.setMotorPower(4000);
        System.out.println("Modified cloned car: " + clonedCar);
    }
}
