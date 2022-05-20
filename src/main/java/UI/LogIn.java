package UI;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;

import java.awt.Color;
import java.awt.EventQueue;

import javax.servlet.http.Cookie;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;

public class LogIn {
	private JFrame LOGIN;
	private JTextField txtUserName;
	private JPasswordField passwordField;
	String cookie;

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
		btnLogIn.addActionListener(e->{
			try {
				if(login(txtUserName.getText(),String.valueOf(passwordField.getPassword())))
				{
					MainMenu MM = new MainMenu(cookie);
					MM.MainMenu.setVisible(true);
					LOGIN.dispose();

				}
				else {
					JOptionPane.showMessageDialog(null, " The account name or password that you have entered is incorrect.\n ", "Error", 0);

				}
			} catch (Exception ioException) {
				ioException.printStackTrace();
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
	public boolean login(String username, String password) throws IOException {
		HttpGet request = new HttpGet("http://localhost:8080/login");
		String auth = username + ":" + password;
		byte[] encodedAuth = Base64.getEncoder().encode(
				auth.getBytes(StandardCharsets.ISO_8859_1));
		String authHeader = "Basic " + new String(encodedAuth);
		request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);




		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(request);
		if (response.getStatusLine().getStatusCode()!=200){
			return false;
		}
		Header[] headers = response.getHeaders("Set-Cookie");
		Pattern pattern = Pattern.compile("=(.*?);");
		Matcher matcher = pattern.matcher(headers[0].getValue().toString());
		if (matcher.find()) {
			cookie=matcher.group(1);
		}
		return true;
	}


}
