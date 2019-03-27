package com.cra.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage = new LoginPage();
		homePage=new HomePage();
		}
	@Test(priority=1)
	public void loginPageTitle() {
		String title= loginPage.validateLoginPageTitle();
	Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag= loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
