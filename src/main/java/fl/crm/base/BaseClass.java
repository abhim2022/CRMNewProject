package fl.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
 
	public static WebDriver driver;
	public static Properties prop;
	public static String currentDir;
	
	public void launchBrowser() throws IOException{
		currentDir = System.getProperty("user.dir");
		System.out.println("currentDir="+currentDir);
		loadPropertyFile();
		if(prop.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", currentDir+"\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}
		else if(prop.getProperty("browser").equals("microsoft_edge")){
			// code to launch microsoft edge browser
		}
		else if(prop.getProperty("browser").equals("firefox")){
			// code to launch firefox browser
		}
		else if(prop.getProperty("browser").equals("IE")){
			// code to launch IE browser
		}
	
	}
	
	public static void loadPropertyFile() throws IOException{
		String filePath = currentDir+"\\src\\main\\java\\fl\\crm\\envdetails\\env.properties";
		FileInputStream fis = new FileInputStream(filePath);
		prop = new Properties();
		prop.load(fis);
		}
	
	
}
