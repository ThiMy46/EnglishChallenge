package ute.tkpmgd.EnglishChallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ute.tkpmgd.EnglishChallenge.dao.JoinRepository;
import ute.tkpmgd.EnglishChallenge.model.Join;
import ute.tkpmgd.EnglishChallenge.model.TestQuestion;
import ute.tkpmgd.EnglishChallenge.response.QuestionResponse;
import ute.tkpmgd.EnglishChallenge.service.ITestQuestionService;

@RestController
@RequestMapping("/api/testquestion")
public class TestQuestionController {

	@Autowired
	private ITestQuestionService questionService;

	@Autowired
	private JoinRepository joinRepository;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getQuestionByid(@PathVariable("id") int joinId) {
		Join join = joinRepository.getOne(joinId);
		TestQuestion question = questionService.getQuestionById(join.getIdQuestion() == 0 ? 1 : join.getIdQuestion());
		return ResponseEntity.ok().body(new QuestionResponse(question));
	}
}
