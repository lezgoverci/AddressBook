import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EditDialog extends JDialog {
	private JTextField firstNameTF;
	private JTextField lastNameTF;
	private JTextField addressTF;
	private JTextField cityTF;
	private JTextField provinceTF;
	private JTextField zipTF;
	private JTextField phoneTF;
	private Person person;
	private String btnPressed;
	public EditDialog(Person aPerson) {
		person = aPerson;
		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Edit Person");
		setBounds(650, 50, 335, 327);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("First Name");
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		label.setBounds(10, 37, 71, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Last Name");
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		label_1.setBounds(10, 62, 71, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Address");
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		label_2.setBounds(10, 87, 71, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("City");
		label_3.setForeground(Color.LIGHT_GRAY);
		label_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		label_3.setBounds(10, 112, 71, 14);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Province");
		label_4.setForeground(Color.LIGHT_GRAY);
		label_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		label_4.setBounds(10, 137, 71, 14);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("ZIP");
		label_5.setForeground(Color.LIGHT_GRAY);
		label_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		label_5.setBounds(10, 162, 71, 14);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Phone Num");
		label_6.setForeground(Color.LIGHT_GRAY);
		label_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		label_6.setBounds(10, 187, 71, 14);
		getContentPane().add(label_6);
		
		firstNameTF = new JTextField();
		firstNameTF.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		firstNameTF.setColumns(10);
		firstNameTF.setBorder(null);
		firstNameTF.setBackground(Color.GRAY);
		firstNameTF.setBounds(91, 34, 213, 20);
		firstNameTF.setText(person.getFirstName());
		getContentPane().add(firstNameTF);
		
		lastNameTF = new JTextField();
		lastNameTF.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lastNameTF.setColumns(10);
		lastNameTF.setBorder(null);
		lastNameTF.setBackground(Color.GRAY);
		lastNameTF.setBounds(91, 59, 213, 20);
		lastNameTF.setText(person.getLastName());
		getContentPane().add(lastNameTF);
		
		addressTF = new JTextField();
		addressTF.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		addressTF.setColumns(10);
		addressTF.setBorder(null);
		addressTF.setBackground(Color.GRAY);
		addressTF.setBounds(91, 84, 213, 20);
		addressTF.setText(person.getAddress());
		getContentPane().add(addressTF);
		
		cityTF = new JTextField();
		cityTF.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		cityTF.setColumns(10);
		cityTF.setBorder(null);
		cityTF.setBackground(Color.GRAY);
		cityTF.setBounds(91, 109, 213, 20);
		cityTF.setText(person.getCity());
		getContentPane().add(cityTF);
		
		provinceTF = new JTextField();
		provinceTF.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		provinceTF.setColumns(10);
		provinceTF.setBorder(null);
		provinceTF.setBackground(Color.GRAY);
		provinceTF.setBounds(91, 134, 213, 20);
		provinceTF.setText(person.getProvince());
		getContentPane().add(provinceTF);
		
		zipTF = new JTextField();
		zipTF.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		zipTF.setColumns(10);
		zipTF.setBorder(null);
		zipTF.setBackground(Color.GRAY);
		zipTF.setBounds(91, 159, 213, 20);
		zipTF.setText(person.getZip());
		getContentPane().add(zipTF);
		
		phoneTF = new JTextField();
		phoneTF.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		phoneTF.setColumns(10);
		phoneTF.setBorder(null);
		phoneTF.setBackground(Color.GRAY);
		phoneTF.setBounds(91, 184, 213, 20);
		phoneTF.setText(person.getContact());
		getContentPane().add(phoneTF);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				person.setFirstName(firstNameTF.getText());
				person.setLastName(lastNameTF.getText());
				person.setAddress(addressTF.getText());
				person.setCity(cityTF.getText());
				person.setProvince(provinceTF.getText());
				person.setContact(phoneTF.getText());
				person.setZip(zipTF.getText());
				btnPressed = "OK";				
				dispose();
			}
		});
		button.setForeground(Color.DARK_GRAY);
		button.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		button.setBackground(Color.GRAY);
		button.setBounds(116, 254, 89, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		button_1.setBackground(Color.GRAY);
		button_1.setBounds(215, 254, 89, 23);
		getContentPane().add(button_1);
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
