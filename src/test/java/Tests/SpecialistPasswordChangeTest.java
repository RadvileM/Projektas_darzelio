package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.SpecialistPasswordChange;



public class SpecialistPasswordChangeTest extends BaseTest{

	@Test
	public void specialistPasswordChangeTest() throws InterruptedException {
		
	SpecialistPasswordChange passwordChange = new SpecialistPasswordChange(driver);
	
	//login as a Specialist
	
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
	
	//try to login again to see if the login with new password works

	passwordChange.addSpecialistUsername();
	passwordChange.addChangedSpecialistPassword();
	passwordChange.clickLoginButton();
	Thread.sleep(1000);
	
	//assert if the login is successful
	String actualLoginText = passwordChange.textSuccessfulSpecialistLogin();
	String expectedLoginText = "Specialistas" + "\n" + "Ðvietimo specialistas";
	assertEquals(actualLoginText, expectedLoginText);
	
	
	
	}
	
}
