package com.ashu.ms.external.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {

	@JsonProperty("player_key")
	private long playerKey;

	@JsonProperty("player_name")
	private String playerName;

	@JsonProperty("player_number")
	private String playerNumber;

	@JsonProperty("player_country")
	private String playerCountry;

	@JsonProperty("player_type")
	private String playerType;

	@JsonProperty("player_age")
	private String playerAge;

	@JsonProperty("player_match_played")
	private String playerMatchPlayed;

	@JsonProperty("player_goals")
	private String playerGoals;

	@JsonProperty("player_yellow_cards")
	private String playerYellowCards;

	@JsonProperty("playerRedCards")
	private String playerRedCards;

	public long getPlayerKey() {
		return playerKey;
	}

	public void setPlayerKey(long playerKey) {
		this.playerKey = playerKey;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(String playerNumber) {
		this.playerNumber = playerNumber;
	}

	public String getPlayerCountry() {
		return playerCountry;
	}

	public void setPlayerCountry(String playerCountry) {
		this.playerCountry = playerCountry;
	}

	public String getPlayerType() {
		return playerType;
	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

	public String getPlayerAge() {
		return playerAge;
	}

	public void setPlayerAge(String playerAge) {
		this.playerAge = playerAge;
	}

	public String getPlayerMatchPlayed() {
		return playerMatchPlayed;
	}

	public void setPlayerMatchPlayed(String playerMatchPlayed) {
		this.playerMatchPlayed = playerMatchPlayed;
	}

	public String getPlayerGoals() {
		return playerGoals;
	}

	public void setPlayerGoals(String playerGoals) {
		this.playerGoals = playerGoals;
	}

	public String getPlayerYellowCards() {
		return playerYellowCards;
	}

	public void setPlayerYellowCards(String playerYellowCards) {
		this.playerYellowCards = playerYellowCards;
	}

	public String getPlayerRedCards() {
		return playerRedCards;
	}

	public void setPlayerRedCards(String playerRedCards) {
		this.playerRedCards = playerRedCards;
	}
	
	
	
	
}
