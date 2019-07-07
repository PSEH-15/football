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

import com.ashu.ms.external.api.CompetitionApi;
import com.ashu.ms.external.api.Constant;
import com.ashu.ms.external.dto.Competition;

@Component
public class CompetitionApiImpl implements CompetitionApi {

	public List<Competition> getCompetitionsByCountry(String countryID) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constant.BASE_URI)
				.queryParam("action", Constant.GET_LEAGUES).queryParam("APIkey", Constant.API_KEY)
				.queryParam("country_id", countryID);

		HttpEntity<?> entity = new HttpEntity<>(headers);
		HttpEntity<List<Competition>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<Competition>>() {
				});
		return response.getBody();
	}

	public Competition getCompetitionByCountryAndLeague(String countryID, String leagueName) {
		List<Competition> competitionList = getCompetitionsByCountry(countryID);
		for (Competition competition : competitionList) {
			if (competition.getLeagueName().equals(leagueName)) {
				return competition;

			}
		}
		return null;
	}
}
