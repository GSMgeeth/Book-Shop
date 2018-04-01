package bookshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlConnection {

    private static Connection con = null;

    public static Connection getSqlConnection() throws Exception {
        if (con == null) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bkshop", "root", "");
        }
        return con;
    }

    public static void updateDB(String q,Injecterble inject) throws Exception {
        System.out.println(q);
        PreparedStatement ps = SqlConnection.getSqlConnection().prepareStatement(q);
        ps=inject.inject(ps);
        ps.execute();
    }

    public static ResultSet getData(String q) throws Exception {
        System.out.println(q);
        return SqlConnection.getSqlConnection().prepareStatement(q).executeQuery();
    }

    public static ResultSet getData(String q, Injecterble inject) throws Exception {
        System.out.println(q);
        PreparedStatement ps = SqlConnection.getSqlConnection().prepareStatement(q);
        ps=inject.inject(ps);
        return ps.executeQuery();
    }
}



