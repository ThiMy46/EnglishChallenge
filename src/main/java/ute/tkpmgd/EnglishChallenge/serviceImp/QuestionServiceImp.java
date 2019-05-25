package ute.tkpmgd.EnglishChallenge.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.tkpmgd.EnglishChallenge.dao.QuestionRepository;
import ute.tkpmgd.EnglishChallenge.exception.QuestionNotFoundException;
import ute.tkpmgd.EnglishChallenge.model.Question;
import ute.tkpmgd.EnglishChallenge.service.IQuestionService;

@Service
public class QuestionServiceImp implements IQuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question findQuestionById(int id) {
		return questionRepository.findById(id)
				.orElseThrow(() -> new QuestionNotFoundException());
	}
}
