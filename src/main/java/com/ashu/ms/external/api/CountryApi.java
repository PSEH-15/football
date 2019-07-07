package com.ashu.ms.external.api;

import java.util.List;

import com.ashu.ms.external.dto.Country;

public interface CountryApi {

	public List<Country> getAllCountry();

	public Country getCountry(String countryName);
}
