package fl.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fl.crm.base.BaseClass;
import fl.crm.utiliti.UtilityClass;

public class LoginPage extends BaseClass {
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="email")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement pwd;
	
	@FindBy(xpath="//div[contains(@class,'submit button')]")
	public WebElement loginButton;
	
	@FindBy(xpath="//span[contains(text(),'Abhineet Mishra')]")
	public WebElement displayUsername;
	
	@FindBy(xpath="//*[@id='ui']/div/div[2]/img")
	public WebElement loadingIcon;
	
	public WebElement getUsername() throws InterruptedException {
	
		Thread.sleep(3000);
		UtilityClass.waitForElementPresent(driver, username);
		return username;
	}
	public WebElement getPassword() {
		try{
		UtilityClass.waitForElementPresent(driver, pwd);
		
	} catch (Exception e) {
		UtilityClass.takeScreenshotAtEndOfTest();
		e.printStackTrace();
	}
	return pwd;
	}
	public WebElement getLoginButton() {
		try{
		UtilityClass.waitForElementPresent(driver, loginButton);
		} catch (Exception e) {
			UtilityClass.takeScreenshotAtEndOfTest();
			e.printStackTrace();
		}
		return loginButton;
	}
	public WebElement getDisplayUsername() {
		try{
		UtilityClass.waitForElementPresent(driver, displayUsername);
	} catch (Exception e) {
		UtilityClass.takeScreenshotAtEndOfTest();
		e.printStackTrace();
	}
		return displayUsername;
	}
	
	
	
	
	
	public void login(String un,String pswd) throws InterruptedException{
		//driver.navigate().refresh();
		UtilityClass.waitForElementToDisappear(driver, loadingIcon);
		getUsername().sendKeys(un);
		getPassword().sendKeys(pswd);
		getLoginButton().click();
		UtilityClass.waitForElementToDisappear(driver, loadingIcon);
	}

}
