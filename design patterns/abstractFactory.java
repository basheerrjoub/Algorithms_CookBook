//Define an interface for the family of objects you want to create
interface Button {
    void click();
}

interface Checkbox {
    void check();
}

//Implement concrete classes for each family member
class WindowsButton implements Button {
    @Override
    public void click() {
        System.out.println("Windows button clicked");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void check() {
        System.out.println("Windows checkbox checked");
    }
}

class MacOSButton implements Button {
    @Override
    public void click() {
        System.out.println("MacOS button clicked");
    }
}

class MacOSCheckbox implements Checkbox {
    @Override
    public void check() {
        System.out.println("MacOS checkbox checked");
    }
}

//Create an abstract factory interface for creating these objects
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

//Implement concrete factory classes
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

//Example usage of the Abstract Factory pattern
public class Main {
    public static void main(String[] args) {
        GUIFactory factory;

        String operatingSystem = System.getProperty("os.name").toLowerCase();
        if (operatingSystem.contains("windows")) {
            factory = new WindowsFactory();
        } else if (operatingSystem.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            throw new UnsupportedOperationException("Unsupported operating system");
        }

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.click();
        checkbox.check();
    }
}