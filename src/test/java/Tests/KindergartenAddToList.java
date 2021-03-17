package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.KindergartensPage;
import page.MainSpecialistPage;

public class KindergartenAddToList extends BaseTest {
	
  @Test(groups = "regression")
  public void uploadKindergarenToList() throws InterruptedException{
	  MainSpecialistPage specialistPage = new MainSpecialistPage(driver);
	  KindergartensPage kindergartensPage = new KindergartensPage(driver);
	  
	  specialistPage.doSpecialistLogin();
	  kindergartensPage.clickNewKindergartenButton();
	  kindergartensPage.addKindergartenName();
	  kindergartensPage.addKindergartenAddress();
	  kindergartensPage.clickAddNewKindergartenButton();
	  //assert the text
	  assertEquals(kindergartensPage.textKindergartenAdded(), "Darželis įvestas sėkmingai!");
	 
  }
}
