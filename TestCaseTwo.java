package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseTwo {

	public static void main(String[] args) throws InterruptedException {
		
		//Setting system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		//Launching the red bus application
		driver.get("https://www.redbus.in/");
		//input the source as Chennai
		driver.findElement(By.id("src")).sendKeys("Chennai");
		Thread.sleep(500);
		driver.findElement(By.id("src")).sendKeys(Keys.TAB);
		//Input the destination as Bangalore
		driver.findElement(By.id("dest")).sendKeys("Bangalore");
        driver.findElement(By.id("onward_cal")).click();	
		//click on the date field
		driver.findElement(By.xpath("(//td[text()='30'])[2]")).click();
		//click on the search button
		driver.findElement(By.id("search_btn")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[@class='cbox-label'])[4]")).click();
		driver.findElement(By.xpath("//label[@title='SLEEPER']")).click();
		
		driver.findElement(By.xpath("(//div[contains(@class,'w-15 fl')]//a)[2]")).click();
		

	}

}
