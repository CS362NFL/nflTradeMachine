package tradeMachine;

public class PlayerController {
	
	/*
	 * Stores an instance of Player that is used to call the Player methods
	 */
	private Player player = null;
	
	/**
	 * 
	 * Method to get the ID of this instance of Player
	 * 
	 * @return The ID of the Player
	 */
	public int getId() {
		return this.getPlayerInstance().getId();
	}

	/**
	 * 
	 * Method to set the ID of this instance of Player
	 * 
	 * @param id The new ID of the Player
	 */
	public void setId(int id) {
		this.getPlayerInstance().setId(id);
	}

	/**
	 * 
	 * Method to get the position of this instance of Player
	 * 
	 * @return The position of the Player
	 */
	public String getPosistion() {
		return this.getPlayerInstance().getPosistion();
	}

	/**
	 * 
	 * Method to set the position of this instance of Player
	 * 
	 * @param posistion The new position of the Player
	 */
	public void setPosistion(String posistion) {
		this.getPlayerInstance().setPosistion(posistion);
	}

	/**
	 * 
	 * Method to get the name of this instance of Player
	 * 
	 * @return The name of the Player
	 */
	public String getName() {
		return this.getPlayerInstance().getName();
	}

	/**
	 * 
	 * Method to set the name of this instance of Player
	 * 
	 * @param name The new name of the Player
	 */
	public void setName(String name) {
		this.getPlayerInstance().setName(name);
	}
	
	
	/**
	 * 
	 * Method to define one instance of the class Player to use in calling Player methods
	 * 
	 * @return the instance of Team being used
	 */
	private Player getPlayerInstance(){
		if(player == null) player = new Player();
		return player;
	}
}
