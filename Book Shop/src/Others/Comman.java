package Others;

import bookshop.SqlConnection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;

public class Comman {

    public static void saveImage(ImageIcon image) {

    }

    public static ImageIcon getImage(String name) {
        ImageIcon image = new ImageIcon("path");

        return image;
    }

    public static int getNextPK(String table, String colomn) throws Exception {
        String sql = "SELECT MAX(" + colomn + ") FROM " + table;
        ResultSet rs = SqlConnection.getData(sql);
        if (rs.first()) {
            return rs.getInt(1) + 1;
        } else {
            return 1;
        }
    }

    public static String getToday() {
        return new SimpleDateFormat("yyyy/MMM/dd").format(new Date());
    }

    public static String getNow() {
        return new SimpleDateFormat("hh:mm:ss a").format(new Date());
    }

}
