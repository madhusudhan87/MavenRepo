package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	
	//before each test case launch browser n login and after each test case close the browser
	
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();//so that i can acess loginpage method
		contactsPage=new ContactsPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	
	}
	
	//test cases for homepage
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();//calling verifyHomepagettile() method from HomePage class to get gettitle value
	Assert.assertEquals(homePageTitle, "CRM","HOME TITLE NOT MATCHED");//message will be displayed in report if title does not match or testcase is failed
	
	
	}
	
	@Test(priority=2)
	public void verifyContactsLinkTest() {
contactsPage=homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
