import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Properties;

public class Forgot_pass {
    static JFrame frame;
    static JLabel user_mail,image_icon,output_msg;
    static JTextField mail_data;
    static JButton pass_recover,user_home;
    static String sender="meghrajyadav.yadav20@gmail.com",
            subject="Password Recover",message="",receiver="";

    static void pass_page(){
        ImageIcon image = new ImageIcon("image/bank_icon.png");

        frame=new JFrame("TCG Banking");
        frame.setBounds(150, 100,400,450);
        image_icon=new JLabel(image);
        image_icon.setBounds(150,10,160,150);
        user_mail=new JLabel("User Mail ID:");
        mail_data=new JTextField();
        user_mail.setBounds(150, 220, 100, 30);
        mail_data.setBounds(110, 250, 200, 30);

        pass_recover=new JButton("Submit");
        pass_recover.setBounds(100, 300, 100, 30);

        user_home=new JButton("Login");
        user_home.setBounds(220, 300, 100, 30);

        output_msg=new JLabel("");
        output_msg.setBounds(150, 350, 200, 30);
        frame.add(user_mail);frame.add(mail_data);
        frame.add(image_icon);frame.add(pass_recover);frame.add(output_msg);frame.add(user_home);
        frame.setLayout(null);
        frame.setVisible(true);
        ActionListener pass_page=new ActionListener() {
            public void actionPerformed(ActionEvent e){
                receiver=mail_data.getText();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TCG_Bank",
                            "root", "12345");

                    String fetch_rec = "Select c_pass from customer_login_data where c_mail='" + receiver + "'";

                    Statement sm = con.createStatement();
                    ResultSet rs = sm.executeQuery(fetch_rec);
                    String user_pass;
                    while (rs.next()) {
                            user_pass=rs.getString("c_pass");
                            message="Your Bank Account Password is: "+user_pass;
                        Properties prop=new Properties();
                        prop.put("mail.smtp.port",587);
                        prop.put("mail.smtp.host","smtp.gmail.com");
                        prop.put("mail.smtp.auth","true");
                        prop.put("mail.smtp.starttls.enable","true");
                        String uname="meghrajyadav.yadav20";
                        String pass="yoyxjhbabzhddzqb";
                        Session session=Session.getInstance(prop,new Authenticator() {

                            protected PasswordAuthentication getPasswordAuthentication(){
                                return new PasswordAuthentication(uname, pass);
                            }
                        });
                        Message user_msg=new MimeMessage(session);
                        user_msg.setFrom(new InternetAddress(sender));
                        user_msg.setSubject(subject);
                        user_msg.setRecipient(Message.RecipientType.TO,new InternetAddress(receiver));
                        user_msg.setText(message);

                        Transport.send(user_msg);
                        output_msg.setText("Password Send Your Mail id!...");
                        mail_data.setText("");
                    }
                }
                catch (Exception ea)
                {
                    System.out.println(ea);
                }

            }
        };
        pass_recover.addActionListener(pass_page);
        ActionListener tcgbank=new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                TCG_Bank tc=new TCG_Bank();
                tc.home_bank();
            }
        };
        user_home.addActionListener(tcgbank);
    }



}
