package A104_JavaEssential_Objects_API;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class ExpectionHandling {

    @Test
    public void StringToCharArray(){

        String welcome = "Welcome to California!";
        char[] array = welcome.toCharArray();
        char lastChar = array[array.length-1];
        System.out.println("The last char is : "+ lastChar);
    }


    @Test
    public void StringToCharArrayForLoop(){

        String welcome = "Welcome to California!";
        char[] array = welcome.toCharArray();

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        for (char element: array) {
            System.out.println(element);
        }
    }



    @Test
    public void TryAndCatchTest(){

        try {
            String welcome = "Welcome to California!";
            char[] array = welcome.toCharArray();
            char lastChar = array[array.length-1];
            System.out.println("The last char is : "+ lastChar);

            String nothing = null;
            System.out.println(nothing.length());

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("The failure messsage is : " + e.getMessage());
            return; // when put return here, the last code will not be executed. line 49
        } catch (NullPointerException e) {
        e.printStackTrace();
        System.out.println("The failure messsage is : " + e.getMessage());
        return; // when put return here, the last code will not be executed. line 49
    }
        System.out.println("Code succesfully passed");
    }


    @Test
    public void StringToCharArray1(){

        String welcome = "Welcome to California!";
        char[] array = welcome.toCharArray();
        char lastChar = array[array.length-1];
        System.out.println("The last char is : "+ lastChar);
    }


    @Test
    public void StringToCharArrayForLoop1(){

        String welcome = "Welcome to California!";
        char[] array = welcome.toCharArray();
        char lastChar = array[array.length-1];
        System.out.println("The last char is : "+ lastChar);
    }
}
