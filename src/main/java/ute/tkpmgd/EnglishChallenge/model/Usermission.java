package english;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usermission database table.
 * 
 */
@Entity
@NamedQuery(name="Usermission.findAll", query="SELECT u FROM Usermission u")
public class Usermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUserMission;

	private int lastResult;

	private int state;

	//bi-directional many-to-one association to Mission
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idMission")
	private Mission mission;

	//bi-directional many-to-one association to Userinfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private Userinfo userinfo;

	public Usermission() {
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

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

}