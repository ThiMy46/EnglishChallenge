package ute.tkpmgd.EnglishChallenge.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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
	
	private int total1;
	
	private int total2;
	
	private int timeRemain = 600000; // 10 minutes
	
	private int idQuestion1 = 1;
	
	private int idQuestion2 = 1;
	
	private String message1;
	
	private String message2;
	
	private int seen1;
	
	private int seen2;

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

	public int getTotal1() {
		return total1;
	}

	public void setTotal1(int total1) {
		this.total1 = total1;
	}

	public int getTotal2() {
		return total2;
	}

	public void setTotal2(int total2) {
		this.total2 = total2;
	}

	public int getTimeRemain() {
		return timeRemain;
	}

	public void setTimeRemain(int timeRemain) {
		this.timeRemain = timeRemain;
	}

	public int getIdQuestion1() {
		return idQuestion1;
	}

	public void setIdQuestion1(int idQuestion1) {
		this.idQuestion1 = idQuestion1;
	}

	public int getIdQuestion2() {
		return idQuestion2;
	}

	public void setIdQuestion2(int idQuestion2) {
		this.idQuestion2 = idQuestion2;
	}

	public String getMessage1() {
		return message1;
	}

	public void setMessage1(String message1) {
		this.message1 = message1;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	public int getSeen1() {
		return seen1;
	}

	public void setSeen1(int seen1) {
		this.seen1 = seen1;
	}

	public int getSeen2() {
		return seen2;
	}

	public void setSeen2(int seen2) {
		this.seen2 = seen2;
	}

}