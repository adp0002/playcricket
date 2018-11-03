package model;

public class Player extends Profile {
	private String skill, skillDescription;
	
	public Player(String id, String name, String gender, int age, String location, String skill) {
		super(id, name, gender, age, location);
		
		this.skill = skill;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getSkillDescription() {
		return skillDescription;
	}

	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}
	
	@Override
	public String toString() {
		return "Player(" + getId() + ", " + getName() + ")";
	}
}
