package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.MainSpecialistPage;
import page.SpecialistPasswordChange;

public class SpecialistAddPersonalDataTest extends BaseTest {
	
	
  @Test
  public void specialistAddPersonalDataTest() throws InterruptedException {
	  MainSpecialistPage specialistPage = new MainSpecialistPage(driver);
	  SpecialistPasswordChange passwordChange = new SpecialistPasswordChange(driver);
	  
	  //Specialist Login
	 specialistPage.doSpecialistLogin();
	 //laukia elemento
	 
	 //Specialist click "Mano duomenys" adding new data
	 
	passwordChange.clickMyDataButton();
	//laukia elemento
	
	specialistPage.addSpecialistName();
	specialistPage.addSpecialistLastName();
	specialistPage.addSpecialistPhone();
	specialistPage.addSpecialistEmail();
	
	specialistPage.clickUpdateMyDataButton();
	//laukia elemento	

	//assert to check if the data was updated
	
	String actualUpdateDataText = specialistPage.textUpdateData();
	String expectedUpdateDataText = "Duomenys atnaujinti!";
	assertEquals(actualUpdateDataText, expectedUpdateDataText);
	 
	 
  }
}
