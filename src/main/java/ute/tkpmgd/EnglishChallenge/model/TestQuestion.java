package ute.tkpmgd.EnglishChallenge.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the testquestion database table.
 * 
 */
@Entity
@Table(name="testquestion")
public class TestQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idquestion;

	@Lob
	private String as1;

	@Lob
	private String as2;

	@Lob
	private String as3;

	@Lob
	private String as4;

	@Lob
	private String question;

	@Lob
	private String review;

	private int right;

	public TestQuestion() {
	}

	public int getIdquestion() {
		return this.idquestion;
	}

	public void setIdquestion(int idquestion) {
		this.idquestion = idquestion;
	}

	public String getAs1() {
		return this.as1;
	}

	public void setAs1(String as1) {
		this.as1 = as1;
	}

	public String getAs2() {
		return this.as2;
	}

	public void setAs2(String as2) {
		this.as2 = as2;
	}

	public String getAs3() {
		return this.as3;
	}

	public void setAs3(String as3) {
		this.as3 = as3;
	}

	public String getAs4() {
		return this.as4;
	}

	public void setAs4(String as4) {
		this.as4 = as4;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRight() {
		return this.right;
	}

	public void setRight(int right) {
		this.right = right;
	}

}
