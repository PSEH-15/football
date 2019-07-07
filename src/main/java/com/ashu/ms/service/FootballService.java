package com.ashu.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashu.ms.exception.DataNotFoundedException;
import com.ashu.ms.external.api.CompetitionApi;
import com.ashu.ms.external.api.CountryApi;
import com.ashu.ms.external.api.StandingApi;
import com.ashu.ms.external.dto.Competition;
import com.ashu.ms.external.dto.Country;
import com.ashu.ms.external.dto.Response;
import com.ashu.ms.external.dto.Standing;

@Service
public class FootballService {

	@Autowired
	private CountryApi countryApi;

	@Autowired
	private CompetitionApi competitionApi;

	@Autowired
	private StandingApi standingApi;

	public Response getResponse(String countryName, String leagueName, String teamName) throws DataNotFoundedException {
		
		Country country = countryApi.getCountry(countryName);
		if(country==null) {
			throw new DataNotFoundedException("Country eith code not founded ");
		}
		
		Competition comp = competitionApi.getCompetitionByCountryAndLeague(country.getCountryId(), leagueName);
		if(comp==null) {
			throw new DataNotFoundedException("league not found with provided name");
		}
		
		Standing standing = standingApi.getStandingByLeageIDAndTeamID(comp.getLeagueId(), teamName);
		if(standing==null) {
			throw new DataNotFoundedException("standing not found with provided teame name");
		}
		
		Response response=new Response();
		response.setCountryId(country.getCountryId());
		response.setCountryName(country.getCountryName());
		
		
		response.setLeagueId(comp.getLeagueId());
		response.setLeagueName(comp.getLeagueName());
		
		response.setTeamKey(standing.getTeam_id());
		response.setTeamName(standing.getTeam_name());
		response.setPosition(standing);
		return response;
	}

}
