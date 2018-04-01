
import bookshop.SqlConnection;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Scanner;


public class test {

    public static void main(String[] args) throws IOException {
        
        try {
            ResultSet rs = SqlConnection.getData("SELECT * FROM user");
            while (rs.next())
            {
                String name = rs.getString("username");
                
                System.out.println(name);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        }
        
        
       
    }

