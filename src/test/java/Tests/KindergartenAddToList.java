package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.KindergartensPage;
import page.MainSpecialistPage;

public class KindergartenAddToList extends BaseTest {
	
  @Test
  public void f() {
	  MainSpecialistPage specialistPage = new MainSpecialistPage(driver);
	  KindergartensPage kindergartensPage = new KindergartensPage(driver);
	  
	  specialistPage.doSpecialistLogin();
	  kindergartensPage.clickNewKindergartenButton();
	  kindergartensPage.addKindergartenName();
	  kindergartensPage.addKindergartenAddress();
	  kindergartensPage.clickAddNewKindergartenButton();
	  
	  String actualAddedKindergartenText = kindergartensPage.textKindergartenAdded();
	  String expectedKindergartenText = "Darželis įvestas sėkmingai!";
	  assertEquals(actualAddedKindergartenText, expectedKindergartenText);
	 
  }
}