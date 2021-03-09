package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.MainAdminPage;

public class AdminPageTest extends BaseTest{

	

	@Test
	public void mainPageTest () throws InterruptedException {
		MainAdminPage mainPage = new MainAdminPage(driver);
		
		mainPage.doAdminLogin();
		//paimam teksta, tikrinam ar prisijungimas sekmingas
		String actualLoginText = mainPage.textSuccessfulAdminLogin();
		String expectedLoginText = "Administratorius";
		assertEquals(expectedLoginText, actualLoginText);
		
		
		//admin logout
		mainPage.doAdminLogout();
		
		String actualLogoutText = mainPage.textSuccessfulAdminLogout();
		String expectedLogoutText = "Prisijungimo vardas";
		assertEquals(expectedLogoutText, actualLogoutText);

	}
		
}
