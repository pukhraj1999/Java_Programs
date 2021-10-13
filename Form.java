package GUIDE;

import javax.swing.*;
import java.awt.*;
public class Form {
    public static void main(String[] args) {
        new Grid();
    }
}

class Grid{

    //Variables
    private JFrame Jframe;
    private int Height=500;
    private int Width=500;
    private int width=100;
    private int height=20;
    private Font font=new Font("Monaco",Font.BOLD,15);

    //Members
    Grid(){
        //Jframe
        Jframe=new JFrame("Form");
        Jframe.setSize(Width, Height);
        Jframe.setLayout(null);
        //Pannel
        JPanel Jpannel=new JPanel(new GridLayout(4,2,0,20));
        //Jpannel.setPreferredSize(new Dimension(300,200));
       // Jpannel.setBackground(Color.GRAY);
        //Widgets
        JLabel First_Name,Last_Name,Email,Passwd;
        JTextField first_Name,last_Name,email,passwd;
        First_Name=new JLabel("First Name:-");
        First_Name.setFont(font);
        Last_Name=new JLabel("Last Name:-");
        Last_Name.setFont(font);
        Email=new JLabel("Email:-");
        Email.setFont(font);
        Passwd=new JLabel("Password:-");
        Passwd.setFont(font);
        first_Name=new JTextField(10);
        last_Name=new JTextField(10);
        email=new JTextField(10);
        passwd=new JPasswordField(10);
        //Position
        Jpannel.setBounds(100,20,300,200);
        //Adding
        Jpannel.add(First_Name);
        Jpannel.add(first_Name);
        Jpannel.add(Last_Name);
        Jpannel.add(last_Name);
        Jpannel.add(Email);
        Jpannel.add(email);
        Jpannel.add(Passwd);
        Jpannel.add(passwd);
        Jframe.add(Jpannel);
        //Jframe adjustments
        Jframe.setVisible(true);
        Jframe.setResizable(false);
        Jframe.setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
    }
}



