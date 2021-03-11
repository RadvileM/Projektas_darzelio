package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class MainAdminPage extends AbstractPage{
	
	private String username = "admin";
	private String password = "admin";

	//inputs
	
	@FindBy( css = "#root > div > div > div > div > form > div.form-group.mx-auto.mt-3 > div > input")
	private WebElement inputUsername;
	
	
	@FindBy( css = "#root > div > div > div > div > form > div:nth-child(2) > div > input")
	private WebElement inputPassword;
	
	//buttons
	@FindBy(css = "#root > div > div > div > div > form > div.form-group.text-center.mt-5 > button")
	private WebElement loginButton;
	
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li > a")
	private WebElement logoutButton;
	
	
	//lock/unlock user Specialist
	@FindBy(xpath = "//button[@class='btn btn-sm btn-secondary col-12']")
	private WebElement lockButton;
	
	@FindBy(xpath = "//button[@class='btn btn-sm btn-info col-12']")
	private WebElement unlockButton;
	
	//text
	@FindBy(linkText = "Administratorius")
	private WebElement successfulAdminLogin;
	
	@FindBy(css = "#root > div > div > div > div > form > div.form-group.mx-auto.mt-3 > label")
	public WebElement successfulAdminLogout;
	
	//lock/unlock user Specialist
	@FindBy(xpath = "//div[@class='alert alert-success']")
	public WebElement successfulLockedUnlockedSpecialist;
	
	
	public MainAdminPage(WebDriver driver) {
		super(driver);
	}

//methods 
	public void doAdminLogin() {
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		loginButton.click();		
	}
		
	
	public void doAdminLogout() {
		logoutButton.click();
		
	}
	
	public void addInputUsername() {
		inputUsername.sendKeys(username);
	}
	

	public void addInputPassword() {
		inputPassword.sendKeys(password);
	}
	
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public String textSuccessfulAdminLogin() {
		return successfulAdminLogin.getText();
	}
	
	public String textSuccessfulAdminLogout() {
		return successfulAdminLogout.getText();
	}
	
	//lock/unlock specialist
	
	public void clickLockButton() {
		lockButton.click();
	}
	
	public void clickUnlockButton() {
		unlockButton.click();
	}
	
	public String textSuccessfulLockedUnlockedSpecialist() {
		return successfulLockedUnlockedSpecialist.getText();
	}

}
