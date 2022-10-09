package fl.crm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fl.crm.base.BaseClass;
import fl.crm.pages.ContactsPage;
import fl.crm.pages.HomePage;
import fl.crm.pages.LoginPage;
import fl.crm.utiliti.UtilityClass;

public class ContactsTest extends BaseClass {
	
	LoginPage loginPage;
	ContactsPage contactPage;
	HomePage homePage;
	
	
	@BeforeClass
	public void setup() throws IOException, InterruptedException{
		launchBrowser();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = new ContactsPage();
		homePage = new HomePage();
		
	}
	
	@DataProvider(name="createuser")
	public Object[][] getUserDetails(){
		Object[][] userDetails = UtilityClass.readExcel(currentDir+"\\src\\main\\resources\\create_user_testdata.xlsx");
		return userDetails;
	}
	
	
	@Test(dataProvider="createuser")
	public void createANewContactAndValidateItIsCreated(String firstName, String lastName, String emailAddress) throws InterruptedException{
		UtilityClass.waitForElementToDisappear(driver, contactPage.loadingIcon);
		contactPage.getContactLink().click();
		contactPage.getCreateButton().click();
		contactPage.getFirstName().sendKeys(firstName);
		contactPage.getLastName().sendKeys(lastName);
		contactPage.getEmail().sendKeys(emailAddress);
		contactPage.getSave().click();
		Thread.sleep(5000);
		String name = contactPage.getCreatedContactFirstLastName().getText().trim();
		Assert.assertEquals(name, firstName+" "+lastName);
	}

}
