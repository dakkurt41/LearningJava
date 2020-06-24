package A102_LearningJava11;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClothingMainClass {


    @Test
    public void Test1() {
        var item = new ClothingItems();
        item.setType("Tshirt");
        item.setSize(ClothingSize.M);
        item.setPrice(19.99);
        item.setQuantity(3);

        displayItemDetails(item);

    }

    private void displayItemDetails(ClothingItems item) {
        var totalPrice = item.getPrice() * item.getQuantity();
        var formatter = NumberFormat.getCurrencyInstance();
        var output = String.format("Your %s %s order will cost %s ",
                item.getSize(),
                item.getType(),
                formatter.format(totalPrice));
        System.out.println(output);
    }


    @Test
    public void Test2() {
        var item = new ClothingItems("Tshirt", ClothingSize.M, 20.00, 5);

        displayItemDetails(item);
    }


    @Test
    public void Test3() {
        var item = new ClothingItems(ClothingItems.SHIRT, ClothingSize.L, 20.00, 4);

        displayItemDetails(item);

    }

    @Test
    public void Test4() {
        var item = new Shirt(ClothingSize.L, 20.00, 4);
        displayItemDetails(item);
    }

    @Test
    public void Test5() {
        String[] colors = new String[3];
        colors[0] = "blue";
        colors[1] = "yellow";
        colors[2] = "red";

        for (int i = 0; i < colors.length; i++) {
            System.out.println(colors[i]);
        }

        ClothingItems[] items = {
                new Shirt(ClothingSize.L, 20.00, 4),
                new Hat(ClothingSize.M, 20.00, 5)
        };

        for (ClothingItems item : items) {
            displayItemDetails(item);
        }

        List<String> colors2 = new ArrayList<>();
        colors2.add("Red");
        colors2.add("Yellow");
        colors2.add("White");

        for (int i = 0; i <colors2.size() ; i++) {
            System.out.println((i+1)+ " : " + colors2.get(i));
        }


        List<ClothingItems> items2 = new ArrayList<>();
        items2.add( new Shirt(ClothingSize.L, 20.00, 4));
        items2.add( new Hat(ClothingSize.L, 19.00, 5));

        for (ClothingItems item: items2) {
            displayItemDetails(item);
        }


    }

    @Test
    public void Test6() {
        var item = new Shirt(ClothingSize.L, 20.00, 4);

        Map<String, ClothingItems> items = new HashMap<>();
        items.put("Shirt", new Shirt(ClothingSize.L, 20.00, 4));
        items.put("Hat", new Shirt(ClothingSize.M, 19.00, 3));

       var first = items.get("Shirt");
       displayItemDetails(first);

       var second = items.get("Hat");
       displayItemDetails(second);
       
       var keys = items.keySet();
        for (String key:keys) {
            var a = items.get(key);
            displayItemDetails(a);
        }

    }


}
