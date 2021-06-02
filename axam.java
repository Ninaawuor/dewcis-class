package examination;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class axam {
    private JButton savebutton;
    private JPanel panel1 ;
    private JButton readButton;
    private JTextField studentid;
    private JTextField coursetitle;
    private JTextField studentname;
    private JTextField grade;


    public axam() {
        savebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
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
                        String querry="insert into midsemester values ('"+studentid+"','"+studentname+"''"+coursetitle+"''"+grade+"')";
                        Statement statement=connection.createStatement();
                        int x =statement.executeUpdate(querry);
                        if (x == 0) {
                            JOptionPane.showMessageDialog(savebutton,"record exists");
                        }
                        else{
                            JOptionPane.showMessageDialog(savebutton,"added sucessfully");
                        }
                    }
                } catch (Exception e1){
                    e1.printStackTrace();
                }

            }
        });
        savebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("mid");
        frame.setContentPane(new axam().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


