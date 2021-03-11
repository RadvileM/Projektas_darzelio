package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainSpecialistPage extends AbstractPage {
	 WebDriverWait wait = new WebDriverWait(driver, 5);
		
	Random rand = new Random();
	
	
	private String username = "TomasMikalauskas";
	private String password = "TomasMikalauskas";
	private String name = "Tomas";
	private String lastname = "Tomas";
	private String mobilephone = "12345678";
	private String email = "tomas@tomas" + rand.nextInt(100) + ".lt";
	
	
	//inputs
	
	@FindBy( css = "#root > div > div > div > div > form > div.form-group.mx-auto.mt-3 > div > input")
	public WebElement inputUsername;
	
	
	@FindBy( css = "#root > div > div > div > div > form > div:nth-child(2) > div > input")
	private WebElement inputPassword;
	
	// add personal data "Mano duomenys"
	@FindBy (id = "Vardas")
	private WebElement inputPersonalName;
	
	@FindBy (id = "Pavardė")
	private WebElement inputPersonalLastname;
	
	@FindBy (id = "Tel")
	private WebElement inputMobilphone;
	
	@FindBy (id = "El.paštas")
	private WebElement inputEmail;
	
	//links navbar
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li:nth-child(1) > a")
	private WebElement kindergartenQueueButton;
	
	
	//buttons
	@FindBy(css = "#root > div > div > div > div > form > div.form-group.text-center.mt-5 > button")
	private WebElement loginButton;
	
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li:nth-child(7) > a")
	private WebElement logoutButton;
	
	//"Mano duomenys"
	@FindBy(css = "#root > div > div > div > div:nth-child(1) > div > form > div:nth-child(2) > div > button")
	private WebElement updateMyDataButton;
	
	
	//text
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li:nth-child(6) > a")
	private WebElement successfulSpecialistLogin;
	
	@FindBy(css = "#root > div > div > div > div > form > div.form-group.mx-auto.mt-3 > label")
	private WebElement successfulSpecialistLogout;

	
	//"mano duomenys"
	@FindBy(css = "#root > div > div > div > div:nth-child(1) > div > form > div.form-group.m-3 > div")
	private WebElement updatePersonalData;
	
	//"Specialisto lock/unlock funkcijos"
	
	@FindBy(xpath = "//div[@class='alert alert-secondary mb-2']")
	private WebElement lockedKindergartenAddList;
	
	@FindBy(xpath = "//div[@class='alert alert-secondary col']")
	private WebElement creatQueueLocked;
	
	public MainSpecialistPage(WebDriver driver) {
		super(driver);
	}	


	//methods
	// Specialist login
	public void doSpecialistLogin() {
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		loginButton.click();
		  wait.until(
		          ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root > div > nav > div:nth-child(3) > li:nth-child(6) > a")));
		   
	}
	
	
	public void doSpecialistLogout() {
		logoutButton.click();
	}
	
	public String textSuccessfulSpecialistLogin() {
		return successfulSpecialistLogin.getText();
	}
	
	public String textSuccessfulSpecialistLogout() {
		return successfulSpecialistLogout.getText();
	}
	
	// add Specialist personal data
	
	public void addSpecialistName() {
		inputPersonalName.clear();
		inputPersonalName.sendKeys(name);
		wait.until(
		          ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='Pavardė']")));
	}
	
	public void addSpecialistLastName() {
		inputPersonalLastname.clear();
		inputPersonalLastname.sendKeys(lastname);
	}
	
	public void addSpecialistPhone() {
		inputMobilphone.clear();
		inputMobilphone.sendKeys(mobilephone);
	}
	
	public void addSpecialistEmail() {
		inputEmail.clear();
		inputEmail.sendKeys(email);
	}
	
	public void clickUpdateMyDataButton() {
		updateMyDataButton.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root > div > div > div > div:nth-child(1) > div > form > div.form-group.m-3 > div")));
	}
	
	public String textUpdateData() {
		return updatePersonalData.getText();
	}
	
	
	//lock/unlock specialisto funkcijos
	public String addKindergartenNotPossibleText() {
		return lockedKindergartenAddList.getText();
	}
	
	public void clickKindergartenQueueLink() {
		kindergartenQueueButton.click();
	}
	
	public String createQueueLockedText() {
		return creatQueueLocked.getText();
	}
	
}
	

	


