package week1.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafTapsAssignment {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		// Open chrome browser
		//chromedriver (is a class) > written by selenium team
		
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/main");
    WebElement userName = driver.findElementById("username");
    userName.sendKeys("DemoSalesManager");
    
    WebElement pwdValue = driver.findElementById("password");
    pwdValue.sendKeys("crmsfa");
    
    pwdValue.clear();
    
    //LinkText
    
    
    //WebElement pwdValue = driver.findElementById("password").sendKeys("crmsfa");
    
    //WebElement pwdValue1 = driver.findElementByName("PASSWORD");
    //pwdValue1.sendKeys("crmsfa");
    
    WebElement loginButton = driver.findElementByClassName("decorativeSubmit");
    loginButton.click();
    
	//driver.navigate().back();
	String title = driver.getTitle();
	System.out.println(title);
	
	driver.navigate().refresh();
	
	//both are same
	driver.get("google.co.in");
	driver.navigate().to("google.co.in");
	driver.close();
	
	
	}

}
