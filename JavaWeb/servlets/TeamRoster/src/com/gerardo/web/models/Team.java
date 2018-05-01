package com.gerardo.web.models;

import java.util.ArrayList;

public class Team {
	private String teamName;
	private ArrayList<Player> players;
	
	public Team (String name) {
		teamName = name;
		players = new ArrayList<>();

	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public int getPlayerAmount () {
		return players.size();
	}
	
	public Player getPlayer (int index) {
		return players.get(index);
	}
	
}
