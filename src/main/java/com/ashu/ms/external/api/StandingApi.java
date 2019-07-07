package com.ashu.ms.external.api;

import java.util.List;

import com.ashu.ms.external.dto.Standing;

public interface StandingApi {

	
	public List<Standing> getStandingByLeageID(String leagueID) ;

	public Standing getStandingByLeageIDAndTeamID(String leagueID, String teamName);
	
	
}
