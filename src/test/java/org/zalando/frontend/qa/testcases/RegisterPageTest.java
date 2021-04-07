package org.zalando.frontend.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.zalando.frontend.qa.base.Base;
import org.zalando.frontend.qa.pages.HomePage;
import org.zalando.frontend.qa.pages.RegisterPage;
import org.zalando.frontend.qa.util.ExcelUtil;

public class RegisterPageTest extends Base {

	HomePage homePage;
	RegisterPage registerPage;
	ExcelUtil excelUtil;
	
	String termsURL = "https://en.zalando.de/zalando-terms/";
	String privacyPolicyURL = "https://en.zalando.de/zalando-privacy-policy/";
	
	@BeforeMethod
	public void initialization() {
		browserInitialization();
		homePage = new HomePage();
		registerPage = homePage.register();
	}
	
	@Test(priority = 1)
	public void userRegisterLabelTest() {
		assertTrue(registerPage.userRegisterLabel());
	}
	
	@Test(priority = 2)
	public void termsAndConditionsTest() {
		assertEquals(termsURL, registerPage.termsAndConditions());
	}
	
	@Test(priority = 3)
	public void privacyPolicyTest() {
		assertEquals(privacyPolicyURL, registerPage.privacyPolicy());
	}
	
	@Test(priority = 4)
	public void validUserRegisterationTest() {
		
		registerPage.validUserRegistration("testingOne", "testingTwo", "testing12@gmail.com", "qweasdzxc", "Men’s fashion");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
