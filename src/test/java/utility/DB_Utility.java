package utility;

import java.sql.*;

public class DB_Utility {

    static Connection conn ; // make it static field so we can reuse in every methods we write
    static Statement stmnt;
    static ResultSet rs ;

    public static void createConnection(){

        String connectionStr = "jdbc:oracle:thin:@3.85.175.229:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        try {
            conn = DriverManager.getConnection(connectionStr,username,password) ;
            System.out.println("CONNECTION SUCCESSFUL !! ");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED !!! " +  e.getMessage() );
        }

    }
    // Create a method called runQuery that accept a SQL Query
    // and return ResultSet Object
    public static ResultSet runQuery(String query){

        ResultSet rs  = null;
        // reusing the connection built from previous method
        try {
            Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmnt.executeQuery(query) ;

        } catch (SQLException e) {
            System.out.println("Error while getting resultset " + e.getMessage());
        }

        return rs ;

    }
    // create a method to clean up all the connection statemnet and resultset
    public static void destroy() {
        try {
            rs.close();
            stmnt.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {

        createConnection();

        ResultSet rs =  runQuery("SELECT * FROM REGIONS");

        // print out second column first row
        rs.next();
        System.out.println(" rs.getString(2) = " + rs.getString(2)   );


    }


}