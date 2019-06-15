package ute.tkpmgd.EnglishChallenge.serviceImp;

import java.util.List;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ute.tkpmgd.EnglishChallenge.dao.JoinRepository;
import ute.tkpmgd.EnglishChallenge.model.Join;
import ute.tkpmgd.EnglishChallenge.response.StatusJoinResponse;
import ute.tkpmgd.EnglishChallenge.service.IJoinService;

@Service
public class JoinServiceImp implements IJoinService{

	@Autowired
	JoinRepository joinRepository;

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
	

}
