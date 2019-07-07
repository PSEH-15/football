package com.ashu.ms.external.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {

	@JsonProperty("team_key")
	private String teamKey;

	@JsonProperty("team_name")
	private String teamName;

	@JsonProperty("team_badge")
	private String teamBadge;

	@JsonProperty("players")
	private List<Player> players;

	@JsonProperty("coaches")
	private List<Caoch> coaches;

	public String getTeamKey() {
		return teamKey;
	}

	public void setTeamKey(String teamKey) {
		this.teamKey = teamKey;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamBadge() {
		return teamBadge;
	}

	public void setTeamBadge(String teamBadge) {
		this.teamBadge = teamBadge;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Caoch> getCoaches() {
		return coaches;
	}

	public void setCoaches(List<Caoch> coaches) {
		this.coaches = coaches;
	}

	
	
}
