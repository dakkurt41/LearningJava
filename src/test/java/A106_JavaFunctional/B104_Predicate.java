package A106_JavaFunctional;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.function.Predicate;

public class B104_Predicate {

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() ==11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() ==11;

    static Predicate<String> containsPhoneNumber = phoneNumber ->
            phoneNumber.contains("3");

    @Test
    public void Test1(){
        System.out.println("Without predicated ");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("09000000000"));
        System.out.println(isPhoneNumberValid("070000"));


        System.out.println("----------------------------------");
        System.out.println("With predicated ");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0700"));

        System.out.println("----------------------------------");
        System.out.println("With predicated contains  ");
        System.out.println(containsPhoneNumber.test("0700"));
        System.out.println(containsPhoneNumber.test("0703"));

        System.out.println("----------------------------------");
        System.out.println("With predicated together  ");
        System.out.println(isPhoneNumberValidPredicate.and(containsPhoneNumber).test("0703"));
        System.out.println(isPhoneNumberValidPredicate.and(containsPhoneNumber).test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.and(containsPhoneNumber).test("07030000000"));


        System.out.println(isPhoneNumberValidPredicate.or(containsPhoneNumber).test("07030000000"));
        System.out.println(isPhoneNumberValidPredicate.or(containsPhoneNumber).test("07030000000"));



    }
}
