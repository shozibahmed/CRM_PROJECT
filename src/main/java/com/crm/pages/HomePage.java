package com.crm.pages;

import java.awt.Desktop.Action;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: yusuf ahmed')]")
	WebElement userNameLabel;
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactsLink;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLInk;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	
	public ContactsPage clickOnContactsLink() {
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", contactsLink);
		
		
		//contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLInk() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
	tasksLInk.click();
	return new TasksPage();
	}
	public void clickOnNewContactLink() {
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
	}
	
}
