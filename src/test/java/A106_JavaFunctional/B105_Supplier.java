package A106_JavaFunctional;

import org.junit.Test;

import java.util.List;
import java.util.function.Supplier;

public class B105_Supplier {

    static String getDbConnectionUrl() {
        return "jdbc://localhosr:5432/users";
    }

    static Supplier<String> getDBConnectionUrlSupplier = ()
            -> "jdbc://localhosr:5432/users";


    static Supplier<List<String>> getDBConnectionUrlSupplierList = ()
            -> List.of(
            "jdbc://localhosr:5432/users",
            "jdbc://localhosr:5432/customer"
    );


    @Test
    public void Test1() {
        String dbConnectionUrl = getDbConnectionUrl();
        System.out.println(dbConnectionUrl);
    }


    @Test
    public void Test2() {
        String s = getDBConnectionUrlSupplier.get();
        System.out.println(s);

    }


    @Test
    public void Test3() {
        List<String> strings = getDBConnectionUrlSupplierList.get();
        System.out.println(strings);
        System.out.println(strings.get(1));
    }


}
