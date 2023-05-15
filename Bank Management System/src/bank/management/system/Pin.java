package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {

    JButton C1,Back;
    JPasswordField p1,p2;

    String pin;
    Pin(String pin){
        this.pin = pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2= i1.getImage().getScaledInstance(1550,830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);

        JLabel l2 = new JLabel("Change your PIN");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setBounds(430,180,400,35);
        l1.add(l2);

        JLabel l3 = new JLabel("New PIN");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("System",Font.BOLD,16));
        l3.setBounds(430,220,150,35);
        l1.add(l3);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(600,220,180,25);
        p1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.add(p1);

        JLabel l4 = new JLabel("Re-enter New PIN");
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("System",Font.BOLD,16));
        l4.setBounds(430,250,400,35);
        l1.add(l4);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(600,250,180,35);
        p2.setFont(new Font("Raleway",Font.BOLD,22));
        l1.add(p2);




        C1 = new JButton("Change");
        C1.setBackground(new Color(65,125,128));
        C1.setForeground(Color.WHITE);
        C1.setBounds(700,362,150,35);
        C1.addActionListener(this);
        l1.add(C1);

        Back = new JButton("Back");
        Back.setBackground(new Color(65,125,128));
        Back.setForeground(Color.WHITE);
        Back.setBounds(700,400,150,35);
        Back.addActionListener(this);
        l1.add(Back);

        setSize(1550,1080);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{

            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"PIN does not match");
                return;
            }
            if(e.getSource()==C1){
                if(p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter PIN");
                    return;
                }
                if(p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter New PIN");
                    return;
                }

                Conn c = new Conn();
                String qu1 = "update bank set pin = '"+pin+"'";
                String qu2 = "update login set pin = '"+pin+"'";
                String qu3 = "update signup3 set pin = '"+pin+"'";

                c.statement.executeUpdate(qu1);
                c.statement.executeUpdate(qu2);
                c.statement.executeUpdate(qu3);

                JOptionPane.showMessageDialog(null,"Pin changes sucessfully");
                setVisible(false);
                new main_Class(pin);
            }else if(e.getSource()==Back){
                new main_Class(pin);
                setVisible(false);
            }

        }catch(Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Pin("");
    }
}
