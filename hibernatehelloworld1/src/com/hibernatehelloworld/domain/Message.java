package com.hibernatehelloworld.domain;


public class Message{

	private String text;
	private int id;
	public int getId() {
		return id;
	}
	public Message(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
