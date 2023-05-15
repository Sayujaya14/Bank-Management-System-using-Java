package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class minist extends JFrame implements ActionListener {

    String pin;
    JButton b1;
    minist(String pin){
        this.pin=pin;
        getContentPane().setBackground(new Color(255,204,204));
        setSize(400,600);
        setLocation(20,20);
        setLayout(null);

        JLabel l1 = new JLabel();
        l1.setBounds(20,140,400,250);
        add(l1);

        JLabel l2 = new JLabel("BANK");
        setFont(new Font("System",Font.BOLD,15));
        l2.setBounds(150,20,200,20);
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20,80,300,20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20,400,300,20);
        add(l4);

        try{
            Conn c = new Conn();

            ResultSet rs = c.statement.executeQuery("select * from login where pin ='"+pin+"'");
             while(rs.next()){
                 l3.setText("Card Number "+rs.getString("cardno").substring(0,4)+"XXXXXXXX"+rs.getString("cardno").substring(12));

             }

        }catch(Exception E){
            E.printStackTrace();
        }

        try{
            int balance =0;
            Conn c=new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin ='"+pin+"'");
            while(resultSet.next());
            l1.setText(l1.getText()+"<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br><html>");
            if(resultSet.getString("type").equals("Deposit")){
                balance += Integer.parseInt(resultSet.getString("amount"));
            }else{
                balance -= Integer.parseInt(resultSet.getString("amount"));
             }
            l4.setText("Your Total balance Rs."+balance);

        }catch (Exception E){
            E.printStackTrace();
        }

      b1 = new JButton("Exit");
      b1.setBounds(20,500,100,25);
      b1.addActionListener(this);
      add(b1);



      setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);

    }

    public static void main(String[] args) {
        new minist("");
    }
}
