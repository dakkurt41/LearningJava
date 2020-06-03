package A101_LearningJava.B101_GettingStarted;

import org.junit.Test;

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

        System.out.println(firstName);
        System.out.println(lastName);

    }
}
