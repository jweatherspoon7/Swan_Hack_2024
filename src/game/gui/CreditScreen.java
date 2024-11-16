package game.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class CreditScreen extends JFrame {
	
	public CreditScreen()
	{
		super("Credit Screen");
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		
		// Creating a new label of title
        JLabel credit = new JLabel();
        
        JLabel text = new JLabel("Made by SIGMA CODERS");
        
        JLabel gojo = new JLabel("Jujutsu Kaisen © Gege Akutami / MAPPA / Shueisha");
        
        JLabel swan = new JLabel("Made for Swan Hacks");
        

        // Creating instance of JButton
        JButton back = new JButton(" Back ");
        
        back.setPreferredSize(new Dimension(80, 5));
        

        // Adding actions to buttons
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new TitleScreen();
        		CreditScreen.this.dispose();

        	}
        });

        c.gridx = 0;
		 c.gridy = 1;
		 c.ipadx = 15;
		 c.ipady = 50;
        // adding buttons in JFrame
        add(back, c);
        
        c.gridx = 0;
		 c.gridy = 0;
		 c.ipadx = 15;
		 c.ipady = 550;
        //adding text in JFrames
        add(text, c);
        
        
        
        c.gridx = 0;
		 c.gridy = 2;
		 c.ipadx = 15;
		 c.ipady = 50;
        //Gojo
        add(gojo, c);
        
        
        c.gridx = 0;
		 c.gridy = 1;
		 c.ipadx = 15;
		 c.ipady = 50;
        add(swan,c);
        
        //resize text
        Font font = new Font("Arial", Font.PLAIN, 50);
        
        text.setFont(font);
        // 400 width and 500 height
        setSize(500, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 


        // making the frame visible
        setVisible(true);
	}
	

}
