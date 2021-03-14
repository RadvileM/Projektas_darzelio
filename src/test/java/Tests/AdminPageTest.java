package Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.MainAdminPage;

public class AdminPageTest extends BaseTest{

	

	@Test(groups = "smoke")
	public void mainPageTest () throws InterruptedException, IOException {
		MainAdminPage mainPage = new MainAdminPage(driver);
		
		mainPage.doAdminLogin();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root > nav > ul > li:nth-child(2) > a > span")));
		//Thread.sleep(1000);
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
