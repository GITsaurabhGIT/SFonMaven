package TestScenario;

import java.util.concurrent.TimeUnit;

//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class firstproj {

	public String baseUrl = "https://login.salesforce.com";
	WebDriver driver;
	
	//generating a unique random number
	static double random_num_double = Math.random()*100 + 1;
	static int random_num = (int)(random_num_double);
	
	@BeforeTest
	public void launchBrowser()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		 
		driver.get(baseUrl);
			
	}
	
	
	@Test(priority = 1)
	public void loginPage()
	{
		//LogIn logIn = new LogIn(driver);
		LogIn lIn=PageFactory.initElements(driver, LogIn.class);
		lIn.userName("sauraabh007@gmail.com");		
		lIn.passwordmeth("salesforce.com17");
		lIn.loginclick();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MINUTES);
	}
	
	@Test(priority = 2)
	public void clickOnContact()
	{
		HomePage contact = new HomePage(driver);
		contact.clickOnContact();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MINUTES);
	}
	
	@Test(priority = 3)
	public void clickingNew()
	{
		Contact_Home ch = new Contact_Home(driver);
		ch.clickNewButton();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MINUTES);
	}
	
	@Test(priority = 4)
	public void setValuesNewPage()
	{
		New_Contact nc = new New_Contact(driver);
		nc.save_Button();
		nc.error_message();
		nc.first_Name("Contact");
		nc.last_Name("Name");
		nc.save_Button();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MINUTES);
	}
	
	@Test(priority = 6)
	public void read_Contact_Name()
	{
		Contact_View vc = new Contact_View(driver);
		String cName = vc.view_contact().toString();
		
		System.out.println(cName);
	}
	
	//@AfterTes
	public void closeBrowser()
	{
		driver.close();
	}
	
}
