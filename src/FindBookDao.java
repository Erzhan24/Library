import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FindBookDao {

        public static boolean findBook(String name) {
            boolean status = false;
            try {
                Connection con = DB.getConnection();
                PreparedStatement ps = con.prepareStatement("select * from books where name=?");
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                status = rs.next();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            return status;
        }}