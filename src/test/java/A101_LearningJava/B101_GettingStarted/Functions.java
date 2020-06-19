package A101_LearningJava.B101_GettingStarted;

import org.junit.Test;

import java.util.Scanner;

public class Functions {

    public static void  announceTeaTime(){
        System.out.println("Waiting for tea... ");
        System.out.println("Type a random word or press Enter");
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        System.out.println("It is time for tea....");

    }

    public static double calculateTax(double tipRate, double listedMealPrice, double taxRate ){
        double tip = (tipRate*listedMealPrice);
        double tax = (taxRate*listedMealPrice);
        double total = tip+tax+listedMealPrice;
        System.out.println("The total is " + total);
        System.out.println("The tip is " + tip);
        System.out.println("The tax is " + tax);
        System.out.println("--------------------------");
        return total;
    }



    public static double calculateSalary(int numberOfHoursPerWeek, double hourlyAmount, int vacationDays ){
        if(numberOfHoursPerWeek <0){
            return -1;
        }
        if(hourlyAmount <0 ){
            return -1;
        }

       double grossSalary = (numberOfHoursPerWeek*hourlyAmount)*52 ;
        double unpaidTime = vacationDays*hourlyAmount*8;
        double total = grossSalary - unpaidTime;
        System.out.println("Total gross salary "+ total );
       return total;
    }


    @Test
    public void functionTest1(){
      double groupTotal1=  calculateTax(0.001, 100, 0.10);
      double groupTotal2 =  calculateTax(0.20, 25, 0.03);
      double groupTotal3 =    calculateTax(0.20, 25, 0.03);
      System.out.println("Group total is "+ (groupTotal1 + groupTotal2 + groupTotal3));

      double perPerson = (groupTotal1 + groupTotal2 + groupTotal3)/3;
      System.out.println("The individual price for each person is : "+ perPerson);
  }

    @Test
    public void readyFunctions(){
        double a = Math.pow(5,2);
        System.out.println(a);

        calculateSalary(40,55, 10);
    }

}
