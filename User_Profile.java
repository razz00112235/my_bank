import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User_Profile {
    static int count_fetch=0;
    static String user_acc,user_mail_data;
    static int sender_id,count_rec=0;
    static  float amount=0;
    static float remain_amount=0;
    static  String sender_account;
    static JLabel ac_holder_name_data,ac_holder_fname_data,ac_holder_mname_data,ac_holder_mail_data,ac_holder_phone_data,
    ac_holder_address_data,pass_update;
    static JTextField user_pass_data;
    public static void user_profile(int user_id,String user_ac){
        JLabel account_no,ac_type,Amount;
        user_acc=user_ac;


        JFrame login = new JFrame("Login Menu");
        JLabel hicon = new JLabel();
        JLabel banking = new JLabel("iBanking");
        JLabel picon = new JLabel();
        JLabel pname = new JLabel();
        JButton logouticon = new JButton();



        login.setBounds(20,20,650,500);
        hicon.setBounds(50,10,50,50);
        banking.setBounds(120,20,150,50);
        picon.setBounds(380,10,20,20);
        pname.setBounds(410,10,75,20);
        logouticon.setBounds(490,10,30,20);



        ImageIcon imgicon = new ImageIcon("download.png");
        hicon.setIcon(imgicon);
        ImageIcon pimgicon = new ImageIcon("parson.png");
        picon.setIcon(pimgicon);
        ImageIcon logimgicon = new ImageIcon("logout.png");
        logouticon.setIcon(logimgicon);
        banking.setFont(new Font("Arial", Font.BOLD, 30));



        login.add(hicon);
        login.add(banking);
        login.add(picon);
        login.add(pname);
        login.add(logouticon);



        JPanel detail = new JPanel();
        JLabel accsum = new JLabel("Current Account Summary");
        detail.setBounds(10,100,200,100);
        accsum.setBounds(10,100,200,20);
        account_no=new JLabel();
        ac_type=new JLabel();
        Amount=new JLabel();


        GridLayout pangrid = new GridLayout(5,1);

        JPanel pan2 = new JPanel();
        pan2.setBounds(10,200,200,215);
        pan2.setLayout(pangrid);
        pan2.setBorder(BorderFactory.createLineBorder(Color.black));

        JButton details = new JButton("Profile");


        JButton deposit = new JButton("Deposit");


        JButton withraw = new JButton("Withdraw");


        JButton transcase = new JButton("History");


        JButton transhis = new JButton("Send");


        pan2.add(details);pan2.add(deposit);pan2.add(withraw);
        pan2.add(transcase);pan2.add(transhis);

        details.setBounds(10,140,250,30);
        deposit.setBounds(10,170,150,30);
        withraw.setBounds(10,200,150,30);

        transcase.setBounds(10,230,150,30);
        transhis.setBounds(10,260,150,30);


        account_no.setBounds(10,130,100,20);
        ac_type.setBounds(10,160,100,20);
        Amount.setBounds(10,190,100,20);

        detail.setBorder(BorderFactory.createLineBorder(Color.black));
        detail.add(accsum);detail.add(account_no);detail.add(ac_type);detail.add(Amount);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/TCG_Bank",
                    "root", "12345");
            String fetch_rec3 = "Select * from customer_amount_data where c_id="+user_id+"";
            Statement sm3 = con3.createStatement();
            ResultSet rs3 = sm3.executeQuery(fetch_rec3);
            while (rs3.next()) {
                count_fetch++;
            }
        }
        catch(Exception es)
        {
            System.out.println(es);
        }

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/TCG_Bank",
                    "root", "12345");
            String fetch_rec2 = "Select * from customer_amount_data where c_id="+user_id+"";
            Statement sm2 = con2.createStatement();
            ResultSet rs2 = sm2.executeQuery(fetch_rec2);



            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TCG_Bank",
                    "root", "12345");
            String fetch_rec = "Select * from customer_amount_data where c_id="+user_id+"";
            Statement sm = con.createStatement();
            ResultSet rs = sm.executeQuery(fetch_rec);


            Color user_db=new Color(74, 38, 51);
            JButton User_dboard=new JButton("Dashboard");
            User_dboard.setBackground(user_db);
            User_dboard.setForeground(Color.WHITE);
            User_dboard.setBounds(450,50,120,40);

            JLabel ac_holder_name=new JLabel("Name: ");
            ac_holder_name.setBounds(300,130,150,30);
            ac_holder_name_data=new JLabel();
            ac_holder_name_data.setBounds(400,130,200,30);

            JLabel ac_holder_fname=new JLabel("Father's Name.");
            ac_holder_fname.setBounds(300,160,150,30);
            ac_holder_fname_data=new JLabel("Father's Name.");
            ac_holder_fname_data.setBounds(400,160,150,30);

            JLabel ac_holder_mname=new JLabel("Mother's Name");
            ac_holder_mname.setBounds(300,190,150,30);
            ac_holder_mname_data=new JLabel();
            ac_holder_mname_data.setBounds(400,190,150,30);

            JLabel ac_address=new JLabel("Address");
            ac_address.setBounds(300,220,150,30);
            ac_holder_address_data=new JLabel();
            ac_holder_address_data.setBounds(400,220,250,30);

            JLabel ac_mobile=new JLabel("Mobile");
            ac_mobile.setBounds(300,250,150,30);
            ac_holder_phone_data=new JLabel();
            ac_holder_phone_data.setBounds(400,250,250,30);

            JLabel ac_mail=new JLabel("User Mail");
            ac_mail.setBounds(300,280,150,30);
            ac_holder_mail_data=new JLabel();
            ac_holder_mail_data.setBounds(400,280,250,30);

            JLabel user_pass=new JLabel("Password ");
            user_pass.setBounds(300,310,150,30);
            user_pass_data=new JTextField();
            user_pass_data.setBounds(400,310,120,30);

            JButton update_pass=new JButton("Update Password");
            update_pass.setBounds(400,340,150,30);

            pass_update=new JLabel();
            pass_update.setBounds(300,380,200,30);

            login.add(ac_holder_name); login.add(ac_holder_name_data);
            login.add(ac_holder_fname); login.add(ac_holder_fname_data);
            login.add(ac_holder_mname); login.add(ac_holder_mname_data);
            login.add(ac_address); login.add(ac_holder_address_data);
            login.add(ac_mobile); login.add(ac_holder_phone_data);
            login.add(ac_mail); login.add(ac_holder_mail_data);login.add(user_pass);login.add(user_pass_data);
            login.add(update_pass);login.add(pass_update);
            login.add(User_dboard);

            ActionListener dashboard=new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    login.setVisible(false);
                    UserDesh dp=new UserDesh();
                    dp.ibanking(user_id);

                }
            };
            User_dboard.addActionListener(dashboard);

            ActionListener change_pass=new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TCG_Bank",
                                "root", "12345");
                        String update_password = "Update  customer_login_data set c_pass='"+user_pass_data.getText()+"' where customer_id="+user_id+"";

                        Statement st_pass = con.createStatement();
                        st_pass.executeUpdate(update_password);
                        System.out.println(update_password);
                        pass_update.setText("Password Change Successfully");

                    }
                    catch(Exception ep)
                    {
                        System.out.println(ep);

                    }

                }
            };
            update_pass.addActionListener(change_pass);



        }
        catch(Exception ee)
        {
            System.out.println(ee);
        }

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TCG_Bank",
                    "root", "12345");
            String fetch_rec = "Select * from customer_data where customer_id="+user_id+"";

            Statement sm = con.createStatement();
            ResultSet rs = sm.executeQuery(fetch_rec);

            while (rs.next())
            {
                String first_name=rs.getString("c_fistname");
                String last_name=rs.getString("c_lastname");
                String ft_name=rs.getString("c_fname");
                String mo_name=rs.getString("c_mname");
                String user_ac_type=rs.getString("account_type");
                user_ac=rs.getString("user_account_no");

                String user_address=rs.getString("c_address");
                String user_state=rs.getString("c_state");
                String user_city=rs.getString("c_city");
                String phone_no=rs.getString("c_phone");
                String mail_id=rs.getString("c_mail");
                user_mail_data=mail_id;
                pname.setText(first_name+" "+last_name);
                account_no.setText("Account No. :"+user_ac);
                ac_type.setText("Type :"+user_ac_type);
                ac_holder_name_data.setText(first_name+" "+last_name);
                ac_holder_fname_data.setText(ft_name);
                ac_holder_mname_data.setText(mo_name);
                ac_holder_address_data.setText(user_address+", City: "+user_city+", "+user_state);
                ac_holder_phone_data.setText(phone_no);
                ac_holder_mail_data.setText(mail_id);
            }

            String fetch_pass = "Select * from customer_login_data where c_mail='"+user_mail_data+"'";
            System.out.println(fetch_pass);
            Statement pass = con.createStatement();
            ResultSet r_pass = pass.executeQuery(fetch_pass);
            while (r_pass.next()) {
                String c_pass=r_pass.getString("c_pass");
                user_pass_data.setText(c_pass);
            }

            String fetch_trans_rs = "Select * from customer_amount_data where c_id="+user_id+"";

            Statement st_amount = con.createStatement();
            ResultSet record_amount = st_amount.executeQuery(fetch_trans_rs);
            float final_amount=0;
            while (record_amount.next()) {
                final_amount=record_amount.getFloat("remain_amount");


            }

            Amount.setText("Amount :"+String.valueOf(final_amount-amount));
        }
        catch(Exception ee)
        {
            System.out.println(ee);
        }



        login.add(detail);
        login.add(pan2);

        login.setLayout(null);
        login.setVisible(true);

        ActionListener user_logout=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                TCG_Bank tc=new TCG_Bank();
                tc.home_bank();

            }
        };
        logouticon.addActionListener(user_logout);

        ActionListener user_dash=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                Transection_history tc=new Transection_history();
                tc.transection_dash(user_id,user_acc);

            }
        };
        transcase.addActionListener(user_dash);

        ActionListener user_dashoard=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                User_Profile ud=new User_Profile();
                ud.user_profile(user_id,user_acc);

            }
        };
        details.addActionListener(user_dashoard);

        ActionListener withdraw_amount=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                Withdraw_amount dp=new Withdraw_amount();
                dp.withdraw(user_id,user_acc);

            }
        };
        withraw.addActionListener(withdraw_amount);
        ActionListener amount_deposit=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                Deposit_amount dp=new Deposit_amount();
                dp.deposit(user_id,user_acc);

            }
        };
        deposit.addActionListener(amount_deposit);






    }




}
