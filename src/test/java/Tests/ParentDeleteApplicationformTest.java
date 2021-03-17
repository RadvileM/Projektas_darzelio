package Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import BaseTest.BaseTest;
import page.MainParentPage;

public class ParentDeleteApplicationformTest extends BaseTest {
	
  @Test(groups = "regression")
  public void parentDeleteAplicationform() throws IOException, InterruptedException {
		MainParentPage parentPage = new MainParentPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
	parentPage.doParentLogin();
	
	//parent creates child's registration form
	parentPage.clickFormUploadButton();
	//Thread.sleep(3000);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class=' text-center text-success my-5']")));
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
	//Thread.sleep(2000);
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#root > form > div:nth-child(5) > div > h3")));
	parentPage.selectKindergarten();
	//Thread.sleep(3000);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root > form > div:nth-child(6) > div > h3")));
	parentPage.selectPriorities();
	//Thread.sleep(2000);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-success my-5']")));
	parentPage.clickSubmitButton();
	//Thread.sleep(4000);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-info ']")));
	
	
	parentPage.clickApplicationFormInformationButton();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-danger my-5 m-1']")));
	
	parentPage.deleteApplicationFormButton();
	parentPage.delteApplicationFormConfirmationButton();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-secondary text-center d-grid gap-2 col-6 mx-auto']")));
	
	String actualNoApplicationFormText = parentPage.getTextNoApplicationsForms();
	String expectedNoApplicationFormText = "Pateiktų prašymų nėra registruota.";
	assertEquals(actualNoApplicationFormText, expectedNoApplicationFormText);

  }
}
