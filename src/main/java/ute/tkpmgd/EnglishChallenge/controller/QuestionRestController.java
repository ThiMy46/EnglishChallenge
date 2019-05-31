package ute.tkpmgd.EnglishChallenge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ute.tkpmgd.EnglishChallenge.dto.AnswerDTO;
import ute.tkpmgd.EnglishChallenge.dto.QuestionDTO;
import ute.tkpmgd.EnglishChallenge.model.Answer;
import ute.tkpmgd.EnglishChallenge.model.Question;
import ute.tkpmgd.EnglishChallenge.serviceImp.QuestionServiceImp;

@RestController
@RequestMapping("/api/questions")
public class QuestionRestController {

	@Autowired
	QuestionServiceImp questionService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllProject(@PathVariable int id) {
		
		Question question = questionService.findQuestionById(id);	
		QuestionDTO questionGetDTO = new QuestionDTO();
		questionGetDTO.setIdQuestion(question.getIdQuestion());
		questionGetDTO.setTextQuestion(question.getTextQuestion());
		
		List<AnswerDTO> answersDTO = new ArrayList<AnswerDTO>();
		for (Answer answer_get : question.getAnswers()) {
			AnswerDTO answer1dto = new AnswerDTO();
			answer1dto.setIdAnswer(answer_get.getIdAnswer());
			answer1dto.setTextAnswer(answer_get.getTextAnswer());
			answersDTO.add(answer1dto);			
		}
		
		questionGetDTO.setAnswers(answersDTO);
		return ResponseEntity.ok().body(questionGetDTO);
	}
}
