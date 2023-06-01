class Animal {

    public Flys flyType;
    private String sound;
    public Animal(){

    }

    public String tryFlying(){
        return flyType.fly();
    }

    public void setFlyType(Flys flyType){
        this.flyType = flyType;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}


class Dog extends Animal{

    public Dog() {
        super();
        setSound("Bark");
        flyType = new ItCantFly();
    }
}

class Bird extends Animal{

    public Bird() {
        super();
        setSound("Tweet");
        flyType = new ItFlys();
    }
}


interface Flys{
    String fly();
}
class ItFlys implements Flys{
    @Override
    public String fly() {
        return "I'm Flying";
    }
}

class ItCantFly implements Flys{
    @Override
    public String fly() {
        return "I Can't Fly";
    }
}


public class Main {
    public static void main(String[] args) {

        Animal bash = new Dog();
        Animal sous = new Bird();
        System.out.println("Bash:" + bash.tryFlying());
        bash.setFlyType(new ItFlys());
        System.out.println("Bash:" + bash.tryFlying());
    }
}