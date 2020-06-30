package A106_JavaFunctional;

import A105_JavaStreams.Gender;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class B101_Imprative {

    //variables
    private List<Person> people = getPeopleData();

    //methods
    private static List<Person> getPeopleData() {
        List<Person> people = List.of(
                new Person("Mike", Gender.MALE),
                new Person("Alan", Gender.MALE),
                new Person("Samet", Gender.MALE),
                new Person("Jack", Gender.MALE),
                new Person("Sarah", Gender.FEMALE),
                new Person("Anna", Gender.FEMALE),
                new Person("Michele", Gender.FEMALE),
                new Person("Alexandra", Gender.FEMALE)
        );
        return people;
    }

    //class
    static class Person{
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
 // enums
    enum Gender{
        MALE,FEMALE
    }

    //Tests

    @Test
    @DisplayName("Impreative Approach for java functional")
    public void ImperativeApproach(){
        List<Person> females = new ArrayList<>();

        for(Person person : people){
            if(person.gender.equals(Gender.FEMALE)){
                females.add(person);
            }
        }
        //first way using foreach from list
        females.forEach(System.out::println);

        //second way
        for(Person female : females){
            System.out.println(female.name);
        }

    }

    @Test
    @DisplayName("Declarative Approach for java functional")
    public void ImperativeApproach1(){
       people.stream()
               .filter(person -> Gender.FEMALE.equals(person.gender))
               .forEach(System.out::println);

        System.out.println("..........................................");

        List<Person> females = people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList());
        females.forEach(System.out::println);
    }

    @Test
    @DisplayName("Impreative Approach for java functional")
    public void ImperativeApproach2(){

    }

    @Test
    @DisplayName("Impreative Approach for java functional")
    public void ImperativeApproach3(){

    }
}
