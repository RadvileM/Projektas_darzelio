package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpecialistPasswordChange extends AbstractPage{
	
	Random rand = new Random();
	
	
	private String specialistUsername = "Specialistas";
	private String specialistPassword = "Specialistas";
	//private String newPassword = "Test" + rand.nextInt(1000);
	private String newPassword = "Test12345";
	
	//inputs
	
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
	
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li:nth-child(5) > a")
	private WebElement successfulSpecialistLogin;
	
	
	//buttons
	@FindBy(css = "#root > div > div > div > div > form > div.form-group.text-center.mt-5 > button")
	private WebElement loginButton;
	
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li:nth-child(4) > a")
	private WebElement myDataButton;
	
		
	@FindBy(css = "#root > div > div > div > div:nth-child(2) > div > form > div:nth-child(2) > button")
	private WebElement changePassword;
	
	
	public void addSpecialistUsername() {
		inputUsername.sendKeys(specialistUsername);
	}
	

	public void addSpecialistPassword() {
		inputPassword.sendKeys(specialistPassword);
	}

	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickMyDataButton() {
		myDataButton.click();
	}
	
	public void addOldPassword() {
		oldPassword.sendKeys(specialistPassword);
	}
	
	public void addNewPassword() {
		addNewPassword.sendKeys(newPassword);
		repeatNewPassword.sendKeys(newPassword);
	}

	public void clickChangeButton() {
		changePassword.click();
	}
	
	public void addChangedSpecialistPassword() {
		inputPassword.sendKeys(newPassword);
	}
	
	public String textSuccessfulSpecialistLogin() {
		return successfulSpecialistLogin.getText();
	}
	
	public SpecialistPasswordChange(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

}
