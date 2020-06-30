package A106_JavaFunctional;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

public class B102_Function {


    static int increment(int number){
        return number+1;
    }
    static int incrementThenMultiple(int number, int number2){
        return (number+1)*number2;
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number +1;
    static Function<Integer,Integer> multipleByTen = a -> a*10;
    BiFunction<Integer,Integer, Integer> addThenMultiply = (x,y)-> (x+1)*y;

    @Test
    public void Test1(){
        int a = increment(0);
        System.out.println(a);

        System.out.println("------------------------------------");
        Integer increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        Integer multiple = multipleByTen.apply(increment2);
        System.out.println(multiple);

        System.out.println("------------------------------------");
        Function<Integer, Integer> chainFunction = incrementByOneFunction.andThen(multipleByTen);
        Integer result = chainFunction.apply(5);
        System.out.println(result);

        System.out.println("------------------------------------");
        Integer result2 = addThenMultiply.apply(4, 100);
        System.out.println(result2);

    }
}
