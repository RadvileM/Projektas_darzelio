package Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.MainAdminPage;
import page.MainParentPage;
import utilities.WaitUtils;

public class ChildRegistrationTest extends BaseTest{

	
	@Test(groups = "regression")
	public void pdfUploadTest () throws InterruptedException, IOException {
	
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
		
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("document.querySelector('#files').style ='';");
		 
		  

		//driver.findElement(By.id("files")).sendKeys("C:\\Users\\Radvile\\Desktop\\Test_PDF.pdf");
//FIX THIS!!!	//	driver.findElement(By.id("files")).sendKeys("..\\src\\test\\resources\\Test_PDF.pdf");

		driver.findElement(By.id("files")).sendKeys("C:\\Users\\Gintare\\Desktop\\Medicinine_pazyma.pdf");

	

	parentPage.clickPdfUploadButton();
	Thread.sleep(2000);
	
	//assert the text
	String actualUpdateDataText = parentPage.gettextSuccessfulPdfUploadText();
	assertEquals(true, actualUpdateDataText.contains("Failas įkeltas sėkmingai"));
		
}

}
