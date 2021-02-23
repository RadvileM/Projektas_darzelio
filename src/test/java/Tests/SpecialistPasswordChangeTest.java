package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.SpecialistPasswordChange;



public class SpecialistPasswordChangeTest extends BaseTest{

	@Test
	public void specialistPasswordChangeTest() throws InterruptedException {
		
	SpecialistPasswordChange passwordChange = new SpecialistPasswordChange(driver);
	
	//login as an admin
	passwordChange.addAdminUsername();
	passwordChange.addAdminPassword();
	passwordChange.clickLoginButton();
	Thread.sleep(1000);


	
	//create new specialist
	
	passwordChange.createNewSpecialist();
	passwordChange.clickCreateNewSpecialistButton();
	
	//admin logout
	passwordChange.clickAdminLogoutButton();
	
	//specialist login
	passwordChange.addSpecialistUsername();
	passwordChange.addSpecialistPassword();
	passwordChange.clickLoginButton();
	Thread.sleep(1000);
	
	//Clicking on "Mano duomenys" button, add old and new passwords
	
	passwordChange.clickMyDataButton();
	Thread.sleep(1000);
	
	passwordChange.addOldPassword();
	passwordChange.addNewPassword();
	passwordChange.clickChangeButton();
	Thread.sleep(3000);

	
	//assert to check if the password has been changed
	String actualLoginText = passwordChange.textSuccessfulSpecialistLogin();
	String expectedLoginText = "Slapta�odis atnaujintas!";
	assertEquals(actualLoginText, expectedLoginText);
	
	
	
	}
	
}
