package UI;

import UI.API.EmployeeAPI;
import com.example.EEmployee.collection.Employee;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainMenu {
	private final Logger LOGGER= LoggerFactory.getLogger(MainMenu.class);
	JFrame MainMenu;
	private JTable table;
	private JTextField txtSearch;
	static DefaultTableModel model;
	private JTextField txtfirstName;
	private JTextField txtLastName;
	private JTextField txtHireDate;
	private JTextField txtRole;
	private JTextField txtJob;
	private JTextField txtSalary;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtBD;
	TableRowSorter<DefaultTableModel> ts;
	@Autowired
	EmployeeAPI employeeAPI;
	HashMap<String, Employee>map;
	String cookie;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu("");
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
	public MainMenu(String cookie) throws Exception {
		this.cookie=cookie;
		LOGGER.info("Hello From Constructor");
			initialize();
		loadEmployeeInformation();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		map=new HashMap<>();
		employeeAPI=new EmployeeAPI();
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


		JLabel lblfirstName = new JLabel("First Name");
		lblfirstName.setBounds(10, 83, 68, 14);
		panel.add(lblfirstName);


		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 125, 68, 14);
		panel.add(lblLastName);

		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(10, 203, 49, 14);
		panel.add(lblRole);

		JLabel hire_date = new JLabel("Hire Date");

		hire_date.setBounds(10, 379, 58, 14);
		panel.add(hire_date);
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(10, 162, 49, 14);
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


		txtfirstName = new JTextField();
		txtfirstName.setBounds(78, 83, 167, 20);
		panel.add(txtfirstName);
		txtfirstName.setColumns(10);
		txtLastName = new JTextField();
		txtLastName.setBounds(78, 122, 167, 20);
		panel.add(txtLastName);
		txtLastName.setColumns(10);


		txtHireDate = new JTextField();
		txtHireDate.setColumns(10);
		txtHireDate.setBounds(78, 376, 167, 20);
		panel.add(txtHireDate);

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
		/* 78, 159, 167, 20*/
		txtPhone.setBounds(78, 159, 167, 20);
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

			@SneakyThrows
			public void actionPerformed(ActionEvent arg0) {
				LOGGER.info("Inside of Add Listener");

				if ( txtfirstName.getText().equals("") ||  txtLastName.getText().equals("")|| txtHireDate.getText().equals("")
						|| txtRole.getText().equals("") || txtJob.getText().equals("") || txtSalary.getText().equals("")
						|| txtEmail.getText().equals("") || txtPhone.getText().equals("")
						|| txtBD.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter All Data!", "Error", 0);
				}
				

				else {
					if(!check())
						return;
					Employee temp=buildEmployee();
					temp=employeeAPI.POSTEmployee(temp,cookie);
					if(Objects.isNull(temp)){
						JOptionPane.showMessageDialog(null, "Something Went Wrong Try Again Later !",
								"ERROR", JOptionPane.ERROR_MESSAGE);
						return;
					}
					map.put(temp.getEmployeeId(),temp);
					addRow(temp);
					clear();
					JOptionPane.showMessageDialog(null,"Successfully Added.","Alert",JOptionPane.WARNING_MESSAGE);

				}
			}

		});

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(483, 11, 158, 37);
		buttons.add(btnUpdate);
		btnUpdate.setBackground(new Color(192, 192, 192));
		btnUpdate.addActionListener(new ActionListener() {

			@SneakyThrows
			public void actionPerformed(ActionEvent e) {
				LOGGER.info("Inside of Update Listener");

				if (table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Table is Empty.", "Alert", JOptionPane.WARNING_MESSAGE);
				}
				else {

					int selectedRowIndex=table.getSelectedRow();
					Employee temp=buildEmployee();
					String id=table.getValueAt(selectedRowIndex,0).toString();
					temp.setEmployeeId(id);
					temp=employeeAPI.updateEmployee(temp,cookie,id);
					if(Objects.isNull(temp)){
						JOptionPane.showMessageDialog(null, "Something Went Wrong Try Again Later !",
								"ERROR", JOptionPane.ERROR_MESSAGE);
						return;
					}
					System.out.println(temp);
					map.replace(id,temp);
					System.out.println(map.get(id));
					update();

					clear();
					JOptionPane.showMessageDialog(null,"Successfully Updated.","Alert",JOptionPane.WARNING_MESSAGE);

				}
				
			}
		});

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(267, 11, 173, 37);
		buttons.add(btnDelete);
		btnDelete.setBackground(new Color(192, 192, 192));
		btnDelete.addActionListener(new ActionListener() {
			@SneakyThrows
			public void actionPerformed(ActionEvent arg0)
			{

				LOGGER.info("Inside of Delete Listener");

				if (table.getSelectedRowCount() == 1) {
					String id =(String) table.getValueAt(table.getSelectedRow(),0);
					if (employeeAPI.deleteEmployee(id,cookie)) {
						model.removeRow(table.getSelectedRow());
						map.remove(id);
						JOptionPane.showMessageDialog(null,"Successfully Deleted.","Alert",JOptionPane.WARNING_MESSAGE);

					}
					else {
						JOptionPane.showMessageDialog(null, "Something Went Wrong Try Again Later !",
								"ERROR", JOptionPane.ERROR_MESSAGE);

					}
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
				txtfirstName.setText(model.getValueAt(SelectedRowIndex, 1).toString());
				txtLastName.setText(model.getValueAt(SelectedRowIndex, 2).toString());
				txtRole.setText(model.getValueAt(SelectedRowIndex, 4).toString());
				txtJob.setText(model.getValueAt(SelectedRowIndex, 5).toString());
				txtSalary.setText(model.getValueAt(SelectedRowIndex, 6).toString());
				txtEmail.setText(model.getValueAt(SelectedRowIndex, 7).toString());
				txtPhone.setText(model.getValueAt(SelectedRowIndex, 3).toString());
				txtHireDate.setText(model.getValueAt(SelectedRowIndex, 8).toString());
				txtBD.setText(model.getValueAt(SelectedRowIndex, 9).toString());
			}
		});

		table.setToolTipText("\r\n");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "First Name","Last Name","Phone", "Role", "Job",
				"Salary", "Email", "Hire Date",  "B-Date" }) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class,
					Object.class, Object.class, Object.class, Object.class,Object.class};

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

		});


	}

	private void update() {
		LOGGER.info("Inside of update function");

		int SelectedRowIndex = table.getSelectedRow();
		model.setValueAt(txtfirstName.getText(), SelectedRowIndex, 1);
		model.setValueAt(txtLastName.getText(), SelectedRowIndex, 2);
		model.setValueAt(txtPhone.getText(), SelectedRowIndex, 3);
		model.setValueAt(txtRole.getText(), SelectedRowIndex, 4);
		model.setValueAt(txtJob.getText(), SelectedRowIndex, 5);
		model.setValueAt(txtSalary.getText(), SelectedRowIndex, 6);
		model.setValueAt(txtEmail.getText(), SelectedRowIndex, 7);
		model.setValueAt(txtHireDate.getText(), SelectedRowIndex, 8);

		model.setValueAt(txtBD.getText(), SelectedRowIndex, 9);
	}

	private Employee buildEmployee() {
		return Employee.builder()
				.fname(txtfirstName.getText())
				.lname(txtLastName.getText())
				.job(txtJob.getText())
				.roll(txtRole.getText())
				.job(txtJob.getText())
				.email(txtEmail.getText())
				.birthDate(txtBD.getText())
				.phone(txtPhone.getText())
				.hireDate(txtHireDate.getText())
				.salary(Integer.parseInt(txtSalary.getText()))
				.build();
	}





	private void loadEmployeeInformation() throws Exception {
		LOGGER.info("Inside of loadEmployeeInformation");

		System.out.println("cookie = " + cookie);
		List<Employee> list= employeeAPI.getAllEmployee(cookie);
		if(Objects.isNull(list)){
			return;
		}
		else{
			list.forEach(e->{
				map.put(e.getEmployeeId(),e);
				addRow(e);

			});

		}
	}
	private void clear(){
		txtfirstName.setText("");
		txtLastName.setText("");
		txtHireDate.setText("");
		txtRole.setText("");
		txtJob.setText("");
		txtSalary.setText("");
		txtEmail.setText("");
		txtPhone.setText("");
		txtBD.setText("");
		LOGGER.info("Inside of Clear");

	}
	private void addRow(Employee employee){
		LOGGER.info("Inside of addRow");

		model = (DefaultTableModel) table.getModel();
		model.addRow(extractData(employee));

	}
	public boolean check()
	{
		LOGGER.info("Inside of check");

		if (txtfirstName.getText().matches("[\\w]+") == false) {
			JOptionPane.showMessageDialog(null, "please, write the name with a correct form", "Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if (txtLastName.getText().matches("[\\w]+") == false) {
			JOptionPane.showMessageDialog(null, "please, write the name with a correct form", "Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		else if (txtHireDate.getText().matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$") == false) {
			JOptionPane.showMessageDialog(null, "please, write the Address with a correct form", "Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if (txtRole.getText().matches("[\\w]+") == false) {
			JOptionPane.showMessageDialog(null, "please, write the Role with a correct form", "Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if (txtJob.getText().matches("[\\w]+") == false) {
			JOptionPane.showMessageDialog(null, "please, write the Job with a correct form", "Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if (txtSalary.getText().matches("[\\d]{1,7}") == false) {
			JOptionPane.showMessageDialog(null, "please, write the Salary with a correct form", "Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if (txtEmail.getText().matches("[a-z]+[\\w_.]*[@][a-z]+[\\w]*[.]com$") == false) {
			JOptionPane.showMessageDialog(null, "please, write the Email with a correct form", "Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		else if (txtPhone.getText().matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$") == false) {
			JOptionPane.showMessageDialog(null, "please, write the Phone with a correct form", "Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if (txtBD.getText().matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$") == false){
			JOptionPane.showMessageDialog(null, "please, write the Birth date with a correct form", "Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}


	public Object[] extractData(Employee employee){
		LOGGER.info("Inside of extractData function");

		Object[]data={employee.getEmployeeId()
				,employee.getFname(),employee.getLname(),employee.getPhone(),
				employee.getRoll(),employee.getJob(),employee.getSalary(),employee.getEmail(),employee.getHireDate(),employee.getBirthDate()};


		return data;

	}

}
