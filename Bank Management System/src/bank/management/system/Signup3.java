package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5;

    JButton s,c;
    String formno;
  Signup3(String formno){
        this.formno = formno;
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
      Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(155,5,100,100);
      add(image);

      JLabel l1 = new JLabel("Page 3");
      l1.setFont(new Font("Raleway",Font.BOLD,22));
      l1.setBounds(280,40,400,40);
      add(l1);

      JLabel l2 = new JLabel("Account Details");
      l2.setFont(new Font("Raleway",Font.BOLD,22));
      l2.setBounds(280,70,400,40);
      add(l2);

      JLabel l3 = new JLabel("Account Type");
      l3.setFont(new Font("Raleway",Font.BOLD,18));
      l3.setBounds(100,140,400,40);
      add(l3);

      r1 = new JRadioButton("Saving Account");
      r1.setFont(new Font("Raleway" ,Font.BOLD,18));
      r1.setBackground(new Color(252,208,76));
      r1.setBounds(100,180,180,40);
      add(r1);

      r2 = new JRadioButton("Fixed Depost");
      r2.setFont(new Font("Raleway" ,Font.BOLD,18));
      r2.setBackground(new Color(252,208,76));
      r2.setBounds(350,180,180,40);
      add(r2);

      r3 = new JRadioButton("Current Account");
      r3.setFont(new Font("Raleway" ,Font.BOLD,18));
      r3.setBackground(new Color(252,208,76));
      r3.setBounds(100,220,180,40);
      add(r3);

      r4 = new JRadioButton("Recurring Account");
      r4.setFont(new Font("Raleway" ,Font.BOLD,18));
      r4.setBackground(new Color(252,208,76));
      r4.setBounds(350,220,280,40);
      add(r4);

      ButtonGroup buttonGroup = new ButtonGroup();
      buttonGroup.add(r1);
      buttonGroup.add(r2);
      buttonGroup.add(r3);
      buttonGroup.add(r4);

      JLabel l4 = new JLabel("Card Number");
      l4.setFont(new Font("Raleway",Font.BOLD,18));
      l4.setBounds(100,260,400,40);
      add(l4);

      JLabel l5 = new JLabel("XXXX-XXXX-XXXX-1234");
      l5.setFont(new Font("Raleway",Font.BOLD,18));
      l5.setBounds(350,260,400,40);
      add(l5);

      JLabel l6 = new JLabel("PIN");
      l6.setFont(new Font("Raleway",Font.BOLD,18));
      l6.setBounds(100,300,400,40);
      add(l6);

      JLabel l7 = new JLabel("XXXX");
      l7.setFont(new Font("Raleway",Font.BOLD,18));
      l7.setBounds(350,300,400,40);
      add(l7);

      JLabel l8 = new JLabel("More Services");
      l8.setFont(new Font("Raleway",Font.BOLD,18));
      l8.setBounds(100,350,400,40);
      add(l8);

      c1 = new JCheckBox("ATM CARD");
      c1.setBackground(new Color(252,208,76));
      c1.setFont(new Font("Raleway",Font.BOLD,14));
      c1.setBounds(100,380,200,40);
      add(c1);

      c2 = new JCheckBox("Net Banking");
      c2.setBackground(new Color(252,208,76));
      c2.setFont(new Font("Raleway",Font.BOLD,14));
      c2.setBounds(300,380,400,40);
      add(c2);

      c3 = new JCheckBox("Mobile Banking");
      c3.setBackground(new Color(252,208,76));
      c3.setFont(new Font("Raleway",Font.BOLD,14));
      c3.setBounds(100,420,200,40);
      add(c3);

      c4 = new JCheckBox("SMS Alert");
      c4.setBackground(new Color(252,208,76));
      c4.setFont(new Font("Raleway",Font.BOLD,14));
      c4.setBounds(300,420,400,40);
      add(c4);

      c5 = new JCheckBox("I decleares that the datails provided by me are correct ");
      c5.setBackground(new Color(252,208,76));
      c5.setFont(new Font("Raleway",Font.BOLD,12));
      c5.setBounds(100,500,600,40);
      add(c5);

      JLabel l9 = new JLabel("Form No:");
      l9.setFont(new Font("Raleway",Font.BOLD,18));
      l9.setBounds(650,10,100,30);
      add(l9);

      s = new JButton("Submit");
      s.setFont(new Font("Raleway",Font.BOLD,14));
      s.setBackground(Color.BLACK);
      s.setForeground(Color.WHITE);
      s.setBounds(250,620,100,30);
      s.addActionListener(this);
      add(s);

      c = new JButton("Cancel");
      c.setFont(new Font("Raleway",Font.BOLD,14));
      c.setBackground(Color.BLACK);
      c.setForeground(Color.WHITE);
      c.setBounds(450,620,100,30);
      c.addActionListener(this);
      add(c);


      setLayout(null);
      setSize(850,750);
      setLocation(450,80);
      getContentPane().setBackground(new Color(252,208,76));
      setVisible(true) ;

  }

    @Override
    public void actionPerformed(ActionEvent e) {
      String atype = null;
      if(r1.isSelected()){
          atype = "Savings Account";
      }else if(r2.isSelected()){
          atype = "Fixed Deposit";
      }else if(r3.isSelected()){
        atype = "Current Account";
    }else if(r4.isSelected()){
          atype = "Recurring Account";
      }

      Random ran = new Random();
      long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
      String cardno = "" + Math.abs(first7);

      long first3 = (ran.nextLong() % 9000L) + 1000L;
      String pin ="" + Math.abs(first3);

      String fac = "";
      if(c1.isSelected()){
          fac = "Atm";
      }else if(c2.isSelected()){
          fac ="Net Banking";
      }else if(c3.isSelected()){
          fac ="Mobile Banking";
      }else if(c4.isSelected()){
          fac ="SMS Alert";
      }

      try{
          if(e.getSource()==s){
              if(atype.equals("")){
                  JOptionPane.showMessageDialog(null,"Fill all fields");
              }else{
                  Conn c1 = new Conn();
                  String q1 = "Insert into values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+fac+"')";
                  String q2 = "Insert into values('"+formno+"','"+cardno+"','"+pin+"')";
                  c1.statement.executeUpdate(q1);
                  c1.statement.executeUpdate(q2);
                  JOptionPane.showMessageDialog(null,"Card Number : "+cardno+"\n Pin:"+pin);
                  new Deposit(pin);
                  setVisible(false);
              }
          }else if(e.getSource()==c){
              System.exit(0);
          }
      }catch(Exception E){
          E.printStackTrace();
      }

    }

    public static void main(String[] args) {
      new Signup3("");

    }
}


