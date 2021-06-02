

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class mid {
    private JButton save;
    private JButton read;
    private JTextField studentid;
    private JTextField studentname;
    private JTextField coursetitle;
    private JTextField grade;
    private JPanel panel1;

    public mid() {
        String studentid,studentname,coursetitle,grade;
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String myname=name.getText();
             //   String unit=subject.getText();
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
                       String querry="insert into midsemester('"+studentid+"','"+studentname+"','"+coursetitle+"','"+grade+"')";
                        Statement statement=connection.createStatement();
                        int x =statement.executeUpdate(querry);
                        if (x == 0) {
                            JOptionPane.showMessageDialog(save,"record exists");
                        }
                        else{
                            JOptionPane.showMessageDialog(save,"added sucessfully");
                        }
                    }
                } catch (Exception e1){
                    e1.printStackTrace();
                }

            }
        });
    }
}
