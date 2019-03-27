package com.crm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase{
	//page Factory-Object repository
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	//@FindBy(xpath="//input[@class=\"btn btn-small\"]")
	WebElement loginBtn;
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
}
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
//		Actions actions = new Actions(driver);
//		actions.moveToElement(loginBtn).click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", loginBtn);
		
		
		//loginBtn.click();
		return new HomePage();
			}
	}
