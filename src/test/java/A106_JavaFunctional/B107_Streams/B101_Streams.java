package A106_JavaFunctional.B107_Streams;

import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static A106_JavaFunctional.B107_Streams.B101_Streams.Gender.*;

public class B101_Streams {

    //variables
    private List<Person> people = getPeopleData();

    //methods
    private static List<Person> getPeopleData() {
        List<Person> people = List.of(
                new Person("Mike", MALE),
                new Person("Alan", MALE),
                new Person("Samet", MALE),
                new Person("Jack", MALE),
                new Person("Sarah", FEMALE),
                new Person("Anna", FEMALE),
                new Person("Michele", FEMALE),
                new Person("Alexandra", FEMALE)
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


    @Test
    public void test1(){
        Set<Gender> collectSet = getPeopleData().stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet());

        System.out.println(collectSet);

        getPeopleData().stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        getPeopleData().stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        getPeopleData().stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);


    }

    @Test
    public void test2(){

        boolean containOnlyFemale = getPeopleData().stream()
                .allMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containOnlyFemale);


        boolean containOnlyFemale1 = getPeopleData().stream()
                .anyMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containOnlyFemale1);
    }
    @Test
    public void test3(){

    }
}
