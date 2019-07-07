package com.ashu.ms.external.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Caoch {

	@JsonProperty("coach_name")
	private String name;

	@JsonProperty("coach_age")
	private String age;

	@JsonProperty("coach_country")
	private String country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
