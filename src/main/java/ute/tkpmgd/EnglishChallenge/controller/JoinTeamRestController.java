package ute.tkpmgd.EnglishChallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ute.tkpmgd.EnglishChallenge.dto.ChallengeDTO;
import ute.tkpmgd.EnglishChallenge.dto.JoinTeamDTO;
import ute.tkpmgd.EnglishChallenge.dto.UserInfoDTO;
import ute.tkpmgd.EnglishChallenge.model.Challenge;
import ute.tkpmgd.EnglishChallenge.model.JoinTeam;
import ute.tkpmgd.EnglishChallenge.model.UserInfo;
import ute.tkpmgd.EnglishChallenge.serviceImp.ChallengeServiceImp;
import ute.tkpmgd.EnglishChallenge.serviceImp.JoinTeamServiceImp;
import ute.tkpmgd.EnglishChallenge.serviceImp.UserInfoServiceImp;

@RestController
@RequestMapping("/api/team")
public class JoinTeamRestController {
	@Autowired 
	ChallengeServiceImp challengeSer;
	@Autowired
	UserInfoServiceImp userinfoSer;
	@Autowired
	JoinTeamServiceImp jointeamSer;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> createTeam() {
		
		//get two user - default available
		UserInfo user1 = userinfoSer.getUserInfoById(1);
		UserInfo user2 = userinfoSer.getUserInfoById(2);
		
		Challenge challenge = challengeSer.getChallengeById(1);
		
		//add user to team just add
		
		JoinTeam join1 = new JoinTeam();//user 1
		join1.setChallenge(challenge);
		join1.setUserinfo(user1);
		join1.setReady(true);
		JoinTeam join_add1 = jointeamSer.createJoinTeam(join1);
		
		JoinTeam join2 = new JoinTeam();//user 2
		join2.setChallenge(challenge);
		join2.setReady(true);
		join2.setUserinfo(user2);
		join2.setResult(0);
		JoinTeam join_add2 = jointeamSer.createJoinTeam(join2);
		
		//send info jointeam, include infomation of: infoUser, 2 user join, challenge
		JoinTeamDTO joinDTO1 = new JoinTeamDTO();
		joinDTO1.setIdJointeam(join_add1.getIdJointeam());
		
		UserInfoDTO userinfo1 = new UserInfoDTO();
		userinfo1.setIdUser(user1.getIdUser());
		userinfo1.setAvatar(user1.getAvatar());
		userinfo1.setEmail(user1.getEmail());
		userinfo1.setFullname(user1.getFullname());
		userinfo1.setLevel(user1.getLevel());
		userinfo1.setExp(user1.getExp());
		
		UserInfoDTO userinfo2 = new UserInfoDTO();
		userinfo2.setIdUser(user2.getIdUser());
		userinfo2.setAvatar(user2.getAvatar());
		userinfo2.setEmail(user2.getEmail());
		userinfo2.setFullname(user2.getFullname());
		userinfo2.setLevel(user2.getLevel());
		userinfo2.setExp(user2.getExp());
		
		joinDTO1.setUserinfo(userinfo1);
		
		ChallengeDTO challengeDTO = new ChallengeDTO();
		challengeDTO.setIdChallenge(challenge.getIdChallenge());
		challengeDTO.setLevel(challenge.getLevel());
		challengeDTO.setTypeChallenge(challenge.getTypeChallenge());
		challengeDTO.setCreateTime(challenge.getCreateTime());
		joinDTO1.setChallenge(challengeDTO);
		
		
		return ResponseEntity.ok().body(joinDTO1);
	}
}
