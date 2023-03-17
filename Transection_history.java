import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Transection_history {
static int count_fetch=0;
static String customer_ac;
    static void transection_dash(int u_id,String user_ac)
    {
        customer_ac=user_ac;
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
            String fetch_rec3 = "Select * from customer_amount_data where c_id="+u_id+"";
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
            String fetch_rec2 = "Select * from customer_amount_data where c_id="+u_id+"";
            Statement sm2 = con2.createStatement();
            ResultSet rs2 = sm2.executeQuery(fetch_rec2);



            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TCG_Bank",
                    "root", "12345");
            String fetch_rec = "Select * from customer_amount_data where c_id="+u_id+" Order BY amount_date_time DESC";
            Statement sm = con.createStatement();
            ResultSet rs = sm.executeQuery(fetch_rec);
            Color user_db=new Color(74, 38, 51);
            JButton User_dboard=new JButton("Dashboard");
            User_dboard.setBackground(user_db);
            User_dboard.setForeground(Color.WHITE);
            User_dboard.setBounds(450,50,120,40);

            login.add(User_dboard);

            ActionListener dashboard=new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    login.setVisible(false);
                    UserDesh dp=new UserDesh();
                    dp.ibanking(u_id);

                }
            };
            User_dboard.addActionListener(dashboard);

            float amount;
            String amount_date,type;

            String column[]={"Transection Time","Amount","Type"};


            int i=0,j=0;


            String data[][]= new String[count_fetch][column.length];
            while (rs.next())
            {

                amount_date=rs.getString("amount_date_time");
                amount=rs.getInt("amount");
                type=rs.getString("trans_type");
                // System.out.println(amount_date+"  "+amount+"  "+type);
                data[i][j]=amount_date;
                data[i][j+1]=String.valueOf(amount);
                data[i][j+2]=type;
                i++;

            }
//            for(int k=0;k<4;k++)
//            {
//                for(int l=0;l<3;l++)
//                {
//                    System.out.print(data[k][l]+" ");
//                }
//
//            }

//            JTable jt=new JTable(data2,column2);
//            jt.setBounds(250,40,200,300);
//            JScrollPane sp=new JScrollPane(jt);
//            login.add(sp);
//            JLabel msg=new JLabel("hello");
//            msg.setBounds(250,150,250,30);
//            login.add(msg);


            JPanel f=new JPanel();
            JTable jt=new JTable(data,column);
            jt.setBounds(30,40,300,320);
            JScrollPane sp=new JScrollPane(jt);
            f.add(sp);
            f.setBounds(220,100,400,320);
            f.setLayout(new BoxLayout(f, BoxLayout.PAGE_AXIS));
            f.setVisible(true);
            login.add(f);
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
                UserDesh ud=new UserDesh();
                ud.ibanking(u_id);

            }
        };
        transcase.addActionListener(user_dash);

        ActionListener amount_deposit=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                Deposit_amount dp=new Deposit_amount();
                dp.deposit(u_id,customer_ac);

            }
        };
        deposit.addActionListener(amount_deposit);
        ActionListener user_dashoard=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                User_Profile ud=new User_Profile();
                ud.user_profile(u_id,customer_ac);

            }
        };
        details.addActionListener(user_dashoard);


        ActionListener withdraw_amount=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                Withdraw_amount dp=new Withdraw_amount();
                dp.withdraw(u_id,customer_ac);

            }
        };
        withraw.addActionListener(withdraw_amount);

        ActionListener sendamount=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                Send_amount dp=new Send_amount();
                dp.send_amount(u_id,customer_ac);

            }
        };
        transhis.addActionListener(sendamount);



    }
//    static void t_history(int u_id)
//    {
//        int customer_id=1;
//        try{
//            System.out.println("hii");
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/TCG_Bank",
//                    "root", "12345");
//
//            String fetch_rec="Select * from customer_amount_data where c_id="+customer_id+"";
//            System.out.println(fetch_rec);
//            Statement sm=con.createStatement();
//            ResultSet rs=sm.executeQuery(fetch_rec);
//            float remain_amount=0,amount=0;
//            int count=1;
//            String date_time,trans_type;
//            while(rs.next()) {
//
//
//                date_time=rs.getString("amount_date_time");
//                trans_type=rs.getString("trans_type");
//                amount=rs.getInt("amount");
//                remain_amount=rs.getInt("remain_amount");
//                System.out.println(count+" "+date_time+" "+trans_type+" "+amount+" "+remain_amount);
//                count++;
//            }
//
//        }
//        catch ( Exception e)
//        {
//            System.out.println(e);
//        }
//    }

}
