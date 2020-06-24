package A102_LearningJava11;

import org.junit.Test;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Calculator {

    public static void main2(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter first value : ");
        var number1 = scanner.nextDouble();
        System.out.print("Enter second value : ");
        var number2 = scanner.nextDouble();
        var result = number1 + number2;
        System.out.println("The sum is : " + result);

    }

    public static void main(String[] args) {
        var now = LocalDateTime.now();
        var month = now.getMonthValue();
        var message = "";
        if (month < 1 || month > 12) {
            message = " invalid month ";
        } else {
            message = "You entered " + month;
        }
        System.out.println(message);

    }


    @Test
    public void switchCases() {

        var now = LocalDateTime.now();
        var month = now.getMonthValue();

        switch (month) {
            case 1:
                System.out.println("The month is January");
                break;
            case 2:
                System.out.println("The month is February");
                break;
            case 3:
                System.out.println("The month is March");
                break;
            case 4:
                System.out.println("The month is April");
                break;
            case 5:
                System.out.println("The month is May");
                break;
            case 6:
                System.out.println("The month is June");
                break;
            default:
                System.out.println("Invalid");

        }

    }

    @Test
    public void loopingBlock(){
        String[] months = {"January", "February", "March", "April"};

        for (int i = 0; i < months.length; i++) {
            System.out.println((i+1) + " : " + months[i]);
        }

        for (String month : months) {
            System.out.println(month);
        }

        var whileCounter = 0;
        while (whileCounter<months.length){
            System.out.println(months[whileCounter]);
            whileCounter++;
        }

        var result = addValues(1,2,3,4,5);
        System.out.println(result);
    }

    public static double addValues(int...values){
        int result = 0;
        for (var value : values) {
            result += value;
        }
        return result;
    }


    @Test
    public void TryAndCatchTest(){

        try {
            var a = "Hello";
            var array = a.split("");
            for (var k:array ) {
                System.out.println(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        String word = "";

        try {
            var word1 = word.substring(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("The messages is : "+ e.getMessage());
        }

    }


    @Test
    public void readFileTxtTest() throws IOException {
        var file_1 = new File("src/hello.txt");
        System.out.println(file_1.exists());

        try {
            FileReader reader = new FileReader(file_1);
            BufferedReader br = new BufferedReader(reader);
            var text = br.readLine();
            System.out.println(text.toUpperCase());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





}
