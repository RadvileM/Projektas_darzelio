package page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;






public class MainAdminPage extends AbstractPage{
	
	private String username1 = "admin";
	private String password2 = "admin";
	

	//inputs
	
	@FindBy( css = "#root > div > div > div > form > div.form-group.mx-auto.mt-3 > div > input")
	
	private WebElement inputUsername;
	
	
	@FindBy( css = "#root > div > div > div > form > div:nth-child(2) > div > input")
	private WebElement inputPassword;
	
	//buttons
	@FindBy(css = "#root > div > div > div > form > div.form-group.text-center.mt-5 > button > span")
	private WebElement loginButton;
	
	@FindBy(css = "#root > nav > ul > li:nth-child(3) > a")
	private WebElement logoutButton;
	
	//text
	@FindBy(linkText = "Administratorius")
	private WebElement successfulAdminLogin;
	
	@FindBy(css = "#root > div > div > div > form > div.form-group.mx-auto.mt-3 > label")
	public WebElement successfulAdminLogout;
	

	
	public MainAdminPage(WebDriver driver) {
		super(driver);
	}

//methods 
	public void doAdminLogin() throws IOException {
		
		List<String> testData = utilities.fileReader.getTestData("src/test/resources/admin-cred.txt");
		
		String username = testData.get(0);
		String password = testData.get(1);
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		loginButton.click();		
	}
		
	
	public void doAdminLogout() {
		logoutButton.click();
		
	}
	
	public void addInputUsername() {
		inputUsername.sendKeys(username1);
	}
	

	public void addInputPassword() {
		inputPassword.sendKeys(password2);
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

}
