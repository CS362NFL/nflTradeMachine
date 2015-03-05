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

	/**
	 * Constructor to convert PlayerData class into a Player
	 * @param player
	 */
	protected Player(NFLData.TeamData.PlayerData player) {
		this.id = player.name + player.position + player.average_salary;
		this.position = player.position;
		this.name = player.name;
	}

	/**
	 * @return id of Player
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id string to set Player id to
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return position of Player
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position string to set Player position to
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return name of Player
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name string to set Player name to
	 */
	public void setName(String name) {
		this.name = name;
	}
}
