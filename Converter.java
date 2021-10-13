package GUIDE;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Converter {

   public static void main(String[] args) {
        new Active();
   }
}

class Active{
    //Variables
    private int Height=500;
    private int Width=500;
    private int width=100;
    private int height=20;
    private int center=80;
    private int extraHeight=30;
    private int extraWidth=200;
    private Font font=new Font("Monaco",Font.BOLD,60);

    private String option;

    //Members
    Active(){
        HomePage();
    }

    public void HomePage(){
        //Frame
        JFrame frame = new JFrame("Decimal Converter");
        frame.setSize(Width,Height-150);
        //Widgets
        JLabel title=new JLabel("Converter");
        JButton binary = new JButton("Binary");
        JButton octal = new JButton("Octal");
        JButton hexaDecimal = new JButton("HexaDecimal");
        JLabel about=new JLabel("Made by Pukhraj");
        //Font and color
        title.setFont(font);
        binary.setFont(new Font("Monaco",Font.BOLD,40));
        octal.setFont(new Font("Monaco",Font.BOLD,40));
        hexaDecimal.setFont(new Font("Monaco",Font.BOLD,35));
        //Position
        title.setBounds(center,10,Width,height+extraHeight);
        binary.setBounds(center+20,70,width+extraWidth,height+extraHeight);
        octal.setBounds(center+20,140,width+extraWidth,height+extraHeight);
        hexaDecimal.setBounds(center+20,210,width+extraWidth,height+extraHeight);
        about.setBounds(Width-120,Height-220,width+extraWidth,height+extraHeight);
        //Spawning at center
        //// Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width-Width)/2;
        int y = (dim.height-Height-150)/2;
        frame.setLocation(x,y);
        //Functionality
        binary.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                option="Binary";
                Convert();
            }
        });
        octal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                option="Octal";
                Convert();
            }
        });
        hexaDecimal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                option="hexaDecimal";
                Convert();
            }
        });
        //Add
        frame.add(title);
        frame.add(binary);
        frame.add(octal);
        frame.add(hexaDecimal);
        frame.add(about);
        //Frame adjustments
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void Convert(){
        //Frame
        JFrame frame = new JFrame("Convert "+option+" to Decimal");
        frame.setSize(Width, Height-200);
        //Widgets
        JTextField text=new JTextField(10);
        JButton decimal = new JButton("Decimal");
        JLabel answer=new JLabel();
        JButton back=new JButton("Back");
        JButton clear=new JButton("Clear");
        JButton reverse=new JButton("Reverse");
        //Font and color
        text.setFont(new Font("Monaco",Font.BOLD,40));
        decimal.setFont(new Font("Monaco",Font.BOLD,40));
        answer.setFont(new Font("Monaco",Font.BOLD,20));
        back.setFont(new Font("Monaco",Font.BOLD,20));
        clear.setFont(new Font("Monaco",Font.BOLD,20));
        reverse.setFont(new Font("Monaco",Font.BOLD,20));
        //Position
        text.setBounds(center+20,30,width+extraWidth,height+extraHeight);
        decimal.setBounds(center+20,100,width+extraWidth,height+extraHeight);
        answer.setBounds(center+70,150,Width,height+extraHeight);
        back.setBounds(10,200,width,height+extraHeight);
        clear.setBounds(Width-120,200,width,height+extraHeight);
        reverse.setBounds(Width-340,200,2*width-50,height+extraHeight);
        //Spawning at center
        //// Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width-Width)/2;
        int y = (dim.height-Height-150)/2;
        frame.setLocation(x,y);
        //Functionality
        decimal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(option=="Binary"){
                    int num=Integer.parseInt(text.getText(),2);
                    answer.setText("Dec:- "+num);
                    text.setText("");
                }else if(option=="Octal"){
                    int num=Integer.parseInt(text.getText(),8);
                    answer.setText("Dec:- "+num);
                    text.setText("");
                }else{
                    int num=Integer.parseInt(text.getText(),16);
                    answer.setText("Dec:- "+num);
                    text.setText("");
                }
            }
        });
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                HomePage();
            }
        });
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                answer.setText("");
            }
        });
        reverse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(option=="Binary"){
                    answer.setText("Binary:- "+Integer.toBinaryString(Integer.parseInt(text.getText())));
                    text.setText("");
                }else if(option=="Octal"){
                    answer.setText("Oct:- "+Integer.toOctalString(Integer.parseInt(text.getText())));
                    text.setText("");
                }else{
                    answer.setText("Hexa:- "+Integer.toHexString(Integer.parseInt(text.getText())));
                    text.setText(""); 
                }
            }
        });
        //Add
        frame.add(text);
        frame.add(decimal);
        frame.add(answer);
        frame.add(back);
        frame.add(clear);
        frame.add(reverse);
        //Frame adjustments
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
