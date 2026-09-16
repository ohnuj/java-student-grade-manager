package DTO;

import java.util.ArrayList;

public class StudentDTO {
	String studentName;
	int age;
	ArrayList<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
	
	public StudentDTO(){
		
	}
	
	public String getName() {
		return studentName;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.studentName = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ArrayList<SubjectDTO>getSubject() {
		return subjects;
	}
}
