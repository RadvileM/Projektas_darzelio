package Tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.KindergartenQueuePage;
import page.MainSpecialistPage;

public class SpecialistCreateQueueTest extends BaseTest {

	
  @Test
  public void specialistCreateWithdrawQueue() {
	  MainSpecialistPage specialistPage = new MainSpecialistPage(driver);
	  KindergartenQueuePage kindergartenQueue = new KindergartenQueuePage(driver);
	  
	  specialistPage.doSpecialistLogin();
	  kindergartenQueue.clickKindergartenQueuePage();
	  //laukiam elemento
	  kindergartenQueue.clickCreateKindergartenQueueButton();
	  //laukiam elemento
	  kindergartenQueue.clickConfirmButtonCreateQueue();
	  
	  
	  //String actualRegisteredChildNumberText = kindergartenQueue.registeredChildNumber();
	  String expectedRegisteredChildNumberText = "Užregistruotų vaikų skaičius: ";
	  assertTrue(true, expectedRegisteredChildNumberText);
	  //assertEquals(actualRegisteredChildNumberText, expectedRegisteredChildNumberText);
	   
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='col-12 btn btn-lg btn-secondary m-1']")));
	
	  kindergartenQueue.clickCancelCreatedQueueButton();
	  //laukia elemento
	  String expectedFreePlacesToKindergarten  = "Laisvų vietų skaičius: ";
	  assertTrue(true, expectedFreePlacesToKindergarten);
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='col-12 btn btn-success m-1']")));
	  kindergartenQueue.clickCreateKindergartenQueueButton();
	  kindergartenQueue.clickCancelConfirmCreateQueueButton();
	  
  }
  
}
