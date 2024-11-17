package game.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import game.App;

public class LevelOneScreen extends BaseLevelScreen
{
	private static int levelCounter = 0;

	
	public LevelOneScreen()
	{
		super("Level One", 1);
		
		if(levelCounter >= 3) 
		{
			new DialogueAfterLvlOne();
			LevelOneScreen.this.dispose();
			return;
		}
				
		String[] newProblem = App.emailsArr[levelCounter];
		levelCounter++;
		setupEmail(newProblem[0], newProblem[1], newProblem[2]); //setup email thingy
		
		gbc.insets = new Insets(1,30,10,5);
		
		//email config
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 4;
		gbc.gridheight = 0;
		gbc.weightx = 0.25;
		gbc.weighty = 0.25;
		add(emailPanel, gbc);
		
		gbc.insets = new Insets(1,5,1,5);
		//scam button
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		gbc.weightx = 0.01;
		gbc.weighty = 0.01;
		add(scamButton, gbc);
		
		gbc.insets = new Insets(1,5,1,30);
		//not scam button
		gbc.gridx = 5;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		add(notScamButton, gbc);
		
		gbc.insets = new Insets(1,5,30,5);
		gbc.gridx = 4;
		gbc.gridy = 8;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
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
					wrong();
				}
			}
		});
		
		notScamButton.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                if(newProblem[3].equals("true"))
                {
                	wrong();
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
	
	public void wrong()
	{
		Timer timer = new Timer(300, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new LevelOneScreen();
				LevelOneScreen.this.dispose();
			}
    	});
    	timer.setInitialDelay(200);
    	timer.setRepeats(false);
    	
    	
    	timer.start();
    	hurtGojo();
	}
}
