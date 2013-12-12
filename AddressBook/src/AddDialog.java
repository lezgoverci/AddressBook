import javax.swing.JDialog;

import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;


public class AddDialog extends JDialog {
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField addressTextField;
	private JTextField cityTextField;
	private JTextField provinceTextField;
	private JTextField zipTextField;
	private JTextField contactTextField;
	
	private String btnPressed;
	
	private Person person;
	
	
	
	public AddDialog() {
		
		btnPressed = "CANCEL";
		getContentPane().setBackground(Color.DARK_GRAY);
		

	
		person = new Person();
		
		setTitle("Enter New Person");
		setBounds(650, 50, 335, 327);
		//setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setForeground(Color.LIGHT_GRAY);
		lblName.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lblName.setBounds(10, 36, 71, 14);
		getContentPane().add(lblName);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		firstNameTextField.setBackground(Color.GRAY);
		firstNameTextField.setBorder(null);
		firstNameTextField.setBounds(91, 33, 213, 20);
		getContentPane().add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.LIGHT_GRAY);
		lblLastName.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lblLastName.setBounds(10, 61, 71, 14);
		getContentPane().add(lblLastName);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lastNameTextField.setBackground(Color.GRAY);
		lastNameTextField.setBorder(null);
		lastNameTextField.setBounds(91, 58, 213, 20);
		getContentPane().add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.LIGHT_GRAY);
		lblAddress.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lblAddress.setBounds(10, 86, 71, 14);
		getContentPane().add(lblAddress);
		
		JLabel lblNewLabel = new JLabel("City");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 111, 71, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblState = new JLabel("Province");
		lblState.setForeground(Color.LIGHT_GRAY);
		lblState.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lblState.setBounds(10, 136, 71, 14);
		getContentPane().add(lblState);
		
		JLabel lblNewLabel_1 = new JLabel("ZIP");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 161, 71, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblPhoneNumber = new JLabel("Phone Num");
		lblPhoneNumber.setForeground(Color.LIGHT_GRAY);
		lblPhoneNumber.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lblPhoneNumber.setBounds(10, 186, 71, 14);
		getContentPane().add(lblPhoneNumber);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		addressTextField.setBackground(Color.GRAY);
		addressTextField.setBorder(null);
		addressTextField.setBounds(91, 83, 213, 20);
		getContentPane().add(addressTextField);
		addressTextField.setColumns(10);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		cityTextField.setBackground(Color.GRAY);
		cityTextField.setBorder(null);
		cityTextField.setBounds(91, 108, 213, 20);
		getContentPane().add(cityTextField);
		cityTextField.setColumns(10);
		
		provinceTextField = new JTextField();
		provinceTextField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		provinceTextField.setBackground(Color.GRAY);
		provinceTextField.setBorder(null);
		provinceTextField.setBounds(91, 133, 213, 20);
		getContentPane().add(provinceTextField);
		provinceTextField.setColumns(10);
		
		zipTextField = new JTextField();
		zipTextField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		zipTextField.setBackground(Color.GRAY);
		zipTextField.setBorder(null);
		zipTextField.setBounds(91, 158, 213, 20);
		getContentPane().add(zipTextField);
		zipTextField.setColumns(10);
		
		contactTextField = new JTextField();
		contactTextField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		contactTextField.setBackground(Color.GRAY);
		contactTextField.setBorder(null);
		contactTextField.setBounds(91, 183, 213, 20);
		getContentPane().add(contactTextField);
		contactTextField.setColumns(10);
		
				
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				person.setFirstName(firstNameTextField.getText());
				person.setLastName(lastNameTextField.getText());
				person.setAddress(addressTextField.getText());
				person.setCity(cityTextField.getText());
				person.setProvince(provinceTextField.getText());
				person.setContact(contactTextField.getText());
				person.setZip(zipTextField.getText());
				btnPressed = "OK";				
				dispose();
				
				
			}
		});
		btnNewButton.setBounds(116, 254, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPressed = "CANCEL";
				dispose();
			}
		});
		btnNewButton_1.setBounds(215, 254, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		//setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	public String getPressedBtn(){
		return btnPressed;
	}


	public Person getPerson() {
		return person;
	}
	

	public void showDialog() {
		setLocationRelativeTo(null);	
		setModalityType(AddDialog.ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		
	}
}
