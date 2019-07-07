package com.ashu.ms.external.api;

import java.util.List;

import com.ashu.ms.external.dto.Team;

public interface TeamApi {

	public List<Team> getTeamByLeageID(String leagueID);

	public Team getTeamByLeageIDAndTeamName(String leagueID, String teamName);
}
