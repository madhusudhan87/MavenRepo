package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/a[3]/span")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")
	WebElement newContactLink;
	
	
	
	
	//Initializing the Page Objects:
			public HomePage(){
				PageFactory.initElements(driver, this);
			}
			
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
public ContactsPage clickOnContactsLink()
{
	contactsLink.click();
	return new ContactsPage();
}
public void clickOnNewContactLink() {
	Actions action=new Actions(driver);
	action.moveToElement(contactsLink).build().perform();//WHEN EVER WE USE ACTION CLASS WE NEED TO USE BUILD AND PERFORM CLASSES.
newContactLink.click();
}


}



