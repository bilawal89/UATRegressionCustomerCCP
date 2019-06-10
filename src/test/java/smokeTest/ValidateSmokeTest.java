package smokeTest;

import static org.testng.Assert.assertEquals;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountSetting;
import pageObjects.Address;
import pageObjects.Catalog;
import pageObjects.ChangePassword;
import pageObjects.Customer;
import pageObjects.Discover;
import pageObjects.Domains;
import pageObjects.EditProfilePage;
import pageObjects.ForgetPswdPage;
import pageObjects.Header;
import pageObjects.HomePage;
import pageObjects.Insight;
import pageObjects.LoginPage;
import pageObjects.NotificationPage;
import pageObjects.Payment;
import pageObjects.Procurement;
import pageObjects.Provider;
import pageObjects.RegisterationPage;
import pageObjects.Role;
import pageObjects.Users;
import pageObjects.Manage;
import pageObjects.MyProfilePage;
import resources.base;

public class ValidateSmokeTest extends base {
	public static Logger Log = LogManager.getLogger(base.class.getName());
	public HomePage hp;
	public WebDriver driver;
	private WebElement HeaderSection;

	@Test(priority = 0)
	public void ValidateLogin() throws IOException, InterruptedException {

		driver = initializeDriver();
		String TitleHome = driver.getTitle();
		Log.info("The title of the home page is captured");
		Assert.assertEquals(TitleHome, "Marketplace - CCP", "User is not being able to Login to the application");
		Log.info("The title of the Shop page is Verified Successfully");
	}

	@Test(priority = 1, dependsOnMethods = { "ValidateLogin" })

	public void ValidateHomePage() throws InterruptedException {

		HomePage hm = new HomePage(driver);
		boolean MarketPlace_present;
		try {
			hm.getMarketPlace_Link().click();
			Thread.sleep(2000);
			Log.info("From the Home Page User has Clicked on MarkITPlace tab");
			MarketPlace_present = true;

		} catch (NoSuchElementException e) {
			MarketPlace_present = false;
			Log.error("User not able to find MarkITPlace Link , hence not able to click it");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(MarketPlace_present, true, "MarketPlace Link is not Present in the Dashboard");
		Log.info("User has routed to the Shop Page after clicking on MarketPlace link");

		boolean Manage_present;
		try {
			hm.getManage_Link();
			Thread.sleep(2000);
			Log.info("From the Home Page User has Clicked on Manage tab");
			Manage_present = true;

		} catch (NoSuchElementException e) {
			Manage_present = false;
			Log.error("User not able to find Manage Link on the home page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Manage_present, true, "Manage Link is not Present in the Dashboard");

		boolean Insight_present;
		try {
			hm.getInsight_Link();
			Thread.sleep(2000);
			Log.info("From the Home Page User has Clicked on Insight tab");
			Insight_present = true;

		} catch (NoSuchElementException e) {
			Insight_present = false;
			Log.error("User not able to find Insight Link on the home page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Insight_present, true, "Insight Link is not Present in the home Dashboard");

		Assert.assertEquals(driver.getCurrentUrl(), "https://ccpqa-customerportal.arpatech.com/marketplace",
				"The URL of the home page is not as per expected");

		boolean Discover_present;
		try {
			hm.getDiscover().isEnabled();

			Discover_present = true;

		} catch (NoSuchElementException e) {
			Discover_present = false;
			Log.error("User not able to find Discover Link on the MarkITPlace Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Discover_present, true, "Discover Link is not Present in the MarkITPlace");

		boolean Applications_present;
		try {
			hm.getApplication_Link().isEnabled();

			Applications_present = true;

		} catch (NoSuchElementException e) {
			Applications_present = false;
			Log.error("User not able to find Applications Link on the MarkITPlace Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Applications_present, true,
				"User not able to find Applications Link on the MarkITPlace Page");

		boolean Infrastructure_present;
		try {
			hm.getInfrastructure_Link();
			Infrastructure_present = true;

		} catch (NoSuchElementException e) {
			Infrastructure_present = false;
			Log.error("User not able to find Infrastructure Link on the Shop Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Infrastructure_present, true, "Infrastructure Link is not Present in the Dashboard");

		boolean Platform_present;
		try {
			hm.getPlatform_Link();
			Platform_present = true;

		} catch (NoSuchElementException e) {
			Platform_present = false;
			Log.error("User not able to find Platform_present Link on the Shop Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Platform_present, true, "Platform Link is not Present in the Dashboard");

		boolean Consulting_present;
		try {
			hm.getConsulting();
			Consulting_present = true;
			Log.error("Consulting link is found on home page");

		} catch (NoSuchElementException e) {
			Consulting_present = false;
			Log.error("User not able to find Consulting Link on the Shop Page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Consulting_present, true, "Consulting Link is not Present in the Dashboard");

		boolean dfp_present;
		try {
			hm.getDFP_Banner().isDisplayed();
			dfp_present = true;
			Log.info("DFP banner is appearing on the home page in the footer");

		} catch (NoSuchElementException e) {
			dfp_present = false;
			Log.error("DFP banner is not appearing on the home page in the footer");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(dfp_present, true, "DFP banner is not appearing on the home page in the footer");

		boolean FeaturedServices_present;
		try {
			hm.getFeatured_Services().isDisplayed();
			FeaturedServices_present = true;
			Log.info("Featured Services section Heading is appearing on the home page");

		} catch (NoSuchElementException e) {
			FeaturedServices_present = false;
			Log.error("Featured Services section Heading is not appearing on the home page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(FeaturedServices_present, true,
				"Featured Services section Heading is not appearing on the home page");

		boolean FeaturedServices_Btn;

		try {
			hm.getBtn().isDisplayed();
			FeaturedServices_Btn = true;
			Log.info("In featured Services section get it now button is appearing on the home page");

		} catch (NoSuchElementException e) {
			FeaturedServices_Btn = false;
			Log.error("In Featured Services section get it now button is not appearing on the home page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(FeaturedServices_Btn, true,
				"In Featured Services section get it now button is not appearing on the home page");

		boolean Shop_present;
		try {
			hm.getShopSection().isDisplayed();
			Shop_present = true;
			Log.info("Shop By Vendor section Heading is appearing on the home page");

		} catch (NoSuchElementException e) {
			Shop_present = false;
			Log.error("Shop By Vendor section Heading is not appearing on the home page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Shop_present, true, "Shop by Vendor section Heading is not appearing on the home page");

		boolean YourServices_present;
		try {
			hm.getServiceSection().isDisplayed();
			YourServices_present = true;
			Log.info("Your Services Heading is appearing on the home page");

		} catch (NoSuchElementException e) {
			YourServices_present = false;
			Log.error("Your Services Heading is not appearing on the home page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(YourServices_present, true, "Your Services Heading is not appearing on the home page");

	}

	@Test(priority = 2, dependsOnMethods = { "ValidateLogin" })

	public void ValidateServicesGetBtn() throws InterruptedException {

		HomePage hm = new HomePage(driver);
		boolean GetNow_present;
		try {
			hm.getBtn().click();
			Thread.sleep(2000);
			Log.info("From the Home Page User has Clicked Get Now button from Services Section");
			GetNow_present = true;

		} catch (NoSuchElementException e) {
			GetNow_present = false;
			Log.error("User not able to find Get now button on the services section of the home page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(GetNow_present, true,
				"User not able to find Get now button on the services section of the home page");
		Assert.assertEquals(driver.getTitle(), "Corp. CSP Azure Active Directory Premium P1 Monthly - CCP",
				"user not able to route to PDP page after clicking on Get it Now button from Home page services section");
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://ccpqa-customerportal.arpatech.com/catalog/product-detail/16",
				"When Clicking on Get It Now button button then the URL is not appearing as expected");
	}

	@Test(priority = 3, dependsOnMethods = { "ValidateLogin" })

	public void ValidateProcurementCheckout() throws InterruptedException {

		HomePage hm = new HomePage(driver);
		boolean GetNow_present;
		try {
			hm.getP_GetBtn().click();
			Thread.sleep(2000);
			Log.info("From the Pdp Page user is clicking on Get it now button");
			GetNow_present = true;

		} catch (NoSuchElementException e) {
			GetNow_present = false;
			Log.error("From the Pdp Page user not able to find get it now button");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(GetNow_present, true, "From the Pdp Page user not able to find get it now button");
		Assert.assertEquals(driver.getTitle(), "Procurement - CCP",
				"User not able to route to procurement checkout page when clicking on get it now button on PDP page");
		// Assert.assertEquals(driver.getCurrentUrl(),
		// "https://ccpqa-customerportal.arpatech.com/procurement?cart=313","User not
		// able to route to desired procurement checkout page URL when clicking on get
		// it now button on PDP page");

		Procurement pr = new Procurement(driver);

		boolean Tenancy_present;
		try {
			pr.getTenancy().isDisplayed();
			// Thread.sleep(2000);
			Log.info("Tenancy Information section is present on procurement checkout page");
			Tenancy_present = true;

		} catch (NoSuchElementException e) {
			Tenancy_present = false;
			Log.error("Tenancy Information section is not present on procurement checkout page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Tenancy_present, true,
				"Tenancy Information section is not present on procurement checkout page");

		boolean Address_present;
		try {
			pr.getAddress().isDisplayed();
			// Thread.sleep(2000);
			Log.info("Address of Use Section is present on procurement checkout page");
			Address_present = true;

		} catch (NoSuchElementException e) {
			Address_present = false;
			Log.error("Address of Use Section is not present on procurement checkout page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Address_present, true,
				"Address of Use Section is not present on procurement checkout page");

		boolean Payment_present;
		try {
			pr.getPayment().isDisplayed();
			// Thread.sleep(2000);
			Log.info("Payment & Billing Section is present on procurement checkout page");
			Payment_present = true;

		} catch (NoSuchElementException e) {
			Payment_present = false;
			Log.error("Payment & Billing Section is not present on procurement checkout page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Payment_present, true,
				"Payment & Billing Section is not present on procurement checkout page");

		boolean Review_Order;
		try {
			pr.getReview_Order().isDisplayed();
			// Thread.sleep(2000);
			Log.info("Review Order Section is present on procurement checkout page");
			Review_Order = true;

		} catch (NoSuchElementException e) {
			Review_Order = false;
			Log.error("Review Order Section is not present on procurement checkout page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Review_Order, true, "Review Order Section is not present on procurement checkout page");

	}

	@Test(priority = 4, dependsOnMethods = { "ValidateLogin" })

	public void ValidateProcurementOrder() throws InterruptedException {

		Procurement pr = new Procurement(driver);

		boolean YesBtn_present;
		try {
			pr.getYesBtn().click();
			Thread.sleep(2000);
			Log.info("From the procurement checkout page user is clicking on step#1 Yes button");
			YesBtn_present = true;

		} catch (NoSuchElementException e) {
			YesBtn_present = false;
			Log.error("From the procurement checkout page, Yes button is not present on step#1 page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(YesBtn_present, true,
				"From the procurement checkout page, Yes button is not present on step#1 page");

		boolean Step1Btn_present;
		try {
			pr.getContinue1().click();
			Thread.sleep(2000);
			Log.info("From the procurement checkout page user is clicking on step#1 continue button");
			Step1Btn_present = true;

		} catch (NoSuchElementException e) {
			Step1Btn_present = false;
			Log.error("From the procurement checkout page, continue button is not present on step#1 page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Step1Btn_present, true,
				"From the procurement checkout page, continue button is not present on step#1 page");

		// Assert.assertEquals(driver.getCurrentUrl(),
		// "https://ccpqa-customerportal.arpatech.com/procurement?cart=313","User not
		// able to route to desired procurement checkout page URL when clicking on get
		// it now button on PDP page");
		boolean Step2Btn_present;
		try {
			pr.getContinue2().click();
			Thread.sleep(2000);
			Log.info("From the procurement checkout page user is clicking on step#1 continue button");
			Step2Btn_present = true;

		} catch (NoSuchElementException e) {
			Step2Btn_present = false;
			Log.error("From the procurement checkout page, continue button is not present on step#2 page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Step2Btn_present, true,
				"From the procurement checkout page, continue button is not present on step#2 page");

		boolean Step3Btn_present;
		try {
			pr.getContinue3().click();
			Thread.sleep(2000);
			Log.info("From the procurement checkout page user is clicking on step#3 continue button");
			Step3Btn_present = true;

		} catch (NoSuchElementException e) {
			Step3Btn_present = false;
			Log.error("From the procurement checkout page, continue button is not present on step#3 page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Step3Btn_present, true,
				"From the procurement checkout page, continue button is not present on step#3 page");

		boolean SbmtBtn_present;
		try {
			pr.getSbmt_Order().click();
			Thread.sleep(2000);
			Log.info("From the procurement checkout page user is clicking on submit order button");
			SbmtBtn_present = true;

		} catch (NoSuchElementException e) {
			SbmtBtn_present = false;
			Log.error("From the procurement checkout page, submit order button is not present on step#4 page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(SbmtBtn_present, true,
				"From the procurement checkout page, submit order button is not present on step#4 page");
		Thread.sleep(8000);

		Assert.assertEquals(driver.getTitle(), "Order Received - CCP",
				"After clicking on submit button on procurement checkout, user is not able to navigate to order received page");
	}

	@Test(priority = 5, dependsOnMethods = { "ValidateLogin" })

	public void ValidateNotificationPage() throws InterruptedException {

		Header hd = new Header(driver);

		// Thread.sleep(10000);
		boolean bell_present;
		try {
			hd.getNotification().click();
			Thread.sleep(2000);
			Log.info("From the Customer Portal user is clicking on notification icon");
			bell_present = true;

		} catch (NoSuchElementException e) {
			bell_present = false;
			Log.error("Notification icon is not present on a page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(bell_present, true, "Notification icon is not present on a page");

		Assert.assertEquals(driver.getTitle(), "Notifications - CCP",
				"User not able to land to the notification page after clicking on the bell icon from the header");

		NotificationPage nt = new NotificationPage(driver);
		boolean Notificationtab_present;
		try {
			nt.getAll_Notification().isDisplayed();
			// Thread.sleep(2000);
			Log.info("All notifications tab is present on notification page");
			Notificationtab_present = true;

		} catch (NoSuchElementException e) {
			Notificationtab_present = false;
			Log.error("All notifications tab is not present on notification page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Notificationtab_present, true, "All notifications tab is not present on notification page");

		boolean Flagged_present;
		try {
			nt.getAll_Notification().isDisplayed();
			// Thread.sleep(2000);
			Log.info("Flagged tab is present on notification page");
			Flagged_present = true;

		} catch (NoSuchElementException e) {
			Flagged_present = false;
			Log.error("Flagged tab is not present on notification page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Flagged_present, true, "Flagged tab is not present on notification page");

	}

	@Test(priority = 6, dependsOnMethods = { "ValidateLogin" })

	public void ValidateInviteEmail() throws InterruptedException {

		Header hd = new Header(driver);

		// Thread.sleep(10000);
		boolean AccountMenu_present;
		Actions an = new Actions(driver);
		try {
			an.moveToElement(hd.getAccountMenu()).perform();
			hd.getUsers().click();
			// Thread.sleep(2000);
			Log.info("From the Customer Portal user is clicking on User management from account menu");
			AccountMenu_present = true;

		} catch (NoSuchElementException e) {
			AccountMenu_present = false;
			Log.error("Account menu and user management is not appearing in the header");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(AccountMenu_present, true,
				"Account menu and user management is not appearing in the header");

		Assert.assertEquals(driver.getTitle(), "User Management - CCP",
				"User not able to land to the User management page after clicking on user management from account menu in the header");

		Users us = new Users(driver);

		// boolean Usertab_present =false;
		boolean Invitetab_present = false;
		boolean InviteUserBtn_present = false;
		boolean EmailTxtbox_present = false;
		boolean InviteBtn_present = false;
		boolean EmailSucessMsg = false;
		boolean InviteMore = false;
		boolean emailtxtbox = false;
		boolean Domain_Msg = false;

		// boolean Requesttab_present =false;

		Random rm = new Random();
		int i = rm.nextInt(1000) + 1;

		// WebDriverWait wt = new WebDriverWait(driver,50);

		try {
			Thread.sleep(5000);
			us.getInvitesTab().click();
			Invitetab_present = true;
			us.getInviteUserBtn().click();
			InviteUserBtn_present = true;

			us.getemailtextbox().sendKeys(i + "bilawal.alam" + i + "@arpatech.com");
			EmailTxtbox_present = true;

			us.getInviteBtn().click();
			InviteBtn_present = true;
			// wt.until(ExpectedConditions.elementToBeClickable(us.getEmailSuccessMsg()));
			Thread.sleep(20000);
			us.getEmailSuccessMsg().isDisplayed();
			EmailSucessMsg = true;

			us.getInviteMoreBtn().click();
			InviteMore = true;

			us.getemailtextbox().sendKeys("bilawal.alam" + i + "@arpatech" + i + ".com");
			emailtxtbox = true;

			us.getInvite2Btn().click();

			Thread.sleep(20000);
			// wt.until(ExpectedConditions.elementToBeClickable(us.getDomainMsg()));
			// wt.until(ExpectedConditions.visibilityOf(us.getDomainMsg()));
			us.getDomainMsg().isDisplayed();

			Domain_Msg = true;

		} catch (NoSuchElementException e) {
			// Notificationtab_present = false;
			// Log.error("All notifications tab is not present on notification page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Invitetab_present, true, "Invite tab is not appearing on User management Page");
		Assert.assertEquals(InviteUserBtn_present, true,
				"Invite User button is not appearing under invite tab in the user management Page");
		Assert.assertEquals(EmailTxtbox_present, true,
				"Email textbox is not appearing when user is clicking invite user button");

		Assert.assertEquals(InviteBtn_present, true,
				"Invite button is not appearing once user is tying the email address in the email textbox under invite tab in user management page");
		Assert.assertEquals(EmailSucessMsg, true,
				"Success Message is not appearing when entering a valid email address in the email field");
		Assert.assertEquals(InviteMore, true,
				"Invite more button is not appearing after a success message of of email register appearing");

		Assert.assertEquals(emailtxtbox, true,
				"User is not able to enter a valid email address with the new domain to register");
		Assert.assertEquals(Domain_Msg, true, "New Domain registeration message is not appearing");

	}

	@Test(priority = 7, dependsOnMethods = { "ValidateLogin" })

	public void ValidateSearchUser() throws InterruptedException {

		Users us = new Users(driver);
		boolean Usertab_present = false;
		boolean Invitetab_present = false;
		boolean Requesttab_present = false;

		try {
			us.getUserTab().click();
			Usertab_present = true;
			us.getInvitesTab().isDisplayed();
			Invitetab_present = true;
			us.getRequestTab().isDisplayed();
			Requesttab_present = true;

		} catch (NoSuchElementException e) {

			Log.error(e.getMessage());
		}
		Assert.assertEquals(Usertab_present, true, "User tab is not present on user management page");
		Assert.assertEquals(Invitetab_present, true, "Invite tab is not present on user management page");
		Assert.assertEquals(Requesttab_present, true, "Request tab is not present on user management page");

		boolean Searchbox_present = false;
		boolean SearchListing_present = false;
		boolean ccprecord_present = false;

		try {
			us.getSearchBox().sendKeys("ccp" + Keys.ENTER);
			Thread.sleep(2000);
			Searchbox_present = true;
			Log.info("User is entering ccp keyword in search box");
			us.getSearchListing().isDisplayed();
			SearchListing_present = true;
			us.getCCPRecord().isDisplayed();
			ccprecord_present = true;

			// SearchListing_present = false;
			// Flagged_present = true;

		} catch (NoSuchElementException e) {
			// Flagged_present = false;
			// Log.error("Flagged tab is not present on notification page");
			Log.error(e.getMessage());
		}

		Assert.assertEquals(Searchbox_present, true, "Search listing textbox is not appearing in user management page");
		Assert.assertEquals(SearchListing_present, true, "Search result records are not getting displayed");
		Assert.assertEquals(ccprecord_present, true, "Correct records are not getting displayed");

		Select se1;

		String Option1 = null;
		String Option2 = null;
		boolean Save_Present = false;
		boolean Cancel_Present = false;

		try {
			se1 = new Select(us.getDropdown());
			Option1 = se1.getOptions().get(0).getText().trim();
			Option2 = se1.getOptions().get(1).getText().trim();
			se1.selectByIndex(1);
			
			Thread.sleep(8000);
			us.getSaveBtn().isDisplayed();
			Save_Present = true;
			us.getCancelBtn().isDisplayed();
			Cancel_Present = true;

		} catch (NoSuchElementException e) {
			// Flagged_present = false;
			// Log.error("Flagged tab is not present on notification page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Option1, "Admin", "Admin is not appearing as the first option of the dropdown of roles");
		Assert.assertEquals(Option2, "User", "User is not appearing as the Second option of the dropdown of roles");
		Assert.assertEquals(Save_Present, true,
				"Save button is not appearing when user is selecting user from the user role drop down");
		Assert.assertEquals(Cancel_Present, true,
				"Cancel button is not appearing when user is selecting user from the user role drop down");
	}

	@Test(priority = 8, dependsOnMethods = { "ValidateLogin" })

	public void ValidateManageDomain() throws InterruptedException {

		Header hd = new Header(driver);

		boolean Domain_present = false;
		Actions an = new Actions(driver);
		try {
			an.moveToElement(hd.getAccountMenu()).perform();
			hd.getDomain().click();

			Log.info("From the Customer Portal user is clicking on manage domains from account menu");
			Domain_present = true;

		} catch (NoSuchElementException e) {

			Log.error("Account menu and manage domains are not appearing in the header of the page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Domain_present, true,
				"Account menu and manage domains are not appearing in the header of the page");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Manage Domains - CCP",
				"User not able to land to the Manage Domain page after clicking on manage domain option from account menu in the header");

		// boolean Usertab_present =false;
		boolean Defaulttext_present = false;
		Domains dm = new Domains(driver);

		try {
			dm.getArpatechDomain().isDisplayed();
			dm.getDefaultText().isDisplayed();

			Defaulttext_present = true;

		} catch (NoSuchElementException e) {
			Defaulttext_present = false;
			Log.error("Default text is not appearing against the arpatech domain on manage domain page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(Defaulttext_present, true,
				"Default text is not appearing against the arpatech domain on manage domain page");

	}

	@Test(priority = 9, dependsOnMethods = { "ValidateLogin" })

	public void ValidateEditProfile() throws InterruptedException {

		Header hd = new Header(driver);

		boolean MyProfle_present = false;
		Actions an = new Actions(driver);
		try {
			an.moveToElement(hd.getAccountMenu()).perform();
			hd.getMyProfile().click();

			Log.info("From the Customer Portal user is clicking on my profile from account menu");
			MyProfle_present = true;

		} catch (NoSuchElementException e) {

			Log.error("From the Customer Portal user not able to find my profile link from account menu");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(MyProfle_present, true,
				"From the Customer Portal user not able to find my profile link from account menu");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "My Profile - CCP",
				"User not able to land to the My Profile page after clicking on My Profile page from account menu in the header");

		MyProfilePage mpp = new MyProfilePage(driver);

		// boolean Usertab_present =false;
		boolean EditProfile_present = false;

		try {
			mpp.getEditProfile_btn().click();

			EditProfile_present = true;

		} catch (NoSuchElementException e) {
			EditProfile_present = false;
			Log.error("Edit profile button is not appearing on My Profile page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(EditProfile_present, true, "Edit profile button is not appearing on My Profile page");

		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Edit Profile - CCP",
				"User not able to land to the Edit Profile page after clicking on Edit profile button on the my profile page");

		boolean emaildisabled = false;
		boolean SaveBtn_present = false;
		EditProfilePage epp = new EditProfilePage(driver);

		try {
			// emaildisabled=epp.getemail().isEnabled();
			epp.getSaveBtn().click();

			SaveBtn_present = true;

		} catch (NoSuchElementException e) {

			Log.error("Save button is not appearing on Edit page");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(SaveBtn_present, true, "Save button is not appearing on Edit page");
		// Assert.assertEquals(emaildisabled, false, "Email text field is not appearing
		// disable on edit profile page");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "My Profile - CCP",
				"User not able to land to the My Profile page after clicking on save button on edit profile page");
	}

	@Test(priority = 10, dependsOnMethods = { "ValidateLogin" })

	public void ValidateUpload_Logo() throws InterruptedException, AWTException {

		Header hd = new Header(driver);

		boolean AccountSettings_present = false;
		Actions an = new Actions(driver);
		try {
			an.moveToElement(hd.getAccountMenu()).perform();
			hd.getAccountSettings().click();

			Log.info("From the Customer Portal user is clicking on Account settings from account menu");
			AccountSettings_present = true;

		} catch (NoSuchElementException e) {

			Log.error("From the Customer Portal user not able to click on Account settings from account menu");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(AccountSettings_present, true,
				"From the Customer Portal user not able to click on Account settings from account menu");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Account Settings - CCP",
				"User not able to land to the Account Settings page after clicking on Account settings link from account menu in the header");

		AccountSetting acc = new AccountSetting(driver);

		// boolean Usertab_present =false;
		boolean BrowseBtn_present = false;
		boolean SaveBtn_present = false;
		boolean SuccessMsg_present = false;
		boolean LogoImageText=false;
		
		Robot rb = new Robot();
	

		try {
			Thread.sleep(5000);
			acc.getBrowseBtn().click();
			//acc.getBrowseBtn().sendKeys("C:\\Users\\bilaw\\Desktop\\logo\\1.png");
			BrowseBtn_present = true;
			Thread.sleep(4000);
			//rb.setAutoDelay(5000);
			StringSelection ss = new StringSelection("C:\\Users\\bilaw\\Desktop\\logo\\1");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			//rb.setAutoDelay(2000);
			
			Thread.sleep(4000);	
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);

			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			//rb.setAutoDelay(1000);
			Thread.sleep(2000);	
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			acc.getSaveChanges().click();
			SaveBtn_present = true;
			Thread.sleep(5000);
			
			//acc.getLogoText().isDisplayed();
			
			//LogoImageText=true;
			//filename= acc.getfilename().getText();
			//acc.getfilename().getText()

			
			acc.getSuccessMsg().isDisplayed();

			SuccessMsg_present = true;

		} catch (NoSuchElementException e) {

			Log.error(
					"On Account Setting Page Browse Button, Save Changes Button or Success Validation message is not appearing");
			Log.error(e.getMessage());
		}
	
		Assert.assertEquals(BrowseBtn_present, true, "Browse button is not appearing in the Account Settings Page");
		Assert.assertEquals(SaveBtn_present, true, "Save Changes Button is not appearing in the Account Settings Page");
		Assert.assertEquals(SuccessMsg_present, true,
				"When User is uploading a logo in Account Setting page then Success validation message doesnot appear");

		//Assert.assertEquals(LogoImageText, true, "Logo image is not getting uploaded");
		//Assert.assertEquals(filename, "1.png","Logo image is not getting uploaded");
	}

	@Test(priority = 11, dependsOnMethods = { "ValidateLogin" })

	public void ValidateAddressofUse() throws InterruptedException, AWTException {

		Header hd = new Header(driver);

		boolean AddressOfUse_present = false;
		Actions an = new Actions(driver);
		try {
			an.moveToElement(hd.getAccountMenu()).perform();
			hd.getAddressOfUse().click();
			AddressOfUse_present = true;
			Log.info("From the Customer Portal user is clicking on Address Of use from account menu");

		} catch (NoSuchElementException e) {

			Log.error("From the Customer Portal user not able to click on Address Of Use from account menu");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(AddressOfUse_present, true,
				"From the Customer Portal user not able to click on Address of Use from account menu in the header");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Address of Use - CCP",
				"User not able to land to the Account Settings page after clicking on Account settings link from account menu in the header");

		Address ad = new Address(driver);

		boolean RequestAddressBtn_present = false;
		boolean AddressField_present = false;
		boolean City_present = false;
		boolean State_present = false;
		boolean ZipCode_present = false;
		boolean Phone_present = false;
		boolean Sbmt_present = false;
		boolean ValidationMsg_present = false;

		try {
			ad.getRequestAddressBtn().click();
			RequestAddressBtn_present = true;
			Thread.sleep(5000);
			Log.info("From the Address of Use page user is clicking on request address button");
			ad.getAddressField().sendKeys("756 Concho Ln");
			 AddressField_present = true;
			
			ad.getCity().sendKeys("Houston");
			
			 City_present = true;
			
			Select se = new Select(ad.getState());
			se.selectByVisibleText("TX");
			
			 State_present = true;
			
			ad.getZip_Code().sendKeys("77084");
			
			 ZipCode_present = true;
			
			ad.getPhone().sendKeys("7138370311");
			
			 Phone_present = true;
			
			ad.getSubmitBtn().click();
			Sbmt_present = true;
			Thread.sleep(2000);
			
			ad.getValidationMsg().isDisplayed();
			ValidationMsg_present = true;

		} catch (NoSuchElementException e) {

			Log.error("From the Customer Portal user not able to click on Address Of Use from account menu");
			Log.error(e.getMessage());
		}
		
		
		Assert.assertEquals(RequestAddressBtn_present, true,
				"Request Address Button is not appearing on Address of Use Page");
		
		Assert.assertEquals(AddressField_present, true,
				"When user is clicking on request address button then address text field is not appearing");
		
		Assert.assertEquals(City_present, true,
				"When user is clicking on request address button then city text field is not appearing");		
		Assert.assertEquals(State_present, true,
				"When user is clicking on request address button then city state dropdown is not appearing");
		
		Assert.assertEquals(ZipCode_present, true,
				"When user is clicking on request address button then zip code text field is not appearing");
		
		Assert.assertEquals(Phone_present, true,
				"When user is clicking on request address button then Phone Number text field is not appearing");
		
		Assert.assertEquals(Sbmt_present, true,
				"Submit button is not appearing on address of use page");
		
		Assert.assertEquals(ValidationMsg_present, true,
				"From the Customer Portal user not able to click on Address of Use from account menu in the header");
}

	@Test(priority = 12, dependsOnMethods = { "ValidateLogin" })

	public void ValidateCatalogRestrictions() throws InterruptedException, AWTException {

		Header hd = new Header(driver);

		boolean CRestrictions_present = false;
		Actions an = new Actions(driver);
		try {
			an.moveToElement(hd.getAccountMenu()).perform();
			hd.getCatalog_Restriction().click();
			CRestrictions_present = true;
			Log.info("From the Customer Portal user is clicking on Catalog Restrictions from account menu");

		} catch (NoSuchElementException e) {

			Log.error("From the Customer Portal user not able to click on Catalog Restrictions from account menu");
			Log.error(e.getMessage());
		}
		Assert.assertEquals(CRestrictions_present, true,
				"From the Customer Portal user not able to click on Catalog Restrictions from account menu in the header");
		Thread.sleep(10000);
		Assert.assertEquals(driver.getTitle(), "Catalog Restrictions - CCP",
				"User not able to land to the Catalog Restriction page after clicking on Catalog Restriction link from account menu in the header");

		Catalog cat = new Catalog(driver);

		boolean Restricted_present = false;
		boolean UnRestricted_present = false;
		boolean CheckBox_present = false;
		boolean RestrictBtn_present = false;
		boolean SuccessMsg_present = false;
		boolean ServiceSearch_present = false;
		boolean CheckBoxes_present = false;
		boolean RestrictedTab_present=false;
		boolean SelectAll_present=false;
		boolean UnRestrictBtn_present=false;
		boolean UnRestrictMsg_present=false;
		try {
			cat.getRestricted().isDisplayed();			
			Restricted_present = true;
			
			cat.getUnrestricted().click();
			UnRestricted_present = true;
			Thread.sleep(4000);
			cat.getCheckBox().click();
			CheckBox_present = true;
			Thread.sleep(2000);
			cat.getRestrict().click();
			
			RestrictBtn_present = true;
			Thread.sleep(4000);
			cat.getSucessMsg().isDisplayed();
			SuccessMsg_present = true;
			cat.getServiceSearch().sendKeys("corp");
			ServiceSearch_present = true;
			Thread.sleep(4000);
			cat.getCheckBox().isDisplayed();
			CheckBoxes_present = true;
			
			cat.getRestricted().click();
			Thread.sleep(4000);
			RestrictedTab_present=true;
			
			cat.getSelectAll().click();
			SelectAll_present=true;
			Thread.sleep(2000);
			
			cat.getUnRestrict().click();
			UnRestrictBtn_present=true;
			
			cat.getUnRestrictSuccessMsg().isDisplayed();
			UnRestrictMsg_present=true;
			
			
		} catch (NoSuchElementException e) {

			Log.error("On Catalog Restriction page all page elements are not appearing");
			Log.error(e.getMessage());
		}
		
		
		Assert.assertEquals(Restricted_present, true,
				"Restricted Tab is not appearing on Catalog Restriction Page");
		
		Assert.assertEquals(UnRestricted_present, true,
				"UnRestricted Tab is not appearing on Catalog Restriction Page");
		
		Assert.assertEquals(CheckBox_present, true,
				"checkboxes are not appearing with the services record");		
		Assert.assertEquals(RestrictBtn_present, true,
				"Restrict button is not appearing on the catalog restriction page");
		
		Assert.assertEquals(SuccessMsg_present, true,
				"Success Message is not appearing when restricting the services ");
		
		Assert.assertEquals(ServiceSearch_present, true,
				"User not able to search the Services on catalog restriction Page");
		
		Assert.assertEquals(CheckBoxes_present, true,
				"Records are not getting search on restriction tab under catalog restriction");

		Assert.assertEquals(RestrictedTab_present, true,
				"User is not able to navigate to the restricted tab again on catalog restriction page");
	
		Assert.assertEquals(SelectAll_present, true,
				"User not able to click on SelectAll checkbox on the restricted section");
	
		Assert.assertEquals(UnRestrictBtn_present, true,
				"User not able to click Unrestricted button after clicking on Select All Button");
		Assert.assertEquals(UnRestrictMsg_present, true,
				"Success Message is not appearing when Unrestricting all the services from the restricted tab");
		}
	
	
	@Test(priority = 13, dependsOnMethods = { "ValidateLogin" })

	public void ValidateChangePassword() throws InterruptedException, AWTException {

		Header hd = new Header(driver);

		boolean ChangePassword_present = false;
		Actions an = new Actions(driver);
		//try {
			an.moveToElement(hd.getAccountMenu()).perform();
			Thread.sleep(1000);
			hd.getChangePassword().click();
			ChangePassword_present = true;
			Log.info("From the Customer Portal user is clicking on Change Passowrd Link from account menu");

		//} catch (NoSuchElementException e) {

			//Log.error("From the Customer Portal user not able to click on Change Passowrd Link from account menu");
			//Log.error(e.getMessage());
		//}
		Assert.assertEquals(ChangePassword_present, true,
				"From the Customer Portal user not able to click on change password from account menu in the header");
		Thread.sleep(10000);
		Assert.assertEquals(driver.getTitle(), "Change Password - CCP",
				"User not able to land to the Change Password page after clicking on Change Password link from account menu in the header");
		
		ChangePassword cp = new ChangePassword(driver);
		boolean CurrentPswd_present = false;
		boolean NewPswd_present = false;
		boolean CnfrmPswd_present = false;
		boolean SaveBtn_present = false;
		boolean SuccessMsgSmall_present = false;

		//try {
			cp.getCurrentPswd().sendKeys("Connection123");			
			CurrentPswd_present = true;
			
			cp.getNewPswd().sendKeys("abcd");
			NewPswd_present = true;
			
			cp.getCnfrm_pswd().sendKeys("abcd");
			CnfrmPswd_present =true;
			
			cp.getSaveBtn().click();
			SaveBtn_present = true;
			Thread.sleep(4000);
			cp.getSmallPswdMsg().isDisplayed();
			SuccessMsgSmall_present = true;
			
		//} catch (NoSuchElementException e) {

		//	Log.error("On Change Restriction page all page elements are not appearing");
			//Log.error(e.getMessage());
		//}
		
		
		Assert.assertEquals(CurrentPswd_present, true,
				"User not able to enter password in current password text field");
		
		Assert.assertEquals(NewPswd_present, true,
				"User not able to enter password in New password text field");
		
		Assert.assertEquals(CnfrmPswd_present, true,
				"User not able to enter password in change password text field");
		
		Assert.assertEquals(SaveBtn_present, true,
				"Save button is not appearing on Change Password Page");
		
		Assert.assertEquals(SuccessMsgSmall_present, true,
				"Password must have atleast 8 characters validation message is not appearing when user is clicking on save button after entering the 4 characters new password");
		
	
		//boolean CurrentPswd_present1 = false;
		//boolean NewPswd_present1 = false;
		//boolean CnfrmPswd_present1 = false;
		//boolean SaveBtn_present1 = false;
		//boolean SuccessMsgSmall_present1 = false;
	//	try {
			//cp.getCurrentPswd().sendKeys("Connection123");			
			//CurrentPswd_present1 = true;
			
			//cp.getNewPswd().sendKeys("Connection123");
			//NewPswd_present1 = true;
			
			//cp.getCnfrm_pswd().sendKeys("Connection123");
			//CnfrmPswd_present1 =true;
			
			//cp.getSaveBtn().click();
			//SaveBtn_present1 = true;
			//Thread.sleep(10000);
			//cp.getSamePswdMsg().isDisplayed();
			//SuccessMsgSmall_present1 = true;
			
			
		//Assert.assertEquals(CurrentPswd_present1, true,
				//"User not able to enter password in current password text field");
		
		//Assert.assertEquals(NewPswd_present1, true,
				//"User not able to enter password in New password text field");
		
		//Assert.assertEquals(CnfrmPswd_present1, true,
				//"User not able to enter password in change password text field");
		
		//Assert.assertEquals(SaveBtn_present1, true,
				//"Save button is not appearing on Change Password Page");
		
		//Assert.assertEquals(SuccessMsgSmall_present1, true,
				//"Old and New Password validation message is not appearing when user is clicking on save button after entering the same new password as the current one");
		
		Thread.sleep(5000);
		boolean CurrentPswd_present2 = false;
		boolean NewPswd_present2 = false;
		boolean CnfrmPswd_present2 = false;
		boolean SaveBtn_present2 = false;
		boolean SuccessMsgSmall_present2 = false;
		//try {
			cp.getCurrentPswd().sendKeys("aaa");			
			CurrentPswd_present2 = true;
			
			cp.getNewPswd().sendKeys("Connection1234");
			NewPswd_present2 = true;
			
			cp.getCnfrm_pswd().sendKeys("Connection1234");
			CnfrmPswd_present2 =true;
			
			cp.getSaveBtn().click();
			SaveBtn_present2 = true;
			Thread.sleep(4000);
			cp.getIncorrectCurrentPswdMsg().isDisplayed();
			SuccessMsgSmall_present2 = true;
	
		
		Assert.assertEquals(CurrentPswd_present2, true,
				"User not able to enter password in current password text field");
		
		Assert.assertEquals(NewPswd_present2, true,
				"User not able to enter password in New password text field");
		
		Assert.assertEquals(CnfrmPswd_present2, true,
				"User not able to enter password in change password text field");
		
		Assert.assertEquals(SaveBtn_present2, true,
				"Save button is not appearing on Change Password Page");
		
		Assert.assertEquals(SuccessMsgSmall_present2, true,
				"Current Password incorrect message is not appearing when user is clicking on save button after entering the wrong current password");
}
	
	@Test(priority = 14, dependsOnMethods = { "ValidateLogin" })

	public void ValidatePaymentMethod() throws InterruptedException, AWTException {
		Header hd = new Header(driver);
		boolean ChangePassword_present = false;
		Actions an = new Actions(driver);
		try {
			an.moveToElement(hd.getAccountMenu()).perform();
			Thread.sleep(1000);
			hd.getPayment_Plan().click();
			ChangePassword_present = true;
			Log.info("From the Customer Portal user is clicking on payment Method Link from account menu");

		} catch (NoSuchElementException e) {

			Log.error("From the Customer Portal user not able to click on payment Method Link from account menu");
		Log.error(e.getMessage());
		}
		Assert.assertEquals(ChangePassword_present, true,
				"From the Customer Portal user not able to click on payment Method link from account menu in the header");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Payment Method - CCP",
				"User not able to land to the Payment Method page after clicking on Payment Method link from account menu in the header");
}
	
	@Test(priority = 15, dependsOnMethods = { "ValidateLogin" })

	public void ValidateDiscover() throws InterruptedException, AWTException {
		HomePage hm = new HomePage(driver);
		boolean Discover_present = false;
		try {
			hm.getDiscover().click();
			Discover_present = true;
			Log.error("From the Customer Portal user is clicking on Discover link under MarkITPlace Section");
		} catch (NoSuchElementException e) {
			Log.error("From the Customer Portal user not able to click on payment Method Link from account menu");
		Log.error(e.getMessage());
		}
		Assert.assertEquals(Discover_present, true,"Discover link is not appearing under MarkITplace section");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Discover - CCP",
				"User not able to land to the Discover Page page after clicking on discover link from MarkITPlace Section");
		SoftAssert sf = new SoftAssert();
		
		String Heading_Text = null ;
	
		Discover ds = new Discover(driver);
		try {
			Heading_Text= ds.getHeading().getText();
			Discover_present = true;
			ds.getStep1Title().getText();
		
		ds.getStep2Title().getText();
		
		ds.getExpectedUserLink().sendKeys("2");
			
		} catch (NoSuchElementException e) {

			Log.error("From the Customer Portal user not able to click on payment Method Link from account menu");
		Log.error(e.getMessage());
		}
		//Thread.sleep(5000);
		sf.assertEquals(Heading_Text, "Discover",
				"Heading in the discover page is not appearing as expected");
				
		sf.assertAll();
}	
	
	@Test(priority = 16, dependsOnMethods = { "ValidateLogin" })

	public void ValidateApplicationsLink() throws InterruptedException, AWTException {
		HomePage hm = new HomePage(driver);
		boolean Application_present = false;
		try {
			hm.getApplication_Link().click();
			Application_present = true;
			Log.info("From the Customer Portal user is clicking on Applications link under MarkITPlace Section");
		} catch (NoSuchElementException e) {
			Log.error("From the Customer Portal user not able to click on Applications Link under MarkITPlace Section");
		Log.error(e.getMessage());
		}
		Assert.assertEquals(Application_present, true,"Applications link is not present under markitplace section");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Shop - CCP",
				"User not able to land to the Shop page after clicking on Applications link from MarkITPlace Section");
		Assert.assertEquals(hm.getService_type().getText(), "SaaS x","SaaS text is not appearing under service type category selection in Application page");	
}	
	
	@Test(priority = 17, dependsOnMethods = { "ValidateLogin" })

	public void ValidateInfrastructureLink() throws InterruptedException, AWTException {
		HomePage hm = new HomePage(driver);
		boolean Infrastructure_present = false;
		try {
			hm.getInfrastructure_Link().click();
			Infrastructure_present = true;
			Log.info("From the Customer Portal user is clicking on Infrastructure link under MarkITPlace Section");
		} catch (NoSuchElementException e) {
			Log.error("From the Customer Portal user not able to click on Infrastructure Link under MarkITPlace Section");
		Log.error(e.getMessage());
		}
		Assert.assertEquals(Infrastructure_present, true,"Infrastructure link is not present under Markitplace section");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Shop - CCP",
				"User not able to land to the Shop page after clicking on Infrastructure link from MarkITPlace Section");
		Assert.assertEquals(hm.getService_type().getText(), "IaaS x","Iaas text is not appearing under service type category selection in Infrastructure page");	
}	
	
	@Test(priority = 18, dependsOnMethods = { "ValidateLogin" })

	public void ValidatePlatformLink() throws InterruptedException, AWTException {
		HomePage hm = new HomePage(driver);
		boolean Platform_present = false;
		try {
			hm.getPlatform_Link().click();
			Platform_present = true;
			Log.info("From the Customer Portal user is clicking on Platform link under MarkITPlace Section");
		} catch (NoSuchElementException e) {
			Log.error("From the Customer Portal user not able to click on Platform Link under MarkITPlace Section");
		Log.error(e.getMessage());
		}
		Assert.assertEquals(Platform_present, true,"Platform link is not present under Markitplace section");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Shop - CCP",
				"User not able to land to the Shop page after clicking on Platform link from MarkITPlace Section");
		Assert.assertEquals(hm.getService_type().getText(), "PaaS x","Paas text is not appearing under service type category selection in Platform page");	
}	
	
	@Test(priority = 19, dependsOnMethods = { "ValidateLogin" })

	public void ValidateConsultingLink() throws InterruptedException, AWTException {
		HomePage hm = new HomePage(driver);
		boolean Consulting_present = false;
		try {
			hm.getConsulting().click();
			Consulting_present = true;
			Log.info("From the Customer Portal user is clicking on Consulting link under MarkITPlace Section");
		} catch (NoSuchElementException e) {
			Log.error("From the Customer Portal user not able to click on Consulting Link under MarkITPlace Section");
		Log.error(e.getMessage());
		}
		Assert.assertEquals(Consulting_present, true,"Consulting link is not present under Markitplace section");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Shop - CCP",
				"User not able to land to the Shop page after clicking on Consulting link from MarkITPlace Section");
		Assert.assertEquals(hm.getService_type().getText(), "Consulting x","Consulting text is not appearing under service type category selection in Consulting page");
}
	
	@Test(priority = 20, dependsOnMethods = { "ValidateLogin" })

	public void ValidateSearching() throws InterruptedException, AWTException {
		HomePage hm = new HomePage(driver);
		boolean Searching_present = false;
		int a = 0 ;
		try {
			hm.getMain_Search().sendKeys("Microsoft"+ Keys.ENTER);
			Searching_present = true;
			Log.info("From the Customer Portal user is searching the Microsoft service");
			Thread.sleep(5000);
			 a = hm.getProducts().size();
		} catch (NoSuchElementException e) {
			Log.error("From the Customer Portal user not able to search the Microsoft service");
		Log.error(e.getMessage());
		

	Assert.assertEquals(Searching_present, true,"User not able to reach Search Box and Search for the Microsoft Services");
	Assert.assertEquals(a, 59,"When User is searching the Microsoft service then the products are not appearing");
		
		}
	}
		
		@Test(priority = 21, dependsOnMethods = { "ValidateLogin" })

		public void ValidateLogOut() throws InterruptedException, AWTException {
			
			Header hd = new Header(driver);

			// Thread.sleep(10000);
			boolean Logout_present;
			Actions an = new Actions(driver);
			try {
				an.moveToElement(hd.getAccountMenu()).perform();
				hd.getLogout().click();
				// Thread.sleep(2000);
				Log.info("From the Customer Portal user is clicking on Logout from account menu");
				Logout_present = true;

			} catch (NoSuchElementException e) {
				Logout_present = false;
				Log.error("Account menu and Logout is not appearing in the header");
				Log.error(e.getMessage());
			}
			Assert.assertEquals(Logout_present, true,
					"Account menu and Logout link is not appearing in the header");

			Assert.assertEquals(driver.getTitle(), "CCP Login",
					"User not able to land on the login page after clicking on Logout link");
			}
		
		
		@Test(priority = 22, dependsOnMethods = { "ValidateLogin" })

		public void ValidateInvalidPassword() throws InterruptedException, AWTException {
			
			LoginPage lp = new LoginPage(driver);
			
			boolean Username_present = false;
			boolean password_present = false;
			boolean Login_present = false;
			
			try {
			lp.getusername().sendKeys("ccptestmain@arpatech.com");
			Username_present = true;
			lp.getpassword().sendKeys("Connection1234");
			password_present = true;
			lp.getloginbtn().click();
			Login_present = true;
			Thread.sleep(5000);
			
				Log.info("From the Customer Portal user Login page , User is entering the correct username but wrong password");
				

			} catch (NoSuchElementException e) {
				
				Log.error("Username,password or Login button is not present on the Login Page");
				Log.error(e.getMessage());
			}
			
			Assert.assertEquals(Username_present, true,"Username field is not appearing on the Login Page");
			Assert.assertEquals(password_present, true,"Password field is not appearing on the Login Page");
			Assert.assertEquals(Login_present, true,"Login button is not appearing on the Login Page");
			Assert.assertEquals(lp.getIncorrect_Credentials().getText(), "The user credentials are incorrect","The user credentials are incorrect message is not appearing when providing valid username and wrong password");

						}
		
		
		@Test(priority = 23, dependsOnMethods = { "ValidateLogin" },enabled=false)

		public void ValidateInvaliduser3Times() throws InterruptedException, AWTException {
			
			LoginPage lp = new LoginPage(driver);
			
			boolean Username_present = false;
			boolean password_present = false;
			boolean Login_present = false;
			
			try {
				for(int a = 0 ; a>=3 ;a++)
			{
			lp.getusername().clear();
			lp.getusername().sendKeys("ccptestmain@arpatech.com");
			Username_present = true;
			lp.getpassword().clear();
			lp.getpassword().sendKeys("Connection1234");
			password_present = true;
			lp.getloginbtn().click();
			Login_present = true;
			Thread.sleep(4000);
				}
			Thread.sleep(5000);
			
				Log.info("From the Customer Portal user Login page , User is entering the correct username but wrong password 3 times");
				

			} catch (NoSuchElementException e) {
				
				Log.error("Username,password or Login button is not present on the Login Page");
				Log.error(e.getMessage());
			}
			
			Assert.assertEquals(Username_present, true,"Username field is not appearing on the Login Page");
			Assert.assertEquals(password_present, true,"Password field is not appearing on the Login Page");
			Assert.assertEquals(Login_present, true,"Login button is not appearing on the Login Page");
			Assert.assertEquals(lp.getIncorrect_Credentials().getText(), "You are locked for 15 minutes because of multiple failed attempts, please contact us for assistance or try again after 15 minutes","USER LOCK MESSAGE IS NOT APPEARING WHEN ENTERING CREDENTIALS INVALID FOR 3 TIMES");
	}
		
		@Test(priority = 24, dependsOnMethods = { "ValidateLogin" },enabled=false)

		public void ValidateLockedUser() throws InterruptedException, AWTException {
			
			LoginPage lp = new LoginPage(driver);
			
			boolean Username_present = false;
			boolean password_present = false;
			boolean Login_present = false;
			
			try {
			lp.getusername().clear();
			lp.getusername().sendKeys("ccptestmain@arpatech.com");
			Username_present = true;
			lp.getusername().clear();
			lp.getpassword().sendKeys("Connection1234");
			password_present = true;
			lp.getloginbtn().click();
			Login_present = true;
			Thread.sleep(5000);
			
			lp.getusername().clear();
			lp.getusername().sendKeys("ccptestmain@arpatech.com");
			//Username_present = true;
			lp.getusername().clear();
			lp.getpassword().sendKeys("Connection1234");
			//password_present = true;
			lp.getloginbtn().click();
			//Login_present = true;
			Thread.sleep(5000);
			
			
			lp.getusername().clear();
			lp.getusername().sendKeys("ccptestmain@arpatech.com");
			//Username_present = true;
			lp.getusername().clear();
			lp.getpassword().sendKeys("Connection1234");
			//password_present = true;
			lp.getloginbtn().click();
			//Login_present = true;
			Thread.sleep(5000);
			
				Log.info("From the Customer Portal user Login page , User is entering the correct username but wrong password");
				

			} catch (NoSuchElementException e) {
				
				Log.error("Username,password or Login button is not present on the Login Page");
				Log.error(e.getMessage());
			}
			
			Assert.assertEquals(Username_present, true,"Username field is not appearing on the Login Page");
			Assert.assertEquals(password_present, true,"Password field is not appearing on the Login Page");
			Assert.assertEquals(Login_present, true,"Login button is not appearing on the Login Page");
			Assert.assertEquals(lp.getIncorrect_Credentials().getText(),"", "The Locked User message is not appearing while the Locked User is trying to Login to the application");

			}
		
		@Test(priority = 25, dependsOnMethods = { "ValidateLogin" })

		public void ValidateForgetPassword() throws InterruptedException, AWTException {
			
			LoginPage lp = new LoginPage(driver);
			
			boolean FPassword_present = false;
			boolean Email_present = false;
			boolean Sbmt_present = false;
		
			try {
			lp.getForget_Pswd().click();
			FPassword_present = true;
			Thread.sleep(10000);
			lp.getemailfield().sendKeys("qaisar.imtiaz@arpatech.com");
			Email_present = true;
			
			lp.getSbmt_Btn().click();
			Sbmt_present = true;
			Thread.sleep(8000);
			
			Log.info("From the Customer Portal forget password page , User is clicking on forget password link and sending the email for password reset");
				

			} catch (NoSuchElementException e) {
				
				Log.error("Forget password link not present on the login page");
				Log.error(e.getMessage());
			}
			
			Assert.assertEquals(FPassword_present, true,"Forget password link is not appearing on the Login Page");
			Assert.assertEquals(Email_present, true,"Username field is not appearing on the Forget password Page");
			Assert.assertEquals(Sbmt_present, true,"Submit button is not appearing on the forget password page");
			Assert.assertEquals(lp.getResetLink().getText(),"A password reset link has been emailed to your email account on file. please check your email","Password resent link alert message is not appearing on forget password page");

			}
		

}
