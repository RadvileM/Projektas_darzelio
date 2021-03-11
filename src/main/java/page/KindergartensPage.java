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
	
	
	//buttons
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div/div/table/tfoot/tr/td[1]/button")
	public WebElement newKindergatenButton;
	
	@FindBy(css = "#root > div > div > div > div.col-7 > div > div > table > tfoot > tr > td:nth-child(3) > button")
	public WebElement confirmKindergartenButton;
	
	
	//inputs
	@FindBy(id = "name")
	public WebElement inputKindergartenName;
	
	@FindBy(id = "address")
	public WebElement inputKindergartenAddress;
	
	
	//text
	@FindBy(xpath = "//div[@class='alert alert-success']")
	public WebElement textKindergartenAddedsuccessful;
	
	
	//methods
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

	}
	
	public String textKindergartenAdded() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
		return textKindergartenAddedsuccessful.getText();
		
	}
	
	
	
	
	public KindergartensPage(WebDriver driver) {
		super(driver);

	}
	

}
