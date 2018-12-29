package com.bceden.digester;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

public class DigesterStudents {
	private Vector<Student> students;
	
	public DigesterStudents(){
		students = new Vector<Student>();
	}
	
	public static void main(String[] args){
		DigesterStudents ds = new DigesterStudents();
		ds.digester();
	}
	
	private void digester(){
		Digester digester = new Digester();
		digester.push(this);
		
		digester.addObjectCreate("students/student", Student.class.getName());
		digester.addCallMethod("students/student/name", "setName",1);
		digester.addCallParam("students/student/name", 0);
		digester.addCallMethod("students/student/course", "setCourse",0);
		digester.addSetNext("students/student", "addStudents");
		digester.addSetProperty("students/student/set-name-property", "propertyName", "propertyValue");
		digester.addSetProperty("students/student/set-course-property", "propertyName", "propertyValue");
		
		try {
			InputStream in = this.getClass().getClassLoader()
				.getResourceAsStream("students.xml");
			DigesterStudents ds = (DigesterStudents)digester.parse(in);
			digester.setDebug(10);
			System.out.println(ds.students);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
	
	public void addStudents(Student student){
		students.add(student);
	}
}
