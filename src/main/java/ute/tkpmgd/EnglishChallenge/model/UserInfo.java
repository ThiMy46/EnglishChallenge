package ute.tkpmgd.EnglishChallenge.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the userinfo database table.
 * 
 */
@Entity
@Table(name="userinfo")
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUser;

	private boolean active;

	private String avatar;

	private String birthday;

	private String email;

	private int exp;

	private String fullname;

	private boolean gender;

	private int level;

	private boolean online;

	private String phone;

	@OneToMany(mappedBy="userinfo")
	private List<Jointeam> jointeams;

	@OneToMany(mappedBy="userinfo1")
	private List<UserChat> userchats1;

	@OneToMany(mappedBy="userinfo2")
	private List<UserChat> userchats2;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private User user;

	@OneToMany(mappedBy="userinfo")
	private List<UserMission> usermissions;

	public UserInfo() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
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

	public boolean getGender() {
		return this.gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean getOnline() {
		return this.online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Jointeam> getJointeams() {
		return this.jointeams;
	}

	public void setJointeams(List<Jointeam> jointeams) {
		this.jointeams = jointeams;
	}

	public Jointeam addJointeam(Jointeam jointeam) {
		getJointeams().add(jointeam);
		jointeam.setUserinfo(this);

		return jointeam;
	}

	public Jointeam removeJointeam(Jointeam jointeam) {
		getJointeams().remove(jointeam);
		jointeam.setUserinfo(null);

		return jointeam;
	}

	public List<UserChat> getUserchats1() {
		return this.userchats1;
	}

	public void setUserchats1(List<UserChat> userchats1) {
		this.userchats1 = userchats1;
	}

	public UserChat addUserchats1(UserChat userchats1) {
		getUserchats1().add(userchats1);
		userchats1.setUserinfo1(this);

		return userchats1;
	}

	public UserChat removeUserchats1(UserChat userchats1) {
		getUserchats1().remove(userchats1);
		userchats1.setUserinfo1(null);

		return userchats1;
	}

	public List<UserChat> getUserchats2() {
		return this.userchats2;
	}

	public void setUserchats2(List<UserChat> userchats2) {
		this.userchats2 = userchats2;
	}

	public UserChat addUserchats2(UserChat userchats2) {
		getUserchats2().add(userchats2);
		userchats2.setUserinfo2(this);

		return userchats2;
	}

	public UserChat removeUserchats2(UserChat userchats2) {
		getUserchats2().remove(userchats2);
		userchats2.setUserinfo2(null);

		return userchats2;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<UserMission> getUsermissions() {
		return this.usermissions;
	}

	public void setUsermissions(List<UserMission> usermissions) {
		this.usermissions = usermissions;
	}

	public UserMission addUsermission(UserMission usermission) {
		getUsermissions().add(usermission);
		usermission.setUserinfo(this);

		return usermission;
	}

	public UserMission removeUsermission(UserMission usermission) {
		getUsermissions().remove(usermission);
		usermission.setUserinfo(null);

		return usermission;
	}

}