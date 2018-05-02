package com.gerardo.web.models;

import java.util.ArrayList;

public class Roster {
	private ArrayList<Team> teamList;
	
	public Roster () {
		teamList = new ArrayList<>();
	}
	
	public ArrayList<Team> getTeamList () {
		return teamList;
	}
	
	public Team getTeam (int index) {
		return teamList.get(index);
	}
	
	public int getRosterSize () {
		return teamList.size();
	}
	
	public void addTeam (Team newTeam) {
		teamList.add(newTeam);
	}
	
	public void removeTeam (int index) {
		teamList.remove(index);
	}
}
