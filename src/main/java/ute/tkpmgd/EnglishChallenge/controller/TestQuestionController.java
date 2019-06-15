package ute.tkpmgd.EnglishChallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ute.tkpmgd.EnglishChallenge.model.TestQuestion;
import ute.tkpmgd.EnglishChallenge.serviceImp.TestQuestionServiceImp;

@RestController
@RequestMapping("/api/testquestion")
public class TestQuestionController {

	@Autowired
	TestQuestionServiceImp questionSer;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getQuestionByid(@PathVariable int id) {
		TestQuestion question = questionSer.getQuestionById(id);
		
		return ResponseEntity.ok().body(question);
	}
}
