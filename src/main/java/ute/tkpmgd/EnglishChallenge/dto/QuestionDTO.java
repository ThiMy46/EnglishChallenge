package ute.tkpmgd.EnglishChallenge.dto;

import java.util.List;

public class QuestionDTO {
	
	private int idQuestion;
	private String explain;
	private int level;
	private String textQuestion;
	private List<AnswerDTO> answers;
	private List<ChallengeQuestionDTO> challengequestions;

	public QuestionDTO() {
	}

	public int getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getExplain() {
		return this.explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getTextQuestion() {
		return this.textQuestion;
	}

	public void setTextQuestion(String textQuestion) {
		this.textQuestion = textQuestion;
	}

	public List<AnswerDTO> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerDTO> answers) {
		this.answers = answers;
	}

	public List<ChallengeQuestionDTO> getChallengequestions() {
		return challengequestions;
	}

	public void setChallengequestions(List<ChallengeQuestionDTO> challengequestions) {
		this.challengequestions = challengequestions;
	}



}