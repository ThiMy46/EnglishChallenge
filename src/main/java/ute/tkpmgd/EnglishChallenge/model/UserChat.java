package ute.tkpmgd.EnglishChallenge.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userchat database table.
 * 
 */
@Entity
@Table(name="userchat")
public class UserChat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_userchat")
	private int idUserchat;

	private String message;

	private String time;

	//bi-directional many-to-one association to Userinfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_userreceive")
	private UserInfo userinfo1;

	//bi-directional many-to-one association to Userinfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usersend")
	private UserInfo userinfo2;

	public UserChat() {
	}

	public int getIdUserchat() {
		return this.idUserchat;
	}

	public void setIdUserchat(int idUserchat) {
		this.idUserchat = idUserchat;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public UserInfo getUserinfo1() {
		return this.userinfo1;
	}

	public void setUserinfo1(UserInfo userinfo1) {
		this.userinfo1 = userinfo1;
	}

	public UserInfo getUserinfo2() {
		return this.userinfo2;
	}

	public void setUserinfo2(UserInfo userinfo2) {
		this.userinfo2 = userinfo2;
	}


}