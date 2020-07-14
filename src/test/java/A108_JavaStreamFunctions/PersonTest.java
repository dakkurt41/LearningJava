package A108_JavaStreamFunctions;

import java.util.ArrayList;
import java.util.List;
import A108_JavaStreamFunctions.Person.Gender;
import org.junit.Test;

public class PersonTest {


    public List<Person> getListPerson (){

        List<Person> listPersons = new ArrayList<>();

        listPersons.add(new Person("Alice", "Brown", "alice@gmail.com", Gender.FEMALE, 26));
        listPersons.add(new Person("Bob", "Young", "bob@gmail.com", Gender.MALE, 32));
        listPersons.add(new Person("Carol", "Hill", "carol@gmail.com", Gender.FEMALE, 23));
        listPersons.add(new Person("David", "Green", "david@gmail.com", Gender.MALE, 39));
        listPersons.add(new Person("Eric", "Young", "eric@gmail.com", Gender.MALE, 26));
        listPersons.add(new Person("Frank", "Thompson", "frank@gmail.com", Gender.MALE, 33));
        listPersons.add(new Person("Gibb", "Brown", "gibb@gmail.com", Gender.MALE, 27));
        listPersons.add(new Person("Henry", "Baker", "henry@gmail.com", Gender.MALE, 30));
        listPersons.add(new Person("Isabell", "Hill", "isabell@gmail.com", Gender.FEMALE, 22));
        listPersons.add(new Person("Jane", "Smith", "jane@gmail.com", Gender.FEMALE, 24));
        return listPersons;
    }


    @Test
    public void filter_with_JavaStream(){

        getListPerson().stream()
                .filter(p->p.getGender().equals(Gender.FEMALE))
                .forEach(s-> System.out.println(s));

        System.out.println("---------------------------");

        getListPerson().stream()
                .filter(p->p.getGender().equals(Gender.FEMALE))
                .forEach(System.out::println);

        System.out.println("---------------------------");

        getListPerson().stream()
                .filter(p->p.getGender().equals(Gender.MALE) && p.getAge()<50)
                .forEach(System.out::println);
    }


    @Test
    public void map_with_JavaStream2(){

        getListPerson().stream()
                .map(p->p.getEmail())
                .forEach(System.out::println);

        System.out.println("---------------------------");

        getListPerson().stream()
                .map(p->p.getAge())
                .forEach(age -> System.out.print(age + " - "));

        System.out.println("---------------------------");
        getListPerson().stream()
                .map(x-> x.getFirstName().toUpperCase())
                .forEach(System.out::println);

        System.out.println("---------------------------");


    }








}
