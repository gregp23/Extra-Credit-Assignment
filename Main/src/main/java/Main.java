import java.awt.Color;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.*;
import java.awt.Dimension;

class Main extends JFrame {
   
  public static void main(String[] args) throws Exception {
   
     //PokeDex HashMap
    HashMap <Integer, String> pokedex = new HashMap<>();/
    
   //Text file that stores akk the Pokemon names
  File file = new File("/Users/greg/NetBeansProjects/Main/pokemon.txt");
  Scanner scanner = new Scanner(file);
     
   //Array to store photos of the Pokemon 
  String[] icon = {"/Users/greg/NetBeansProjects/Main/pokeball.jpg",
      "/Users/greg/NetBeansProjects/Main/bulbasaur.jpg",
    "/Users/greg/NetBeansProjects/Main/ivy.jpg",
    "/Users/greg/NetBeansProjects/Main/veny.jpg",
    "/Users/greg/NetBeansProjects/Main/charman.jpg", 
    "/Users/greg/NetBeansProjects/Main/meleon.jpg",
    "/Users/greg/NetBeansProjects/Main/charzard.jpg",
    "/Users/greg/NetBeansProjects/Main/squirt.jpg",
    "/Users/greg/NetBeansProjects/Main/war.jpg",
    "/Users/greg/NetBeansProjects/Main/blast.jpg"};
  
    //Iterator add names and photos to the PokeDex HashMap
    for(int i = 1; i <= 15; i++){
       String pokeName = scanner.next();
      pokedex.put(i, pokeName); 
    }
    System.out.println(pokedex.toString());
       //1. Create the frame.
    JFrame frame = new JFrame("Mini Pokedex");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       //2.Add components for the window
  final  JLabel imageLabel = new JLabel();
    JLabel title = new JLabel();
    JLabel name = new JLabel();
    JButton button = new JButton("Search");
    JTextField textBox = new JTextField();
    
       //3.Properties for title JLabel
    title.setLocation(30,10);
    title.setForeground(Color.YELLOW);
    title.setText("Pokémon   PokéDex");
    title.setFont(new java.awt.Font("Impact",0,24));
    title.setSize(300,40);
    
       //4.Properties for name JLabel
    name.setLocation(75,10);
    name.setForeground(Color.WHITE);
    name.setText("Pokémon Name");
    name.setFont(new java.awt.Font("Impact",0,25));
    name.setSize(240,800);
    name.setVisible(false);
       //5.Properties for button
    button.setLocation(150, 50);
    button.setSize(83,32);
    button.setFont(new java.awt.Font("Impact", 0, 13)); // NOI18N
    
        //6. Properties for textbox
    textBox.setSize(83,32);
    textBox.setLocation(25, 50);
    
        //7.Properties for JLabel/Image
        ImageIcon image = new ImageIcon(icon[0]);
        imageLabel.setIcon(image);
        
        
    
    //7. Properties for the JFrame
    frame.add(textBox);
    frame.getContentPane().add(button);
    frame.getContentPane().add(title);
    frame.getContentPane().add(name);
   frame.add(imageLabel);
    frame.getContentPane().setBackground(Color.darkGray);
    frame.setSize(270,500);
    frame.setVisible(true);
    imageLabel.setLocation(25, 30);
    button.addActionListener(new ActionListener(){  
        @Override
        
        public void actionPerformed(ActionEvent e){ 
            String numBox = textBox.getText();
            Integer value = Integer.parseInt(numBox);

            if(pokedex.containsKey(value)){
                

                name.setText(pokedex.get(value).toString());
                name.setVisible(true);
                imageLabel.setIcon(new ImageIcon(icon[value]));

            }
         } });
    

  }
  
}
