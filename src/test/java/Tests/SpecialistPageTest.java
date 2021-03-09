package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.MainSpecialistPage;

public class SpecialistPageTest extends BaseTest {
	
	
	
  @Test
  public void specialistLoginPageTest() throws InterruptedException {
	  MainSpecialistPage specialistPage = new MainSpecialistPage(driver);
	  
	  specialistPage.doSpecialistLogin();
	  
		String actualLoginText = specialistPage.textSuccessfulSpecialistLogin();
		String expectedLoginText = "TomasMikalauskas" + "\n" + "Švietimo specialistas";
		assertEquals(actualLoginText, expectedLoginText);		
  }
  
  @Test
  public void specialistLogoutPageTest() throws InterruptedException {
	  MainSpecialistPage specialistPage = new MainSpecialistPage(driver);
	  
	  specialistPage.doSpecialistLogin();
	  specialistPage.doSpecialistLogout();
	  
		String actualLoginText = specialistPage.textSuccessfulSpecialistLogout();
		String expectedLoginText = "Prisijungimo vardas";
		assertEquals(actualLoginText, expectedLoginText);
  }
}
