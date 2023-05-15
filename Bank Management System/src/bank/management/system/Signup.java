package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {

    Random ran = new Random();

    long first4 = (ran.nextLong() % 9000) + 1000L;

    String first = " " + Math.abs(first4);

    JTextField textName, textFname, textemail, textaddress, textcity, textpin, textstate;
    JDateChooser dateChooser;

    JRadioButton r1,r2,m1,m2;

    JButton next;

    Signup(){
        super("Application Form");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);
 
        JLabel label1 = new JLabel("Application Form No" + first);
        label1.setBounds(250,20,600,40);
        label1.setFont(new Font("Ralway",Font.BOLD,38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Ralway",Font.BOLD,38));
        label2.setBounds(330,70,500,30);
        add(label2);

        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);

        JLabel labelName = new JLabel("Name");
        labelName.setFont(new Font("Raleway",Font.BOLD,20));
        labelName.setBounds(100,150,300,30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD,14));
        textName.setBounds(300,150,400,30);
        add(textName);

        JLabel labelFname = new JLabel("Father's Name");
        labelFname.setFont(new Font("Raleway",Font.BOLD,20));
        labelFname.setBounds(100,190,200,30);
        add(labelFname);

        textFname = new JTextField();
        textFname.setFont(new Font("Raleway",Font.BOLD,14));
        textFname.setBounds(300,190,400,30);
        add(textFname);

        JLabel DOB = new JLabel("DOB");
        DOB.setFont(new Font("Raleway", Font.BOLD,20));
        DOB.setBounds(100,230,200,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,230,400,30);
        add(dateChooser);

        JLabel labelGender = new JLabel("Gender");
        labelGender.setFont(new Font("Raleway",Font.BOLD,20));
        labelGender.setBounds(100,270,200,30);
        add(labelGender);

        r1=new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(300,270,60,30);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(new Color(222,255,228));
        r2.setBounds(450,270,100,30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel labelemail = new JLabel("Email address");
        labelemail.setFont(new Font("Raleway",Font.BOLD,20));
        labelemail.setBounds(100,310,200,30);
        add(labelemail);

        textemail = new JTextField();
        textemail.setFont(new Font("Raleway",Font.BOLD,14));
        textemail.setBounds(300,310,400,30);
        add(textemail);

        JLabel labelmarital = new JLabel("Marital Status");
        labelmarital.setFont(new Font("Raleway",Font.BOLD,20));
        labelmarital.setBounds(100,350,200,30);
        add(labelmarital);

        m1=new JRadioButton("Married");
        m1.setFont(new Font("Raleway",Font.BOLD,14));
        m1.setBackground(new Color(222,255,228));
        m1.setBounds(300,350,100,30);
        add(m1);

        m2=new JRadioButton("Unmarried");
        m2.setFont(new Font("Raleway",Font.BOLD,14));
        m2.setBackground(new Color(222,255,228));
        m2.setBounds(450,350,100,30);
        add(m2);

        ButtonGroup buttongroup1 = new ButtonGroup();
        buttongroup1.add(m1);
        buttongroup1.add(m2);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setFont(new Font("Raleway",Font.BOLD,20));
        labeladdress.setBounds(100,390,200,30);
        add(labeladdress);

        textaddress = new JTextField();
        textaddress.setFont(new Font("Raleway",Font.BOLD,14));
        textaddress.setBounds(300,390,400,30);
        add(textaddress);

        JLabel labelcity = new JLabel("City");
        labelcity.setFont(new Font("Raleway",Font.BOLD,20));
        labelcity.setBounds(100,430,200,30);
        add(labelcity);

        textcity = new JTextField();
        textcity.setFont(new Font("Raleway",Font.BOLD,14));
        textcity.setBounds(300,430,400,30);
        add(textcity);

        JLabel labelpin = new JLabel("City");
        labelpin.setFont(new Font("Raleway",Font.BOLD,20));
        labelpin.setBounds(100,470,200,30);
        add(labelpin);

        textpin = new JTextField();
        textpin.setFont(new Font("Raleway",Font.BOLD,14));
        textpin.setBounds(300,470,400,30);
        add(textpin);

        JLabel labelstate = new JLabel("State");
        labelstate.setFont(new Font("Raleway",Font.BOLD,20));
        labelstate.setBounds(100,510,200,30);
        add(labelstate);

        textstate = new JTextField();
        textstate.setFont(new Font("Raleway",Font.BOLD,14));
        textstate.setBounds(300,510,400,30);
        add(textstate);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,550,80,30);
        next.addActionListener(this);
        add(next);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = first;
        String name = textName.getText();
        String fname = textFname.getText();
        String dob =  ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }else if(r2.isSelected()){
            gender = "Female";
        }
         String email = textemail.getText();
        String marital = null;
        if(m1.isSelected()){
            marital = "Married";
        }else if(m2.isSelected()){
            marital = "Unmarried";
        }
        String address = textaddress.getText();
        String city = textcity.getText();
        String pincode = textpin.getText();
        String state = textstate.getText();

        try{
           if(textName.getText().equals("")){
               JOptionPane.showMessageDialog(null,"Fill all the field");
           }else{
               Conn con1= new Conn();
               String q = "Insert into signup values('"+formno+"' , '"+name+"' , '"+fname+"' ,'"+dob+"' ,'"+gender+"' ,'"+email+"' , '"+marital+"' ,'"+address+"' ,'"+city+"' ,'"+pincode+"' ,'"+state+"')";
               con1.statement.executeUpdate(q);
               new Signup2(formno);
               setVisible(false);
           }
        }catch(Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
      new Signup();
    }
}


