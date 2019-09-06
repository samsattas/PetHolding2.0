package model;

public class Pet {
	//RELATIONS
	private Date bDate;
	
	//ATTRIBUTES
	private int id;
	private String name;
	private char gender;
	private String type;
	
	//CONSTRUCTOR
	/**
	 * @param bDate
	 * @param id
	 * @param name
	 * @param gender
	 * @param type
	 */
	public Pet( int id, String name, Date bDate, char gender, String type) {
		super();
		this.bDate = bDate;
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.type = type;
	}
	
	//GETTERS & SETTERS
	/**
	 * @return the bDate
	 */
	public Date getbDate() {
		return bDate;
	}

	/**
	 * @param bDate the bDate to set
	 */
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
}
