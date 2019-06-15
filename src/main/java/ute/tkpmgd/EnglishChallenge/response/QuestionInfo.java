package ute.tkpmgd.EnglishChallenge.response;

import ute.tkpmgd.EnglishChallenge.model.TestQuestion;

public class QuestionInfo {
	private int id;
	private String question;
	private String answer;
	private String review;
	
	public QuestionInfo(TestQuestion question) {
		this.id = question.getIdquestion();
		this.question = question.getQuestion();
		this.review = question.getReview();
		switch (question.getRight()) {
		case 1:
			this.answer = question.getAs1();
			break;
		case 2:
			this.answer = question.getAs2();
			break;
		case 3:
			this.answer = question.getAs3();
			break;
		default:
			this.answer = question.getAs4();
			break;
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}

	
}
