package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditProfilePage {
	
	public WebDriver driver ;
	
	
	
	public EditProfilePage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	//By EditProfile_btn=By.xpath("//a[@class='btn edit']");
	By SaveBtn=By.xpath("//a[text()='Save']");

	By CancelBtn=By.xpath("//a[text()='Cancel']");
	
	
	By Heading = By.xpath("//h1[text()='My Account']");
	
	By email = By.id("email");
	
	//By Notification_heading=By.xpath("//h1[text()='Notifications']");
	
	public WebElement getemail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getCancelBtn()
	{
		return driver.findElement(CancelBtn);
	}
	
	public WebElement getSaveBtn()
	{
		return driver.findElement(SaveBtn);
	}
	
	public WebElement getHeading()
	{
		return driver.findElement(Heading);
	}
	
	

}
