package ute.tkpmgd.EnglishChallenge.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.tkpmgd.EnglishChallenge.dao.JoinTeamRepository;
import ute.tkpmgd.EnglishChallenge.exception.NotFoundException;
import ute.tkpmgd.EnglishChallenge.model.JoinTeam;
import ute.tkpmgd.EnglishChallenge.service.IJoinTeamService;

@Service
public class JoinTeamServiceImp implements IJoinTeamService{

	@Autowired
	JoinTeamRepository jointeamRe;
	
	@Override
	public JoinTeam createJoinTeam(JoinTeam team) {
		return jointeamRe.save(team);
	}

	@Override
	public JoinTeam getJoinTeamById(int id) {
		return jointeamRe.findById(id)
				.orElseThrow(() -> new NotFoundException());
	}

}
