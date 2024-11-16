package game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class CreditScreen extends JFrame {
	
	public CreditScreen()
	{
		super("Credit Screen");
		setLayout(null);
		// Creating a new label of title
        JLabel credit = new JLabel();
        
        JLabel text = new JLabel("Made by SIGMA CODERS");
        

        // Creating instance of JButton
        JButton back = new JButton(" Back ");

        // x axis, y axis, width, height
        back.setBounds(150, 300, 200, 50);
        text.setBounds(50,50,200,50);

        // Adding actions to buttons
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new TitleScreen();
        		CreditScreen.this.dispose();

        	}
        });

        // adding buttons in JFrame
        add(back);
        
        //adding text in JFrames
        add(text);
        
        //resize text
        Font font = new Font("Arial", Font.PLAIN, 24);
        
        // 400 width and 500 height
        setSize(500, 600);


        // making the frame visible
        setVisible(true);
	}
	

}
