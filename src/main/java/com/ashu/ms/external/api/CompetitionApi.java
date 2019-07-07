package com.ashu.ms.external.api;

import java.util.List;

import com.ashu.ms.external.dto.Competition;

public interface CompetitionApi {

	public List<Competition> getCompetitionsByCountry(String countryID);

	public Competition getCompetitionByCountryAndLeague(String countryID, String leagueName);
}
