package ute.tkpmgd.EnglishChallenge.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the challengequestion database table.
 * 
 */
@Entity
@Table(name="challengequestion")
public class Challengequestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idChallengeQuestion;

	//bi-directional many-to-one association to Challenge
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idChallenge")
	private Challenge challenge;

	//bi-directional many-to-one association to Question
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idQuestion")
	private Question question;

	//bi-directional many-to-one association to Teamanswer
	@OneToMany(mappedBy="challengequestion")
	private List<Teamanswer> teamanswers;

	public Challengequestion() {
	}

	public int getIdChallengeQuestion() {
		return this.idChallengeQuestion;
	}

	public void setIdChallengeQuestion(int idChallengeQuestion) {
		this.idChallengeQuestion = idChallengeQuestion;
	}

	public Challenge getChallenge() {
		return this.challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Teamanswer> getTeamanswers() {
		return this.teamanswers;
	}

	public void setTeamanswers(List<Teamanswer> teamanswers) {
		this.teamanswers = teamanswers;
	}

	public Teamanswer addTeamanswer(Teamanswer teamanswer) {
		getTeamanswers().add(teamanswer);
		teamanswer.setChallengequestion(this);

		return teamanswer;
	}

	public Teamanswer removeTeamanswer(Teamanswer teamanswer) {
		getTeamanswers().remove(teamanswer);
		teamanswer.setChallengequestion(null);

		return teamanswer;
	}

}