package game.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public abstract class BaseLevelScreen extends JFrame
{
	protected GridBagLayout grid = new GridBagLayout();
	protected GridBagConstraints gbc = new GridBagConstraints();
	
	//elements to be shared between objects
	protected JPanel emailPanel;
	
	protected JPanel phonePanel;
	
	//button if player wants to report spam
	protected JButton scamButton = new JButton("SCAM");
		
	//button if player wants say not sapm
	protected JButton notScamButton = new JButton("NOT SCAM");
	
	protected JDialog scamReasonsDialog = new JDialog(this, "Reasons", true);
	
	protected JDialog trustedEmailsDialog = new JDialog(this, "List of Trusted Emails", true);
	
	protected JDialog victory = new JDialog();
	
	protected JDialog lost = new JDialog();
	
	protected JButton revealEmailList = new JButton("List of Trusted Emails");
	
	protected JCheckBox isWrongDomain = new JCheckBox("A) Sus email domain");  
	
	protected JButton undoScamButton = new JButton("back");
		
	protected JButton submitButton = new JButton("submit");
	
	protected ImageIcon gojo = new ImageIcon("Gojo_Satoru.WEBP-ezgif.com-webp-to-jpg-converter.jpg");
	
	protected ImageIcon hurtGojo = new ImageIcon("hurtGOJO.jpg");
	
	protected JLabel gojoPicture = new JLabel(gojo);
	
	protected Clip gojoHurtSound;

	protected Clip gojoLaugh;
	
	public BaseLevelScreen(String title, int reasonsAmount)
	{
		super(title);
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(grid);
		
		gojo = new ImageIcon("Gojo_Satoru.WEBP-ezgif.com-webp-to-jpg-converter.jpg");
		hurtGojo = new ImageIcon("hurtGOJO.jpg");
		
		revealEmailList.setSize(50, 30);
		scamReasonsDialog.setSize(300, 300);
		scamReasonsDialog.setLayout(new GridLayout(reasonsAmount + 3, -1));
		scamReasonsDialog.add(new JLabel("Why is this a scam?"));
		
		trustedEmailsDialog.setSize(300,300);
		trustedEmailsDialog.setLayout(new GridLayout(5, -1));
		trustedEmailsDialog.add(new JLabel("McAfee@mcafee.com"));
		trustedEmailsDialog.add(new JLabel("boss@businessgmail.com"));
		trustedEmailsDialog.add(new JLabel("hiring@bigcompany.com"));
		trustedEmailsDialog.add(new JLabel("hiring@bigcompany.com"));
		trustedEmailsDialog.add(new JLabel("deals@topshoppingstore.com"));
		
		//hiring@bigcompany.com deals@topshoppingstore.com
		
		victory.setSize(300,300);
		victory.add(new JLabel("GJ"));
		
		lost.setSize(300,300);
		lost.add(new JLabel("BAD"));
		
		JLabel findScamLabel = new JLabel("FIND OUT IF ITS A SCAM");
	    findScamLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		    
	    gbc.insets = new Insets(1,30,2,0);
	    gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 3;
		gbc.ipady = 10;
		gbc.ipadx = 20;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		add(findScamLabel, gbc);
				
        gbc.gridx = 2;
		gbc.gridy = 0;
		add(gojoPicture, gbc);
		
		revealEmailList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trustedEmailsDialog.setVisible(true);
			}
			
		});
		
		scamButton.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {

				scamReasonsDialog.setVisible(true);
								
            }
		});
		
		undoScamButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				scamReasonsDialog.setVisible(false);
				isWrongDomain.setSelected(false);
			}
		});
		
		File sound = new File("Man screaming (Original meme)-[AudioTrimmer.com].wav");

		File sound1 = new File("gojo_laugh.wav");
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(sound);
			AudioInputStream audio1 = AudioSystem.getAudioInputStream(sound1);
            gojoHurtSound = AudioSystem.getClip();
            gojoLaugh = AudioSystem.getClip();
            
            gojoHurtSound.open(audioStream);
            gojoLaugh.open(audio1);
            
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	 	
	/**
	 * class to set up panel for email
	 */
	protected void setupEmail(String subject, String email, String message)
	{
		emailPanel = new JPanel(); 
		
		emailPanel.setBackground(Color.WHITE);

		emailPanel.setLayout(new GridLayout(3,1));
				
		//add title of email
		JLabel eTitle = new JLabel(subject);
	
		emailPanel.add(eTitle);
		
		//add sender of email
		JLabel eSender = new JLabel(email);
	
		emailPanel.add(eSender);
		
		JTextArea eMessage = new JTextArea(message);
		eMessage.setEditable(false);
		eMessage.setEnabled(false);
		eMessage.setLineWrap(true);

		emailPanel.add(eMessage);
	}
	
	protected void setupPhone(String phoneNum, JButton play, JButton stop)
	{
		phonePanel = new JPanel();
		
		phonePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		phonePanel.setLayout(new GridLayout(3,1));
		
		phonePanel.add(new JLabel(phoneNum));
		
		phonePanel.add(play);
		phonePanel.add(stop);
	}
	
	protected void hurtGojo()
	{
	       
		Timer timer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				gojoPicture.setIcon(gojo);
			    gojoPicture.repaint();
			}
			
		});
		
		 timer.setRepeats(false);
         timer.setInitialDelay(100);
         timer.start();
         
         gojoPicture.setIcon(hurtGojo);
		 gojoPicture.repaint();
		 gojoHurtSound.stop(); // Stop the clip if it's already playing
		 gojoHurtSound.setFramePosition(0); // Reset the clip to the beginning
		 gojoHurtSound.start(); // Play the clip
	}
	
	protected void winSound()
	{
		 gojoLaugh.stop(); // Stop the clip if it's already playing
		 gojoLaugh.setFramePosition(0); // Reset the clip to the beginning
		 gojoLaugh.start(); // Play the clip
	}
}
