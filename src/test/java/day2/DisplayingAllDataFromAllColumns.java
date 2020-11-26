package day2;

import utility.DB_Utility;

import java.sql.*;

public class DisplayingAllDataFromAllColumns {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();
        ResultSet rs = DB_Utility.runQuery("SELECT * FROM EMPLOYEES");



        //print out entire first row of employee table from above query
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        //print out column name in the beginning row, then print first row

        for( int colNum = 1; colNum <= columnCount; colNum++){
            System.out.print(rsmd.getColumnLabel(colNum) + "\t" );
        }
        System.out.println("===========================");
        rs.next() ;

        //this whole loop is getting one row of data
        for( int colNum = 1; colNum <= columnCount; colNum++){
            System.out.print(rs.getString(colNum) + "\t");
        }

        // now how do you get all the  row if you know how to get one row???
        // i want to go from the first row to last row and print all columns
        rs.beforeFirst();

        while (rs.next()) {

            for (int colNum = 1; colNum <= columnCount; colNum++) {
                System.out.print(rs.getString(colNum) + "\t");
            }
            System.out.println();
        }

        DB_Utility.destroy();

    }
}
