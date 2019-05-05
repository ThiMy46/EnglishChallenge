package ute.tkpmgd.EnglishChallenge.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the team database table.
 * 
 */
@Entity
@Table(name="team")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTeam;

	@Column(name="in_match")
	private boolean inMatch;

	private int level;

	private String nameTeam;

	@OneToMany(mappedBy="team")
	private List<JoinTeam> jointeams;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idChallenge")
	private Challenge challenge;

	@OneToMany(mappedBy="team")
	private List<TeamAnswer> teamanswers;

	public Team() {
	}

	public int getIdTeam() {
		return this.idTeam;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}

	public boolean getInMatch() {
		return this.inMatch;
	}

	public void setInMatch(boolean inMatch) {
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

	public List<JoinTeam> getJointeams() {
		return this.jointeams;
	}

	public void setJointeams(List<JoinTeam> jointeams) {
		this.jointeams = jointeams;
	}

	public JoinTeam addJointeam(JoinTeam jointeam) {
		getJointeams().add(jointeam);
		jointeam.setTeam(this);

		return jointeam;
	}

	public JoinTeam removeJointeam(JoinTeam jointeam) {
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

	public List<TeamAnswer> getTeamanswers() {
		return this.teamanswers;
	}

	public void setTeamanswers(List<TeamAnswer> teamanswers) {
		this.teamanswers = teamanswers;
	}

	public TeamAnswer addTeamanswer(TeamAnswer teamanswer) {
		getTeamanswers().add(teamanswer);
		teamanswer.setTeam(this);

		return teamanswer;
	}

	public TeamAnswer removeTeamanswer(TeamAnswer teamanswer) {
		getTeamanswers().remove(teamanswer);
		teamanswer.setTeam(null);

		return teamanswer;
	}

}