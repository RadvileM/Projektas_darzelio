package BaseTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
	
	protected static WebDriver driver;
	
	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://akademijait.vtmc.lt:8181/dis-app/");
	}
	

	
	@Before
	public void openHomePage(){
		driver.get("http://akademijait.vtmc.lt:8181/dis-app/");
	}
	

	@AfterClass
	public static void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
