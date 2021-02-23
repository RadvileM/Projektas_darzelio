package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpecialistPasswordChange extends AbstractPage{
	
	Random rand = new Random();
	
	private String username = "admin";
	private String password = "admin";
	
	
	private String newSpecialistUsername = "Specialist" + rand.nextInt(1000);
	private String specialistPassword = "Test" + rand.nextInt(100000);
	
	//inputs
	@FindBy(name = "name")
	private WebElement inputNewSpecialist;
	
	@FindBy( css = "#root > div > div > div > div > form > div.form-group.mx-auto.mt-3 > div > input")
	public WebElement inputUsername;
	
	
	@FindBy( css = "#root > div > div > div > div > form > div:nth-child(2) > div > input")
	private WebElement inputPassword;
	
	@FindBy(id = "Dabartinis slaptaþodis")
	private WebElement oldPassword;
	
	@FindBy(id = "Naujas slaptaþodis")
	private WebElement addNewPassword;
	
	@FindBy(id = "Pakartokite naujà slaptaþodá")
	private WebElement repeatNewPassword;
	
	@FindBy(css = "#root > div > div > div > div:nth-child(2) > div > form > div.form-group.m-3 > div")
	private WebElement successfulSpecialistLogin;
	
	
	//buttons
	
	@FindBy(css = "#root > div > div > div > div > form > div.form-group.text-center.mt-5 > button")
	private WebElement loginButton;
	
	@FindBy(css = "#root > div > div > div > div.col-12.col-sm-12.col-md-4.col-lg-4 > form > button.btn.btn-success.mr-3")
	private WebElement createSpecialistButton;
	
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li > a")
	private WebElement logoutButton;
	
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li:nth-child(4) > a")
	private WebElement myDataButton;
	
		
	@FindBy(css = "#root > div > div > div > div:nth-child(2) > div > form > div:nth-child(2) > button")
	private WebElement changePassword;
	
	
	//methods
	//admin login
	
	public void addAdminUsername() {
		inputUsername.sendKeys(username);
	}
	
	public void addAdminPassword() {
		inputPassword.sendKeys(password);
	}
	
	
// create new specialist
	public void createNewSpecialist() {
		inputNewSpecialist.sendKeys(newSpecialistUsername);
	}

	public void clickCreateNewSpecialistButton() {
		createSpecialistButton.click();
	}
	
	public void clickAdminLogoutButton() {
		logoutButton.click();
	}
	
	
	//specialist login
	
	public void addSpecialistUsername() {
		inputUsername.sendKeys(newSpecialistUsername);
	}
	
	
	public void addSpecialistPassword() {
		inputPassword.sendKeys(newSpecialistUsername);
	}

	public void clickLoginButton() {
		loginButton.click();
	}
	
	//Specialist changes the password
	
	public void clickMyDataButton() {
		myDataButton.click();
	}
	
	public void addOldPassword() {
		oldPassword.sendKeys(newSpecialistUsername);
	}
	
	public void addNewPassword() {
		addNewPassword.sendKeys(specialistPassword);
		repeatNewPassword.sendKeys(specialistPassword);
	}

	public void clickChangeButton() {
		changePassword.click();
	}
	
	
	
	public String textSuccessfulSpecialistLogin() {
		return successfulSpecialistLogin.getText();
	}
	
	public SpecialistPasswordChange(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

}
