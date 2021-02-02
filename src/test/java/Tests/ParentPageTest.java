package Tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.internal.FindsByCssSelector;
import org.openqa.selenium.internal.FindsByLinkText;

import BaseTest.BaseTest;
import Utils.WaitUtils;
import page.MainAdminPage;
import page.MainParentPage;

public class ParentPageTest extends BaseTest{

	private MainParentPage parentPage = new MainParentPage(driver);
	private MainAdminPage mainPage = new MainAdminPage(driver);

	
	@Test
	public void mainParentPageTest () throws InterruptedException {
		
		parentPage.addInputParentUsername();
		parentPage.addInputParentPassword();
		parentPage.clickLoginButton();
		Thread.sleep(3000);
		
		//paimam teksta, tikrinam ar prisijungimas sekmingas
		String actualLoginText = driver.findElement(By.cssSelector("#root > div > nav > div:nth-child(3) > li:nth-child(1) > a > div > span")).getText();
		String expectedLoginText = "Vaiko atstovas";
		assertEquals(expectedLoginText, actualLoginText);
		}


	@Test
	public void parentLogoutTest () throws InterruptedException {
		parentPage.addInputParentUsername();
		parentPage.addInputParentPassword();
		parentPage.clickLoginButton();
		Thread.sleep(3000);
		parentPage.clickLogoutButton();
		
		String actualLogoutText =  driver.findElement(By.cssSelector("#root > div > div > div > div > div > form > div.form-group.mx-auto.mt-3 > label")).getText();
		String expectedLogoutText = "Prisijungimo vardas";
		assertEquals(expectedLogoutText, actualLogoutText);
		
	}

		
}
