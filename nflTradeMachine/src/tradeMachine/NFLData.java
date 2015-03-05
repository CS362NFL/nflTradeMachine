package tradeMachine;

import java.util.List;

public class NFLData {
	public List<TeamData> teams;
	
	public class TeamData {
		public String name;
		public List<PlayerData> players;
		
		public class PlayerData {
			public String age;
			public String average_salary;
			public String contract_length;
			public String contract_value;
			public String experience;
			public String expires;
			public String guaranteed;
			public String name;
			public String position;
		}
	}
}
