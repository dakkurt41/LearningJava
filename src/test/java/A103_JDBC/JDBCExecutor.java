package A103_JDBC;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor {

    public static final DatabaseConnectionManager dcm = new DatabaseConnectionManager(
            "localhost",
            "hplussport",
            "postgres",
            "password");


    @Test
    public void Test1(){
        System.out.println("Learning the JDBC with Java");
        try {
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select COUNT(*) from customer");

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void Test2(){

        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = new Customer();
            customer.setFirstName("Kazim");
            customer.setLastName("Karabekir");
            customer.setEmail("george.washington@wh.gov");
            customer.setPhone("(555) 555-6543");
            customer.setAddress("1234 Main St");
            customer.setCity("Sinan Tepesi");
            customer.setState("VA");
            customer.setZipCode("22121");

            customerDAO.create(customer);
            System.out.println("Database created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void Test3(){

        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = customerDAO.findById(1000);
            System.out.println(customer.getFirstName() + " " + customer.getLastName());
            customerDAO.create(customer);
            System.out.println("Database created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
