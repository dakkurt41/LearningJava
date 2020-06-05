package A101_LearningJava.B101_GettingStarted;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HelloWorld {

    @Test
    public void Test1(){
        System.out.println("Hello World Java program. Ready to learn...");
    }

    @Test
    public void PrimitiveDataTypes(){

        int age = 34;
        double Gpa = 4.0;
        char firstNameInitial = 'K';
        char lastNameInitial = 'D';
        boolean hasPerfectAttandance = true;

        System.out.println(age);
        System.out.println(Gpa);
        System.out.println(firstNameInitial);
        System.out.println(lastNameInitial);
        System.out.println(hasPerfectAttandance);
    }


    @Test
    public void ReferenceDataTypes(){

       String firstName = "Kara";
       String lastName = "Kartal";
       char firstNameInital = firstName.charAt(0);

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(firstNameInital);

    }

    @Test
    public void ConcatenateVariables(){

        int age = 34;
        double Gpa = 4.0;
        char lastNameInitial = 'D';
        String firstName = "Kara";
        String lastName = "Kartal";
        char firstNameInital = firstName.charAt(0);

        System.out.println(firstName + " " + lastName +  " has a GPA of "+ Gpa );

    }

    @Test
    public void Scanner(){

        int age = 34;
        double Gpa = 4.0;
        char lastNameInitial = 'D';
        String firstName = "Kara";
        String lastName = "Kartal";
        char firstNameInital = firstName.charAt(0);

        System.out.println("What do you want to update it to?");

        Scanner input = new Scanner(System.in);
        Gpa = input.nextDouble();

        System.out.println(firstName + " " + lastName +  " has a GPA of "+ Gpa );

    }

    @Test
    public void IfStatementsLogic(){

        System.out.println("Pick a number between 1 and 10");
       int number = 2;

       if(number<5){
           System.out.println("Enjoy the good luck a friend brings you");
       } else {
           System.out.println("Your shoe selection will make you very happy today");
       }

    }


    @Test
    public void IfStatementsLogic2(){

        String foodName = "pizza";
        System.out.println("Pick a number between 1 and 10");
        int number = 7;

        if(number==0){
            foodName ="chicken";
            System.out.println(foodName);
        } else if(number == 7) {
            foodName ="steak";
            System.out.println(foodName);
        }else{
            System.out.println(foodName);
        }

    }

   @Test
    public void whileLoops() {
        Scanner input = new Scanner(System.in);
        Boolean  isRepeatOn = true;
        System.out.println("The music is playing. ");
        while(isRepeatOn){
            System.out.println("Do you want to go next one yes/no ");
            String answer = input.next();
            if(answer.contains("yes")){
                isRepeatOn = false;
            }else if (answer.contains("no")){
                isRepeatOn= true;
            }
        }
        System.out.println("The next song is playing.......");

    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String question = "What is your favorite color?";


        String choice1= "blue";
        String choice2= "black";
        String choice3= "yellow";

        String correctAns = choice2;

        System.out.println(question);
        System.out.println("Choose the following");
        System.out.println( "A-"+choice1);
        System.out.println( "B-"+choice2);
        System.out.println( "C-"+choice3);

        Boolean userans  = true;
        String ans = input.next();
        while(userans){
            System.out.println(question);
            System.out.println("Choose the following");
            System.out.println( "A-"+choice1);
            System.out.println( "B-"+choice2);
            System.out.println( "C-"+choice3);

            if (correctAns.equalsIgnoreCase(choice2)) {
                System.out.println("The answer is Correct.");
                userans = false;
            } else if (ans.equalsIgnoreCase(choice2)){
                System.out.println( choice2 +" NOT Correct. Try Again");
                userans = false;
            }else if(ans.equals(choice3)){
                System.out.println( choice3 +" NOT Correct. Try Again");
                userans = false;
            }
        }
    }
}
