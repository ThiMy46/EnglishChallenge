package english;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jointeam database table.
 * 
 */
@Entity
@NamedQuery(name="Jointeam.findAll", query="SELECT j FROM Jointeam j")
public class Jointeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idJoinTeam;

	private byte[] lead;

	private byte[] ready;

	//bi-directional many-to-one association to Team
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTeam")
	private Team team;

	//bi-directional many-to-one association to Userinfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private UserInfo userinfo;

	public Jointeam() {
	}

	public int getIdJoinTeam() {
		return this.idJoinTeam;
	}

	public void setIdJoinTeam(int idJoinTeam) {
		this.idJoinTeam = idJoinTeam;
	}

	public byte[] getLead() {
		return this.lead;
	}

	public void setLead(byte[] lead) {
		this.lead = lead;
	}

	public byte[] getReady() {
		return this.ready;
	}

	public void setReady(byte[] ready) {
		this.ready = ready;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public UserInfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

}