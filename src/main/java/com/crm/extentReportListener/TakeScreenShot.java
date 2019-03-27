package com.crm.extentReportListener;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TakeScreenShot {
	
	WebDriver browser = new FirefoxDriver();

	EventFiringWebDriver eventDriver = new EventFiringWebDriver(browser).register(new AbstractWebDriverEventListener() 
	{

	  @Override
	  public void onException(Throwable throwable, WebDriver browser) {

	    // Take the screenshot using the Webdriver.
	    File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    // Now you can copy the screenshot somewhere on your system.
	    FileUtils.copyFile(screen, new File("c:\\Selenium Testing Questions\\screen.png"));
	  
	

	try {

	  eventDriver.findElement(By.id("test"));
	  fail("Caught the Expected exception.");
	  // Intentionally causing the exception for demo.

	} catch (NoSuchElementException e) {

	  // Triggering point for the <onException> event.
	}
	
	
	  }
	
	

}
