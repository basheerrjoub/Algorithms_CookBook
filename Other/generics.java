class Main{
    public static void main(String[] args) {

        Double[] nums = {1.0,2.2,3.5,4.0,5.0,5.0,5.0,3.0,23.0,355.0};
        Character[] chars = {'B', 'A', 'S', 'H', 'E', 'E', 'R'};
        //Main.printList(chars);

        //Save an integer in the generic class
        Bash<Integer> num = new Bash<>(12);
        System.out.println(num.getX());

        //Save a String in the generic class
        Bash<String> str = new Bash<>("Basheer");
        System.out.println(str.getX());



    }
    public static <Type> void  printList(Type[] items){
        for(Type x: items)
            System.out.print(x + "   ");
    }
}

//Creating a Generic Class
class Bash <Type>{
    Type x;
    Bash(Type x){
        this.x = x;
    }

    public Type getX() {
        return x;
    }
}
