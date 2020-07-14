package A107_MethodsForIteratingCollections;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B01Test {


    //List
    public static List<String> ListOfNames() {
        List<String> names = new ArrayList<>();
        names.add("Tom");
        names.add("Mary");
        names.add("Peter");
        names.add("John");
        names.add("Kim");
        return names;
    }

    //Set
    public static Set<Integer> getNumbers(){
        Set<Integer> numbers = new HashSet<>();
        numbers.add(100);
        numbers.add(5);
        numbers.add(16);
        numbers.add(42);
        numbers.add(78);
        return numbers;
    }

    // Map
    public static Map<Integer, String> getGrades(){

    Map<Integer, String > listOfGrades = new HashMap<>();
    listOfGrades.put(65, "A");
    listOfGrades.put(66, "B");
    listOfGrades.put(67, "C");
    listOfGrades.put(68, "D");

    return listOfGrades;
    }


    public static List<B02_Student> getListOfStudents (){
        List<B02_Student> listStudents = new ArrayList<>();

        listStudents.add(new B02_Student("Alice", 82));
        listStudents.add(new B02_Student("Bob", 90));
        listStudents.add(new B02_Student("Carol", 67));
        listStudents.add(new B02_Student("David", 80));
        listStudents.add(new B02_Student("Eric", 55));
        listStudents.add(new B02_Student("Frank", 49));
        listStudents.add(new B02_Student("Gary", 88));
        listStudents.add(new B02_Student("Henry", 98));
        listStudents.add(new B02_Student("Ivan", 66));
        listStudents.add(new B02_Student("John", 52));
        return listStudents;

    }


    @Test
    public void ClassicForLoop() {
            List list  = ListOfNames();

        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }


    @Test
    public void TheIteratorMethod_withList() {

        Iterator<String> list = ListOfNames().iterator();
        while(list.hasNext()){
            System.out.println(list.next());
        }
    }

    @Test
    public void TheIteratorMethod_withSet() {

       Iterator<Integer> numbers = getNumbers().iterator();
       while(numbers.hasNext()){
           System.out.println(numbers.next());
       }
    }

    @Test
    public void TheIteratorMethod_withMap() {

      Iterator<Integer> list = getGrades().keySet().iterator();
      while(list.hasNext()){
          var key = list.next();
          var value = getGrades().get(key);
          System.out.println(key + " --- " + value);
      }

        for (Integer key : getGrades().keySet()) {
            var value = getGrades().get(key);
            System.out.println(key + "-----> "+ value);

        }

    }

    @Test
    public void TheIteratorMethod_withLambdaExpression() {

        getGrades().forEach((key,value) ->
                System.out.println(key+ " ---- "+ value)
        );

        getNumbers().forEach(number ->
                System.out.println("number : " + number)
        );

        ListOfNames().forEach(name ->
                System.out.println(name));

    }



    @Test
    public void LambdaExpressionFromStudentClass() {

        List<B02_Student> listGoodGrade = new ArrayList<>();
        for (B02_Student student: getListOfStudents()) {
            if(student.getScore()>70){
                listGoodGrade.add(student);
            }
        }
        for (B02_Student student: listGoodGrade) {
            System.out.println(student.getName() + " -- " + student.getScore());
        }

    }


    @Test
    public void LambdaExpressionFromStudentClass2() {

        List<B02_Student> collect = getListOfStudents().stream().
                                    filter(s -> s.getScore() > 70).collect(Collectors.toList());

      collect.stream().forEach(System.out::println);
      collect.forEach(System.out::println);

    }

    @Test
    public void calculateAvarageOfStudent() {

       // first way
        var sum = 0.0;
        for (B02_Student student: getListOfStudents()) {
            sum = sum + student.getScore();
        }
        var average = sum/getListOfStudents().size();
        System.out.println("Average from loop : " + average);


        // second way for stream
        double asDouble = getListOfStudents().stream().mapToInt(s -> s.getScore()).average().getAsDouble();
        System.out.println("Average is from stream :" + asDouble);

    }


    @Test
    public void sortAndLimitOfStudent() {

//Command alt V
        List<B02_Student> top3student = getListOfStudents().stream()
                .filter(s -> s.getScore() > 70)
                .sorted()
                .limit(3)
                .collect(Collectors.toList());


       top3student.forEach(System.out::println);

      // -------------------------
        getListOfStudents().stream()
                .sorted()
                .parallel()
                .filter(s -> s.getScore() >= 70)
                .forEach(System.out::println);
    }

    @Test
    public void sortAndLimitOfStudent2() {

        getListOfStudents().stream()
                .sorted()
                .filter(s -> s.getScore() >= 60)
                .forEach(System.out::println);

        getListOfStudents().stream()
                .filter(s->s.getScore() >= 50)
                .map(s->s.getName())
                .sorted()
                .forEach(name -> System.out.println(name));
    }




}
