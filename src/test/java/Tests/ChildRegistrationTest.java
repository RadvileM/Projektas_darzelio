package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.MainAdminPage;
import page.MainParentPage;

public class ChildRegistrationTest extends BaseTest{
	
	@Test
	public void pdfUploadTest () throws InterruptedException {
	
		MainAdminPage adminPage = new MainAdminPage(driver);
		MainParentPage parentPage = new MainParentPage(driver);
		
		//admin login
		adminPage.doAdminLogin();
		Thread.sleep(1000);
		
		//admin creates parent
		parentPage.addParentUsername();
		parentPage.selectParent();
		parentPage.clickCreateButton();
		Thread.sleep(1000);
		
		//admin logout
		adminPage.doAdminLogout();
		
		//parent login
		parentPage.doParentLoginUploadTest();
		Thread.sleep(1000);
		
		//parent creates child's registration form
		parentPage.clickFormUploadButton();
		parentPage.addParentNameInput();
		parentPage.addParentLastnameInput();
		parentPage.addParentID();
		parentPage.addParentAddress();
		parentPage.addParentCity();
		parentPage.addParentNumber();
		parentPage.addParentEmailInput();
		parentPage.addChildName();
		parentPage.addChildLastname();
		parentPage.addChildId();
		parentPage.addBirthdateInput();
		parentPage.addChildAddress();
		parentPage.addChildCity();
		Thread.sleep(2000);
		parentPage.selectKindergarten();
		Thread.sleep(2000);
		parentPage.selectPriorities();
		Thread.sleep(2000);
		parentPage.clickSubmitButton();
		Thread.sleep(2000);
		
		//pdf upload
	parentPage.clickPdfUploadButton();
	
	//assert the text
	String actualUpdateDataText = parentPage.gettextSuccessfulPdfUploadText();
	String expectedUpdateDataText = "Failas �keltas s�kmingai!";
	assertEquals(actualUpdateDataText, expectedUpdateDataText);
		
}

}
