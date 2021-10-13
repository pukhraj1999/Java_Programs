package GUIDE;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

import javax.swing.undo.*;
import javax.swing.text.*;
import javax.swing.event.*;

public class HPad {

   public static void main(String[] args) {
        new Pad();
   }
}

class Pad {
    //Variables
    private int Height=500;
    private int Width=500;
    private int width=100;
    private int height=20;
    private int center=80;
    private int extraHeight=30;
    private int extraWidth=200;
    private Font font=new Font("Monaco",Font.BOLD,60);

    private JEditorPane text;
    private UndoManager manager;
    //Members
    Pad(){
        Home();
    }

    public void Home (){
        //Managers
        manager=new UndoManager();
        //Frame
        JFrame frame = new JFrame("HPad");
        frame.setSize(Width,Height);
        //Menus
        JMenuBar menubar=new JMenuBar();
        JMenu file=new JMenu("File");
        JMenu edit=new JMenu("Edit");
        JMenu view=new JMenu("View");
        //File items
        JMenuItem open=new JMenuItem("Open");
        JMenuItem close=new JMenuItem("Close");
        JMenuItem save=new JMenuItem("Save");
        JMenuItem exit=new JMenuItem("Exit");
        
        file.add(open);
        file.add(save);
        file.add(close);
        file.add(exit);
        //Edit items
        JMenuItem undo=new JMenuItem("Undo");
        JMenuItem redo=new JMenuItem("Redo");
        JMenuItem cut=new JMenuItem("Cut");
        JMenuItem copy=new JMenuItem("Copy");
        JMenuItem paste=new JMenuItem("Paste");
        JMenuItem selectAll=new JMenuItem("SelectAll");

        edit.add(undo);
        edit.add(redo);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        //View
        JMenu size=new JMenu("Size");
        JMenu style=new JMenu("Style");
        JMenu font=new JMenu("Font");
        JMenuItem html=new JMenuItem("Html");

        //Size
        view.add(size);
        view.add(style);
        view.add(font);
        view.add(html);
        //Scroll Pannel
  
        //Functionality
            //File
        open.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFileChooser fileChooser=new JFileChooser();
                int options=fileChooser.showOpenDialog(open);
                if(options== JFileChooser.APPROVE_OPTION) {
                    File file=fileChooser.getSelectedFile();    
                    String filepath=file.getPath();
                    try{
                        BufferedReader bufferReader=new BufferedReader(new FileReader(filepath));
                        String line="",content="";
                        while(line!=null){
                            line=bufferReader.readLine();
                            content+=line+"\n";
                        }
                        text.setText(content);
                        bufferReader.close();    
                    }catch(Exception ex){
                        System.out.println(ex);
                    }  
                } 
            }
        });
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               JFileChooser fileChooser = new JFileChooser();
               int option = fileChooser.showSaveDialog(text);
               if(option == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    System.out.println("File Saved:-"+file.getName()+file.getAbsolutePath());
                    //Saves the file
                    File saveFile = new File(file.getParentFile(), file.getName());
                    try {
                        text.write(new OutputStreamWriter(new FileOutputStream(saveFile),"utf-8"));
                    } catch (Exception ec) {
                        ec.printStackTrace();
                    }
                }
            }
        });
        close.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                text.setContentType("text/plain");
                text.setText("");
            }
        });     
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });     
        //Edit

        undo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    manager.undo();
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
        });    
        redo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    manager.redo();
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
        });     
        cut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                text.cut();
            }
        });
        copy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                text.copy();
            }
        });
        paste.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                text.paste();
            }
        });
        selectAll.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                text.selectAll();
            }
        });
            //View
        size.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });  
        html.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String content=text.getText();
                text.setContentType("text/html");
                text.setText(content);
            }
        });
        //Widgets
        text=new JEditorPane();
        text.setContentType("text/txt");
        text.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				manager.addEdit(e.getEdit());
			}
        });
        //Font and color

        //Spawning at center
        //// Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width-Width)/2;
        int y = (dim.height-Height-150)/2;
        frame.setLocation(x,y);
        //Position
        //text.setBounds(0,0,dim.width,dim.height);
        //Add
        menubar.add(file);
        menubar.add(edit);
        menubar.add(view);
        frame.add(text); 
        frame.setJMenuBar(menubar);
        frame.getContentPane().add(new JScrollPane(text));
        //Frame adjustments
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
