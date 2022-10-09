package fl.crm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fl.crm.base.BaseClass;
import fl.crm.pages.HomePage;
import fl.crm.pages.LoginPage;

public class HomeTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeClass
	public void setup() throws IOException, InterruptedException{
		launchBrowser();
		loginPage = new LoginPage();
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		System.out.println(prop.getProperty("url"));
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		homePage = new HomePage();
	}
	
	
	
	@Test
	public void verifyHomePageTitle(){
		String title = driver.getTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		}
	
	@Test
	public void validateHomeMenuLinkIsDisplayed(){
		Assert.assertTrue(homePage.homeMenuLink.isDisplayed());
	}
	@Test
	public void validateCalanderMenuLinkIsDisplayed(){
		Assert.assertTrue(homePage.calendarMenuLink.isDisplayed());
	}
	@Test
	public void validateCompaniesMenuLinkIsDisplayed(){
		Assert.assertTrue(homePage.companiesMenuLink.isDisplayed());
	}
	@Test
	public void validateContactsMenuLinkIsDisplayed(){
		Assert.assertTrue(homePage.contactsMenuLink.isDisplayed());
	}
	@Test
	public void validateDealsMenuLinkIsDisplayed(){
		Assert.assertTrue(homePage.dealsMenuLink.isDisplayed());
	}

}
