package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.MainSpecialistPage;
import page.SpecialistPasswordChange;

public class SpecialistAddPersonalDataTest extends BaseTest {
	
	
  @Test(groups = "regression")
  public void specialistAddPersonalDataTest(){
	  MainSpecialistPage specialistPage = new MainSpecialistPage(driver);
	  SpecialistPasswordChange passwordChange = new SpecialistPasswordChange(driver);
	  
	  //Specialistas prisijungia prie sistemos
	 specialistPage.doSpecialistLogin();
	 //laukia elemento
	 
	 //Specialistas nueine i puslapi "Mano duomenys" 
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
