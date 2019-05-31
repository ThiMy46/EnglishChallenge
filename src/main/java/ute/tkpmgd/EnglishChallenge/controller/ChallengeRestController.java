package ute.tkpmgd.EnglishChallenge.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ute.tkpmgd.EnglishChallenge.model.Question;

@RestController
@RequestMapping("/api/challenges")
public class ChallengeRestController {

	@RequestMapping(value = "/{idChallenge}/questions/{idQuestion}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllProject(@PathVariable int idChallenge, @PathVariable int idQuestion) {
		
		return ResponseEntity.ok().body(true);
	}
}
