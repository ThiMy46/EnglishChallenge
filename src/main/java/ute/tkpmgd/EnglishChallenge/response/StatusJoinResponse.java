package ute.tkpmgd.EnglishChallenge.response;

public class StatusJoinResponse {

	protected boolean status = false;
	protected int joinId;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getJoinId() {
		return joinId;
	}
	public void setJoinId(int joinId) {
		this.joinId = joinId;
	}
	
}
