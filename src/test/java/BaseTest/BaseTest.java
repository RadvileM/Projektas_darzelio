package BaseTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
	
	protected static WebDriver driver;
	
	@BeforeClass
	public void setUp() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://akademijait.vtmc.lt:8181/dis-app/");
		  
	}
	

	
	//@BeforeMethod
	//public void openHomePage(){
	//driver.get("http://akademijait.vtmc.lt:8181/dis-app/");
	//}
	

	@AfterClass
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
