package A106_JavaFunctional.B108_CombinatorPattern;

import org.junit.Test;

import java.time.LocalDate;

import static A106_JavaFunctional.B108_CombinatorPattern.CustomerRegistrationValidator.*;

public class CustomerTest {

    @Test
    public void Test1(){

        Customer customer = new Customer(
                "Mira",
                "mira@gmail.com",
                "+087654323456",
                LocalDate.of(2000,1,1)
        );

        CustomerValidatorService customerValidatorService = new CustomerValidatorService();
        boolean result = customerValidatorService.isValid(customer);
        System.out.println(result);

        ValidationResult result2 = isEmailValid()
                .and(isPhoneValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result2);

        if(result2 != ValidationResult.SUCCESS){
            throw new IllegalStateException(result2.name());
        }
    }


}
