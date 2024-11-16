package game.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class LevelOneScreen extends BaseLevelScreen
{
	
	public LevelOneScreen()
	{
		super("Level One");
		
		//make margins on page
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		 gbc.fill = GridBagConstraints.VERTICAL;  
	    gbc.gridx = 0;  
	    gbc.gridy = 0;  
				
		JPanel emailPanel = new JPanel();
		GridBagLayout ePGBL = new GridBagLayout();
		GridBagConstraints ePGBC = new GridBagConstraints();
		
		emailPanel.setBackground(Color.WHITE);
		
		add(emailPanel);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridwidth = 4;
		
		
		
		setVisible(true);
	}

}
