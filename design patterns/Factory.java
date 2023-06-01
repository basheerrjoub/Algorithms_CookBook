interface Shape{
    void draw();
}

class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}


class ShapeFactory{
    public Shape getShape(String type){
        if (type.equals("rectangle")) return new Rectangle();
        if(type.equals("square")) return new Square();
        return null;
    }
}

public class Main {
    public static void main(String[] args){

        //Implementing the factory
        ShapeFactory factory = new ShapeFactory();
        //Implementing a rectangle
        Shape myShape = factory.getShape("rectangle");
        //Drawing the shape
        myShape.draw();
        //Now the width and length of the rect are the same
        //So change the shape to square would be more suitable
        myShape = factory.getShape("square");
        //Drawing the shape
        myShape.draw();

    }
}