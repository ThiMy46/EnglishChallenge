package english;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idQuestion;

	@Lob
	private String explain;

	private int level;

	@Lob
	private String textQuestion;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="question")
	private List<Answer> answers;

	//bi-directional many-to-one association to Challengequestion
	@OneToMany(mappedBy="question")
	private List<Challengequestion> challengequestions;

	//bi-directional many-to-one association to Mission
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idMission")
	private Mission mission;

	public Question() {
	}

	public int getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getExplain() {
		return this.explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getTextQuestion() {
		return this.textQuestion;
	}

	public void setTextQuestion(String textQuestion) {
		this.textQuestion = textQuestion;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setQuestion(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setQuestion(null);

		return answer;
	}

	public List<Challengequestion> getChallengequestions() {
		return this.challengequestions;
	}

	public void setChallengequestions(List<Challengequestion> challengequestions) {
		this.challengequestions = challengequestions;
	}

	public Challengequestion addChallengequestion(Challengequestion challengequestion) {
		getChallengequestions().add(challengequestion);
		challengequestion.setQuestion(this);

		return challengequestion;
	}

	public Challengequestion removeChallengequestion(Challengequestion challengequestion) {
		getChallengequestions().remove(challengequestion);
		challengequestion.setQuestion(null);

		return challengequestion;
	}

	public Mission getMission() {
		return this.mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

}