import java.util.Comparator;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root
public class Person implements Comparable{
	@Element
	private String firstName;
	@Element
	private String lastName;
	@Element
	private String address;
	@Element
	private String city;
	@Element
	private String province;
	@Element
	private String zip;
	@Element
	private String contact;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getProvince() {
		return province;
	}
	public String getZip() {
		return zip;
	}
	public String getContact() {
		return contact;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	protected static Comparator<Person> PersonCityComparator = new Comparator<Person>(){

		@Override
		public int compare(Person p1, Person p2) {
			String pName1 = p1.getCity().toUpperCase();
			String pName2 = p2.getCity().toUpperCase();
			return pName1.compareTo(pName2);
		}
		
	};
	
	protected static Comparator<Person> PersonProvinceComparator = new Comparator<Person>(){

		@Override
		public int compare(Person p1, Person p2) {
			String pName1 = p1.getProvince().toUpperCase();
			String pName2 = p2.getProvince().toUpperCase();
			return pName1.compareTo(pName2);
		}
		
	};
	
	protected static Comparator<Person> PersonAddressComparator = new Comparator<Person>(){

		@Override
		public int compare(Person p1, Person p2) {
			String pName1 = p1.getAddress().toUpperCase();
			String pName2 = p2.getAddress().toUpperCase();
			return pName1.compareTo(pName2);
		}
		
	};
	
	protected static Comparator<Person> PersonContactComparator = new Comparator<Person>(){

		@Override
		public int compare(Person p1, Person p2) {
			String pName1 = p1.getContact().toUpperCase();
			String pName2 = p2.getContact().toUpperCase();
			return pName1.compareTo(pName2);
		}
		
	};
	
	
	
	protected static Comparator<Person> PersonNameComparator = new Comparator<Person>(){

		@Override
		public int compare(Person p1, Person p2) {
			String pName1 = p1.getLastName().toUpperCase();
			String pName2 = p2.getLastName().toUpperCase();
			return pName1.compareTo(pName2);
		}
		
	};
	
	protected static Comparator<Person> PersonZipComparator = new Comparator<Person>(){

		@Override
		public int compare(Person p1, Person p2) {
			String pName1 = p1.getZip();
			String pName2 = p2.getZip();
			return pName1.compareTo(pName2);
		}
		
	};
	protected static Comparator<Person> PersonFirstNameComparator = new Comparator<Person>(){

		@Override
		public int compare(Person p1, Person p2) {
			String pName1 = p1.getFirstName().toUpperCase();
			String pName2 = p2.getFirstName().toUpperCase();
			return pName1.compareTo(pName2);
		}
		
	};

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}




}
