package GUIDE;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Basics {
    public static void main(String[] args) {
        new CheckBox();        
    }    
}
class Button{
    //Variables
    private JFrame Jframe;

    //Methods
    Button(){
        //Creating new frame
        Jframe=new JFrame("Buttons");
        //size of frame
        Jframe.setSize(250,250);
        //Creating buttons 
        JButton btn1=new JButton("Click");
        JButton btn2=new JButton("Click");
        //Creating button containing icon
        JButton btn3=new JButton(new ImageIcon("apple_tv_button.png"));
        //Setting location of button
        btn1.setBounds(10,30, 100, 30 );
        btn2.setBounds(10, 60, 100, 30);
        btn3.setBounds(10, 100, 100, 100);
        //Setting text of button
        btn2.setText("Sexy");
        //Getting text of button
        String text=btn2.getText();
        System.out.println(text);
        //Adding functionality in buttons 
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                btn1.setText("Yo");
            }
        });
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                btn2.setText("What's up?");
            }
        });
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                btn2.setText("Fuck You!");
            }
        });
        //Adding functions to frame
        Jframe.add(btn1);
        Jframe.add(btn2);
        Jframe.add(btn3);
        //Setting layout and visibility
        Jframe.setLayout(null);
        Jframe.setVisible(true);
        //Close the program
        Jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Label_TextField{
    //Variables
    private JFrame Jframe;
    private int Height=500;
    private int Width=500;

    //Members
    Label_TextField(){
        Jframe=new JFrame("IpFinder");
        Jframe.setSize(Width, Height);
        //Widgets
        JLabel l1=new JLabel("Hi there");
        JTextField tf1=new JTextField();
        JButton btn1=new JButton("Find Ip");
        JLabel Ip=new JLabel("");
        //Positions
        l1.setBounds(220, 20, 100, 30);
        tf1.setBounds(170,50,150,30);
        btn1.setBounds(200, 90, 100, 30);
        Ip.setBounds(120,120,300,30);
        //Functionality
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    String host=tf1.getText();
                    //Getting Ip Address
                    String ip=java.net.InetAddress.getByName(host).getHostAddress();
                    Ip.setText("Ip of "+host+" is "+ip);
                    tf1.setText("");
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
        });
        //Adding in frame
        Jframe.add(l1);
        Jframe.add(tf1);
        Jframe.add(btn1);
        Jframe.add(Ip);
        //Jframe adjustments
        Jframe.setLayout(null);
        Jframe.setVisible(true);
        Jframe.setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
    }
}

class TextArea{
    //Variables
    private JFrame Jframe;
    private int Height=500;
    private int Width=500;

    //Members
    TextArea(){
        Jframe=new JFrame("Counter");
        Jframe.setSize(Width, Height);
        //Widgets
        JLabel l1=new JLabel("Write your Thoughts:");
        JTextArea text=new JTextArea();
        JButton count=new JButton("Count");
        JLabel words=new JLabel("");
        JLabel characters=new JLabel("");
        //Position
        l1.setBounds(180,10,Width,30);
        text.setBounds(0,50,Width,300);
        count.setBounds(200,360,100,30);
        words.setBounds(0,360,Width,30);
        characters.setBounds(0, 380, Width, 30);
        //Functionality
        count.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String txt=text.getText();
                int Words=0,Characters=0;
                for(int i=0;i<txt.length();i++){
                    if(txt.charAt(i)==' ')
                        Words++;
                    else
                        Characters++;
                }
                Words++;//Storing last word
                words.setText("Words:"+Words);
                characters.setText("Characters:"+Characters);
            }
        });
        //Adding in frame
        Jframe.add(l1);
        Jframe.add(text);
        Jframe.add(count);
        Jframe.add(words);
        Jframe.add(characters);
        //Jframe adjustments
        Jframe.setLayout(null);
        Jframe.setVisible(true);
        Jframe.setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
    }
}

class PasswordField{
    //Variables
    private JFrame Jframe;
    private int Height=150;
    private int Width=250;
    private int width=100;
    private int height=20;

    //Members
    PasswordField(){
        Jframe=new JFrame("Password");
        Jframe.setSize(Width, Height);
        //Widgets
        JLabel name=new JLabel("Name:-");
        JLabel passwd=new JLabel("Password:-");
        JTextField Name=new JTextField(); 
        JPasswordField Passwd=new JPasswordField();
        JButton login=new JButton("Log in");
        //Position
        name.setBounds(20, 10, width, height);
        Name.setBounds(120, 10, width, height);
        
        passwd.setBounds(20, 40, width, height);
        Passwd.setBounds(120, 40, width, height);

        login.setBounds(80, 70, width, height);
        //Adding in frame
        Jframe.add(name);
        Jframe.add(Name);
        Jframe.add(passwd);
        Jframe.add(Passwd);
        Jframe.add(login);
        //Jframe adjustments
        Jframe.setLayout(null);
        Jframe.setVisible(true);
        Jframe.setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
    }
}

class CheckBox{
    //Similarly RadioBox

    //Variables
    private JFrame Jframe;
    private int Height=250;
    private int Width=250;
    private int width=100;
    private int height=20;
    private int extraWidth=200;
    private Font font=new Font("Monaco",Font.BOLD,15);

    //Members
    CheckBox(){
        Jframe=new JFrame("Menu");
        Jframe.setSize(Width, Height);
        //Widgets
        JCheckBox c1=new JCheckBox("Coffee $50");
        JCheckBox c2=new JCheckBox("Tea $40");
        JCheckBox c3=new JCheckBox("Samosa $20");
        JCheckBox c4=new JCheckBox("Burger $30");
        JButton order=new JButton("Order");
        JLabel TotalAmount=new JLabel("");
        //Position
        c1.setBounds(60, 10, width+extraWidth, height);
        c2.setBounds(60, 40, width+extraWidth, height);
        c3.setBounds(60, 70, width+extraWidth, height);
        c4.setBounds(60, 100, width+extraWidth, height);
        order.setBounds(60, 130, width, height);
        TotalAmount.setBounds(60, 160, width+extraWidth, height);
        //Setting font
        c1.setFont(font);
        c2.setFont(font);
        c3.setFont(font);
        c4.setFont(font);
        TotalAmount.setFont(font);
        //Functionality
        order.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int amount=0;
                String msg="";
                if(c1.isSelected())
                    amount+=50;
                if(c2.isSelected())
                    amount+=40;
                if(c3.isSelected())
                    amount+=20;
                if(c4.isSelected())
                    amount+=30;
                msg+="Total Amount:$ "+amount;
                TotalAmount.setText(msg);
            }
        });
        //Adding in frame
        Jframe.add(c1);
        Jframe.add(c2);
        Jframe.add(c3);
        Jframe.add(c4);
        Jframe.add(order);
        Jframe.add(TotalAmount);
        //Jframe adjustments
        Jframe.setLayout(null);
        Jframe.setVisible(true);
        Jframe.setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
    }
}
