package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class classAssignment1{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		// Open chrome browser
		//chromedriver (is a class) > written by selenium team
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().back();
		driver.get("http://www.leafground.com/pages/selectable.html");
		WebElement item7 = driver.findElement(By.xpath("//ol[@id = 'selectable']/li[text()='Item 7']"));
		WebElement item4 = driver.findElement(By.xpath("//ol[@id = 'selectable']/li[text()='Item 4']"));
		
		Actions builder = new Actions(driver);
		builder.clickAndHold(item7).release(item4).perform();
	}

}
