import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class UserDesh
{
 static String user_ac;
   static void ibanking(int u_id)
    {
        JLabel account_no,ac_type,Amount;



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
        detail.setBounds(10,100,200,320);
        accsum.setBounds(10,100,200,20);
        account_no=new JLabel();
        ac_type=new JLabel();
        Amount=new JLabel();

        account_no.setBounds(10,130,100,20);
        ac_type.setBounds(10,160,100,20);
        Amount.setBounds(10,190,100,20);

        detail.setBorder(BorderFactory.createLineBorder(Color.black));
        detail.add(accsum);detail.add(account_no);detail.add(ac_type);detail.add(Amount);


        ImageIcon imgicon2 = new ImageIcon("detail.png");
        JButton details = new JButton(imgicon2);

        ImageIcon imgicon3 = new ImageIcon("deposit.png");
        JButton deposit = new JButton(imgicon3);

        ImageIcon imgicon4 = new ImageIcon("withdraw.jpg");
        JButton withraw = new JButton(imgicon4);

        ImageIcon imgicon5 = new ImageIcon("transfercase.jpg");
        JButton transcase = new JButton(imgicon5);

        ImageIcon imgicon6 = new ImageIcon("history.png");
        JButton transhis = new JButton(imgicon6);

        ImageIcon imgicon7 = new ImageIcon("parson.png");
        JButton info = new JButton(imgicon7);


        details.setBounds(270,120,50,50);
        deposit.setBounds(370,120,50,50);
        withraw.setBounds(470,120,50,50);

        transcase.setBounds(270,250,50,50);
        transhis.setBounds(370,250,50,50);
        info.setBounds(470,250,50,50);


        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TCG_Bank",
                    "root", "12345");
            String fetch_rec = "Select * from customer_data where customer_id="+u_id+"";
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

            String fetch_trans = "Select * from customer_amount_data where c_id="+u_id+"";
            Statement st_amount = con.createStatement();
            ResultSet record_amount = st_amount.executeQuery(fetch_trans);
            float final_amount=0;
            Amount.setText("Amount :"+String.valueOf(final_amount));
            while (record_amount.next()) {
                final_amount=record_amount.getFloat("remain_amount");


                Amount.setText("Amount :"+String.valueOf(final_amount));
            }

        }
        catch(Exception ee)
        {
            System.out.println(ee);
        }



        login.add(details);
        login.add(deposit);
        login.add(withraw);

        login.add(detail);
        login.add(transcase);login.add(transhis);login.add(info);

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

        ActionListener trans_history=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                Transection_history tc=new Transection_history();
                tc.transection_dash(u_id,user_ac);

            }
        };
        transhis.addActionListener(trans_history);
        ActionListener withdraw_amount=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                Withdraw_amount dp=new Withdraw_amount();
                dp.withdraw(u_id,user_ac);

            }
        };
        withraw.addActionListener(withdraw_amount);

        ActionListener amount_deposit=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                Deposit_amount dp=new Deposit_amount();
                dp.deposit(u_id,user_ac);

            }
        };
        deposit.addActionListener(amount_deposit);
        ActionListener sendamount=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                Send_amount dp=new Send_amount();
                dp.send_amount(u_id,user_ac);

            }
        };
        transcase.addActionListener(sendamount);

        ActionListener user_dashoard=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                User_Profile ud=new User_Profile();
                ud.user_profile(u_id,user_ac);

            }
        };
        info.addActionListener(user_dashoard);


    }


}



