package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KindergartensPage extends AbstractPage {
	WebDriverWait wait = new WebDriverWait(driver, 5);

	Random rand = new Random();

	private String name = "Vilniaus Saulute " + rand.nextInt(1000);
	private String adrress = "Gedimino pr. " + rand.nextInt(1000);

	/* buttons */
	@FindBy(xpath = "//button[@class='btn btn-md btn-success']")
	public WebElement newKindergatenButton;

	@FindBy(xpath = "//button[@class='btn btn-md btn-success']")
	public WebElement confirmKindergartenButton;

	/* inputs */
	@FindBy(id = "name")
	public WebElement inputKindergartenName;

	@FindBy(id = "address")
	public WebElement inputKindergartenAddress;

	/* text */
	@FindBy(xpath = "//div[@class='alert alert-success']")
	public WebElement textKindergartenAddedsuccessful;

	@FindBy(xpath = "//button[@class='btn btn-md btn-success']")
	public WebElement textOnAddKindergartenButton;

	/* methods */
	public void clickNewKindergartenButton() {
		newKindergatenButton.click();
	}

	public void addKindergartenName() {
		inputKindergartenName.sendKeys(name);
	}

	public void addKindergartenAddress() {
		inputKindergartenAddress.sendKeys(adrress);
	}

	public void clickAddNewKindergartenButton() {
		confirmKindergartenButton.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
	}

	public String textKindergartenAdded() {
		return textKindergartenAddedsuccessful.getText();

	}

	// tikrina ar yra mygtukas prideti darzeli

	public String textOnButtonAddKindergarten() {
		return textOnAddKindergartenButton.getText();
	}

	/* waits */

	public void waitForAddKindergartenButtonText() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(this.textOnAddKindergartenButton));
	}

	public KindergartensPage(WebDriver driver) {
		super(driver);
	}

}
