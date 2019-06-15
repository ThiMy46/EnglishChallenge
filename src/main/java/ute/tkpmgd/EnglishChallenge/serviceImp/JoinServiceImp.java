package ute.tkpmgd.EnglishChallenge.serviceImp;

import java.util.List;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ute.tkpmgd.EnglishChallenge.dao.JoinRepository;
import ute.tkpmgd.EnglishChallenge.dao.TestQuestionRepository;
import ute.tkpmgd.EnglishChallenge.model.Join;
import ute.tkpmgd.EnglishChallenge.model.TestQuestion;
import ute.tkpmgd.EnglishChallenge.response.StatusJoinResponse;
import ute.tkpmgd.EnglishChallenge.response.StatusUserAnswerResponse;
import ute.tkpmgd.EnglishChallenge.service.IJoinService;

@Service
public class JoinServiceImp implements IJoinService{

	@Autowired
	private JoinRepository joinRepository;
	
	@Autowired
	private TestQuestionRepository testQuestionRepository;

	@Override
	public StatusJoinResponse readyToJoin(int userId) {
		StatusJoinResponse joinResponse = new StatusJoinResponse();
		Join join = null;
		List<Join> emptyJoins = joinRepository.findJoinEmpty();
		if (CollectionUtils.isEmpty(emptyJoins)) {
			join = new Join();
			join.setUser1(userId);
			join = joinRepository.save(join);
			joinResponse.setStatus(false);
			joinResponse.setJoinId(join.getId());
		} else {
			join = emptyJoins.get(0);
			join.setUser2(userId);
			join = joinRepository.save(join);
			joinResponse.setStatus(true);
			joinResponse.setJoinId(join.getId());
		}
		return joinResponse;
	}

	@Override
	public StatusJoinResponse waitToJoin(int joinId) {
		StatusJoinResponse joinResponse = new StatusJoinResponse();
		joinResponse.setStatus(false);
		joinResponse.setJoinId(joinId);
		Join join = joinRepository.getOne(joinId);
		if(join.getUser2() > 0) {
			joinResponse.setStatus(true);
		}
		return joinResponse;
	}

	@Override
	public void processTimeSecond(int joinId, ScheduledFuture<?> scheduledFuture) {
		Join join = joinRepository.getOne(joinId);
		int timeRemain = join.getTimeRemain();
		timeRemain -= IJoinService.FIXED_RATE;
		if(timeRemain <= 0) {
			scheduledFuture.cancel(false);
			timeRemain = 0;
		}
		join.setTimeRemain(timeRemain);
		joinRepository.save(join);
	}

	@Override
	public int getTimeSecond(int joinId) {
		Join join = joinRepository.getOne(joinId);
		return join.getTimeRemain();
	}

	@Override
	public StatusUserAnswerResponse saveUserAnswer(int userId, int questionId, int answer, int joinId) {
		TestQuestion question = testQuestionRepository.getOne(questionId);
		Join join = joinRepository.getOne(joinId);
		StatusUserAnswerResponse joinResponse = new StatusUserAnswerResponse();
		boolean isUser1 = join.getUser1() == userId;
		boolean isComplete;
		int score = question.getRight() == answer ? 1 : 0;
		int total, right;
		if (isUser1) {
			right = join.getRight1() + score;
			total = join.getTotal1() + 1;
			join.setRight1(right);
			join.setTotal1(total);
		} else {
			right = join.getRight1() + score;
			total = join.getTotal1() + 1;
			join.setRight2(right);
			join.setTotal2(total);
		}
		isComplete = total >= IJoinService.MAX_QUESTIONS;
		if (isComplete) {
			if (isUser1) {
				join.setTime1(IJoinService.MAX_SECONDS - join.getTimeRemain());
			} else {
				join.setTime2(IJoinService.MAX_SECONDS - join.getTimeRemain());
			}
		} else {
			joinResponse.setNextQuestion(++questionId);
		}
		joinRepository.save(join);
		
		joinResponse.setStatus(isComplete);
		joinResponse.setJoinId(joinId);
		return joinResponse;
	}
	

}
