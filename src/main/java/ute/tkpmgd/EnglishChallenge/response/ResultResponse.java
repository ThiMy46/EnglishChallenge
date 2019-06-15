package ute.tkpmgd.EnglishChallenge.response;

import java.util.List;

public class ResultResponse {

	private List<ResultUserInfo> userInfos;
	
	private List<QuestionInfo> questionInfos;
	
	private int timeRemain;

	public List<ResultUserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<ResultUserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public List<QuestionInfo> getQuestionInfos() {
		return questionInfos;
	}

	public void setQuestionInfos(List<QuestionInfo> questionInfos) {
		this.questionInfos = questionInfos;
	}

	public int getTimeRemain() {
		return timeRemain;
	}

	public void setTimeRemain(int timeRemain) {
		this.timeRemain = timeRemain;
	}
	
}
