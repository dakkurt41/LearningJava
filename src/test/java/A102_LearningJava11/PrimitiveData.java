package A102_LearningJava11;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class PrimitiveData {

    @Test
    public void PrimitiveDataType(){
        int  result = 12 + 14 ;
        String answer = "The answer is "+ result;
        System.out.println(answer);

        System.out.println("From int  to string ");
        int value1 = 45;
        String fromIntValue = Integer.toString(value1);
        System.out.println(fromIntValue);

        System.out.println("convert from boolean to string");
        boolean a = true;
        String b = Boolean.toString(a);
        System.out.println(b);

        System.out.println("from long to string");
        long long1 = 56_781_345;
        String long2 = Long.toString(long1);
        System.out.println(long2);

    }


    @Test
    @DisplayName("A user I login to Amaozon,com ")
    public void FormatDataType(){
        double a = 56_781_345.34;
        NumberFormat b = NumberFormat.getInstance();
        System.out.println(b.format(a));

        System.out.println("format double to integer");
        NumberFormat c = NumberFormat.getIntegerInstance();
        System.out.println(c.format(a));

        b.setGroupingUsed(false);
        System.out.println(b.format(a));

        b.setGroupingUsed(true);
        System.out.println(b.format(a));

       Locale locale  = Locale.getDefault();
       NumberFormat d = NumberFormat.getNumberInstance(locale);
       System.out.println("Locale --> " + d.format(a));

    }


    @Test
    @DisplayName("Compare string")
    public void CompareString(){
        String s1 = "Hello!";
        var s2 = "Hello!";
        System.out.println(s2);

        if(s1==s2){
            System.out.println("It is true");
        }

        String a1 = new String("True");
        String a2 = new String("True");
        if(a1.equalsIgnoreCase(a2)){
            System.out.println("It is false");
        }

    }

    @Test
    public void ParseString(){
        var s = "Welcome to California!";
        System.out.println("length of string : "+ s.length());

        var position = s.indexOf("California");
        System.out.println("Index of CA " + position);

        var sub = s.substring(11);
        System.out.println("substring " + sub);

        var subTrim = "Welcome       ";
        System.out.println(subTrim.length());
        System.out.println("Trim version " + subTrim.trim().length());


    }





}
