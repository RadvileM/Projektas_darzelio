package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainParentPage extends AbstractPage {
	private String username = "MariusAdomaitis";
	private String password = "MariusAdomaitis";
	
	
	
	//inputs
	
	@FindBy( css = "#root > div > div > div > div > div > form > div.form-group.mx-auto.mt-3 > div > input")
	public WebElement inputUsername;
	
	
	@FindBy( css = "#root > div > div > div > div > div > form > div:nth-child(2) > div > input")
	private WebElement inputPassword;
	
	//buttons
	@FindBy(css = "#root > div > div > div > div > div > form > div.form-group.text-center.mt-5 > button > span")
	private WebElement loginButton;
	
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li.nav-item.my-auto > a")
	private WebElement logoutButton;
	
	
	//text
	@FindBy(linkText = "Vaiko atstovas")
	private WebElement successfulParentLogin;
	
	@FindBy(linkText = "Prisijungimo vardas")
	private WebElement successfulParentLogout;
	

	
	public MainParentPage(WebDriver driver) {
		super(driver);
	}
	
	public void addInputParentUsername() {
		inputUsername.sendKeys(username);
	}
	

	public void addInputParentPassword() {
		inputPassword.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickLogoutButton() {
		logoutButton.click();
	}
	

}
