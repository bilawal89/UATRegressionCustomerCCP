package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Payment {

	public WebDriver driver;
	
	public Payment(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By ChangeBtn = By.xpath("//a[text()='Change Payment Method']");
	
	By AddCreditBtn=By.id("show-credit-card-iframe");
	
	By NameField = By.id("CCName");
	
	
	
	
	
	public WebElement getNameField() {
		return driver.findElement(NameField);
	}

	
	public WebElement getAddCreditBtn() {
		return driver.findElement(AddCreditBtn);
	}
	
	public WebElement getChangeBtn() {
		return driver.findElement(ChangeBtn);
	}
}
