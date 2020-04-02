package week1.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookAssignment {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		// Open chrome browser
		//chromedriver (is a class) > written by selenium team
		
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	Thread.sleep(2000);
    WebElement userName = driver.findElementById("email");
    userName.sendKeys("shruthi.suchi@gmail.com");
    
    WebElement pwdValue = driver.findElementById("pass");
    pwdValue.sendKeys("Lifegone@123");
    
    
    WebElement loginButton = driver.findElementByXPath("//form[@id='login_form']//table/tbody[1]/tr[2]/td[3]/label[1]/input[1]");
    loginButton.click();
    Thread.sleep(2000);
    
    driver.findElementById("userNavigationLabel").click();
    
	driver.close();
	
	}

}
