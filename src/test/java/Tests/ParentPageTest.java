package Tests;


import org.openqa.selenium.By;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import Utils.WaitUtils;
import page.MainAdminPage;
import page.MainParentPage;

public class ParentPageTest extends BaseTest{

	
	@Test
	public void parentLoginPageTest () throws InterruptedException {
		MainParentPage parentPage = new MainParentPage(driver);
		
		parentPage.addInputParentUsername();
		parentPage.addInputParentPassword();
		parentPage.clickLoginButton();
		Thread.sleep(3000);
		
		//paimam teksta, tikrinam ar prisijungimas sekmingas
		String actualLoginText = parentPage.textSuccessfulParentLogin();
		String expectedLoginText = "Vaiko atstovas";
		assertEquals(expectedLoginText, actualLoginText);
		}
	
	


	@Test
	public void parentLogoutTest () throws InterruptedException {
		MainParentPage parentPage = new MainParentPage(driver);
		
		parentPage.addInputParentUsername();
		parentPage.addInputParentPassword();
		parentPage.clickLoginButton();
		Thread.sleep(3000);
		parentPage.clickLogoutButton();

		
		String actualLogoutText = parentPage.textSuccessfulParentLogout();
		String expectedLogoutText = "Prisijungimo vardas";
		assertEquals(expectedLogoutText, actualLogoutText);
		
	}

		
}
