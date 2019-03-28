package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	String sheetName="contacts";
	public ContactsPageTest(){
		super();
	}

	
	@BeforeMethod
	public void setUp(){
		initialization();
	
		loginPage = new LoginPage();//so that i can acess loginpage method
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		contactsPage= homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contact label is missing on page");
	}
	
	//getting data and storing in data two dimension array
	@DataProvider
	public Object[][] getExcelTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	
	
	@Test(priority=2, dataProvider="getExcelTestData")
	public void validateCreateNewContact(String firstName,String lastName,String company) throws InterruptedException {
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("madhu", "n", "innova-path");
		contactsPage.createNewContact(firstName, lastName, company);
		
	}
	
@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
}
