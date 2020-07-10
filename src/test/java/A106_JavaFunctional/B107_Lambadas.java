package A106_JavaFunctional;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.function.BiFunction;
import java.util.function.Function;

public class B107_Lambadas {

    @Test
    public void Test1(){

        Function<String, String> upperCaseName = value->{
            if(value.isBlank()){
                System.out.println("It is blank.");
            }
            return value.toUpperCase();
        };
        upperCaseName.apply("");
    }



    @Test
    public void Test2(){

        BiFunction<String,Integer, String> upperCaseName = (name,age)->{

            if(name.contains("java")){
                System.out.println("It is succesfully found java");
            }
            if(age<12){
                System.out.println("Age is less than 12");
            }
            return "name "+ name + " age " + age;
        };

        upperCaseName.apply("java computer language", 11);
    }




}
