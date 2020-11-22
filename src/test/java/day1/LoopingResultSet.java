package day1;

import java.sql.*;

public class LoopingResultSet {
    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@3.85.175.229:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr, username, password);

        Statement stmnt = conn.createStatement();

        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");

        //rs.next() method will return boolean value
        // if there is next row -->> return true and move the pointer to next row
        // if there is no next row -->> false

        while( rs.next()) {
            System.out.println("Region_ID " + rs.getString("REGION_ID"));
            System.out.println("Region_Name " + rs.getString("REGION_NAME"));

        }

        //Iterate over all Countries
        rs = stmnt.executeQuery("SELECT * FROM COUNTRIES");
        //rs.next();
        //System.out.println(rs.getString(1));

        while(rs.next() ){
            System.out.println(rs.getString(1) + " "+
                    rs.getString(2)+" "+
                    rs.getString(3));
        }

        rs.previous();

    }
}