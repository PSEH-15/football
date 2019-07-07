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
import com.ashu.ms.external.api.CountryApi;
import com.ashu.ms.external.dto.Country;

@Component
public class CountryApiImpl implements CountryApi {

	public List<Country> getAllCountry() {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Constant.BASE_URI)
				.queryParam("action", "get_countries").queryParam("APIkey", Constant.API_KEY);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		HttpEntity<List<Country>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<Country>>() {
				});
		return response.getBody();
	}

	public Country getCountry(String countryName) {
		List<Country> countryList = getAllCountry();
		for (Country country : countryList) {
			if (country.getCountryName().equals(countryName)) {
				return country;
			}
		}
		return null;

	}
}
