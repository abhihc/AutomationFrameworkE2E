package org.zalando.frontend.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.zalando.frontend.qa.base.Base;

public class RegisterPage extends Base{
	
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	//Page Factory
	
	@FindBy (xpath = "//*[contains(text(),'I’m new here')]")
	private WebElement registerLabel;
	
	@FindBy (xpath = "//a[contains(text(),'Terms and Conditions')]")
	private WebElement termsURL;
	
	@FindBy (xpath = "//a[contains(text(),'Privacy Policy')]")
	private WebElement privacyPolicyURL;
	
	@FindBy (name = "register.firstname")
	private WebElement firstName;
	
	@FindBy (name = "register.lastname")
	private WebElement lastName;
	
	@FindBy (name = "register.email")
	private WebElement email;
	
	@FindBy (name = "register.password")
	private WebElement password;
	
	@FindBy (xpath = "//*[@role='group']/div/div/div/label/span")
	private List<WebElement> category;
	
	@FindBy (xpath  = "//span[contains(text(),'Yes, I wish')]")
	private WebElement promotionsCheckbox;
	
	@FindBy (xpath = "//span[contains(text(),'Yes, I agree')]")
	private WebElement policyCheckbox;
	
	@FindBy (xpath = "//*[@data-testid='register_button']")
	private WebElement registerButton;
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean userRegisterLabel() {
		return registerLabel.isDisplayed();
	}
	
	
	public String termsAndConditions() {
		termsURL.click();
		
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		
		return driver.getCurrentUrl();
	}
	
	public String privacyPolicy() {
		privacyPolicyURL.click();
		
		for(String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		
		return driver.getCurrentUrl();
		
	}
	
	public void validUserRegistration(String fName,String lName,String emailID, String pwd,String cat) {
		
		
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(emailID);
		password.sendKeys(pwd);
		
		jsExecutor.executeScript("window.scrollBy(0,8000)");

		
		for (WebElement webElement : category) {
			System.out.println(webElement.getText());
			if(webElement.getText().equals(cat)) {
				webElement.click();
			}
		}
		
		promotionsCheckbox.click();
		policyCheckbox.click();
		
		registerButton.click();
		
	}
	
	

}
