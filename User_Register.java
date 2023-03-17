import java.util.*;
import javax.swing.*;
import javax.swing.text.StyledEditorKit.BoldAction;
import java.sql.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Properties;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class User_Register{
    static JLabel user_name,user_address,user_city,user_state,user_phone,user_email,label_top,user_pan,last_name,
            f_name,mother_name,ac_type,output_msg;
    static JTextField name,city,state,phone,mail,pan_number,user_last_name,user_fname,user_mother_name;
    static int get_last_id,get_last_meter_no;
    static JTextArea address;
    static JButton submit,Login;
    static String sender="meghrajyadav.yadav20@gmail.com",receiver="",
            subject="New Bank Account Registration",message="";
    static String mail_msg="";
    static int count_mail=0;
    public void reg_home()
    {
        Color cl=new Color(217,217,217);
        Color bt_color=new Color(21, 21, 21);
        JFrame frame=new JFrame("New User Register");
        frame.getContentPane().setBackground(cl);
        frame.setBounds(150, 100,800,550);
        label_top=new JLabel("New Customer Registration");
        label_top.setBounds(250, 50, 450, 30);
        label_top.setFont(new Font("Calibri", Font.BOLD, 25));

        user_name=new JLabel("First Name");last_name=new JLabel("Last Name");
        f_name=new JLabel("Father's Name");mother_name=new JLabel("Mothe's Name");
        user_address=new JLabel("Address");
        user_city=new JLabel("City");
        user_state=new JLabel("State");
        user_email=new JLabel("Email");
        user_phone=new JLabel("Phone");
        user_pan=new JLabel("PAN No.");ac_type=new JLabel("Account Type");
        output_msg=new JLabel();
        name=new JTextField();user_last_name=new JTextField();user_fname=new JTextField();
        user_mother_name=new JTextField();
        address=new JTextArea();
        city=new JTextField();
        state=new JTextField();
        phone=new JTextField();
        mail=new JTextField();
        pan_number=new JTextField();
       Login=new JButton("Login");
       Login.setBounds(10,10,100,30);
        Login.setBackground(bt_color);
        Login.setForeground(Color.WHITE);

        user_name.setBounds(50, 100, 100, 30);
        name.setBounds(160, 100, 150, 30);
        last_name.setBounds(350,100,150,30);
        user_last_name.setBounds(450,100,150,30);
        f_name.setBounds(50,140,100,30);
        user_fname.setBounds(160,140,150,30);
        mother_name.setBounds(350,140,150,30);
        user_mother_name.setBounds(450,140,150,30);


        user_address.setBounds(50, 180, 100, 30);
        address.setBounds(160, 180, 300, 30);

        user_city.setBounds(50, 220, 100, 30);
        city.setBounds(160, 220, 150, 30);

        user_state.setBounds(350, 220, 100, 30);
        state.setBounds(450, 220, 150, 30);

        user_email.setBounds(50, 260, 100, 30);
        mail.setBounds(160, 260, 150, 30);
        user_phone.setBounds(350, 260, 100, 30);
        phone.setBounds(450, 260, 150, 30);
        user_pan.setBounds(50,300,100,30);
        pan_number.setBounds(160,300,150,30);

        ac_type.setBounds(50,340,100,30);


        String Account_type[]={"Saving Account","Current Account"};
        JComboBox ac=new JComboBox(Account_type);
        ac.setBounds(160, 340,150,30);

        submit=new JButton("Register");
        submit.setBounds(160, 380, 120, 50);
        output_msg.setBounds(160,450,350,30);

        submit.setBackground(bt_color);
        submit.setForeground(Color.WHITE);

        frame.add(user_last_name);frame.add(last_name);
        frame.add(label_top);frame.add(user_name); frame.add(name);
        frame.add(user_fname);frame.add(f_name);frame.add(mother_name);frame.add(user_mother_name);
        frame.add(user_address);frame.add(address);frame.add(user_city);frame.add(city);
        frame.add(user_state);frame.add(state);
        frame.add(user_email); frame.add(mail);frame.add(user_phone);frame.add(phone);
        frame.add(user_pan);frame.add(pan_number);frame.add(submit);frame.add(ac_type);frame.add(ac);
        frame.add(output_msg);frame.add(Login);
        frame.setLayout(null);
        frame.setVisible(true);

        ActionListener user_reg=new ActionListener() {
            public void actionPerformed(ActionEvent e){

                String first_name,last_name,ft_name,mo_name,user_add,user_cty,user_state,user_phone,user_mail="",
                        user_pan,user_account_type;
                first_name=name.getText();
                last_name=user_last_name.getText();
                ft_name=user_fname.getText();
                mo_name=user_mother_name.getText();
                user_add=address.getText();
                user_cty=city.getText();
                user_state=state.getText();

                user_pan=pan_number.getText();
                user_account_type=(String)ac.getItemAt(ac.getSelectedIndex());
                String mail_regx="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
                if(mail.getText().matches(mail_regx))
                {
                    if(!phone.getText().matches("^[0-9]"))
                    {
                        phone.setText("Enter only Number");
                        phone.setForeground(Color.RED);
                    }
                    else
                    {
                        user_phone=phone.getText();
                        user_mail=mail.getText();
                        try{
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TCG_Bank",
                                    "root", "12345");
                            String fetch_rec="Select * from Customer_Data";
                            Statement sm=con.createStatement();
                            ResultSet rs=sm.executeQuery(fetch_rec);
                            int get_last_id=0;
                            String get_account_no="",fetch_acc="";
                            while(rs.next())
                            {
                                get_last_id=rs.getInt("customer_id");
                                get_account_no=rs.getString("user_account_no");
                            }
                            get_last_id+=1;
                            String first_digit="TCG";
                            if(get_last_id==1)
                            {

                                int last_digit=1000001;
                                get_account_no=first_digit+last_digit;
                            }
                            else
                            {
                                fetch_acc=get_account_no.substring(3);
                                int conver_acc=Integer.parseInt(fetch_acc);
                                conver_acc+=1;
                                get_account_no=first_digit+String.valueOf(conver_acc);

                            }


                            String fetch_rmail_id="Select * from Customer_Data where c_mail='"+user_mail+"'";
                            Statement s_mail=con.createStatement();
                            ResultSet r_mail=s_mail.executeQuery(fetch_rmail_id);
                            String check_mail;
                            while(r_mail.next())
                            {
                                check_mail=r_mail.getString("c_mail");
                                count_mail++;

                            }


                            if(count_mail==0) {

                                LocalDateTime myDateObj = LocalDateTime.now();
                                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                                String account_create_date = myDateObj.format(myFormatObj);

                                String insert_data = "Insert into Customer_Data value(" + get_last_id + ",'" + first_name + "','" + last_name + "','" + ft_name + "','" + mo_name + "','" + user_add + "','" + user_cty + "','" + user_state + "','" + user_mail + "','" + user_pan + "','" + user_phone + "','" + user_account_type + "','" + get_account_no + "','" + account_create_date + "')";
                                Statement st = con.createStatement();
                                st.executeUpdate(insert_data);
                                Random random = new Random();
                                int user_pass = random.nextInt(999999);


                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/TCG_Bank",
                                        "root", "12345");


                                float start_amount = 0;
                                String amount_type = "Open Ac";
                                String insert_data_rs = "Insert into customer_amount_data value(" + get_last_id + "," + start_amount + ",'" + amount_type + "','" + start_amount + "','" + account_create_date + "')";
                                Statement st2 = con.createStatement();
                                st2.executeUpdate(insert_data_rs);


                                String user_data = "Insert into Customer_login_data value(" + get_last_id + ",'" + user_mail + "','" + user_pass + "')";
                                Statement st_user_data = con.createStatement();
                                st_user_data.executeUpdate(user_data);
                                mail_msg = "Dear " + first_name + last_name + "Your A/c no:" + get_account_no + " '\n' Thanks for TCG Bank Registration. Your Password is " + user_pass;
                                mail_send("meghrajyadav.yadav20@gmail.com", user_mail, "TCG Bank Registration", mail_msg);
                                name.setText("");
                                user_last_name.setText("");
                                user_fname.setText("");
                                user_mother_name.setText("");
                                address.setText("");
                                city.setText("");
                                state.setText("");
                                phone.setText("");
                                mail.setText("");
                                pan_number.setText("");
                                output_msg.setText("Thanks For Registration Please Check Your Mail...");
                            }
                            else
                            {
                                mail.setText("");
                                output_msg.setText("This Mail is Also Registered!...");
                                count_mail=0;
                            }

                        }
                        catch (Exception es)
                        {
                            System.out.println(es);
                        }
                    }

                }
                else
                {
                    mail.setText("Email Enter Correctly");
                    mail.setForeground(Color.RED);
                }





            }
        };
        submit.addActionListener(user_reg);

        ActionListener user_login=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                TCG_Bank home=new TCG_Bank();
                home.home_bank();
            }
        };
        Login.addActionListener(user_login);


    }



    public static String mail_send(String from,String to,String subj,String msg){
        String flag="false";
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

        try {
            Message user_msg=new MimeMessage(session);
            user_msg.setFrom(new InternetAddress(from));
            user_msg.setSubject(subj);
            user_msg.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
            user_msg.setText(msg);

            Transport.send(user_msg);
            flag="true";

        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }

}