package com.example.myfirstapp;

public class Shape {
	private Integer type;
	private int occurrence;
	
	public Shape(Integer type) {
		occurrence = 0;
		this.type = type;
	}
	
	public boolean isAllMatched () {
		// If there are already 2 buttons matched with this shape, return true
		if (occurrence == 2)
			return true;
		return false;
	}
	
	public void incrementOccurrence () {
		occurrence++;
	}
	
	public Integer getType() {
		return type;
	}
}
