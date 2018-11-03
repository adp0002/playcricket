package model;

import java.util.ArrayList;
import java.util.List;

public class Squad {
	private String name;
	private List<Player> players = new ArrayList<>(); 
	
	public Squad(String name, List<Player> players) {
		this.name = name;
		
		if (players != null) {
			this.players = new ArrayList<>(players);	
		}
	}

	public String getName() {
		return name;
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	public Player getPlayer(String id) {
		for (Player player: players) {
			if (player.getId().equals(id)) {
				return player;
			}
		}
		
		return null;
	}
}
