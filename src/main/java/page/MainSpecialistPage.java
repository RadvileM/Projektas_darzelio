package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainSpecialistPage extends AbstractPage {
	
	private String username = "TomasMikalauskas";
	private String password = "TomasMikalauskas";
	
	
	//inputs
	
	@FindBy( css = "#root > div > div > div > div > form > div.form-group.mx-auto.mt-3 > div > input")
	public WebElement inputUsername;
	
	
	@FindBy( css = "#root > div > div > div > div > form > div:nth-child(2) > div > input")
	private WebElement inputPassword;
	
	
	//buttons
	@FindBy(css = "#root > div > div > div > div > form > div.form-group.text-center.mt-5 > button")
	private WebElement loginButton;
	
	
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li:nth-child(6) > a")
	private WebElement logoutButton;
	
	
	//text
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li:nth-child(5) > a")
	//(css = "#root > div > nav > div:nth-child(3) > li:nth-child(5) > a > span")
	private WebElement successfulSpecialistLogin;
	
	
	
	@FindBy(css = "#root > div > div > div > div > form > div.form-group.mx-auto.mt-3 > label")
	private WebElement successfulSpecialistLogout;

	
	
	public MainSpecialistPage(WebDriver driver) {
		super(driver);
	}	


	
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
	
	
	}
	

	


