package org.zalando.frontend.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.zalando.frontend.qa.base.Base;

public class HomePage extends Base{
	
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	
	//Page Factory - Web Elements
	@FindBy (xpath = "//*[@type='email']")
	private WebElement email;
	
	@FindBy (xpath = "//div[@class='_0xLoFW _7ckuOK _78xIQ-']/div/div/label/span")
	private List<WebElement> category;
	
	@FindBy (xpath = "//span[contains(text(),'Sign me up')]")
	private WebElement signMeUpButton;
	
	@FindBy (xpath = "//div[@class='_6XSjfv JUrPjL']/span")
	private WebElement signedUpUser;
	
	@FindBy (xpath = "//span[contains(text(),'Register now')]")
	private WebElement registerButton;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean addNewsLetter(String emailString, String categeoryString) {
		
		jsExecutor.executeScript("window.scrollBy(0,800)");
		
		email.sendKeys(emailString);
		for (WebElement webElement : category) {
			if(webElement.getText().equals(categeoryString)) {
				webElement.click();
			}
		}
		signMeUpButton.click();

		if(!signedUpUser.isDisplayed()) {
			return false;
		}
		
		return true;
		
		
	}
	
	public RegisterPage register() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[@title='Login']"))).build().perform();

		registerButton.click();
		
		return new RegisterPage();
	}
	
	
	

}
