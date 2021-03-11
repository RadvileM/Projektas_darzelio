package Tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.MainAdminPage;
import page.MainSpecialistPage;

public class AdminLockUnlockSpecialistFunctionsTest extends BaseTest {
  @Test
  public void adminLockUnlockSpecialistFunctions() throws InterruptedException {
	  MainAdminPage mainPage = new MainAdminPage(driver);
	  MainSpecialistPage specialistPage = new MainSpecialistPage(driver);
	  
	  //admin prisijungia prie sistemos
	  mainPage.doAdminLogin();
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-sm btn-secondary col-12']")));
	 //admin uzrakina Specialisto funkcijas
	  mainPage.clickLockButton();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
	  
	 String actualLockedSpecialistText = mainPage.textSuccessfulLockedUnlockedSpecialist();
	 String expectedLockedText = "Švietimo specialistų funkcionalumas užrakintas";
	 assertEquals(actualLockedSpecialistText, expectedLockedText);
	  
	  mainPage.doAdminLogout();
	  
	  //specialistas prisijungia prie sistemos
	  specialistPage.doSpecialistLogin();
	  
	  //patikrina teskta, kad negalima prideti nauju darzeliu
		String actualText = specialistPage.addKindergartenNotPossibleText();
		String expectedLogoutText = "Naujų darželių ir grupių pridėjimas negalimas";
		assertEquals(actualText, expectedLogoutText);
		
		//pereina i kita puslapi patikrinti eiliu sudarymo funkcionalumo
		specialistPage.clickKindergartenQueueLink();
		
		
		String actualCreateQueueLockedText = specialistPage.createQueueLockedText();
		String expectedCreateQueueLockedText = "Eilių sudarymas ir atšaukimas negalimas";
		assertEquals(actualCreateQueueLockedText, expectedCreateQueueLockedText);
		
		//specialistas atsijungia nuo sistemos
	  specialistPage.doSpecialistLogout();
		
	  //administratorius prisijungia prie sistemos
	  mainPage.doAdminLogin();
	  
	  
	  //administratorius atrakna Specialisto funkcijas
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-sm btn-info col-12']")));
	  mainPage.clickUnlockButton();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
		
	  	 String actualUnlockedSpecialistText = mainPage.textSuccessfulLockedUnlockedSpecialist();
		 String expectedUnlockedText = "Švietimo specialistų funkcionalumas atstatytas";
		 assertEquals(actualUnlockedSpecialistText, expectedUnlockedText);
	  
	  
  }
}
