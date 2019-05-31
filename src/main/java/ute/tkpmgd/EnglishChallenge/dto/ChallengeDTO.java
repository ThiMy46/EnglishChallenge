package ute.tkpmgd.EnglishChallenge.dto;

import java.util.List;


public class ChallengeDTO {
	
	private int idChallenge;
	private String createTime;
	private int level;
	private boolean typeChallenge;
	private List<ChallengeQuestionDTO> challengequestions;
	private List<JoinTeamDTO> jointeams;

	public ChallengeDTO() {
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

	public void setTypeChallenge(boolean i) {
		this.typeChallenge = i;
	}

	public List<ChallengeQuestionDTO> getChallengequestions() {
		return challengequestions;
	}

	public void setChallengequestions(List<ChallengeQuestionDTO> challengequestions) {
		this.challengequestions = challengequestions;
	}

	public List<JoinTeamDTO> getJointeams() {
		return jointeams;
	}

	public void setJointeams(List<JoinTeamDTO> jointeams) {
		this.jointeams = jointeams;
	}

	
}