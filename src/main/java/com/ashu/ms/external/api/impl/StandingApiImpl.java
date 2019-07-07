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
import com.ashu.ms.external.api.StandingApi;
import com.ashu.ms.external.dto.Standing;


@Component
public class StandingApiImpl implements StandingApi {

	public List<Standing> getStandingByLeageID(String leagueID) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constant.BASE_URI)
				.queryParam("action", "get_standings").queryParam("APIkey", Constant.API_KEY)
				.queryParam("league_id", leagueID);

		HttpEntity<?> entity = new HttpEntity<>(headers);
		HttpEntity<List<Standing>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<Standing>>() {
				});
		return response.getBody();
	}

	public Standing getStandingByLeageIDAndTeamID(String leagueID, String teamName) {

		List<Standing> sList = getStandingByLeageID(leagueID);
		for (Standing standing : sList) {
			if (standing.getTeam_name().equals(teamName)) {
				return standing;
			}
		}
		return null;
	}

}
