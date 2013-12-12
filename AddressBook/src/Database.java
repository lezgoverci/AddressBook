import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Database {

	@ElementList
	private ArrayList<Person> db ;
	
	Database(){
		db = new ArrayList<Person>();
	}	
	
	protected void removePerson(int i){
		db.remove(i);		
	}
	
	protected void addPerson(Person p){		
		db.add(p);
	}
	
	protected void add(ArrayList<Person> pList){
		db.addAll(pList);
	}
	
	protected ArrayList<Person> getList(){
		return db;
	}
	
	protected Person getPerson(int i){
		return db.get(i);
	}
	
	protected void sortByName(){
		
		Collections.sort(db, Person.PersonFirstNameComparator);
		Collections.sort(db, Person.PersonNameComparator);
		
	}
	
	protected void sortByZip(){
		sortByName();
		Collections.sort(db, Person.PersonZipComparator);
	}

	public int find(int index, String keyword) {
		
		int temp = 0;
		for(int i = index; i < db.size(); i++){
			if(((db.get(i).getLastName().equals(keyword))
				|| (db.get(i).getLastName().equals(keyword))
				|| (db.get(i).getFirstName().equals(keyword))
				|| (db.get(i).getAddress().equals(keyword))
				|| (db.get(i).getCity().equals(keyword))
				|| (db.get(i).getProvince().equals(keyword))
				|| (db.get(i).getZip().equals(keyword))
				|| (db.get(i).getContact().equals(keyword))
				) && index != db.size())
			{
				temp = i;
				break;
			}
			else
				temp = db.size();
				
		}
		return temp;
		
	}


}
