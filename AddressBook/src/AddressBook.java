import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.awt.List;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;





public class AddressBook extends JFrame {
	
	static Database db = new Database();
	static List list = new List();
	String keyword;
	static int filePrintNumbering = 1; 
	protected static final boolean UNCHANGED = false;
	protected static final boolean CHANGED = true;
	protected static final boolean NOTSAVED = false;
	protected static final boolean SAVED = true;
	protected static boolean status;
	protected static boolean save;
	
	static JMenuItem saveMenuItem;
	static JMenuItem saveAsMenuItem;
	static JMenuItem printMenuItem;
	static JMenuItem quitMenuItem;
	
	Serializer serializer = new Persister();
	static File databaseFile;
	
	
	
	public AddressBook() {
		
		status = UNCHANGED;
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 50, 500, 276);
		getContentPane().setLayout(null);
		
		JButton addBtn = new JButton("Add");
		addBtn.setForeground(Color.DARK_GRAY);
		addBtn.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		addBtn.setBackground(Color.GRAY);
		addBtn.setBounds(98, 169, 89, 23);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddDialog dialog = new AddDialog();
				dialog.showDialog();
				if(dialog.getPressedBtn() == "OK")
					AddressBook.addToDB(dialog.getPerson());		
			}
		});
	
		getContentPane().setLayout(null);
		getContentPane().add(addBtn);
		
		JButton editBtn = new JButton("Edit");
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditDialog dialog = new EditDialog(db.getPerson(list.getSelectedIndex()));
				dialog.showDialog();
				if(dialog.getPressedBtn() == "OK"){
					AddressBook.removeFromDB(list.getSelectedIndex());
					AddressBook.addToDB(dialog.getPerson());
				}
				//AddressBook.editPerson(list.getSelectedIndex());
			
			}
		});
		editBtn.setBackground(Color.GRAY);
		editBtn.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		editBtn.setForeground(Color.DARK_GRAY);
		editBtn.setBounds(197, 169, 89, 23);
		getContentPane().add(editBtn);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				int selected = JOptionPane.showConfirmDialog(null,"Are you sure?", null, JOptionPane.YES_NO_OPTION);
				if(selected == 0)
					AddressBook.removeFromDB(list.getSelectedIndex());
			}
		});
		deleteBtn.setBackground(Color.GRAY);
		deleteBtn.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		deleteBtn.setForeground(Color.DARK_GRAY);
		deleteBtn.setBounds(296, 169, 89, 23);
		getContentPane().add(deleteBtn);
		

		list.setBackground(Color.GRAY);
		list.setBounds(10, 10, 464, 138);
		getContentPane().add(list);
	
		

		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.GRAY);
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		final JMenuItem openMenuItem = new JMenuItem("Open");
		openMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				
				try {
					if(db.getList().isEmpty() || status == UNCHANGED){
						fc.showOpenDialog(openMenuItem);
						databaseFile = fc.getSelectedFile();
					}
					else if(status == CHANGED){
						int result = OfferSave.showSaveDialog();
						if(result == 0){
							serializer.write(db, databaseFile);
							fc.showOpenDialog(openMenuItem);
						}
						else if(result == 1){							
							fc.showOpenDialog(openMenuItem);
							
						}
					}

					db.getList().clear();
					databaseFile = fc.getSelectedFile();
					db.add(serializer.read(Database.class, databaseFile).getList());
					updateList();
					AddressBook.status = UNCHANGED;
					AddressBook.save = SAVED; 
					updateParameters(AddressBook.status,AddressBook.save);
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				db.getList().clear();
				try {
					databaseFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				updateList();
				AddressBook.status = UNCHANGED;
				AddressBook.save = SAVED; 
				updateParameters(AddressBook.status,AddressBook.save);
				
			}
		});
		fileMenu.add(mntmNew);
		fileMenu.add(openMenuItem);
		
		saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(databaseFile == null){
						final JFileChooser fc = new JFileChooser();
						fc.showSaveDialog(saveMenuItem);
						databaseFile = fc.getSelectedFile().getAbsoluteFile();
					}
					serializer.write(db, databaseFile);
					AddressBook.status = UNCHANGED;
					AddressBook.save = SAVED; 
					updateParameters(AddressBook.status,AddressBook.save);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		saveMenuItem.setEnabled(false);
		fileMenu.add(saveMenuItem);
		
		saveAsMenuItem = new JMenuItem("Save As");
		saveAsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				fc.showSaveDialog(saveAsMenuItem);
				try {
					databaseFile = fc.getSelectedFile();
					serializer.write(db, databaseFile);
					AddressBook.status = UNCHANGED;
					AddressBook.save = SAVED; 
					updateParameters(AddressBook.status,AddressBook.save);
					 
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		saveAsMenuItem.setEnabled(false);
		fileMenu.add(saveAsMenuItem);
		
		printMenuItem = new JMenuItem("Print");
		printMenuItem.setEnabled(false);
		printMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddressBook.printToFile();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		fileMenu.add(printMenuItem);
		
		quitMenuItem = new JMenuItem("Quit");
		quitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();				
				if(AddressBook.save == NOTSAVED && AddressBook.status == CHANGED){
					int result = OfferSave.showSaveDialog();
					if(result == 0){
						fc.showSaveDialog(quitMenuItem);
						databaseFile = fc.getSelectedFile();
						try {
							serializer.write(db, databaseFile);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
					}

				}				
				dispose();
			}
		});
		
		quitMenuItem.setEnabled(false);
		fileMenu.add(quitMenuItem);
		
		JMenu sortMenu = new JMenu("Sort");
		menuBar.add(sortMenu);
		
		JMenuItem sortByNameMenuItem = new JMenuItem("by Name");
		sortByNameMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				db.sortByName();
				updateList();
				
			}
		});
		sortMenu.add(sortByNameMenuItem);
		
		JMenuItem sortByZipMenuItem = new JMenuItem("by ZIP");
		sortByZipMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.sortByZip();
				updateList();
			}
		});
		sortMenu.add(sortByZipMenuItem);
		
		JMenu searchMenu = new JMenu("Search");
		menuBar.add(searchMenu);
		
		final JMenuItem findAgainMenuItem = new JMenuItem("Find Again");
		JMenuItem findMenuItem = new JMenuItem("Find");
		findMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//list.select(-1);
				keyword = JOptionPane.showInputDialog("Type a keyword to find:");
				int index = db.find(list.getSelectedIndex(),keyword);
				if(index == db.getList().size()){
					JOptionPane.showMessageDialog(null, "Not Found");
					findAgainMenuItem.setEnabled(false);
					keyword = null;
				}
				else{
					list.select(index);
					findAgainMenuItem.setEnabled(true);
				}
			}
		});
		searchMenu.add(findMenuItem);
		
		//JMenuItem findAgainMenuItem = new JMenuItem("Find Again");
		findAgainMenuItem.setEnabled(false);
		findAgainMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int currentIndex = list.getSelectedIndex();
				int nextIndex = list.getSelectedIndex()+ 1;
				int result = db.find(nextIndex , keyword);
				list.select(result);
				if(nextIndex == db.getList().size() || result == db.getList().size()){
					JOptionPane.showMessageDialog(null, "Nothing more");
					findAgainMenuItem.setEnabled(false);
				}
				
			}
		});
		searchMenu.add(findAgainMenuItem);
		
		//pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	protected static void removeFromDB(int selectedIndex) {
		db.removePerson(selectedIndex);
		updateList();
		
	}
	protected static void addToDB(Person person) {
		db.addPerson(person);
		updateList();
		
	}
	protected static void updateList() {
		ArrayList<Person> dbList = new ArrayList<Person>(db.getList());
		list.removeAll();
		for(int i = 0; i < dbList.size(); i++){
			list.add(
				
					dbList.get(i).getLastName()
					+ ", "
					+ dbList.get(i).getFirstName()				
					+ "       "
					+ dbList.get(i).getAddress()
					+ ", "
					+ dbList.get(i).getCity()
					+ ", "
					+ dbList.get(i).getProvince()
					+ ", "
					+ dbList.get(i).getZip()
					+ ", "
					+ dbList.get(i).getContact()
					);
		}
		list.select(0);
		AddressBook.status = CHANGED;
		AddressBook.save = NOTSAVED;
		updateParameters(AddressBook.status,AddressBook.save);

		
	
		
	}
	
	private static void updateParameters(boolean aStatus, boolean aSave) {
		if(aStatus == CHANGED && aSave == NOTSAVED ){
			saveMenuItem.setEnabled(true);
			saveAsMenuItem.setEnabled(true);
			printMenuItem.setEnabled(true);
			quitMenuItem.setEnabled(true);
		}
		else if(aStatus == CHANGED && aSave == SAVED ){
			saveMenuItem.setEnabled(false);
			saveAsMenuItem.setEnabled(true);
			printMenuItem.setEnabled(true);
			quitMenuItem.setEnabled(true);
		}
		else if(aStatus == UNCHANGED && aSave == SAVED ){
			saveMenuItem.setEnabled(false);
			saveAsMenuItem.setEnabled(false);
			printMenuItem.setEnabled(true);
			quitMenuItem.setEnabled(true);
		}
		else if(aStatus == UNCHANGED && aSave == NOTSAVED ){
			saveMenuItem.setEnabled(true);
			saveAsMenuItem.setEnabled(true);
			printMenuItem.setEnabled(true);
			quitMenuItem.setEnabled(true);
		}
		
	}
	protected static void printToFile() throws FileNotFoundException, UnsupportedEncodingException{
		ArrayList<Person> dbList = new ArrayList<Person>(db.getList());
		PrintWriter writer = new PrintWriter("printedfile" + filePrintNumbering + ".txt" , "UTF-8");
		for(int i = 0; i < dbList.size(); i++){
			writer.println(
				
					dbList.get(i).getLastName()
					+ ", "
					+ dbList.get(i).getFirstName()				
					+ ", "
					+ dbList.get(i).getAddress()
					+ ", "
					+ dbList.get(i).getCity()
					+ ", "
					+ dbList.get(i).getProvince()
					+ ", "
					+ dbList.get(i).getZip()
					+ ", "
					+ dbList.get(i).getContact()
					);
		}
		filePrintNumbering++;
		
	writer.close();
	}
}
