package A106_JavaFunctional.B107_Streams;

import org.junit.Test;

import java.util.Optional;

public class B102_Optionals {


    @Test
    public void Test1(){
        Object optionalValue = Optional.ofNullable(null)
                .orElseGet(() -> "Default Value");
        System.out.println(optionalValue);

        Object optionalValue2 = Optional.ofNullable("Hello")
                .orElseGet(() -> "Default Value");
        System.out.println(optionalValue);
    }



    @Test
    public void Test2(){
        Object optionalValue2 = Optional.ofNullable("John Carter")
                .orElseThrow(() -> new IllegalStateException("Exception"));
        System.out.println(optionalValue2);

      Optional.ofNullable("Abc@gmail.com")
                .ifPresent(email -> System.out.println("Sending the email to "+ email));

      Optional.ofNullable(null)
              .ifPresentOrElse(email -> System.out.println("Printing the email "+ email),
                      () -> {
                          System.out.println("Cannot sending the email.");
                      });

    }
}
