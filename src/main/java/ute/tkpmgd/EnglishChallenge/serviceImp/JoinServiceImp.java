package ute.tkpmgd.EnglishChallenge.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ute.tkpmgd.EnglishChallenge.dao.JoinRepository;
import ute.tkpmgd.EnglishChallenge.dao.TestQuestionRepository;
import ute.tkpmgd.EnglishChallenge.model.Join;
import ute.tkpmgd.EnglishChallenge.model.TestQuestion;
import ute.tkpmgd.EnglishChallenge.response.MessageResponse;
import ute.tkpmgd.EnglishChallenge.response.QuestionInfo;
import ute.tkpmgd.EnglishChallenge.response.ResultResponse;
import ute.tkpmgd.EnglishChallenge.response.ResultUserInfo;
import ute.tkpmgd.EnglishChallenge.response.StatusJoinResponse;
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
	public StatusJoinResponse saveUserAnswer(int userId, int answer, int joinId) {
		Join join = joinRepository.getOne(joinId);
		StatusJoinResponse joinResponse = new StatusJoinResponse();
		boolean isUser1 = join.getUser1() == userId;
		boolean isSave = true;
		TestQuestion question = isUser1 ? testQuestionRepository.getOne(join.getIdQuestion1()) 
				:testQuestionRepository.getOne(join.getIdQuestion2());
		boolean isComplete;
		int score = question.getRight() == answer ? 1 : 0;
		int total, right;
		if (isUser1) {
			right = join.getRight1() + score;
			total = join.getTotal1() + 1;
			join.setRight1(right);
			join.setTotal1(total);
		} else {
			right = join.getRight2() + score;
			total = join.getTotal2() + 1;
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
			if (isUser1) {
				join.setIdQuestion1(join.getIdQuestion1() + 1);
			} else {
				join.setIdQuestion2(join.getIdQuestion2() + 1);
			}
		}
		if (isUser1) {
			if (join.getTotal1() > 10)
				isSave = false;
		} else {
			if (join.getTotal2() > 10)
				isSave = false;
		}
		if(isSave)
			joinRepository.save(join);
		
		joinResponse.setStatus(isComplete);
		joinResponse.setJoinId(joinId);
		return joinResponse;
	}

	@Override
	public ResultResponse completeJoin(int joinId) {
		ResultResponse response = new ResultResponse();
		Join join = joinRepository.getOne(joinId);
		if (join.getTime1() == 0) {
			join.setTime1(MAX_SECONDS);
		}
		if (join.getTime2() == 0) {
			join.setTime2(MAX_SECONDS);
		}
		join = joinRepository.save(join);
		
		List<ResultUserInfo> userInfos = new ArrayList<>();
		
		ResultUserInfo userInfo = new ResultUserInfo();
		userInfo.setId(join.getUser1());
		userInfo.setScore(join.getRight1());
		userInfo.setTime(join.getTime1());
		userInfo.setTotal(join.getTotal1());
		userInfos.add(userInfo);
		
		userInfo = new ResultUserInfo();
		userInfo.setId(join.getUser2());
		userInfo.setScore(join.getRight2());
		userInfo.setTime(join.getTime2());
		userInfo.setTotal(join.getTotal2());
		userInfos.add(userInfo);

		List<QuestionInfo> questionInfos = testQuestionRepository.findAll().stream().map(QuestionInfo::new)
				.collect(Collectors.toList());
		
		response.setQuestionInfos(questionInfos);
		response.setUserInfos(userInfos);
		response.setTimeRemain(join.getTimeRemain());
		
		return response;
	}

	@Override
	public MessageResponse saveMessage(int joinId, String message, int userId) {
		MessageResponse response = new MessageResponse();
		Join join = joinRepository.getOne(joinId);
		if(userId == join.getUser1()) {
			join.setMessage1(message);
			join.setSeen1(1);
		} else if (userId == join.getUser2()){
			join.setMessage2(message);
			join.setSeen2(1);
		}
		joinRepository.save(join);
		response.setMe(true);
		response.setMessage(message);
		return response;
	}

	@Override
	public MessageResponse getMessage(int joinId, int userId) {
		MessageResponse response = new MessageResponse();
		Join join = joinRepository.getOne(joinId);
		response.setMe(false);
		if (userId == join.getUser1() && join.getSeen2() == 1) {
			join.setSeen2(0);
			response.setMessage(join.getMessage2());
		}
		if (userId == join.getUser2() && join.getSeen1() == 1) {
			join.setSeen1(0);
			response.setMessage(join.getMessage1());
		}
		joinRepository.save(join);
		return response;
	}

}
