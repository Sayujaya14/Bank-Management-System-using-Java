package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    String pin;
    TextField textField;
    JButton Draw,Back;
    Withdrawl(String pin){
        this.pin=pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2= i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);

        JLabel l2 = new JLabel("Miximum Withdrawl is RS.20,000");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setBounds(460,180,700,35);
        l1.add(l2);

        JLabel l3 = new JLabel("Enter your amount");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("System",Font.BOLD,16));
        l3.setBounds(460,200,700,35);
        l1.add(l3);

        textField = new TextField();
        textField.setBounds(460,230,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        l1.add(textField);

        Draw = new JButton("Draw");
        Draw.setBackground(new Color(65,125,128));
        Draw.setForeground(Color.WHITE);
        Draw.setBounds(700,362,150,35);
        Draw.addActionListener(this);
        l1.add(Draw);

        Back = new JButton("Back");
        Back.setBackground(new Color(65,125,128));
        Back.setForeground(Color.WHITE);
        Back.setBounds(700,400,150,35);
        Back.addActionListener(this);
        l1.add(Back);




        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Draw) {
            try {

                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Pleae enter amount");
                } else {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from where pin ='" + pin + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient");
                        return;
                    }
                    c.statement.executeUpdate("insert into bank values('" + pin + "','" + date + "','withdrawl','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs" + amount + "Debited Sucessfully");
                    setVisible(false);
                    new main_Class(pin);
                }

            } catch (Exception E) {

            }
        }else if(e.getSource()==Back){
           setVisible(false);
           new main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
