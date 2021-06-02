import java.sql.Connection;
import java.sql.DriverManager;
public class connectDB {
    public static void main(String[] args) {
        connectDB obj_connect= new connectDB();
        System.out.println(obj_connect.getConnection());
    }

    public Connection getConnection()
    {
    Connection connection = null;
        String host="localhost";
        String port="5432";
        String db_name="postgres";
        String username="postgres";
        String password="bengrace8";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
            if (connection != null) {
                System.out.println("Connection OK");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
