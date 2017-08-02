package model;

import java.util.Date;

public class HistoryModel {
	
	private Date date;
	private String result;
	private String comments;
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return this.result;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getComments() {
		return this.comments;
	}
	
	@Override
	public String toString() {
		return "HistoryModel [date=" + this.date + ", result=" + this.result + ", comments=" + this.comments + "]";
	}

}
