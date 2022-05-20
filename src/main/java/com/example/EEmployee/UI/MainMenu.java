package com.example.EEmployee.UI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu {

	JFrame MainMenu;
	private JTable table;
	private JTextField txtSearch;
	static DefaultTableModel model;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtRole;
	private JTextField txtJob;
	private JTextField txtSalary;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtBD;
	private JTextField txtId;
	TableRowSorter<DefaultTableModel> ts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.MainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void getTable() {
		// TODO Auto-generated method stub
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MainMenu = new JFrame("Main Menu");
		MainMenu.setBounds(100, 100, 1112, 669);
		MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainMenu.getContentPane().setLayout(null);
		MainMenu.setResizable(false);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1098, 643);
		panel.setBackground(new Color(211, 211, 211));
		MainMenu.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel buttons = new JPanel();
		buttons.setBackground(new Color(220, 220, 220));
		buttons.setBounds(135, 562, 897, 59);
		panel.add(buttons);
		buttons.setLayout(null);

		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(265, 40, 49, 14);
		panel.add(lblSearch);

		JLabel lblID = new JLabel("ID");
		lblID.setBounds(10, 86, 49, 14);
		panel.add(lblID);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 125, 49, 14);
		panel.add(lblName);

		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(10, 203, 49, 14);
		panel.add(lblRole);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 162, 49, 14);
		panel.add(lblAddress);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(10, 379, 49, 14);
		panel.add(lblPhone);

		JLabel lblJob = new JLabel("Job");
		lblJob.setBounds(10, 250, 49, 14);
		panel.add(lblJob);

		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setBounds(10, 290, 49, 14);
		panel.add(lblSalary);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 334, 49, 14);
		panel.add(lblEmail);

		JLabel lblBD = new JLabel("B-Date");
		lblBD.setBounds(10, 418, 49, 14);
		panel.add(lblBD);
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(78, 83, 167, 20);
		panel.add(txtId);

		txtName = new JTextField();
		txtName.setBounds(78, 122, 167, 20);
		panel.add(txtName);
		txtName.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(78, 159, 167, 20);
		panel.add(txtAddress);

		txtRole = new JTextField();
		txtRole.setColumns(10);
		txtRole.setBounds(78, 200, 167, 20);
		panel.add(txtRole);

		txtJob = new JTextField();
		txtJob.setColumns(10);
		txtJob.setBounds(78, 247, 167, 20);
		panel.add(txtJob);

		txtSalary = new JTextField();
		txtSalary.setColumns(10);
		txtSalary.setBounds(78, 287, 167, 20);
		panel.add(txtSalary);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(78, 331, 167, 20);
		panel.add(txtEmail);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(78, 376, 167, 20);
		panel.add(txtPhone);

		txtBD = new JTextField();
		txtBD.setColumns(10);
		txtBD.setBounds(78, 415, 167, 20);
		panel.add(txtBD);

		txtSearch = new JTextField();
		txtSearch.setBounds(324, 37, 708, 20);
		panel.add(txtSearch);
		txtSearch.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(265, 68, 767, 466);
		panel.add(scrollPane);

		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(59, 11, 168, 37);
		buttons.add(btnAdd);
		btnAdd.setBackground(new Color(192, 192, 192));
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (txtId.getText().equals("") || txtName.getText().equals("") || txtAddress.getText().equals("")
						|| txtRole.getText().equals("") || txtJob.getText().equals("") || txtSalary.getText().equals("")
						|| txtEmail.getText().equals("") || txtPhone.getText().equals("")
						|| txtBD.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter All Data!", "Error", 0);
				}
				

				else {
					Object data[] = { txtId.getText(), txtName.getText(), txtAddress.getText(), txtRole.getText(),
							txtJob.getText(), txtSalary.getText(), txtEmail.getText(), txtPhone.getText(),
							txtBD.getText() };

				
					model = (DefaultTableModel) table.getModel();
					model.addRow(data);
					txtId.setText("");
					txtName.setText("");
					txtAddress.setText("");
					txtRole.setText("");
					txtJob.setText("");
					txtSalary.setText("");
					txtEmail.setText("");
					txtPhone.setText("");
					txtBD.setText("");

				}
			}

		});

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(483, 11, 158, 37);
		buttons.add(btnUpdate);
		btnUpdate.setBackground(new Color(192, 192, 192));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Table is Empty.", "Alert", JOptionPane.WARNING_MESSAGE);
				}
				else {
				int SelectedRowIndex = table.getSelectedRow();
				model.setValueAt(txtId.getText(), SelectedRowIndex, 0);
				model.setValueAt(txtName.getText(), SelectedRowIndex, 1);
				model.setValueAt(txtAddress.getText(), SelectedRowIndex, 2);
				model.setValueAt(txtRole.getText(), SelectedRowIndex, 3);
				model.setValueAt(txtJob.getText(), SelectedRowIndex, 4);
				model.setValueAt(txtSalary.getText(), SelectedRowIndex, 5);
				model.setValueAt(txtEmail.getText(), SelectedRowIndex, 6);
				model.setValueAt(txtPhone.getText(), SelectedRowIndex, 7);
				model.setValueAt(txtBD.getText(), SelectedRowIndex, 8);
				txtId.setText("");
				txtName.setText("");
				txtAddress.setText("");
				txtRole.setText("");
				txtJob.setText("");
				txtSalary.setText("");
				txtEmail.setText("");
				txtPhone.setText("");
				txtBD.setText("");
				}
				
			}
		});

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(267, 11, 173, 37);
		buttons.add(btnDelete);
		btnDelete.setBackground(new Color(192, 192, 192));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRowCount() == 1) {
					model.removeRow(table.getSelectedRow());

				} else {
					if (table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Table is Empty.", "Alert", JOptionPane.WARNING_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "Please Select A Single Row to Delete .", "Alert",
								JOptionPane.WARNING_MESSAGE);

					}
				}

			}
		});

		JButton btnClose = new JButton("CLOSE");
		btnClose.setBounds(705, 11, 139, 37);
		buttons.add(btnClose);
		btnClose.setBackground(new Color(192, 192, 192));
		btnClose.addActionListener(new ActionListener() {
			public void close() {
				WindowEvent closeWindow = new WindowEvent(MainMenu, WindowEvent.WINDOW_CLOSING);
				Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
			}

			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});

		txtSearch.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				model = (DefaultTableModel) table.getModel();
				ts = new TableRowSorter<DefaultTableModel>(model);
				table.setRowSorter(ts);
				ts.setRowFilter(RowFilter.regexFilter(txtSearch.getText().trim()));

			}

			@Override
			public void keyReleased(KeyEvent e) {
				model = (DefaultTableModel) table.getModel();
				ts = new TableRowSorter<DefaultTableModel>(model);
				table.setRowSorter(ts);
				ts.setRowFilter(RowFilter.regexFilter(txtSearch.getText().trim()));

			}
		});

		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model = (DefaultTableModel) table.getModel();
				int SelectedRowIndex=table.getSelectedRow();
				txtId.setText(model.getValueAt(SelectedRowIndex, 0).toString());
				txtName.setText(model.getValueAt(SelectedRowIndex, 1).toString());
				txtAddress.setText(model.getValueAt(SelectedRowIndex, 2).toString());
				txtRole.setText(model.getValueAt(SelectedRowIndex, 3).toString());
				txtJob.setText(model.getValueAt(SelectedRowIndex, 4).toString());
				txtSalary.setText(model.getValueAt(SelectedRowIndex, 5).toString());
				txtEmail.setText(model.getValueAt(SelectedRowIndex, 6).toString());
				txtPhone.setText(model.getValueAt(SelectedRowIndex, 7).toString());
				txtBD.setText(model.getValueAt(SelectedRowIndex, 8).toString());
			}
		});

		table.setToolTipText("\r\n");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Name", "Address", "Role", "Job",
				"Salary", "Email", "Phone",  "B-Date" }) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class,
					Object.class, Object.class, Object.class, Object.class};

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

		});

	};
	

}
