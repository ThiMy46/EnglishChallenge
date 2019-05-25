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
	@Column(name="id_usermission")
	private int idUsermission;

	@Column(name="last_result")
	private int lastResult;

	private int state;

	//bi-directional many-to-one association to Mission
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_mission")
	private Mission mission;

	//bi-directional many-to-one association to Userinfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user")
	private UserInfo userinfo;

	public UserMission() {
	}

	public int getIdUsermission() {
		return this.idUsermission;
	}

	public void setIdUsermission(int idUsermission) {
		this.idUsermission = idUsermission;
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