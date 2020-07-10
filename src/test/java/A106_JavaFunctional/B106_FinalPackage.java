package A106_JavaFunctional;

import org.junit.Test;

import java.util.function.Consumer;

public class B106_FinalPackage {


    static  void hello(String firstName, String lastName, Consumer<String> callback){
        System.out.println(firstName);
        if(lastName != null){
            System.out.println(lastName);
        }else{
            callback.accept(firstName);
        }
    }


    static  void hello2(String firstName, String lastName, Runnable callback){
        System.out.println(firstName);
        if(lastName != null){
            System.out.println(lastName);
        }else{
            callback.run();
        }
    }
    @Test
    public void Test1(){
        hello("John", null, value -> {
            System.out.println("The lastname is not provided for "+ value );
        });


        hello2("John", null, ()->{
            System.out.println("The lastname is not provided for " );
        });
    }



}

