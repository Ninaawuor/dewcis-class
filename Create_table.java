import java.sql.Connection;
import java.sql.Statement;
public class Create_table {


    /**
     * @param args
     */
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        connectDB obj_connect=new connectDB ();


        connection=obj_connect.getConnection();
        try {
            String query="create table midsemester(myname varchar(200),unit varchar(200))";
            statement= connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("finished");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}

