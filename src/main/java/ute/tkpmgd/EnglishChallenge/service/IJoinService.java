package ute.tkpmgd.EnglishChallenge.service;

import java.util.concurrent.ScheduledFuture;

import ute.tkpmgd.EnglishChallenge.response.StatusJoinResponse;

public interface IJoinService {
	
	public static final long FIXED_RATE = 1000; // 1 second
	
	public StatusJoinResponse readyToJoin(int userId);
	public StatusJoinResponse waitToJoin(int joinId);
	public void processTimeSecond(int joinId, ScheduledFuture<?> scheduledFuture);
	public int getTimeSecond(int joinId);
}
