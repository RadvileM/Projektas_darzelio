package Tests;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.MainParentPage;

public class ParentAddPersonalDataTest extends BaseTest {
  @Test
  public void parentAddPersonalDataTest() throws InterruptedException {
	  MainParentPage parentPage = new MainParentPage(driver);
	  
	  //parent login
	  parentPage.doParentLogin();
	  //laukia elemento	  
	  //Specialist click "Mano duomenys" adding new data
	  parentPage.clickMyDataButton();
	  //laukia elemento
	      
	  parentPage.addParentName();
	  parentPage.addParentLastName();
	  parentPage.addParentPhone();
	  parentPage.addParentEmail();
	  
	  
	  parentPage.clickUpdateMyDataButton();

		//assert to check if the data was updated
		
		String actualUpdateDataText = parentPage.textUpdateData();
		String expectedUpdateDataText = "Duomenys atnaujinti!";
		assertEquals(actualUpdateDataText, expectedUpdateDataText);
  }
}
