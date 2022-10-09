package fl.crm.utiliti;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import fl.crm.base.BaseClass;

public class UtilityClass extends BaseClass {
	
	/**
	* Wait for element present.
	*
	* @param driver the driver
	* @param webElement the web element
	* @param logger the logger
	* @return true, if successful
	* @throws TimeoutException the timeout exception
	*/
	//Method Overload, we are using fluent wait
	public static boolean waitForElementPresent(WebDriver driver, WebElement webElement) throws TimeoutException{
	
	System.out.println("fluent wait started!");
	//Thread.sleep(5000);
	Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	 //Wait for the condition with timeout 30 seconds
			  .withTimeout(Duration.ofSeconds(20))
		       // poll interval of 1 seconds.
		     .pollingEvery(Duration.ofSeconds(1))
	       //ignore the NoSuchElementException
	     .ignoring(NoSuchElementException.class);
	fluentWait.until(ExpectedConditions.visibilityOf(webElement));
	System.out.println("fluent wait End!");
	return true;
	}

	/**
	* Wait for element present.
	*
	* @param driver the driver
	* @param webElement the web element
	* @param logger the logger
	* @return true, if successful
	* @throws TimeoutException the timeout exception
	*/
	//Method Overload, we are using fluent wait -- For a List of Webelements
	public static boolean waitForElementsPresent(WebDriver driver, List<WebElement> webElement) throws TimeoutException{
	try {
	//Thread.sleep(5000);
	Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	 //Wait for the condition with timeout 30 seconds
	     .withTimeout(Duration.ofSeconds(60))
	       // poll interval of 1 seconds.
	     .pollingEvery(Duration.ofSeconds(1))
	       //ignore the NoSuchElementException
	     .ignoring(NoSuchElementException.class);
	fluentWait.until(ExpectedConditions.visibilityOfAllElements(webElement));
	return true;
	}catch (NullPointerException e) {
		System.out.println("null pointer");
	// TODO Auto-generated catch block
		e.printStackTrace();
	return false;
	}catch (TimeoutException e) {
		System.out.println("timeout");
	// TODO Auto-generated catch block
		e.printStackTrace();
	return false;
	}catch (Exception e) {
		System.out.println("exception");
	// TODO Auto-generated catch block
		e.printStackTrace();
	return false;
	}
	}

	public static void takeScreenshotAtEndOfTest() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		System.out.println("currentDir="+currentDir);
		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Wait for an element to disappear before performing any action
	 * @param driver
	 * @param webelement
	 * @return
	 */
	public static boolean waitForElementToDisappear(WebDriver driver, WebElement element){
	System.out.println("waitingForElementToDisappear :(");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	 //Wait for the condition with timeout 30 seconds
	     .withTimeout(Duration.ofSeconds(120))  
	       // poll interval of 1 seconds.
	     .pollingEvery(Duration.ofSeconds(2))
	       //ignore the NoSuchElementException
	     .ignoring(NoSuchElementException.class);
		System.out.println("Element-Disappeared :)");
	return fluentWait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public static void verifyElementPresentAndWaitForDisappear(WebDriver driver, WebElement element){
		if(element.isDisplayed()){
			waitForElementToDisappear(driver,element);
		}
	}

	public static Object[][] readExcel(String filePath){
		//String TESTDATA_SHEET_PATH = "C:\\Users\\Abhineet Mishra\\Desktop\\create_user_testdata.xlsx";
		
		 XSSFWorkbook workbook = null;
		 XSSFSheet sheet;
		 DataFormatter formatter = new DataFormatter();
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(filePath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				workbook = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //get my workbook 
			 sheet=workbook.getSheet("users");// get my sheet from workbook
			       XSSFRow Row = sheet.getRow(0);   //get my Row which start from 0   
			   
			    	int RowNum = sheet.getPhysicalNumberOfRows();// count my number of Rows
			    	System.out.println("RowNum="+RowNum);
			    	int ColNum= Row.getLastCellNum(); // get last ColNum 
			    	System.out.println("ColNum="+ColNum);
			    	
			    	Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
			    	
			     for(int i=0; i<RowNum-1; i++) //Loop work for Rows
			     {  
			     XSSFRow row= sheet.getRow(i+1);
			     
			     for (int j=0; j<ColNum; j++) //Loop work for colNum
			     {
			     if(row==null)
			     Data[i][j]= "";
			     else 
			     {
			     XSSFCell cell= row.getCell(j);
			     if(cell==null)
			     Data[i][j]= ""; //if it get Null value it pass no data 
			     else
			     {
			     String value=formatter.formatCellValue(cell);
			     System.out.print(value+" ");
			     Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
			     }
			     }
			     }
			     System.out.println();
			     }
				return Data;
			 
			    	
	}

		


}
