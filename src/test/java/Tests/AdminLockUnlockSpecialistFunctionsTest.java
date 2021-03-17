package Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import page.KindergartenQueuePage;
import page.KindergartensPage;
import page.MainAdminPage;
import page.MainSpecialistPage;

public class AdminLockUnlockSpecialistFunctionsTest extends BaseTest {
	@Test(groups = "regression")
	public void adminLockUnlockSpecialistFunctions() throws InterruptedException, IOException {
		MainAdminPage mainPage = new MainAdminPage(driver);
		MainSpecialistPage specialistPage = new MainSpecialistPage(driver);
		KindergartensPage kindergartensPage = new KindergartensPage(driver);
		KindergartenQueuePage kindergartenQueue = new KindergartenQueuePage(driver);

		// admin lock Specialist functions, Specialist check if functions is locked
		mainPage.doAdminLogin();
		mainPage.waitForLockSpecialistButton();
		mainPage.clickLockButton();

		mainPage.waitForSuccessfulLockedSpecialistText();
		// assert the text
		assertEquals(mainPage.textSuccessfulLockedUnlockedSpecialist(),
				"Švietimo specialistų funkcionalumas užrakintas");

		mainPage.doAdminLogout();
		specialistPage.doSpecialistLogin();

		// assert the text
		assertEquals(specialistPage.addKindergartenNotPossibleText(), "Naujų darželių ir grupių pridėjimas negalimas");

		specialistPage.clickKindergartenQueueLink();

		// assert the text
		assertEquals(specialistPage.createQueueLockedText(), "Eilių sudarymas ir atšaukimas negalimas");

		specialistPage.doSpecialistLogout();

		// admin unlock Specialist functions, specialist check if functions are unlocked
		mainPage.doAdminLogin();
		mainPage.waitForUnlockSpecialistButton();
		//wait.until(
		//		ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-sm btn-info col-12']")));
		
		mainPage.clickUnlockButton();
		mainPage.waitForSuccessfulUnlockedSpecialistText();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']")));

		// assert the text
		assertEquals(mainPage.textSuccessfulLockedUnlockedSpecialist(),
				"Švietimo specialistų funkcionalumas atstatytas");

		mainPage.doAdminLogout();
		specialistPage.doSpecialistLogin();
		kindergartensPage.waitForAddKindergartenButtonText();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-md btn-success']")));

		// assert the text
		assertEquals(kindergartensPage.textOnButtonAddKindergarten(), "Pridėti darželį");

		kindergartenQueue.clickKindergartenQueuePage();
		kindergartenQueue.waitForCreateQueueButton();
		//wait.until(
		//		ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='col-12 btn btn-success m-1']")));

		// assert the text
		assertEquals(kindergartenQueue.textOnKindergartenQueueButton(), "Sudaryti eiles");

		specialistPage.doSpecialistLogout();
	}
}
