package com.ashu.ms.external.api.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ashu.ms.external.api.Constant;
import com.ashu.ms.external.api.TeamApi;
import com.ashu.ms.external.dto.Team;

@Component
public class TeamsApiImpl implements TeamApi {

	public List<Team> getTeamByLeageID(String leagueID) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constant.BASE_URI)
				.queryParam("action", Constant.GET_TEAMS).queryParam("APIkey", Constant.API_KEY)
				.queryParam("league_id", leagueID);

		HttpEntity<?> entity = new HttpEntity<>(headers);
		HttpEntity<List<Team>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<Team>>() {
				});
		return response.getBody();
	}

	public Team getTeamByLeageIDAndTeamName(String leagueID, String teamName) {
		List<Team> teamList = getTeamByLeageID(leagueID);
		for (Team team : teamList) {
			if (team.getTeamName().equals(teamName)) {
				return team;
			}
		}
		return null;
	}
}
