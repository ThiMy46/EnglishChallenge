package ute.tkpmgd.EnglishChallenge.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the join database table.
 * 
 */
@Entity
@Table(name="joins")
public class Join implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int right1;

	private int right2;

	private int time1;

	private int time2;

	private int user1;

	private int user2;

	public Join() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRight1() {
		return this.right1;
	}

	public void setRight1(int right1) {
		this.right1 = right1;
	}

	public int getRight2() {
		return this.right2;
	}

	public void setRight2(int right2) {
		this.right2 = right2;
	}

	public int getTime1() {
		return this.time1;
	}

	public void setTime1(int time1) {
		this.time1 = time1;
	}

	public int getTime2() {
		return this.time2;
	}

	public void setTime2(int time2) {
		this.time2 = time2;
	}

	public int getUser1() {
		return this.user1;
	}

	public void setUser1(int user1) {
		this.user1 = user1;
	}

	public int getUser2() {
		return this.user2;
	}

	public void setUser2(int user2) {
		this.user2 = user2;
	}

}