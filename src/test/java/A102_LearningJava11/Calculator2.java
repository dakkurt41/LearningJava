package A102_LearningJava11;

import java.util.Scanner;

public class Calculator2 {


    public static void main(String[] args) {
        calculate();
    }

    public static void  calculate(){
        try {
            var scanner = new Scanner(System.in);
            System.out.print("Enter a numeric value : ");
            var a = scanner.nextDouble();
            System.out.print("Enter a numeric value : ");
            var b = scanner.nextDouble();
            System.out.print("Choose an operator (- * + /) : ");
            char c = scanner.next().charAt(0);
            var result = chooseOperator(a,b,c);
            System.out.println(result);


        } catch (Exception e) {
            System.out.println("It is not a numeric value : " + e.getMessage());
        }
    }

    public static double chooseOperator(double num1 , double num2, char operator){
        double result = 0;
       if(operator == '/' ){
           result =  num1/num2;
       } else if(operator == '-'){
           result =  num1-num2;
       }else if(operator == '+'){
           result =  num1+num2;
       }else if(operator == '*'){
           result =  num1*num2;
       }else {
           System.out.println("You did not choose a valid operator!");
       }
        System.out.println("The result is : " + result);
        return result;
    }



}
