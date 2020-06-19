package A101_LearningJava.Classes;

public class Student {

    String firstName;
    String lastName;
    int yearToGrad;
    double gpa;
    String declaredMajor;

    public Student(String firstName, String lastName, int yearToGrad, double gpa, String declaredMajor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearToGrad = yearToGrad;
        this.gpa = gpa;
        this.declaredMajor= declaredMajor;
    }

    public void incrementExpectedGradYear(){
         this.yearToGrad = this.yearToGrad +1;
    }
}
