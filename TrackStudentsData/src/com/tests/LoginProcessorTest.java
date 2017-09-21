package com.tests;

import org.testng.annotations.Test;

import com.models.LoginProcessor;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginProcessorTest 
{
	LoginProcessor loginobj = new LoginProcessor();
	
  @Test
  public void testLoginSuccessfulIfValidCredentials() 
  {
	  boolean expLoginStatus = true;
	  boolean actLoginStatus =  loginobj.Login("validUserName","validP@1");
	  Assert.assertEquals(actLoginStatus, expLoginStatus);
  }
  
  @Test
  public void testLoginFailedIfBlankUserName() 
  {
	  boolean expLoginStatus = false;
	  boolean actLoginStatus =  loginobj.Login(" ","validPassword");
	  Assert.assertEquals(actLoginStatus, expLoginStatus);
  }
  
  @Test
  public void testLoginFailedIfBlankPassword() 
  {
	  boolean expLoginStatus = false;
	  boolean actLoginStatus =  loginobj.Login("validUserName"," ");
	  Assert.assertEquals(actLoginStatus, expLoginStatus);
  }
  
  @Test
  public void testLoginFailedIfBlankUserNameAndBlankPassword() 
  {
	  boolean expLoginStatus = false;
	  boolean actLoginStatus =  loginobj.Login(" "," ");
	  Assert.assertEquals(actLoginStatus, expLoginStatus);
  }
  @Test
  public void testLoginFailedIfInvalidPassword() 
  {
	  boolean expLoginStatus = false;
	  boolean actLoginStatus =  loginobj.Login("validUserName","InvalidPassword");
	  Assert.assertEquals(actLoginStatus, expLoginStatus);
  }
  
  @Test
  public void testLoginFailedIfInvalidUserName() 
  {
	  boolean expLoginStatus = false;
	  boolean actLoginStatus =  loginobj.Login("InvalidUserName","validPassword");
	  Assert.assertEquals(actLoginStatus, expLoginStatus);
  }
  
  @BeforeClass
  public void beforeClass() 
  {
	  //Load Web Page if Testing though Web
  }

  @AfterClass
  public void afterClass() 
  {
	  //close Web Page
  }

}
