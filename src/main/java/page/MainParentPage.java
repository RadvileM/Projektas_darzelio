package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainParentPage extends AbstractPage {	
	Random rand = new Random();
	
	private String username = "MariusAdomaitis";
	private String password = "MariusAdomaitis";
	private String name = "Marius";
	private String lastname = "Adomaitis";
	private String mobilephone = "12345678";
	private String email = "marius@adomaitis" + rand.nextInt(100) + ".lt";
	
	
	
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
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li:nth-child(4) > a")
	private WebElement myDataButton;

	@FindBy(css = "#root > div > div > div > div:nth-child(1) > div > form > div:nth-child(2) > div > button")
	private WebElement updateMyDataButton;
	
	//text
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li:nth-child(5) > a > span")
	private WebElement successfulParentLogin;
	
	@FindBy(css = "#root > div > div > div > div > form > div.form-group.mx-auto.mt-3 > label")
	private WebElement successfulParentLogout;
	
	//"mano duomenys"
	@FindBy(css = "#root > div > div > div > div:nth-child(1) > div > form > div.form-group.m-3 > div")
	private WebElement updatePersonalData;
	
	public MainParentPage(WebDriver driver) {
		super(driver);
	}
	
	
	//methods
	public void doParentLogin() {
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		loginButton.click();
	}
	

	//public void addInputParentPassword() {
	//	inputPassword.sendKeys(password);
	//}

	//public void clickLoginButton() {
	//	loginButton.click();
	//}
	
	public void doParentLogout() {
		logoutButton.click();
	}
	
	public String textSuccessfulParentLogin() {
		return successfulParentLogin.getText();
	}
	
	public String textSuccessfulParentLogout() {
		return successfulParentLogout.getText();
	}
	
	//Mano duomenys
	public void clickMyDataButton() {
		myDataButton.click();
	}
	
	// add Parent personal data
	
	public void addParentName() {
		inputPersonalName.clear();
		inputPersonalName.sendKeys(name);
	}
	
	public void addParentLastName() {
		inputPersonalLastname.clear();
		inputPersonalLastname.sendKeys(lastname);
	}
	
	public void addParentPhone() {
		inputMobilphone.clear();
		inputMobilphone.sendKeys(mobilephone);
	}
	
	public void addParentEmail() {
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
