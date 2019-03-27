package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	//Page Factory
		@FindBy(name="email")
		WebElement email;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
		WebElement loginBtn;
		
		
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//doing Actions
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		
		
		public HomePage login(String un, String pwd) { 
			email.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			
			    	
			return new HomePage();
		}


}
