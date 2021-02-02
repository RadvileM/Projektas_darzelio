package Tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.internal.FindsByCssSelector;
import org.openqa.selenium.internal.FindsByLinkText;

import BaseTest.BaseTest;
import Utils.WaitUtils;
import page.MainAdminPage;

public class AdminPageTest extends BaseTest{

	private MainAdminPage mainPage = new MainAdminPage(driver);

	
	@Test
	public void mainPageTest () throws InterruptedException {
		
		mainPage.addInputUsername();
		mainPage.addInputPassword();
		mainPage.clickLoginButton();
		Thread.sleep(3000);
		
		//paimam teksta, tikrinam ar prisijungimas sekmingas
		String actualLoginText = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/strong")).getText();
		String expectedLoginText = "SUKURTI NAUDOTOJĄ";
		assertEquals(expectedLoginText, actualLoginText);
		


		//admin logout
	mainPage.clickLogoutButton();
	
	String actualLogoutText =  driver.findElement(By.cssSelector("#root > div > div > div > div > div > form > div.form-group.mx-auto.mt-3 > label")).getText();
	String expectedLogoutText = "Prisijungimo vardas";
	assertEquals(expectedLogoutText, actualLogoutText);

	}
		
}
