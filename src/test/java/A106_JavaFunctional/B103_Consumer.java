package A106_JavaFunctional;

import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class B103_Consumer {

    static class Customer {
        private final String name;
        private final String phone;

        public Customer(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }

    static void greetCustomer (Customer customer){
        System.out.println("Hello, "+ customer.name +
                ". Thank for registering phone number : "+ customer.phone);
    }

    static Consumer<Customer> customerConsumer = customer ->
            System.out.println("Hello, "+ customer.name +
                    ". Thank for registering phone number : "+ customer.phone);


    static BiConsumer<Customer,Boolean> bicustomerConsumer = (customer, showPhone) ->
            System.out.println("Hello, "+ customer.name +
                    ". Thank for registering phone number : "+ (showPhone ? customer.phone : "*********") );

    @Test
    public void Test1(){
        Customer customer = new Customer("John", "12345678");
        greetCustomer(customer);
    }


    @Test
    public void Test2(){
        Customer john = new Customer("John", "12345678");
        customerConsumer.accept(john);

    }

    @Test
    public void Test3(){
        Customer john = new Customer("John", "12345678");
        bicustomerConsumer.accept(john,false);

    }
}
