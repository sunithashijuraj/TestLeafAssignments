package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class classAssignment2{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
				System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
				// Open chrome browser
				//chromedriver (is a class) > written by selenium team
				
				ChromeDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//get url
				driver.get("https://www.flipkart.com/");
				driver.manage().window().maximize();
				driver.findElement(By.xpath("//button[text()='✕']")).click();
				WebElement element = driver.findElement(By.xpath("//span[text()='TVs & Appliances']"));
				
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@title='BPL'][1]")).click();
				String text = driver.findElement(By.xpath("//div[@class='col col-7-12'][1]/div")).getText();
				System.out.println(text);
	}

}
