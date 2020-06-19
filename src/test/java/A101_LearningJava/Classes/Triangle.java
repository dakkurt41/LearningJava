package A101_LearningJava.Classes;

public class Triangle {

    static int numberOfSide = 3;
    double height;
    double base;
    double sideOne;
    double sideTwo;
    double sideThree;

    public Triangle(double height, double base, double sideOne, double sideTwo, double sideThree) {
        this.height = height;
        this.base = base;
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
    }

    public double findArea(){
        return (this.base*this.height)/2;
    }
}
