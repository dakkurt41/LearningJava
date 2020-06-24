package A103_JDBC;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

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
    public void CreateSqlTest(){

        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = customerDAO.findById(100);
            System.out.println(customer.getFirstName() + " " + customer.getLastName());
            customerDAO.create(customer);
            System.out.println("Database created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void UpdateSqlTest(){

        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = customerDAO.findById(1000);
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getEmail());
            customer.setFirstName("Tavsan");
            customer.setLastName("Hanim");
            customer.setEmail("tavsanhanim@wh.gov");
            customer = customerDAO.update(customer);
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void DeleteSqlTest(){

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
            Customer dbcustomer = customerDAO.create(customer);
            System.out.println("Create value : "+ dbcustomer);
            dbcustomer = customerDAO.findById(dbcustomer.getId());
            System.out.println("Get by id value : " + dbcustomer);

            dbcustomer.setFirstName("Tavsan");
            dbcustomer = customerDAO.update(dbcustomer);
            System.out.println("Update value : " + dbcustomer);

            customerDAO.delete(dbcustomer.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void OrderLineTest(){

        try{
            Connection connection = dcm.getConnection();
            OrderDAO orderDAO = new OrderDAO(connection);
            Order order = orderDAO.findById(1002);
            System.out.println(order);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }



    @Test
    public void LimitingByOrderTest(){

        try{
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            customerDAO.findAllSorted(20).forEach(System.out :: println);


        }catch(SQLException e){
            e.printStackTrace();
        }
    }




    @Test
    public void SelectFromDatabase(){

        try{
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
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



}
