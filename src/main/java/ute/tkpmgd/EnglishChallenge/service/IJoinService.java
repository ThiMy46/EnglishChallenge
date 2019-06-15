package ute.tkpmgd.EnglishChallenge.service;

import java.util.concurrent.ScheduledFuture;

import ute.tkpmgd.EnglishChallenge.response.ResultResponse;
import ute.tkpmgd.EnglishChallenge.response.StatusJoinResponse;
import ute.tkpmgd.EnglishChallenge.response.StatusUserAnswerResponse;

public interface IJoinService {
	
	public final int FIXED_RATE = 1000; // 1 second
	public final int MAX_SECONDS = 600000; // 10 minutes
	public final int MAX_QUESTIONS = 10;
	
	public StatusJoinResponse readyToJoin(int userId);
	public StatusJoinResponse waitToJoin(int joinId);
	public void processTimeSecond(int joinId, ScheduledFuture<?> scheduledFuture);
	public int getTimeSecond(int joinId);
	public ResultResponse completeJoin(int joinId);
	public StatusUserAnswerResponse saveUserAnswer(int userId, int questionId, int answer, int joinId);
}
