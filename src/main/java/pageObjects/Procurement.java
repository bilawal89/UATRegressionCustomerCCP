package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Procurement {

	public WebDriver driver;
	
	public Procurement(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	By Catheading = By.xpath("//h2[text()='Edit Category']");
	By Tenancy=By.xpath("(//span[@class=\"step-title\"])[1]");
	By Address=By.xpath("//span[@class=\"step-title\" and text()='Address of Use']");
	By Payment = By.xpath("//span[@class=\"step-title\" and text()='Payment and Billing']");
	By Review_Order=By.xpath("//span[@class=\"step-title\" and text()='Review Order']");
	By Continue1=By.xpath("//a[@class=\"btn btn-primary\" and text()='Continue']");
	By Continue2=By.xpath("(//a[@class=\"btn btn-primary\" and text()='Continue'])[2]");
	By Continue3=By.xpath("(//a[@class=\"btn btn-primary\" and text()='Continue'])[2]");
	By Submit_Order=By.xpath("//a[@class=\"btn btn-primary\" and text()='Submit Order']");
	By YesBtn=By.xpath("//a[text()='Yes I do']");
	By Sbmt_Order=By.xpath("//a[text()='Submit Order']");
	
	public WebElement getSbmt_Order() {
		return driver.findElement(Sbmt_Order);
	}
	public WebElement getYesBtn() {
		return driver.findElement(YesBtn);
	}
	
	public WebElement getSubmit_Order() {
		return driver.findElement(Submit_Order);
	}
	public WebElement getContinue3() {
		return driver.findElement(Continue3);
	}
	public WebElement getContinue2() {
		return driver.findElement(Continue2);
	}
	
	public WebElement getContinue1() {
		return driver.findElement(Continue1);
	}
	public WebElement getAddress() {
		return driver.findElement(Address);
	}
	
	public WebElement getPayment() {
		return driver.findElement(Payment);
	}
	
	public WebElement getReview_Order() {
		return driver.findElement(Review_Order);
	}
	
	public WebElement getCatheading() {
		return driver.findElement(Catheading);
	}
	public WebElement getTenancy() {
		return driver.findElement(Tenancy);
	}
	
}
