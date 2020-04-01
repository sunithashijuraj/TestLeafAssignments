package week1.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		// Open chrome browser
		//chromedriver (is a class) > written by selenium team
		
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/main");
    WebElement userName = driver.findElementById("username");
    userName.sendKeys("DemoSalesManager");
    
    WebElement pwdValue = driver.findElementById("password");
    pwdValue.sendKeys("crmsfa");
    
    WebElement loginButton = driver.findElementByClassName("decorativeSubmit");
    loginButton.click();
    WebElement crmLink = driver.findElementByLinkText("CRM/SFA");
    crmLink.click();
    Thread.sleep(4000);
	driver.close();
	
	
	}

}
