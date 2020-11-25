package day2;

import java.sql.*;

public class GettingMoreInfoAboutResultSetObject {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@3.85.175.229:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM EMPLOYEES") ;

        // MetaData - data about the data
        // ResultSetMetaData -  data about ReslutSet object that contain our resulting rows and columns
        // for example column names, column counts .. and more
        // This is how we get them ResultSetMetaData object

        //ResultSetMetData itself does not contains any row data
        //it only has information about the columns
        ResultSetMetaData rsmd = rs.getMetaData();
        //we only need two methods from this to get column count and column name | label

        int colCount = rsmd.getColumnCount();
        System.out.println("colCount = "+ colCount);
        //this is how we get column label | name using index
        // get first column name
        System.out.println("First Column Name is "+ rsmd.getColumnLabel(1));
        System.out.println("Second Column Name is "+ rsmd.getColumnLabel(2));

        //now print out all column names :

        for(int colNum = 1; colNum <= colCount ;colNum++){
            System.out.println("Column name " + rsmd.getColumnLabel(colNum));
        }

        rs.close();
        stmnt.close();
        conn.close();






    }
}
