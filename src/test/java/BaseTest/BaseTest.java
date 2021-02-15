package BaseTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
	
	protected static WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://akademijait.vtmc.lt:8181/dis-app/");
	}
	

	
//	@Before
//	public void openHomePage(){
//		driver.get("http://akademijait.vtmc.lt:8181/dis-app/");
//	}
	

	@AfterClass
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
