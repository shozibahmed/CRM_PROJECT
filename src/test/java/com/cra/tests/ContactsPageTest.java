package com.cra.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName="contacts";
		
	public ContactsPageTest() {
		super();
	}
		@BeforeMethod
		public void setUp() {
			intialization();
			testUtil=new TestUtil();
			contactsPage=new ContactsPage();
			loginPage = new LoginPage();
			homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
			testUtil.switchToFrame();
			contactsPage=homePage.clickOnContactsLink();
		}
	@Test()
	public void verifyContactsPageLabel()
	{
		
		
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the page");
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
	return data;
	}
	
	
	
	@Test(priority=4, dataProvider="getCRMTestData" )
	public void validateCreateNewContact(String title, String firstName, String lastName) {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title, firstName, lastName);
		
		//contactsPage.createNewContact("Mr.", "Adam", "Smith");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
