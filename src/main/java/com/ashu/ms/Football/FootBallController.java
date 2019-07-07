package com.ashu.ms.Football;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.ms.exception.DataNotFoundedException;
import com.ashu.ms.exception.InvalidInputDataException;
import com.ashu.ms.external.dto.Response;
import com.ashu.ms.service.FootballService;

@RestController
@RequestMapping("/football")
public class FootBallController {

	@Autowired
	private FootballService service;

	@GetMapping("/position")
	public ResponseEntity<Response> getPosition(@RequestParam("country_name") String countryName,

			@RequestParam("league_name") String leagueName, @RequestParam("team_name") String teamName

	) {

		Response res;
		try {
			validateParam(countryName, leagueName, teamName);
			res = service.getResponse(countryName, leagueName, teamName);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} catch (InvalidInputDataException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (DataNotFoundedException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private void validateParam(String countryName, String leagueName, String teamName)
			throws InvalidInputDataException {
		// TODO Auto-generated method stub
		if (countryName == null || leagueName == null || teamName == null) {
			throw new InvalidInputDataException("All input data is mendatory");
		}
	}

	@GetMapping("/test")
	public String get() {
		return "return Hello";

	}

}
