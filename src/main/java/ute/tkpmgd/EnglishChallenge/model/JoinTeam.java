package ute.tkpmgd.EnglishChallenge.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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

	private boolean lead;

	private boolean ready;
	
	private int result;

	private String timecomplete;
	
	//bi-directional many-to-one association to Userinfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_challenge")
	private Challenge challenge;

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

	public UserInfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getTimecomplete() {
		return timecomplete;
	}

	public void setTimecomplete(String timecomplete) {
		this.timecomplete = timecomplete;
	}

	public Challenge getChallenge() {
		return challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}

	
}