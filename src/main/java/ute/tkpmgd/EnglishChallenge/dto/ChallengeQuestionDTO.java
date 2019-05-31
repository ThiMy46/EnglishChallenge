package ute.tkpmgd.EnglishChallenge.dto;

public class ChallengeQuestionDTO{

	private int idChallengequestion;
	private ChallengeDTO challenge;
	private QuestionDTO question;

	public ChallengeQuestionDTO() {
	}

	public int getIdChallengequestion() {
		return this.idChallengequestion;
	}

	public void setIdChallengequestion(int idChallengequestion) {
		this.idChallengequestion = idChallengequestion;
	}

	public ChallengeDTO getChallenge() {
		return challenge;
	}

	public void setChallenge(ChallengeDTO challenge) {
		this.challenge = challenge;
	}

	public QuestionDTO getQuestion() {
		return question;
	}

	public void setQuestion(QuestionDTO question) {
		this.question = question;
	}


}