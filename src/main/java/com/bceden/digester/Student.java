package com.bceden.digester;

public class Student {
	private String name;
	private String course;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String toString() {
		return ("Name=" + this.name + " & Course=" + this.course);
	}
}
