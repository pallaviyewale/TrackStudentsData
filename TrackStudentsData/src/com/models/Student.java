package com.models;

public class Student
{ 
	private int ID;
	private String FirstName;
	private String LastName;
	private char Grade =  '\0';
	
	
	public Student (int id, String firstname, String lastname, char grade)
	{
		ID = id;
		FirstName = firstname;
		LastName = lastname;
		Grade = grade;
	}

	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public char getGrade() {
		return Grade;
	}


	public void setGrade(char grade) {
		Grade = grade;
	}
	
}

