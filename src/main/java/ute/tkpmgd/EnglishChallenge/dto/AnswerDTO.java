package ute.tkpmgd.EnglishChallenge.dto;

public class AnswerDTO{

	private int idAnswer;
	private int inCorrect;
	private String textAnswer;
	private QuestionDTO question;

	public AnswerDTO() {
	}

	public int getIdAnswer() {
		return this.idAnswer;
	}

	public void setIdAnswer(int idAnswer) {
		this.idAnswer = idAnswer;
	}

	public int getInCorrect() {
		return this.inCorrect;
	}

	public void setInCorrect(int inCorrect) {
		this.inCorrect = inCorrect;
	}

	public String getTextAnswer() {
		return this.textAnswer;
	}

	public void setTextAnswer(String textAnswer) {
		this.textAnswer = textAnswer;
	}

	public QuestionDTO getQuestion() {
		return question;
	}

	public void setQuestion(QuestionDTO question) {
		this.question = question;
	}

	
}