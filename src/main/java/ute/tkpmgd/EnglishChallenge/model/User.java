package ute.tkpmgd.EnglishChallenge.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;

	private String password;

	private String rolename;

	private String username;

	//bi-directional many-to-one association to Userinfo
	@OneToMany(mappedBy="user")
	private List<UserInfo> userinfos;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserInfo> getUserinfos() {
		return userinfos;
	}

	public void setUserinfos(List<UserInfo> userinfos) {
		this.userinfos = userinfos;
	}

}