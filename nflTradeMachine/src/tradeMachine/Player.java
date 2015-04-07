package tradeMachine;

public class Player {
	private String id;
	private String position;
	private String name;
	private int years;
	private int totalMoney;
	private int averageCapHit;
	
	public Player(String id, String position, String name, int years, int totalMoney, int averageCapHit){
		this.id = id;
		this.position = position;
		this.name = name;
		this.years = years;
		this.totalMoney = totalMoney;
		this.averageCapHit = averageCapHit;
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
	 * @return total number of years on player contracts
	 */
	public int getYears() {
		return years;
	}

	/**
	 * @param years set number of years left on the player's contract
	 */
	public void setYears(int years) {
		this.years = years;
	}

	/**
	 * @return total money player has on contract
	 */
	public int getTotalMoney() {
		return totalMoney;
	}

	/**
	 * @param totalMoney amount of money to set a player's total money to
	 */
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	/**
	 * @return average cap hit player has on his team each year
	 */
	public int getAverageCapHit() {
		return averageCapHit;
	}

	/**
	 * @param averageCapHit amount to set average cap hit to
	 */
	public void setAverageCapHit(int averageCapHit) {
		this.averageCapHit = averageCapHit;
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
