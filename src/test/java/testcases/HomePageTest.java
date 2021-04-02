package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import resources.Base;

public class HomePageTest extends Base
{
	public WebDriver driver;
	
	@BeforeTest
	public void browserIntialize() throws IOException {
		driver = initalizeDriver();
		driver.get(properties.getProperty("url"));
	}
    
	@Test
	public void urlTest() {
		Assert.assertEquals(properties.getProperty("url"), driver.getCurrentUrl());
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}
