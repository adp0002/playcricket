package model;

public class Profile {
	private String id;
	private String name;
	private String gender;
	private int age;
	private String location;
	
	public Profile(String id, String name, String gender, int age, String location) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public String getLocation() {
		return location;
	}
}
