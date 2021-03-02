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
	  Thread.sleep(3000);
	  
		String actualLoginText = specialistPage.textSuccessfulSpecialistLogin();
		String expectedLoginText = "TomasMikalauskas" + "\n" + "�vietimo specialistas";
		assertEquals(actualLoginText, expectedLoginText);		
  }
  
  @Test
  public void specialistLogoutPageTest() throws InterruptedException {
	  MainSpecialistPage specialistPage = new MainSpecialistPage(driver);
	  
	  specialistPage.doSpecialistLogin();
	  Thread.sleep(3000);
	  specialistPage.doSpecialistLogout();
	  
		String actualLoginText = specialistPage.textSuccessfulSpecialistLogout();
		String expectedLoginText = "Prisijungimo vardas";
		assertEquals(actualLoginText, expectedLoginText);
  }
}
