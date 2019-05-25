package ute.tkpmgd.EnglishChallenge.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the answer database table.
 * 
 */
@Entity
@Table(name="answer")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_answer")
	private int idAnswer;

	@Column(name="in_correct")
	private int inCorrect;

	@Lob
	@Column(name="text_answer")
	private String textAnswer;

	//bi-directional many-to-one association to Question
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_question")
	private Question question;

	public Answer() {
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

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}