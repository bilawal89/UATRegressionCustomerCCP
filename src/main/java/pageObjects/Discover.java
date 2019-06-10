package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Discover {

	public WebDriver driver;
	
	public Discover(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By Heading =By.xpath("//h1[@class='ccp-m-heading']");
	By Step1Title=By.xpath("(//span[@class='step-title'])[1]");
	By Step2Title=By.xpath("(//span[@class='step-title'])[2]");
	By ExpectedUserLink=By.id("ExpectedUsers");
	By ContinueBtn=By.xpath("//a[text()='Continue']");
	
	public WebElement getContinueBtn() {
		return driver.findElement(ContinueBtn);
	}
	
	public WebElement getExpectedUserLink() {
		return driver.findElement(ExpectedUserLink);
	}
	public WebElement getStep2Title() {
		return driver.findElement(Step2Title);
	}
	public WebElement getStep1Title() {
		return driver.findElement(Step1Title);
	}
	public WebElement getHeading() {
		return driver.findElement(Heading);
	}

	
}
