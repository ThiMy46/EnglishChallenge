package ute.tkpmgd.EnglishChallenge.service;

import ute.tkpmgd.EnglishChallenge.model.JoinTeam;

public interface IJoinTeamService {

	public JoinTeam createJoinTeam(JoinTeam team);
	public JoinTeam getJoinTeamById(int id);
}
