package game;

import java.io.*;
import javax.swing.*;

public class App 
{
	//inital window for the game
	private static void initWindow()
	{
		// Creating instance of JFrame
        JFrame frame = new JFrame();

        // Creating instance of JButton
        JButton button = new JButton(" test ");

        // x axis, y axis, width, height
        button.setBounds(150, 200, 220, 50);

        // adding button in JFrame
        frame.add(button);

        // 400 width and 500 height
        frame.setSize(500, 600);

        // using no layout managers
        frame.setLayout(null);

        // making the frame visible
        frame.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		initWindow();
	}

}
