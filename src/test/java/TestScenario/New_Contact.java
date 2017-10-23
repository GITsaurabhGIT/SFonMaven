package TestScenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class New_Contact {
	
	WebDriver driver;
	
	public New_Contact(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By f_Name = By.id("name_firstcon2");
	By l_Name = By.id("name_lastcon2");
	By save = By.name("save");
	By err = By.xpath("//*[contains(text(),'You must enter a value')]");
	
	public void first_Name(String fname)
	{
		driver.findElement(f_Name).sendKeys(fname);		
	}
	
	public void last_Name(String lname)
	{
		driver.findElement(l_Name).sendKeys(lname+firstproj.random_num);
	}
	
	public void save_Button()
	{
		driver.findElement(save).click();
	}
	
	public void error_message()
	{	
		Assert.assertEquals(driver.findElement(err).getText(), "Error: You must enter a value","assertion failed");
	}
}
