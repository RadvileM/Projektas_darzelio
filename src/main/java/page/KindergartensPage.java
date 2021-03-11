package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KindergartensPage extends AbstractPage {
	
	Random rand = new Random();
	
	private String name = "Vilniaus Saulute " + rand.nextInt(100);
	private String adrress = "Gedimino pr. " + rand.nextInt(100);
	
	
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
	//@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div[2]/div/table/tfoot/tr/td[2]/div/div")
	//(xpath = "//div[@class='alert alert-success']")
	@FindBy(css = "#root > div > div > div > div.col-7 > div.row > div > table > tfoot > tr > td:nth-child(2) > div > div")
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
		return textKindergartenAddedsuccessful.getText();
		
	}
	
	
	
	
	public KindergartensPage(WebDriver driver) {
		super(driver);

	}
	

}
