package game.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

	
	public class Win extends JFrame{
		
		public Win(){
		
			super("Win");
			setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
			
			ImageIcon gojo_wins = new ImageIcon("animation (1).gif");
			 
	         // Resize the image
			
			JLabel you_wins = new JLabel("You Win!");
	 
	            
	         JLabel gojo = new JLabel(gojo_wins);
	         
	         
	         you_wins.setHorizontalAlignment(JLabel.CENTER);
	         
	         you_wins.setAlignmentX(CENTER_ALIGNMENT);
	         gojo.setAlignmentX(CENTER_ALIGNMENT);
	         
	         
	        
	         
	         
	         add(you_wins);
	         add(Box.createVerticalStrut(50));
	       	 add(gojo);
	       	 
	       	Font font = new Font("Arial", Font.PLAIN, 90);
	       	
	       	you_wins.setFont(font);
	       	 
	       	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		     setExtendedState(JFrame.MAXIMIZED_BOTH);
		     setVisible(true);  
			
			
			
		}

}
