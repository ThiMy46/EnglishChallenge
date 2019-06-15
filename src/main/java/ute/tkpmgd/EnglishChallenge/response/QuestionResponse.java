package ute.tkpmgd.EnglishChallenge.response;

import ute.tkpmgd.EnglishChallenge.model.TestQuestion;

public class QuestionResponse {

	private int id;
	private String content;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	
	public QuestionResponse(TestQuestion question) {
		this.id = question.getIdquestion();
		this.content = question.getQuestion();
		this.answer1 = question.getAs1();
		this.answer2 = question.getAs2();
		this.answer3 = question.getAs3();
		this.answer4 = question.getAs4();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	
	
}
