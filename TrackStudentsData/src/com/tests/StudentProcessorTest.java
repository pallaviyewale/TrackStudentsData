package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import com.models.StudentProcessor;

import org.testng.Assert;
import com.models.*;

public class StudentProcessorTest 
{ 
	StudentProcessor studentproc = new StudentProcessor();
	StudentProcessor studentprocList = new StudentProcessor();
	
	//******************** AddStudent Tests Start ******************************************* //
  
	@Test(groups = {"TestAddStudent"})
  public void testAddStudentSuccessfullIfValidData() 
  {
	  int actStudentId = studentproc.AddStudent("John","Amato");
	  Assert.assertTrue(actStudentId > 0);
  }
  
  @Test(groups = {"TestAddStudent"})
  public void testAddStudentSuccessfulForMaxFirstNameLength() 
  {
	  int actStudentId = studentproc.AddStudent("Julieeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee","Sampson");
	  Assert.assertTrue(actStudentId > 0);
  }
  
  @Test(groups = {"TestAddStudent"})
  public void testAddStudentSuccessfulForMaxLastNameLength() 
  {
	  int actStudentId = studentproc.AddStudent("Julie","Sampsonnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
	  Assert.assertTrue(actStudentId > 0);
  }
  
  @Test(groups = {"TestAddStudent"})
  public void testAddStudentSuccessfulForUniqueFirstNameLastName() 
  {
	  int actStudentId = studentproc.AddStudent("Joe","Bohemow");
	  Assert.assertTrue(actStudentId > 0);
  }
  
  @Test(groups = {"TestAddStudent"})
  public void testAddStudentFailedForUniqueFirstNameLastName() 
  {
	  int expStudentId = 0;
	  int actStudentId = studentproc.AddStudent("Joe","Bohemow");
	  Assert.assertEquals(actStudentId, expStudentId);
  }
  
  @Test(groups = {"TestAddStudent"})
  public void testAddStudentFailedIfSpecialCharsInFirstName() 
  {
	  int expStudentId = 0;
	  int actStudentId = studentproc.AddStudent("Margaret@","Lesse");
	  Assert.assertEquals(actStudentId, expStudentId);
  }
  
  @Test(groups = {"TestAddStudent"})
  public void testAddStudentFailedIfBlankFirstName() 
  {
	  int expStudentId = 0;
	  int actStudentId = studentproc.AddStudent("","Heather");
	  Assert.assertEquals(actStudentId, expStudentId);
  }

  @Test(groups = {"TestAddStudent"})
  public void testAddStudentFailedForMoreThanMaxFirstNameLength() 
  {
	  int expStudentId = 0;
	  int actStudentId = studentproc.AddStudent("Reedddddddddddddddddddddddddddddddddddddddddddddddddddddddd","Heather");
	  Assert.assertEquals(actStudentId, expStudentId);
  }
  
  @Test(groups = {"TestAddStudent"})
  public void testAddStudentFailedIfSpecialCharsInLastName() 
  {
	  int expStudentId = 0;
	  int actStudentId = studentproc.AddStudent("Read","Heather@");
	  Assert.assertEquals(actStudentId, expStudentId);
  }
  
  @Test(groups = {"TestAddStudent"})
  public void testAddStudentFailedIfBlankLastName() 
  {
	  int expStudentId = 0;
	  int actStudentId = studentproc.AddStudent("Read"," ");
	  Assert.assertEquals(actStudentId, expStudentId);
  }

  @Test(groups = {"TestAddStudent"})
  public void testAddStudentFailedForMoreThanMaxLastNameLength() 
  {
	  int expStudentId = 0;
	  int actStudentId = studentproc.AddStudent("Read","Heatherrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
	  Assert.assertEquals(actStudentId, expStudentId);
  }
 
//******************** AddStudent Tests End ******************************************* //
  
  
//******************** GetStudent Tests Start ******************************************* //
  
  @Test(groups = {"TestGetStudent"})
  public void testGetStudentSuccessfulForExistingStudentId() 
  {
	  Student studentObj = studentproc.GetStudent(1);
	  Assert.assertNotNull(studentObj);
	  Assert.assertEquals(studentObj.getID(), 1);
  }
  
  @Test(groups = {"TestGetStudent"})
  public void testGetStudentFailedForNonExistingStudentId() 
  {
	  Student studentObj = studentproc.GetStudent(2);
	  Assert.assertNull(studentObj);
  }
  
  @Test(groups = {"TestGetStudent"})
  public void testGetStudentFailedForNegativeStudentId() 
  {
	  Student studentObj = studentproc.GetStudent(-2);
	  Assert.assertNull(studentObj);
  }
  
  @Test(groups = {"TestGetStudent"})
  public void testGetStudentFailedForZeroStudentId() 
  {
	  Student studentObj = studentproc.GetStudent(0);
	  Assert.assertNull(studentObj);
  }
  
//******************** GetStudent Tests End ******************************************* //
  
//******************** UpdateStudent Tests Start ******************************************* //
 
  //Assumed returns boolean
  
  @Test(groups = {"TestUpdateStudent"})
  public void testUpdateStudentSuccessfulForValidFirstName() 
  {
	  Student studentObj = new Student(1, "JohnA", "Christi", 'A');
	  boolean actUpdateStatus = studentproc.UpdateStudent(studentObj);
	  Assert.assertEquals(actUpdateStatus, true);
  }
  
  @Test(groups = {"TestUpdateStudent"})
  public void testUpdateStudentSuccessfullIfValidLastName() 
  {
	  Student studentObj = new Student(2, "Scott", "Brookss", 'A');
	  boolean actUpdateStatus = studentproc.UpdateStudent(studentObj);
	  Assert.assertEquals(actUpdateStatus, true);
  }
  
  @Test(groups = {"TestUpdateStudent"})
  public void testUpdateStudentSuccessfullIfValidGrade() 
  {
	  Student studentObj = new Student(3, "Rayana", "Sampson", 'D');
	  boolean actUpdateStatus = studentproc.UpdateStudent(studentObj);
	  Assert.assertEquals(actUpdateStatus, true);
  }
  
  @Test(groups = {"TestUpdateStudent"})
  public void testUpdateStudentSuccessfulForMaxFirstNameLength() 
  {
	  Student studentObj = new Student(4, "Mikeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", "Mahoney", 'A');
	  boolean actUpdateStatus = studentproc.UpdateStudent(studentObj);
	  Assert.assertEquals(actUpdateStatus, true);
  }
  
  @Test(groups = {"TestUpdateStudent"})
  public void testUpdateStudentSuccessfulForMaxLasttNameLength() 
  {
	  Student studentObj = new Student(5, "Julie", "Marvineeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", 'A');
	  boolean actUpdateStatus = studentproc.UpdateStudent(studentObj);
	  Assert.assertEquals(actUpdateStatus, true);
  }
  
  @Test(groups = {"TestUpdateStudent"})
  public void testUpdateStudentFailedForUniqueFirstNameLastName() 
  {
	  Student studentObj = new Student(6, "John", "Amato", 'A');
	  boolean actUpdateStatus = studentproc.UpdateStudent(studentObj);
	  Assert.assertEquals(actUpdateStatus, false);
  }
  
  @Test(groups = {"TestUpdateStudent"})
  public void testUpdateStudentFailedIfSpecialCharsInFirstName() 
  {
	  Student studentObj = new Student(6, "John@", "Amato", 'A');
	  boolean actUpdateStatus = studentproc.UpdateStudent(studentObj);
	  Assert.assertEquals(actUpdateStatus, false);
  }
  
  @Test(groups = {"TestUpdateStudent"})
  public void testUpdateStudentFailedIfBlankFirstName() 
  {
	  Student studentObj = new Student(6, " ", "Amato", 'A');
	  boolean actUpdateStatus = studentproc.UpdateStudent(studentObj);
	  Assert.assertEquals(actUpdateStatus, false);
  }

  @Test(groups = {"TestUpdateStudent"})
  public void testUpdateStudentFailedForMoreThanMaxFirstNameLength() 
  {
	  Student studentObj = new Student(6, "Johneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", "Amato", 'A');
	  boolean actUpdateStatus = studentproc.UpdateStudent(studentObj);
	  Assert.assertEquals(actUpdateStatus, false);
  }
  
  @Test(groups = {"TestUpdateStudent"})
  public void testUpdateStudentFailedIfSpecialCharsInLastName() 
  {
	  Student studentObj = new Student(6, "John", "Amato@", 'A');
	  boolean actUpdateStatus = studentproc.UpdateStudent(studentObj);
	  Assert.assertEquals(actUpdateStatus, false);
  }
  
  @Test(groups = {"TestUpdateStudent"})
  public void testUpdateStudentFailedIfBlankLastName() 
  {
	  Student studentObj = new Student(6, "John", " ", 'A');
	  boolean actUpdateStatus = studentproc.UpdateStudent(studentObj);
	  Assert.assertEquals(actUpdateStatus, false);
  }

  @Test(groups = {"TestUpdateStudent"})
  public void testUpdateStudentFailedForMoreThanMaxLastNameLength() 
  {
	  Student studentObj = new Student(6, "John", "Amatooooooooooooooooooooooooooooooooooooooooooooo", 'A');
	  boolean actUpdateStatus = studentproc.UpdateStudent(studentObj);
	  Assert.assertEquals(actUpdateStatus, false);
  }
  
//******************** UpdateStudent Tests End ******************************************* //
  
//******************** DropStudent Tests Start ******************************************* //
  
  @Test(groups = {"TestDropStudent"})
  public void testDropStudentSuccessfulForExistingStudentId() 
  {
	  boolean actDropStatus = studentproc.DropStudent(6);
	  Assert.assertEquals(actDropStatus, true);
  }
  
  @Test(groups = {"TestDropStudent"})
  public void testDropStudentFailedForNonExistingStudentId() 
  {
	  boolean actDropStatus = studentproc.DropStudent(502);
	  Assert.assertEquals(actDropStatus, false);
  }
  
  @Test(groups = {"TestDropStudent"})
  public void testDropStudentFailedForNegativeStudentId() 
  {
	  boolean actDropStatus = studentproc.DropStudent(-2);
	  Assert.assertEquals(actDropStatus, false);
  }
  
  @Test(groups = {"TestDropStudent"})
  public void testDropStudentFailedForZeroStudentId() 
  {
	  boolean actDropStatus = studentproc.DropStudent(0);
	  Assert.assertEquals(actDropStatus, false);
  }
  
//******************** DropStudent Tests End ******************************************* //
  
//******************** ListStudent Tests Start ******************************************* //
 
  @Test(groups = {"TestListStudent"}, dependsOnGroups = {"ListStudent"} )
  public void testListStudentsSuccessfulForAllStudents() 
  {
	  List<Student> listStudent = studentprocList.ListStudents();
	  Assert.assertEquals(listStudent.size(), 5);
  }
  
  @Test(groups = {"TestListStudent"}, dependsOnGroups = {"ListStudent"})
  public void testListStudentsFailedForAllStudents() 
  {
	  List<Student> listStudent = studentprocList.ListStudents();
	  Assert.assertEquals(listStudent.size(), 4);
  }
  
  @Test(groups = {"TestListStudent"}, dependsOnGroups = {"ListStudent"})
  public void testListStudentsFailedForEmptyList() 
  {
	  studentprocList.DropStudent(1);
	  studentprocList.DropStudent(2);
	  studentprocList.DropStudent(3);
	  studentprocList.DropStudent(4);
	  studentprocList.DropStudent(5);
	  
	  List<Student> listStudent = studentproc.ListStudents();
	  Assert.assertNull(listStudent);
  }
  
  @BeforeClass(groups = {"ListStudent", "TestListStudent"})
  public void beforeClass() 
  {
	  studentprocList.AddStudent("John","Christie");
	  studentprocList.AddStudent("Scott","Brooks");
	  studentprocList.AddStudent("Rayana","Sampson");
	  studentprocList.AddStudent("Mike","Mahoney");
	  studentprocList.AddStudent("Julie","Marvin");
  }

//******************** ListStudent Tests End ******************************************* //
  
}
