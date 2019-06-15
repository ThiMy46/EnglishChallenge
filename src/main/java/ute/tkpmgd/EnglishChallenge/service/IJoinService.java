package ute.tkpmgd.EnglishChallenge.service;

import ute.tkpmgd.EnglishChallenge.model.Join;

public interface IJoinService {

	public Join getJoinById(int id);
	public Join createJoin(Join join);
}
