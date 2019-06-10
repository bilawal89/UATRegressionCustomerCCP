package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountSetting {

	public WebDriver driver;
	
	public AccountSetting(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By Heading = By.xpath("//span[text()='Account Settings']");
	
	By BrowseBtn = By.xpath("//span[@class='btn btn-default btn-file']");
	
	By SaveChanges=By.xpath("//a[@class='btn btn-primary' and text()='Save Changes']");
	
	By SuccessMsg = By.xpath("//span[text()='Settings saved successfully']");
	
	By filename= By.xpath("//span[@class='fileinput-filename']");
	
	By LogoText=By.xpath("//span[text()='1.png']");
	
	
	public WebElement getLogoText() {
		return driver.findElement(LogoText);
	}
	
	public WebElement getfilename() {
		return driver.findElement(filename);
	}
	
	public WebElement getSuccessMsg() {
		return driver.findElement(SuccessMsg);
	}
	
	public WebElement getSaveChanges() {
		return driver.findElement(SaveChanges);
	}
	
	public WebElement getBrowseBtn() {
		return driver.findElement(BrowseBtn);
	}
	
	public WebElement getHeading() {
		return driver.findElement(Heading);
	}
}
