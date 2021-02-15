package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.MainSpecialistPage;

public class SpecialistPageTest extends BaseTest {
	
	
  @Test
  public void specialistLoginPageTest() throws InterruptedException {
	  MainSpecialistPage specialistPage = new MainSpecialistPage(driver);
	  
	  specialistPage.addInputSpecialistUsername();
	  specialistPage.addInputSpecialistPassword();
	  specialistPage.clickLoginButton();
	  Thread.sleep(3000);
	  
		String actualLoginText = specialistPage.textSuccessfulSpecialistLogin();
		String expectedLoginText = "Švietimo specialistas";
		assertEquals(expectedLoginText, actualLoginText);
  }
  
  @Test
  public void specialistLogputPageTest() throws InterruptedException {
	  MainSpecialistPage specialistPage = new MainSpecialistPage(driver);
	  
	  specialistPage.addInputSpecialistUsername();
	  specialistPage.addInputSpecialistPassword();
	  specialistPage.clickLoginButton();
	  Thread.sleep(3000);
	  specialistPage.clickLogoutButton();
	  
		String actualLoginText = specialistPage.textSuccessfulSpecialistLogout();
		String expectedLoginText = "Prisijungimo vardas";
		assertEquals(expectedLoginText, actualLoginText);
  }
}
