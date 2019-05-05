package english;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userchat database table.
 * 
 */
@Entity
@NamedQuery(name="Userchat.findAll", query="SELECT u FROM Userchat u")
public class Userchat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUserChat;

	private String message;

	private String time;

	//bi-directional many-to-one association to Userinfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUserReceive")
	private Userinfo userinfo1;

	//bi-directional many-to-one association to Userinfo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUserSend")
	private Userinfo userinfo2;

	public Userchat() {
	}

	public int getIdUserChat() {
		return this.idUserChat;
	}

	public void setIdUserChat(int idUserChat) {
		this.idUserChat = idUserChat;
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

	public Userinfo getUserinfo1() {
		return this.userinfo1;
	}

	public void setUserinfo1(Userinfo userinfo1) {
		this.userinfo1 = userinfo1;
	}

	public Userinfo getUserinfo2() {
		return this.userinfo2;
	}

	public void setUserinfo2(Userinfo userinfo2) {
		this.userinfo2 = userinfo2;
	}

}