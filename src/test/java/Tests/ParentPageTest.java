package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.MainParentPage;

public class ParentPageTest extends BaseTest{
	
		
	@Test(groups = "smoke")
	public void parentLoginPageTest () throws InterruptedException {
		MainParentPage parentPage = new MainParentPage(driver);
		
		parentPage.doParentLogin();
		
		//paimam teksta, tikrinam ar prisijungimas sekmingas
		String actualLoginText = parentPage.textSuccessfulParentLogin();
		String expectedLoginText = "Vaiko atstovas";
		assertEquals(expectedLoginText, actualLoginText);
		}

	@Test(groups = "smoke")
	public void parentLogoutTest () throws InterruptedException {		
		MainParentPage parentPage = new MainParentPage(driver);
		
		parentPage.doParentLogin();
		parentPage.doParentLogout();

		String actualLogoutText = parentPage.textSuccessfulParentLogout();
		String expectedLogoutText = "Prisijungimo vardas";
		assertEquals(expectedLogoutText, actualLogoutText);
		
	}

		
}
