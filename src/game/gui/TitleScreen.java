package game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class TitleScreen extends JFrame
{
	public TitleScreen()
	{
		super("Title Screen");
		setLayout(null);
		// Creating a new label of title
        JLabel title = new JLabel();
        

        // Creating instance of JButton
        JButton button = new JButton(" Start ");
        JButton exit = new JButton(" Exit ");
        JButton credits = new JButton(" Credits ");

        // x axis, y axis, width, height
        button.setBounds(150, 200, 200, 50);
        exit.setBounds(150, 300, 200, 50);
        credits.setBounds(150, 400, 200, 50);
        
        // Adding actions to buttons
        exit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TitleScreen.this.dispatchEvent(new WindowEvent(TitleScreen.this, WindowEvent.WINDOW_CLOSING));
        	}
        });
        
        
        

        // adding buttons in JFrame
        add(button);
        add(exit);
        add(credits);

        // 400 width and 500 height
        setSize(500, 600);


        // making the frame visible
        setVisible(true);
	}

}
