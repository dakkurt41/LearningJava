package A102_LearningJava11;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter first value : ");
        var number1 = scanner.nextDouble();
        System.out.print("Enter second value : ");
        var number2 = scanner.nextDouble();
        var result = number1 + number2;
        System.out.println("The sum is : "+ result );

    }
}
