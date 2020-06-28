package A105_JavaStreams;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTests {

    private List<Person> people = getPeople();

    private static List<Person> getPeople() {
        return List.of(
                new Person("Mike", 19, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)

        );
    }


    @Test
    @DisplayName("Imparative Approach")
    public void Test1() {

        List<Person> females = new ArrayList<>();
        List<Person> males = new ArrayList<>();

        for (Person person : people) {
            if (person.getGender().equals(Gender.FEMALE)) {
                females.add(person);
            } else {
                males.add(person);
            }
        }

        females.forEach(System.out::println);
        System.out.println("-----------------");
        males.forEach(System.out::println);


    }


    @Test
    @DisplayName("Filter")
    public void Test2() {
        List<Person> females = people.stream()
                .filter(person ->
                        person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        females.forEach(System.out::println);

        System.out.println(females.get(0).getName());
        System.out.println(females.get(0).getAge());
        System.out.println(females.get(0).getGender());
    }

    @Test
    @DisplayName("Sort")
    public void Test3() {
        people.forEach(System.out::println);

        System.out.println("---------Sort by age---------");
        List<Person> sortedAge = people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender))
                .collect(Collectors.toList());
        sortedAge.forEach(System.out::println);

        System.out.println("---------Sort by names--------- ");
        List<Person> sortNames = people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());
        sortNames.forEach(System.out::println);

        System.out.println("---------Sort by gender---------- ");
        List<Person> sortGender = people.stream()
                .sorted(Comparator.comparing(Person::getGender))
                .collect(Collectors.toList());
        sortGender.forEach(System.out::println);
    }

    @Test
    @DisplayName("All Match")
    public void Test4() {
//all match
        boolean allMatch = people.stream().allMatch(person -> person.getAge()>8);
        System.out.println("All Match : " + allMatch);

        // any match
        boolean anyMatching = people.stream().anyMatch(person -> person.getAge()>8);
        System.out.println("Any Match : "+ anyMatching);

        // none match
        boolean none = people.stream().noneMatch(person -> person.getName().equals("Mike"));
        System.out.println("None match : " + none);

    }


    @Test
    @DisplayName("Max")
    public void Test5() {

        Optional<Person> findMaxAge = people.stream()
                .max(Comparator.comparing(Person::getAge));

        System.out.println(findMaxAge);
        System.out.println(findMaxAge.get().getAge());


        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
    }


    @Test
    @DisplayName("Min")
    public void Test6() {
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
    }

    @Test
    @DisplayName("Grouping by ")
    public void Test7() {

        Map<Gender, List<Person>>  groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach(((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            System.out.println("-------------");

        }));

    }

    @Test
    @DisplayName("Oldest male in the list")
    public void Test8() {
        Optional<String> oldestMale = people.stream()
                .filter(person -> person.getGender().equals(Gender.MALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        oldestMale.ifPresent(System.out::println);

        System.out.println(" ------------");

        Optional<String> oldestFemale = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        oldestFemale.ifPresent(System.out::println);

    }


}
