package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquriy extends JFrame implements ActionListener {

    String pin;

    JLabel l3;
    JButton b1;
    BalanceEnquriy(String pin){
        this.pin=pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2= i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);

        JLabel l2 = new JLabel("Your Current Balance is Rs");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setBounds(430,180,700,35);
        l1.add(l2);

        JLabel l3 = new JLabel();
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("System",Font.BOLD,16));
        l3.setBounds(430,200,700,35);
        l1.add(l3);

        b1 = new JButton("Back");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(700,406,150,35);
        b1.addActionListener(this);
        l1.add(b1);

        int balance =0;
        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while(resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else{
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        l3.setText(""+balance);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Class(pin);

    }

    public static void main(String[] args) {
        new BalanceEnquriy("");
    }
}
