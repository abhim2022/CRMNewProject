package fl.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fl.crm.base.BaseClass;
import fl.crm.utiliti.UtilityClass;

public class ContactsPage extends BaseClass {
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactLink;

	
	@FindBy(xpath="//a[contains(@href,'/contacts/new')]/button")
	WebElement createButton;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement email;
	
	@FindBy(xpath="//i[@class='save icon']/..")
	WebElement save;
	
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[1]")
	WebElement createdContactFirstLastName;
	
	@FindBy(xpath="//*[@id='ui']/div/div[2]/img")
	public WebElement loadingIcon;
	
	
	
	
	
	public WebElement getCreatedContactFirstLastName() {
		UtilityClass.waitForElementPresent(driver, createdContactFirstLastName);
		return createdContactFirstLastName;
	}





	public WebElement getCreateButton() {
		UtilityClass.waitForElementPresent(driver, createButton);
		return createButton;
	}





	public WebElement getFirstName() {
		UtilityClass.waitForElementPresent(driver, firstName);
		return firstName;
	}





	public WebElement getLastName() {
		UtilityClass.waitForElementPresent(driver, lastName);
		return lastName;
	}





	public WebElement getEmail() {
		UtilityClass.waitForElementPresent(driver, email);
		return email;
	}





	public WebElement getSave() {
		UtilityClass.waitForElementPresent(driver, save);
		return save;
	}





	public WebElement getContactLink(){
		UtilityClass.waitForElementPresent(driver, contactLink);
		return contactLink;
	}
	
	

}
