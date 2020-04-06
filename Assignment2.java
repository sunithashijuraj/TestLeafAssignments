package week1.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) {
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
	    String text = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).getText();
	    System.out.println(text);
	    driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();
	    driver.findElement(By.linkText("Delete")).click();
	    driver.findElement(By.linkText("Find Leads")).click();
	    driver.findElement(By.name("id")).sendKeys(text);
	    driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	    
	    String text2 = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
	    if (text2.contains("No records to display")) {
	    	System.out.println("Deletion of Lead is successfull");
	    } else {
	    	System.out.println("Deletion is not successfull");
	    }

	}

}
