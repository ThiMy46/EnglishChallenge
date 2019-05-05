package ute.tkpmgd.EnglishChallenge.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the challenge database table.
 * 
 */
@Entity
@Table(name="challenge")
public class Challenge implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idChallenge;

	private String createTime;

	private int level;

	private boolean typeChallenge;

	//bi-directional many-to-one association to Challengequestion
	@OneToMany(mappedBy="challenge")
	private List<ChallengeQuestion> challengequestions;

	//bi-directional many-to-one association to Team
	@OneToMany(mappedBy="challenge")
	private List<Team> teams;

	public Challenge() {
	}

	public int getIdChallenge() {
		return this.idChallenge;
	}

	public void setIdChallenge(int idChallenge) {
		this.idChallenge = idChallenge;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean getTypeChallenge() {
		return this.typeChallenge;
	}

	public void setTypeChallenge(boolean typeChallenge) {
		this.typeChallenge = typeChallenge;
	}

	public List<ChallengeQuestion> getChallengequestions() {
		return this.challengequestions;
	}

	public void setChallengequestions(List<ChallengeQuestion> challengequestions) {
		this.challengequestions = challengequestions;
	}

	public ChallengeQuestion addChallengequestion(ChallengeQuestion challengequestion) {
		getChallengequestions().add(challengequestion);
		challengequestion.setChallenge(this);

		return challengequestion;
	}

	public ChallengeQuestion removeChallengequestion(ChallengeQuestion challengequestion) {
		getChallengequestions().remove(challengequestion);
		challengequestion.setChallenge(null);

		return challengequestion;
	}

	public List<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Team addTeam(Team team) {
		getTeams().add(team);
		team.setChallenge(this);

		return team;
	}

	public Team removeTeam(Team team) {
		getTeams().remove(team);
		team.setChallenge(null);

		return team;
	}

}