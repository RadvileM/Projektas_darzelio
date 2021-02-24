package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainSpecialistPage extends AbstractPage {
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
	
	
	
	
	//buttons
	@FindBy(css = "#root > div > div > div > div > form > div.form-group.text-center.mt-5 > button")
	private WebElement loginButton;
	
	
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li:nth-child(6) > a")
	private WebElement logoutButton;
	
	//"Mano duomenys"
	@FindBy(css = "#root > div > div > div > div:nth-child(1) > div > form > div:nth-child(2) > div > button")
	private WebElement updateMyDataButton;
	
	
	//text
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li:nth-child(5) > a")
	private WebElement successfulSpecialistLogin;
	
	@FindBy(css = "#root > div > div > div > div > form > div.form-group.mx-auto.mt-3 > label")
	private WebElement successfulSpecialistLogout;

	
	//"mano duomenys"
	@FindBy(css = "#root > div > div > div > div:nth-child(1) > div > form > div.form-group.m-3 > div")
	private WebElement updatePersonalData;
	
	
	public MainSpecialistPage(WebDriver driver) {
		super(driver);
	}	


	//methods
	// Specialist login
	public void addInputSpecialistUsername() {
		inputUsername.sendKeys(username);
	}
	

	public void addInputSpecialistPassword() {
		inputPassword.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickLogoutButton() {
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
	}
	
	public String textUpdateData() {
		return updatePersonalData.getText();
	}
	
	
	}
	

	


