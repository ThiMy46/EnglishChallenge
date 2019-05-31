package ute.tkpmgd.EnglishChallenge.dto;

import java.util.List;

public class UserInfoDTO{
	private int idUser;
	private byte active;
	private String avatar;
	private String birthday;
	private String email;
	private int exp;
	private String fullname;
	private byte gender;
	private int level;
	private byte online;
	private String phone;
	private List<JoinTeamDTO> jointeams;

	public UserInfoDTO() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getExp() {
		return this.exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public byte getGender() {
		return this.gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public byte getOnline() {
		return this.online;
	}

	public void setOnline(byte online) {
		this.online = online;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<JoinTeamDTO> getJointeams() {
		return jointeams;
	}

	public void setJointeams(List<JoinTeamDTO> jointeams) {
		this.jointeams = jointeams;
	}


}