package english;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the teamanswer database table.
 * 
 */
@Entity
@NamedQuery(name="Teamanswer.findAll", query="SELECT t FROM Teamanswer t")
public class Teamanswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTeamAnswer;

	private String answer;

	private String time;

	//bi-directional many-to-one association to Challengequestion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idChallengeQuestion")
	private Challengequestion challengequestion;

	//bi-directional many-to-one association to Team
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTeam")
	private Team team;

	public Teamanswer() {
	}

	public int getIdTeamAnswer() {
		return this.idTeamAnswer;
	}

	public void setIdTeamAnswer(int idTeamAnswer) {
		this.idTeamAnswer = idTeamAnswer;
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

	public Challengequestion getChallengequestion() {
		return this.challengequestion;
	}

	public void setChallengequestion(Challengequestion challengequestion) {
		this.challengequestion = challengequestion;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}