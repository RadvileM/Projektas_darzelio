package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Utils.WaitUtils;



public class MainAdminPage extends AbstractPage{
	
	private String username = "admin";
	private String password = "admin";

	//inputs
	
	@FindBy( css = "#root > div > div > div > div > div > form > div.form-group.mx-auto.mt-3 > div > input")
	private WebElement inputUsername;
	
	
	@FindBy( css = "#root > div > div > div > div > div > form > div:nth-child(2) > div > input")
	private WebElement inputPassword;
	
	//buttons
	@FindBy(css = "#root > div > div > div > div > div > form > div.form-group.text-center.mt-5 > button > span")
	private WebElement loginButton;
	
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li.nav-item.my-auto > a")
	private WebElement logoutButton;
	
	//text
	@FindBy(linkText = "Administratorius")
	private WebElement successfulAdminLogin;
	

	
	public MainAdminPage(WebDriver driver) {
		super(driver);
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
	
	public void clickLogoutButton() {
		logoutButton.click();
	}
	

			
}
