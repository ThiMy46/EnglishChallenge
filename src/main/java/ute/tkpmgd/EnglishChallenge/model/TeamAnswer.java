package ute.tkpmgd.EnglishChallenge.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the teamanswer database table.
 * 
 */
@Entity
@Table(name="teamanswer")
public class TeamAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_teamanswer")
	private int idTeamanswer;

	private String answer;

	private String time;

	//bi-directional many-to-one association to Challengequestion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_challengequestion")
	private ChallengeQuestion challengequestion;

	//bi-directional many-to-one association to Team
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="id_team")
//	private Team team;

	public TeamAnswer() {
	}

	public int getIdTeamanswer() {
		return this.idTeamanswer;
	}

	public void setIdTeamanswer(int idTeamanswer) {
		this.idTeamanswer = idTeamanswer;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public ChallengeQuestion getChallengequestion() {
		return this.challengequestion;
	}

	public void setChallengequestion(ChallengeQuestion challengequestion) {
		this.challengequestion = challengequestion;
	}


}