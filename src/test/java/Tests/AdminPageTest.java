package Tests;


import org.openqa.selenium.By;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import Utils.WaitUtils;
import page.MainAdminPage;

public class AdminPageTest extends BaseTest{

	
	@Test
	public void mainPageTest () throws InterruptedException {
		MainAdminPage mainPage = new MainAdminPage(driver);
		
		mainPage.addInputUsername();
		mainPage.addInputPassword();
		mainPage.clickLoginButton();
		Thread.sleep(3000);
		
		//paimam teksta, tikrinam ar prisijungimas sekmingas
		String actualLoginText = mainPage.textSuccessfulAdminLogin();
		//String actualLoginText = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/strong")).getText();
		String expectedLoginText = "Administratorius";
		assertEquals(expectedLoginText, actualLoginText);
		


		//admin logout
	mainPage.clickLogoutButton();
	String actualLogoutText = mainPage.textSuccessfulAdminLogout();
	//String actualLogoutText =  driver.findElement(By.cssSelector("#root > div > div > div > div > div > form > div.form-group.mx-auto.mt-3 > label")).getText();
	String expectedLogoutText = "Prisijungimo vardas";
	assertEquals(expectedLogoutText, actualLogoutText);

	}
		
}
