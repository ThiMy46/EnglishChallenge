package ute.tkpmgd.EnglishChallenge.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usermission database table.
 * 
 */
@Entity
@Table(name="usermission")
public class UserMission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUserMission;

	private int lastResult;

	private int state;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idMission")
	private Mission mission;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private UserInfo userinfo;

	public UserMission() {
	}

	public int getIdUserMission() {
		return this.idUserMission;
	}

	public void setIdUserMission(int idUserMission) {
		this.idUserMission = idUserMission;
	}

	public int getLastResult() {
		return this.lastResult;
	}

	public void setLastResult(int lastResult) {
		this.lastResult = lastResult;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Mission getMission() {
		return this.mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public UserInfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

}