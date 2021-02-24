package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.MainParentPage;

public class ParentAddPersonalData extends BaseTest {
  @Test
  public void parentAddPersonalDataTest() throws InterruptedException {
	  MainParentPage parentPage = new MainParentPage(driver);
	  
	  //parent login
	  parentPage.doParentLogin();
	  Thread.sleep(1000);
	  
	//Specialist click "Mano duomenys" adding new data
	  parentPage.clickMyDataButton();
	  Thread.sleep(1000);
	  
	  parentPage.addParentName();
	  parentPage.addParentLastName();
	  parentPage.addParentPhone();
	  parentPage.addParentEmail();
	  
	  parentPage.clickUpdateMyDataButton();
	  Thread.sleep(3000);
	  
		//assert to check if the data was updated
		
		String actualUpdateDataText = parentPage.textUpdateData();
		String expectedUpdateDataText = "Duomenys atnaujinti!";
		assertEquals(actualUpdateDataText, expectedUpdateDataText);
  }
}
