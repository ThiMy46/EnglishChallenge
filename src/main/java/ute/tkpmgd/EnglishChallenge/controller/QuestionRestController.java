package ute.tkpmgd.EnglishChallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ute.tkpmgd.EnglishChallenge.model.Question;
import ute.tkpmgd.EnglishChallenge.serviceImp.QuestionServiceImp;

@RestController
@RequestMapping("/api/question")
public class QuestionRestController {

	@Autowired
	QuestionServiceImp questionService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllProject(@PathVariable int id) {
		
		//get project by id from service
		Question question = questionService.findQuestionById(id);	
		return ResponseEntity.ok().body(question);
	}
}
