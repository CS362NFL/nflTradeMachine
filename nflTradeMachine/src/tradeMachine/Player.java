package tradeMachine;

public class Player {
	private String id;
	private String position;
	private String name;
	
	public Player(String id, String position, String name){
		this.id = id;
		this.position = position;
		this.name = name;
	}

	protected Player(NFLData.TeamData.PlayerData player) {
		this.id = player.name + player.position + player.average_salary;
		this.position = player.position;
		this.name = player.name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPosistion() {
		return position;
	}

	public void setPosistion(String posistion) {
		this.position = posistion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
