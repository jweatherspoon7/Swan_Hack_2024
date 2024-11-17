package game.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;

import game.App;

public class LevelOneScreen extends BaseLevelScreen
{
	private static int levelCounter = 0;

	
	public LevelOneScreen()
	{
		super("Level One", 1);
		
		if(levelCounter >= App.emailsArr.length) return; //go to next level
		
		String[] newProblem = App.emailsArr[levelCounter];
		levelCounter++;
		setupEmail(newProblem[0], newProblem[1], newProblem[2]); //setup email thingy
		
	    //title of the level
	    JLabel title = new JLabel("FIND OUT IF ITS A SCAM");
	    title.setFont(new Font("Arial", Font.PLAIN, 25));
		
	    gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 5;
		gbc.ipady = 30;
		add(title, gbc);
		
		//email config
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 4;
		add(emailPanel, gbc);
		
		//scam button
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		add(scamButton, gbc);
		
		//not scam button
		gbc.gridx = 5;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		add(notScamButton, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 8;
		gbc.gridwidth = 0;
		gbc.gridheight = 0;
		add(revealEmailList, gbc);

		scamReasonsDialog.add(isWrongDomain, gbc);
		
		scamReasonsDialog.add(submitButton, gbc);
		scamReasonsDialog.add(undoScamButton, gbc);
		
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isWrongDomain.isSelected() && newProblem[3].equals("true") && newProblem[4].equals("true"))
				{
					new LevelOneScreen();
					LevelOneScreen.this.dispose();
					victory.setVisible(true);
				}
				else
				{
					new LevelOneScreen();
					LevelOneScreen.this.dispose();
					lost.setVisible(true);
				}
			}
		});
		
		notScamButton.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                if(newProblem[3].equals("true"))
                {
                	new LevelOneScreen();
					LevelOneScreen.this.dispose();
                	lost.setVisible(true);
                }
                else
                {
                	new LevelOneScreen();
					LevelOneScreen.this.dispose();
                	victory.setVisible(true);
                }
            }
		});
		
		
		setVisible(true);
	}
}
