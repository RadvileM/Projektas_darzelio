package Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.MainAdminPage;
import page.SpecialistPasswordChange;



public class SpecialistPasswordChangeTest extends BaseTest{

	@Test(groups = "regression")
	public void specialistPasswordChangeTest() throws InterruptedException, IOException {
	SpecialistPasswordChange passwordChange = new SpecialistPasswordChange(driver);
	MainAdminPage mainPage = new MainAdminPage(driver);
	
	//login as an admin
	mainPage.doAdminLogin();
	WebDriverWait wait = new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='fw-bold text-secondary']")));
	//passwordChange.addAdminUsername();
	//passwordChange.addAdminPassword();
	//passwordChange.clickLoginButton();
	 
	//laukia elemento Administratorius


	//create new specialist
	//Thread.sleep(2000);
	passwordChange.createNewSpecialist();
	passwordChange.clickCreateNewSpecialistButton();
	
	//admin logout
	//passwordChange.clickAdminLogoutButton();
	mainPage.doAdminLogout();
	
	//specialist login
	passwordChange.addSpecialistUsername();
	passwordChange.addSpecialistPassword();
	passwordChange.clickLoginButton();
	
	//Thread.sleep(1000);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root > nav > ul > li:nth-child(6) > a")));
	
	//Clicking on "Mano duomenys" button, add old and new passwords
	
	passwordChange.clickMyDataButton();
	//Thread.sleep(2000);
	
	passwordChange.addOldPassword();
	passwordChange.addNewPassword();
	passwordChange.clickChangeButton();
	//Thread.sleep(3000);

	//assert to check if the password has been changed
	String actualLoginText = passwordChange.textSuccessfulSpecialistLogin();
	String expectedLoginText = "Slaptažodis atnaujintas!";
	assertEquals(actualLoginText, expectedLoginText);
	
	
	
	}
	
}
