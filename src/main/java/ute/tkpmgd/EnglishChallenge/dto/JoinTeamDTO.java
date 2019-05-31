package ute.tkpmgd.EnglishChallenge.dto;

public class JoinTeamDTO{
	
	private int idJointeam;
	private byte lead;
	private byte ready;
	private ChallengeDTO challenge;
	private UserInfoDTO userinfo;

	public JoinTeamDTO() {
	}

	public int getIdJointeam() {
		return this.idJointeam;
	}

	public void setIdJointeam(int idJointeam) {
		this.idJointeam = idJointeam;
	}

	public byte getLead() {
		return this.lead;
	}

	public void setLead(byte lead) {
		this.lead = lead;
	}

	public byte getReady() {
		return this.ready;
	}

	public void setReady(byte ready) {
		this.ready = ready;
	}

	public ChallengeDTO getChallenge() {
		return challenge;
	}

	public void setChallenge(ChallengeDTO challenge) {
		this.challenge = challenge;
	}

	public UserInfoDTO getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfoDTO userinfo) {
		this.userinfo = userinfo;
	}


}