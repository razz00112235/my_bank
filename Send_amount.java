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

public class Send_amount {
    static int count_fetch=0;
    static String user_acc;
    static int sender_id,count_rec=0;
    static  float amount=0;
    static float remain_amount=0;
    static  String sender_account;
    public static void send_amount(int user_id,String user_ac){
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

            JLabel amount_msg=new JLabel("Send Amount: ");
            amount_msg.setBounds(420,130,150,30);
            JLabel acc_no=new JLabel("Account No.");
            acc_no.setBounds(300,180,150,30);

            JTextField ac_field=new JTextField();
            ac_field.setBounds(450,180,150,30);

            JLabel amount_data=new JLabel("Amount");
            amount_data.setBounds(300,220,150,30);
            JTextField amount_field=new JTextField();
            amount_field.setBounds(450,220,150,30);
            JButton deposit_bt=new JButton("Send");
            deposit_bt.setBounds(450,260,150,30);
            login.add(amount_msg);login.add(amount_field);login.add(deposit_bt);
            login.add(acc_no);login.add(ac_field);login.add(amount_data);login.add(amount_field);
            login.add(User_dboard);

            ActionListener dashboard=new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    login.setVisible(false);
                    UserDesh dp=new UserDesh();
                    dp.ibanking(user_id);

                }
            };
            User_dboard.addActionListener(dashboard);
            ActionListener send_amount=new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    if(amount_field.getText().matches("[0-9]+"))
                    {
                        amount=Float.parseFloat(amount_field.getText());
                        sender_account=ac_field.getText();

                        try{
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/TCG_Bank",
                                    "root", "12345");
                            String amount_type="Send To "+sender_account;

                            LocalDateTime myDateObj = LocalDateTime.now();
                            DateTimeFormatter date_format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                            String deposit_date = myDateObj.format(date_format);
                            String fetch_trans = "Select * from customer_data where user_account_no='"+sender_account+"'";
                            Statement st_amount = con.createStatement();
                            ResultSet record_amount = st_amount.executeQuery(fetch_trans);


                            while(record_amount.next()) {
                                sender_id=record_amount.getInt("customer_id");
                            }



                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con2= DriverManager.getConnection("jdbc:mysql://localhost:3306/TCG_Bank",
                                    "root", "12345");
                            String fetch_trans_sender = "Select * from customer_amount_data where c_id="+sender_id+"";

                            Statement fetch_statement = con2.createStatement();
                            ResultSet fetch_rst = fetch_statement.executeQuery(fetch_trans_sender);

                            while(fetch_rst.next()) {

                                remain_amount=fetch_rst.getFloat("remain_amount");
                                count_rec++;
                            }

                            remain_amount=remain_amount+amount;


                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con5= DriverManager.getConnection("jdbc:mysql://localhost:3306/TCG_Bank",
                                    "root", "12345");
                            String insert_data_send_rec="Insert into customer_amount_data value("+sender_id+","+amount+",'"+amount_type+"',"+remain_amount+",'"+deposit_date+"')";

                            Statement st5=con5.createStatement();
                            st5.executeUpdate(insert_data_send_rec);

                            String fetch_rec="Select * from customer_amount_data where c_id="+user_id+"";

                            Statement sm=con.createStatement();
                            ResultSet rs=sm.executeQuery(fetch_rec);
                            float remain_sender_amount=0;
                            while(rs.next()) {
                                remain_sender_amount=rs.getInt("remain_amount");
                            }
                            remain_sender_amount=remain_sender_amount-amount;


                            if(remain_sender_amount>amount)
                            {

                                String insert_data_user="Insert into customer_amount_data value("+user_id+","+amount+",'"+amount_type+"','"+remain_sender_amount+"','"+deposit_date+"')";

                                Statement st4=con.createStatement();
                                st4.executeUpdate(insert_data_user);

                            }
                            else
                            {
                                System.out.println("no amount");
                            }
                            amount_field.setText("");
                            ac_field.setText("");
                            String fetch_trans_rs = "Select * from customer_amount_data where c_id="+user_id+"";
                            System.out.println(fetch_trans_rs);
                            Statement st_amount1 = con.createStatement();
                            ResultSet record_amount1 = st_amount1.executeQuery(fetch_trans_rs);
                            float final_amount=0;
                            while (record_amount1.next()) {
                                final_amount=record_amount1.getFloat("remain_amount");


                            }

                            Amount.setText("Amount :"+String.valueOf(final_amount));

                        }
                        catch(Exception ec)
                        {

                        }

                    }
                    else
                    {
                        amount_field.setText("Enter Number only");
                        amount_field.setForeground(Color.RED);
                    }


                }
            };
            deposit_bt.addActionListener(send_amount);



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
            System.out.println(user_id);
            System.out.println(fetch_rec);
            Statement sm = con.createStatement();
            ResultSet rs = sm.executeQuery(fetch_rec);

            while (rs.next())
            {
                String first_name=rs.getString("c_fistname");
                String last_name=rs.getString("c_lastname");
                String ft_name=rs.getString("c_address");
                String mo_name=rs.getString("c_pan");
                String user_ac_type=rs.getString("account_type");
                user_ac=rs.getString("user_account_no");
                String user_state=rs.getString("account_create_date");

                pname.setText(first_name+" "+last_name);
                account_no.setText("Account No. :"+user_ac);
                ac_type.setText("Type :"+user_ac_type);
            }

            String fetch_trans_rs = "Select * from customer_amount_data where c_id="+user_id+"";
            System.out.println(fetch_trans_rs);
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
