package day3;

import utility.DB_Utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilityPractice {

    public static void main(String[] args) throws SQLException {

        //test out all the methods you have created so far for practice
        DB_Utility.createConnection();

        ResultSet jobRs = DB_Utility.runQuery("SELECT * FROM JOBS");

        /**
         * Get the row count of the ResultSet
         * move the pointer to the last row and get the row number
         */

        int rowCount = DB_Utility.getRowCount();
        System.out.println("rowCount = " + rowCount);

        int colCount = DB_Utility.getColumnCount();
        System.out.println("colCount = " + colCount);


        DB_Utility.destroy();
    }

}
