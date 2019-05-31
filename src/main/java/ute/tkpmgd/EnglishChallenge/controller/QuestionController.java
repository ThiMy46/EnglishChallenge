package ute.tkpmgd.EnglishChallenge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ute.tkpmgd.EnglishChallenge.dto.AnswerDTO;
import ute.tkpmgd.EnglishChallenge.dto.QuestionDTO;
import ute.tkpmgd.EnglishChallenge.model.Answer;
import ute.tkpmgd.EnglishChallenge.model.Challenge;
import ute.tkpmgd.EnglishChallenge.model.Question;
import ute.tkpmgd.EnglishChallenge.serviceImp.ChallengeServiceImp;
import ute.tkpmgd.EnglishChallenge.serviceImp.QuestionServiceImp;

@Controller
public class QuestionController {

	@Autowired 
	ChallengeServiceImp challengeSer;
	@Autowired
	QuestionServiceImp questionService;
	
	@PostMapping("/question/{id}")
	public String getQuestion(@PathVariable int id, @RequestParam int idUser, @RequestParam int question, @RequestParam String answer, ModelMap model) {
		Challenge challenge = challengeSer.getChallengeById(1);
		challenge.getChallengequestions();
		//save answer
		if(question != 0) {
			
		}
		//get question
		Question questionGet = questionService.findQuestionById(id);	
		QuestionDTO questionGetDTO = new QuestionDTO();
		questionGetDTO.setIdQuestion(questionGet.getIdQuestion());
		questionGetDTO.setTextQuestion(questionGet.getTextQuestion());
		
		List<AnswerDTO> answersDTO = new ArrayList<AnswerDTO>();
		for (Answer answer_get : questionGet.getAnswers()) {
			AnswerDTO answer1dto = new AnswerDTO();
			answer1dto.setIdAnswer(answer_get.getIdAnswer());
			answer1dto.setTextAnswer(answer_get.getTextAnswer());
			answersDTO.add(answer1dto);			
		}
		
		questionGetDTO.setAnswers(answersDTO);
		//questionGetDTO.setExplain(questionGet.getExplain());
		
		model.addAttribute("question", questionGetDTO);
		return "home";
	}
}
