package week1.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JacksonInject.Value;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		
		//Set system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		//Initialize chrome driver class
		ChromeDriver driver = new ChromeDriver();
		//Add implicit wait
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		//Open LeafTaps page
		driver.get("http://leaftaps.com/opentaps/control/main");
		//Enter Username
		WebElement userName = driver.findElementById("username");
	    userName.sendKeys("DemoSalesManager");
	    //Enter Password
	    WebElement pwdValue = driver.findElementById("password");
	    pwdValue.sendKeys("crmsfa");
	    //Click Submit
	    WebElement loginButton = driver.findElementByClassName("decorativeSubmit");
	    loginButton.click();
	    //Click CRM/SFA Link
	    WebElement crmLink = driver.findElementByLinkText("CRM/SFA");
	    crmLink.click();
	    //Click Leads Tab
	    driver.findElement(By.linkText("Leads")).click();
	    
	    //Click Find Leads
	    driver.findElement(By.linkText("Find Leads")).click();
	    //Click the first Result
	    driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
	    //Get the page title
	    System.out.println("The Page title is" +driver.getTitle());
	    //Click on Edit 
	    driver.findElement(By.linkText("Edit")).click();
	    //Declare a string variable to update the company name
	    String text = new String();
	    text = "NTestLeaf";
	    driver.findElement(By.id("updateLeadForm_companyName")).clear();
	    driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(text);
	    driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
	    //Verify and compare the updated string value in company name
	    String text1 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
	    System.out.println(text1);
	    if (text1.contains(text)) {
	    	System.out.println("The company name is updated successfully");
	    }else {
	    	System.out.println("The company name is not not updated successfully");
	    }
	    driver.close();
	    }
	    

	}


