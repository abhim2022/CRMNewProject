package fl.crm.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fl.crm.base.BaseClass;
import fl.crm.pages.LoginPage;
import fl.crm.utiliti.UtilityClass;

public class LoginTest extends BaseClass {

	LoginPage loginPage;

	@BeforeClass
	public void setup() throws IOException {
		launchBrowser();
		loadPropertyFile();
		loginPage = new LoginPage();
	}

	@Test
	public void verifyTitle() {
			String title = driver.getTitle();
			Assert.assertEquals(title, "Cogmento CRM");
		
	}

	@Test
	public void login() throws InterruptedException {
		
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(loginPage.getDisplayUsername().isDisplayed());
	}

}
