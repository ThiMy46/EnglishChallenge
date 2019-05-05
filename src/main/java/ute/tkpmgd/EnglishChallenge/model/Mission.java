package english;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mission database table.
 * 
 */
@Entity
@NamedQuery(name="Mission.findAll", query="SELECT m FROM Mission m")
public class Mission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMission;

	private int level;

	private String nameMission;

	private int receiveExp;

	private String typeMission;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="mission")
	private List<Question> questions;

	//bi-directional many-to-one association to Usermission
	@OneToMany(mappedBy="mission")
	private List<Usermission> usermissions;

	public Mission() {
	}

	public int getIdMission() {
		return this.idMission;
	}

	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getNameMission() {
		return this.nameMission;
	}

	public void setNameMission(String nameMission) {
		this.nameMission = nameMission;
	}

	public int getReceiveExp() {
		return this.receiveExp;
	}

	public void setReceiveExp(int receiveExp) {
		this.receiveExp = receiveExp;
	}

	public String getTypeMission() {
		return this.typeMission;
	}

	public void setTypeMission(String typeMission) {
		this.typeMission = typeMission;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setMission(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setMission(null);

		return question;
	}

	public List<Usermission> getUsermissions() {
		return this.usermissions;
	}

	public void setUsermissions(List<Usermission> usermissions) {
		this.usermissions = usermissions;
	}

	public Usermission addUsermission(Usermission usermission) {
		getUsermissions().add(usermission);
		usermission.setMission(this);

		return usermission;
	}

	public Usermission removeUsermission(Usermission usermission) {
		getUsermissions().remove(usermission);
		usermission.setMission(null);

		return usermission;
	}

}