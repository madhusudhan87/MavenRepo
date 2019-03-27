package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/div/input")
	WebElement firstName;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[1]/div/div/input")
WebElement secondName;
	

	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[2]/div[2]/div/div/input")
WebElement company;
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
	WebElement saveBtn;
	
	
	
	
	//Initializing the PageFactory Objects:
			public ContactsPage(){
				PageFactory.initElements(driver, this);
			}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void createNewContact(String ftName,String ltName,String companyName) throws InterruptedException  {
		
		
		
		
		firstName.sendKeys(ftName);
		secondName.sendKeys(ltName);
		company.sendKeys(companyName);
		
		saveBtn.click();
		Thread.sleep(2000);
	}
	
	
	
}
