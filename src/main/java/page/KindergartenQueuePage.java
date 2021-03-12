package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KindergartenQueuePage extends AbstractPage {

	//Nav bar link
	@FindBy(css = "#root > div > nav > div:nth-child(3) > li:nth-child(1) > a")
	public WebElement kinderGartenQueueButton;
	
	//button
	@FindBy(xpath = "//button[@class='col-12 btn btn-lg btn-success m-1']")
	public WebElement createKindergartenQueue;
		
	
	//Metodai
	public void clickKindergartenQueuePage() {
		kinderGartenQueueButton.click();
	}
	
	public String textOnKindergartenQueueButton() {
		return createKindergartenQueue.getText();
	}
	
	
	
		public KindergartenQueuePage(WebDriver driver) {
		super(driver);
	}

}
