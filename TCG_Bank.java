import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TCG_Bank {
    static JFrame frame;
    static JLabel user_name,user_pass,output_msg,image_icon;
    static JTextField name_data,pass_data;
    static JButton user_login,user_register,forgot_pass;

   static void home_bank(){
           ImageIcon image = new ImageIcon("image/bank_icon.png");

           frame=new JFrame("TCG Banking");
           frame.setBounds(150, 100,400,450);
           image_icon=new JLabel(image);
           image_icon.setBounds(150,10,160,150);
           user_name=new JLabel("Username");
           user_pass=new JLabel("Password");
           name_data=new JTextField();
           pass_data=new JPasswordField();
           output_msg=new JLabel();
           user_name.setBounds(50, 200, 100, 30);
           name_data.setBounds(130, 200, 200, 30);
           user_pass.setBounds(50, 240, 100, 30);
           pass_data.setBounds(130, 240, 200, 30);
           user_login=new JButton("Login");
           user_login.setBounds(130, 300, 100, 30);
           user_register=new JButton("Register");
           user_register.setBounds(230, 300, 100, 30);


                  forgot_pass=new JButton("Forgot Password");
       forgot_pass.setBounds(130, 350, 200, 30);

              output_msg.setBounds(150, 380, 100, 30);
           frame.add(user_name);frame.add(user_pass);
           frame.add(user_login);frame.add(user_register);frame.add(image_icon);
           frame.add(name_data);frame.add(pass_data);frame.add(output_msg);frame.add(forgot_pass);
           frame.setLayout(null);
           frame.setVisible(true);



       ActionListener forgot_pass_data=new ActionListener() {
           public void actionPerformed(ActionEvent e){
               frame.setVisible(false);
               Forgot_pass fp=new Forgot_pass();
               fp.pass_page();
           }
       };
       forgot_pass.addActionListener(forgot_pass_data);

           ActionListener user_lg=new ActionListener() {
               public void actionPerformed(ActionEvent e){
                   String name_user=name_data.getText();
                   String pass_user=pass_data.getText();
                   login_data(name_user,pass_user);
               }
           };
           user_login.addActionListener(user_lg);
       ActionListener user_reg=new ActionListener() {
           public void actionPerformed(ActionEvent e){
               frame.setVisible(false);
              User_Register user_rg=new User_Register();
              user_rg.reg_home();

           }
       };
       user_register.addActionListener(user_reg);
   }

    public static void login_data(String name,String pass)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TCG_Bank",
                    "root", "12345");

            String fetch_rec="Select * from customer_login_data where c_mail='"+name+"' && c_pass='"+pass+"'";

            Statement sm=con.createStatement();
            ResultSet rs=sm.executeQuery(fetch_rec);
            int count=0,user_id;
            String name_fetch,pass_fetch;
            while(rs.next())
            {
                user_id=rs.getInt("customer_id");
                name_fetch=rs.getString("c_mail");
                pass_fetch=rs.getString("c_pass");
                if(name.compareTo(name_fetch)==0 && pass.compareTo(pass_fetch)==0)
                {
                    count++;
                }

                if(count==0)
                {
                    name_data.setText("");
                    pass_data.setText("");
                    output_msg.setText("Wrong Details");

                }
                else{
                    frame.setVisible(false);
                    UserDesh ud=new UserDesh();
                    ud.ibanking(user_id);

                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
            home_bank();
    }
}
