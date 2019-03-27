package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.TestBase;

public class ContactsPage extends TestBase {
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	
	@FindBy(xpath= "//form[@id='vContactsForm']/table/tbody/tr[6]/td[1]/input[@name='contact_id']")
	WebElement selectID;
	
	@FindBy(id="first_name")
	WebElement firstName;
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save'] ")
	WebElement saveBtn;
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	public void createNewContact(String title, String ftName,String ltName) {
		Select select=new Select(driver.findElement(By.name("title")));
	
		select.selectByVisibleText(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		saveBtn.click();
		
	}
	
}
