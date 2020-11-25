package day2;

import java.sql.*;

public class Review {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@3.85.175.229:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM JOBS");

        //I wanna read the first row
        rs.next();
        System.out.println("First column value in Jobs " + rs.getString(1));
        System.out.println("Second column value in Jobs " + rs.getString(2));

        // move to row number 7 and get columns values
        rs.absolute(7);
        System.out.println("First column value in Jobs in row 7 " + rs.getString(1));
        System.out.println("Second column value in Jobs in row 7 " + rs.getString(2));

        rs.last();
        System.out.println("First column value in Jobs in last row " + rs.getString(1));
        System.out.println("Second column value in Jobs in last row " + rs.getString(2));

        rs.previous();
        System.out.println("First column value in Jobs in 2nd row from the last " + rs.getString(1));
        System.out.println("Second column value in Jobs in 2nd row from the last " + rs.getString(2));

        System.out.println(" \n================ Loop from first row till last row print JOB_ID ================ ");
        rs.beforeFirst();

        while (rs.next()){
            System.out.println("Loop First Column " + rs.getString("JOB_ID"));
        }

        System.out.println(" \n================= Loop from first row till last row print JOB_ID =============== ");
        // WE ARE CURRENTLY AT AFTER LAST LOCATION
        // if you want yo make sure and explicitly say so
        //we can do below

        rs.afterLast();
        while (rs.previous()){
            System.out.println(" MIN SALARY COLUMN AS NUMBER $ " + rs.getDouble("MIN_SALARY") );
        }


    }
}
