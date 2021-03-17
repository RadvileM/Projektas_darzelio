package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpecialistPasswordChange extends AbstractPage {
	WebDriverWait wait = new WebDriverWait(driver, 5);

	Random rand = new Random();

	private String newSpecialistUsername = "Specialist" + rand.nextInt(1000);
	private String specialistPassword = "Test" + rand.nextInt(1000000);

	/* inputs */
	@FindBy(name = "name")
	private WebElement inputNewSpecialist;

	@FindBy(css = "#root > div > div > div > form > div.form-group.mx-auto.mt-3 > div > input")
	public WebElement inputUsername;

	@FindBy(css = "#root > div > div > div > form > div:nth-child(2) > div > input")
	private WebElement inputPassword;

	@FindBy(xpath = "//input[@id='Dabartinis slaptažodis']")
	private WebElement oldPassword;

	@FindBy(id = "Naujas slaptažodis")
	private WebElement addNewPassword;

	@FindBy(id = "Pakartokite naują slaptažodį")
	private WebElement repeatNewPassword;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement successfulSpecialistLogin;

	/* buttons */

	@FindBy(xpath = "//button[@class='btn btn-secondary']")
	private WebElement loginButton;

	@FindBy(xpath = "//button[@class='btn btn-success mr-3']")
	private WebElement createSpecialistButton;

	@FindBy(css = "#root > div > nav > div:nth-child(3) > li > a")
	private WebElement logoutButton;

	@FindBy(css = "#root > nav > ul > li:nth-child(5) > a")
	private WebElement myDataButton;

	@FindBy(css = "#root > div > div > div:nth-child(2) > div > form > div:nth-child(2) > button")
	private WebElement changePassword;

	/* methods */

// create new specialist
	public void createNewSpecialist() {
		inputNewSpecialist.sendKeys(newSpecialistUsername);
	}

	public void clickCreateNewSpecialistButton() {
		createSpecialistButton.click();
	}

	// specialist login

	public void addSpecialistUsername() {
		inputUsername.sendKeys(newSpecialistUsername);
	}

	public void addSpecialistPassword() {
		inputPassword.sendKeys(newSpecialistUsername);
	}

	public void clickLoginButton() {
		loginButton.click();
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#root
		// > div > nav > div:nth-child(3) > li > a")));
	}

	// Specialist changes the password
	public void clickMyDataButton() {
		myDataButton.click();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.cssSelector("#root > div > div > div > div:nth-child(1) > div > h2")));
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
	}

	public String textSuccessfulSpecialistLogin() {
		return successfulSpecialistLogin.getText();
	}

	public SpecialistPasswordChange(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
