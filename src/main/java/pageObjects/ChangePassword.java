package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ChangePassword {

	public WebDriver driver;

	public ChangePassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	// By EditProfile_btn=By.xpath("//a[@class='btn edit']");
	By Heading = By.xpath("//h1[text()='Change Password']");

	By CurrentPswd = By.id("current_password");
	By NewPswd = By.id("password");
	By Cnfrm_pswd = By.id("password_confirmation");

	By SaveBtn = By.xpath("//a[text()='Save']");
	By CancelBtn = By.xpath("//a[text()='Cancel ']");
	By SamePswdMsg = By.xpath("//span[text()='Current password cannot be saved as new password']");

	By SmallPswdMsg=By.xpath("//span[text()='Password must have at least 8 characters and contain uppercase, lowercase letters and numbers']");
	
	By IncorrectCurrentPswdMsg=By.xpath("//span[text()='The provided current password is incorrect, please try again']");
	
	public WebElement getIncorrectCurrentPswdMsg() {
		return driver.findElement(IncorrectCurrentPswdMsg);
	}
	
	public WebElement getCurrentPswd() {
		return driver.findElement(CurrentPswd);
	}
	public WebElement getNewPswd() {
		return driver.findElement(NewPswd);
	}
	public WebElement getCnfrm_pswd() {
		return driver.findElement(Cnfrm_pswd);
	}
	public WebElement getSaveBtn() {
		return driver.findElement(SaveBtn);
	}
	public WebElement getCancelBtn() {
		return driver.findElement(CancelBtn);
	}
	public WebElement getSamePswdMsg() {
		return driver.findElement(SamePswdMsg);
	}
	public WebElement getSmallPswdMsg() {
		return driver.findElement(SmallPswdMsg);
	}
	
	public WebElement getHeading() {
		return driver.findElement(Heading);
	}

}
