package com.example.EEmployee.UI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class LogIn {

	private JFrame LOGIN;
	private JTextField txtUserName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.LOGIN.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LOGIN = new JFrame();
		LOGIN.setTitle("LOGIN");
		LOGIN.setBounds(100, 100, 450, 300);
		LOGIN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LOGIN.getContentPane().setLayout(null);
		LOGIN.setResizable(false);
		JLabel lblUserName = new JLabel("USERNAME");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserName.setBounds(69, 54, 126, 14);
		LOGIN.getContentPane().add(lblUserName);

		txtUserName = new JTextField();
		txtUserName.setBounds(194, 47, 221, 27);
		LOGIN.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(67, 90, 89, 20);
		LOGIN.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(190, 93, 227, 27);
		LOGIN.getContentPane().add(passwordField);

		JButton btnLogIn = new JButton("LOGIN");
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogIn.setBounds(323, 178, 89, 38);
		btnLogIn.setBackground(new Color(192, 192, 192));
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtUserName.getText().equals("user") && passwordField.getText().equals("123")) {
					MainMenu MM = new MainMenu();
					MM.MainMenu.setVisible(true);
					LOGIN.dispose();
				} else {
					JOptionPane.showMessageDialog(null, " Wrong Username or Password ", "Error", 0);

				}

			}
		});

		LOGIN.getContentPane().add(btnLogIn);

		JCheckBox chckShowPass = new JCheckBox("Show Password");
		chckShowPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (chckShowPass.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('*');
				}
			}
		});
		chckShowPass.setBounds(191, 148, 140, 23);
		LOGIN.getContentPane().add(chckShowPass);
	}
}
