package com.bayviewglen.maingame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class UsernameMissing {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsernameMissing window = new UsernameMissing(null, null, null, null, null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param users 
	 * @param newUser 
	 * @param string2 
	 * @param string 
	 */
	public UsernameMissing(ArrayList<User> users, String username, String password, int[] login, boolean[] newUser) {
		initialize(users, username, password, login, newUser);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param users 
	 * @param password 
	 * @param username 
	 * @param login 
	 * @param newUser 
	 */
	private void initialize(ArrayList<User> users, String username, String password, int[] login, boolean[] newUser) {
		frame = new JFrame();
		frame.setBounds(100, 100, 503, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSorryThatUsername = new JLabel("Sorry! That username does not exist! \r\n Would you like ");
		lblSorryThatUsername.setBounds(41, 37, 401, 28);
		frame.getContentPane().add(lblSorryThatUsername);
		
		JLabel lblToCreateAn = new JLabel("to create an accound with that username?");
		lblToCreateAn.setBounds(43, 62, 378, 20);
		frame.getContentPane().add(lblToCreateAn);
		
		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean[] newAchivement = {false, false, false, false, false};
				users.add(new User(username,password, new Achivement(newAchivement), new Highscores(0, username, 0, 0, 0),0,0, null, null, 0));
				newUser[0] = true;
				frame.setVisible(false);
				login[0] = 100;
			}
		});
		btnYes.setBounds(100, 175, 115, 29);
		frame.getContentPane().add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNo.setBounds(251, 175, 115, 29);
		frame.getContentPane().add(btnNo);
	}
}
