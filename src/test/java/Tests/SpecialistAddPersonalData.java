package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.MainSpecialistPage;
import page.SpecialistPasswordChange;

public class SpecialistAddPersonalData extends BaseTest {
	
	
  @Test
  public void SpecialistAddPersonalDataTest() throws InterruptedException {
	  MainSpecialistPage specialistPage = new MainSpecialistPage(driver);
	  SpecialistPasswordChange passwordChange = new SpecialistPasswordChange(driver);
	  
	  //Specialist Login
	 specialistPage.addInputSpecialistUsername();
	 specialistPage.addInputSpecialistPassword();
	 specialistPage.clickLoginButton();
	 Thread.sleep(1000);
	 
	 //Specialist click "Mano duomenys" adding new data
	 
	passwordChange.clickMyDataButton();
	Thread.sleep(1000);
	
	specialistPage.addSpecialistName();
	specialistPage.addSpecialistLastName();
	specialistPage.addSpecialistPhone();
	specialistPage.addSpecialistEmail();
	
	specialistPage.clickUpdateMyDataButton();
	Thread.sleep(3000);
	
	//assert to check if the data was updated
	
	String actualUpdateDataText = specialistPage.textUpdateData();
	String expectedUpdateDataText = "Duomenys atnaujinti!";
	assertEquals(actualUpdateDataText, expectedUpdateDataText);
	 
	 
  }
}
