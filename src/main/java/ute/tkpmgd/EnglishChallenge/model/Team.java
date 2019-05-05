package english;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the team database table.
 * 
 */
@Entity
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTeam;

	@Column(name="in_match")
	private byte[] inMatch;

	private int level;

	private String nameTeam;

	//bi-directional many-to-one association to Jointeam
	@OneToMany(mappedBy="team")
	private List<Jointeam> jointeams;

	//bi-directional many-to-one association to Challenge
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idChallenge")
	private Challenge challenge;

	//bi-directional many-to-one association to Teamanswer
	@OneToMany(mappedBy="team")
	private List<Teamanswer> teamanswers;

	public Team() {
	}

	public int getIdTeam() {
		return this.idTeam;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}

	public byte[] getInMatch() {
		return this.inMatch;
	}

	public void setInMatch(byte[] inMatch) {
		this.inMatch = inMatch;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getNameTeam() {
		return this.nameTeam;
	}

	public void setNameTeam(String nameTeam) {
		this.nameTeam = nameTeam;
	}

	public List<Jointeam> getJointeams() {
		return this.jointeams;
	}

	public void setJointeams(List<Jointeam> jointeams) {
		this.jointeams = jointeams;
	}

	public Jointeam addJointeam(Jointeam jointeam) {
		getJointeams().add(jointeam);
		jointeam.setTeam(this);

		return jointeam;
	}

	public Jointeam removeJointeam(Jointeam jointeam) {
		getJointeams().remove(jointeam);
		jointeam.setTeam(null);

		return jointeam;
	}

	public Challenge getChallenge() {
		return this.challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}

	public List<Teamanswer> getTeamanswers() {
		return this.teamanswers;
	}

	public void setTeamanswers(List<Teamanswer> teamanswers) {
		this.teamanswers = teamanswers;
	}

	public Teamanswer addTeamanswer(Teamanswer teamanswer) {
		getTeamanswers().add(teamanswer);
		teamanswer.setTeam(this);

		return teamanswer;
	}

	public Teamanswer removeTeamanswer(Teamanswer teamanswer) {
		getTeamanswers().remove(teamanswer);
		teamanswer.setTeam(null);

		return teamanswer;
	}

}