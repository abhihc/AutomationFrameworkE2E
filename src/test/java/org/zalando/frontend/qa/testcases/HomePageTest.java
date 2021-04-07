package org.zalando.frontend.qa.testcases;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.zalando.frontend.qa.base.Base;
import org.zalando.frontend.qa.pages.HomePage;
import org.zalando.frontend.qa.util.ExcelUtil;

public class HomePageTest extends Base
{
	
	HomePage homePage;
	ExcelUtil excelUtil;
	
	String sheetName = "newsletter";

	@BeforeMethod
	public void initialization() {
		browserInitialization();
		homePage = new HomePage();
		excelUtil = new ExcelUtil();
	}
	
	@Test(priority = 1)
	public void urlTest() {
		assertEquals(properties.getProperty("url"), driver.getCurrentUrl());
	}
	
	@DataProvider
	public Object newsLetterData() {
		Object[][] data = ExcelUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority = 2,dataProvider = "newsLetterData")
	public void addNewsLetterTest(String email, String category) {
		
		assertEquals(true, homePage.addNewsLetter(email,category),"news letter sing up failed");		
		
	}
	
	@Test(priority = 3)
	public void registerTest() {
		homePage.register();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
