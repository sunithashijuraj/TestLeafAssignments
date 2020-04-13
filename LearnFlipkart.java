package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnFlipkart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		// Open chrome browser
		//chromedriver (is a class) > written by selenium team
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//get url
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		//Collect the elements to be performed
		WebElement element = driver.findElement(By.xpath("//span[Text()='Electronics']"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
		
	}

}
