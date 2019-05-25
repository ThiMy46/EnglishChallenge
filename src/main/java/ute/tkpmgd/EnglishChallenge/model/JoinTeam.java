package ute.tkpmgd.EnglishChallenge.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jointeam database table.
 * 
 */
@Entity
@Table(name="jointeam")
public class JoinTeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_jointeam")
	private int idJointeam;

	private byte lead;

	private byte ready;

	//bi-directional many-to-one association to Team
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_team")
	private Team team;

	//bi-directional many-to-one association to Userinfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user")
	private UserInfo userinfo;

	public JoinTeam() {
	}

	public int getIdJointeam() {
		return this.idJointeam;
	}

	public void setIdJointeam(int idJointeam) {
		this.idJointeam = idJointeam;
	}

	public byte getLead() {
		return this.lead;
	}

	public void setLead(byte lead) {
		this.lead = lead;
	}

	public byte getReady() {
		return this.ready;
	}

	public void setReady(byte ready) {
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