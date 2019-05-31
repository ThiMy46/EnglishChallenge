package ute.tkpmgd.EnglishChallenge.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ute.tkpmgd.EnglishChallenge.dao.UserInfoRepository;
import ute.tkpmgd.EnglishChallenge.exception.NotFoundException;
import ute.tkpmgd.EnglishChallenge.model.UserInfo;
import ute.tkpmgd.EnglishChallenge.service.IUserInfoService;

@Service
public class UserInfoServiceImp implements IUserInfoService{

	@Autowired
	UserInfoRepository userInfoRe;
	
	@Override
	public UserInfo getUserInfoById(int id) {
		return userInfoRe.findById(id)
				.orElseThrow(() -> new NotFoundException());
	}

}
