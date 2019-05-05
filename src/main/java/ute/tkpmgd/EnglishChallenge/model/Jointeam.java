package ute.tkpmgd.EnglishChallenge.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jointeam database table.
 * 
 */
@Entity
@Table(name="jointeam")
public class Jointeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idJoinTeam;

	private boolean lead;

	private boolean ready;

	//bi-directional many-to-one association to Team
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTeam")
	private Team team;

	//bi-directional many-to-one association to Userinfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private Userinfo userinfo;

	public Jointeam() {
	}

	public int getIdJoinTeam() {
		return this.idJoinTeam;
	}

	public void setIdJoinTeam(int idJoinTeam) {
		this.idJoinTeam = idJoinTeam;
	}

	public boolean getLead() {
		return this.lead;
	}

	public void setLead(boolean lead) {
		this.lead = lead;
	}

	public boolean getReady() {
		return this.ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

}