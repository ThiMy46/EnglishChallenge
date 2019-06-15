package ute.tkpmgd.EnglishChallenge.serviceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.tkpmgd.EnglishChallenge.dao.TestQuestionRepository;
import ute.tkpmgd.EnglishChallenge.exception.NotFoundException;
import ute.tkpmgd.EnglishChallenge.model.TestQuestion;
import ute.tkpmgd.EnglishChallenge.service.ITestQuestionService;

@Service
public class TestQuestionServiceImp implements ITestQuestionService{

	@Autowired
	TestQuestionRepository testQuesRe;
	
	@Override
	public TestQuestion getQuestionById(int id) {
		return testQuesRe.findById(id)
				.orElseThrow(() -> new NotFoundException());
	}

}
