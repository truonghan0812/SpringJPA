package com.truonghan.entities;

public class Teaser {

	private String title;
	private String athor;
	private String teaserText;
	
	
	
	
	public Teaser(String title, String athor, String teaserText) {
		super();
		this.title = title;
		this.athor = athor;
		this.teaserText = teaserText;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAthor() {
		return athor;
	}
	public void setAthor(String athor) {
		this.athor = athor;
	}
	public String getTeaserText() {
		return teaserText;
	}
	public void setTeaserText(String teaserText) {
		this.teaserText = teaserText;
	}
}
