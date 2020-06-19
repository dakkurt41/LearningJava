package A101_LearningJava.Classes;

import org.junit.Test;

public class ForTriangleClass {

    @Test
    public void TriangelTest(){
        Triangle triangle1 =  new Triangle(5, 20, 15,14,15);
        double result = triangle1.findArea();
        System.out.println("The area is : "+ result);

        System.out.println("The sideone of trianangel is : " + triangle1.sideOne);
        System.out.println("The static atribute "+ Triangle.numberOfSide);
    }
    @Test
    public void StudentTest(){
       Student student1 = new Student("Kara", "Kartal",2020, 3.4, "Science");
       Student student2 = new Student("Saman", "Alev",2019, 2.7, "Teacher");

       student1.incrementExpectedGradYear();
        System.out.println(student1.firstName);
        System.out.println(student1.lastName);
        System.out.println(student1.gpa);
        System.out.println(student1.declaredMajor);
       System.out.println("Students year to graduate " + student1.yearToGrad);

    }
}
