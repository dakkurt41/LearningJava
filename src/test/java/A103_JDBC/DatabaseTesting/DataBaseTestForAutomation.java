package A103_JDBC.DatabaseTesting;

import A103_JDBC.Customer;
import A103_JDBC.DatabaseConnectionManager;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseTestForAutomation {


    public static final DatabaseConnectionManager dcm = new DatabaseConnectionManager(
            "localhost",
            "hplussport",
            "postgres",
            "password");
    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    private static final String INSERT = "INSERT INTO customer (first_name, last_name," +
            "email, phone, address, city, state, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT = "SELECT customer_id, first_name, last_name, email, phone, address, city, state, zipcode " +
            "FROM customer WHERE customer_id >= 10010";


    @Test
    public void SelectFromDatabase(){

        try{
            connection = dcm.getConnection();
            statement = connection.createStatement();
            String query = "SELECT customer_id, first_name, last_name, email, phone, address, city, state, zipcode " +
                    "FROM customer WHERE customer_id >= 10010";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                System.out.println(rs.getString(1));    //First Column
                System.out.println(rs.getString(2));    //Second Column
                System.out.println(rs.getString(3));    //Third Column
                System.out.println(rs.getString(4));    //Fourth Column
            }


        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    @Test
    public void InsertIntoDatabase(){

        try{
            connection = dcm.getConnection();
            statement = connection.createStatement();
            String query = "INSERT INTO customer (first_name, last_name ) VALUES ('Elma', 'Armut')";
            ResultSet rs1 = statement.executeQuery(query);

            String query2 = "Select * from customer where first_name = 'Elma'";
            ResultSet rs = statement.executeQuery(query2);
            while(rs.next())
            {
                System.out.println(rs.getString(1));    //First Column
                System.out.println(rs.getString(2));    //Second Column
            }


        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    @Test
    public void databaseConncetionCheck(){

        try  {
            connection = dcm.getConnection();
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void SelectExample(){

        System.out.println("JDBC Connection Testing ~");

        List result = new ArrayList<>();

        try  {

            connection = dcm.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("customer_id");
                String name = resultSet.getString("first_name");
                String last= resultSet.getString("last_name");
                String email = resultSet.getString("email");

                Customer obj = new Customer();
                obj.setId(id);
                obj.setFirstName(name);
                obj.setLastName(last);
                obj.setEmail(email);
                result.add(obj);

            }
            result.forEach(x -> System.out.println(x));

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }





}
