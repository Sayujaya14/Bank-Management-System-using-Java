package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    String pin;
    TextField textField;
    JButton Dep,Back;

    Deposit(String pin){
        this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2= i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);

        JLabel l2 = new JLabel("Enter Amount You Want To Depost");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setBounds(460,180,400,35);
        l1.add(l2);

        textField = new TextField();
        textField.setBounds(460,230,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        l1.add(textField);

        Dep = new JButton("Deposit");
        Dep.setBackground(new Color(65,125,128));
        Dep.setForeground(Color.WHITE);
        Dep.setBounds(700,362,150,35);
        Dep.addActionListener(this);
        l1.add(Dep);

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
        try{
            String amount = textField.getText();
            Date date = new Date();
            if(e.getSource()==Dep){
                if(textField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter your amount");
                }else{
                    Conn c = new Conn();
                    c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
                    JOptionPane.showMessageDialog(null,""+amount+"Deposited Sucessfully");
                    setVisible(false);
                    new main_Class(pin);
                }
            }else if(e.getSource()==Back){
                setVisible(false);
                new main_Class(pin);
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
     new Deposit("");
    }
}
