package fl.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fl.crm.base.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="*//span[contains(text(),'Home')]")
	public WebElement homeMenuLink;
	
	@FindBy(xpath="*//span[contains(text(),'Calendar')]")
	public WebElement calendarMenuLink;
	
	@FindBy(xpath="*//span[contains(text(),'Contacts')]")
	public WebElement contactsMenuLink;
	
	@FindBy(xpath="*//span[contains(text(),'Companies')]")
	public WebElement companiesMenuLink;
	
	@FindBy(xpath="*//span[contains(text(),'Deals')]")
	public WebElement dealsMenuLink;
	

}
