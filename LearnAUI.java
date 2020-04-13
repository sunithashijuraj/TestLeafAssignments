package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnAUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		// Open chrome browser
		//chromedriver (is a class) > written by selenium team
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//get url
		driver.get("http://www.leafground.com/pages/drop.html");
		driver.manage().window().maximize();
		//Collect the elements to be performed
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDrop(draggable, droppable).perform();
		
		driver.navigate().back();
		
		driver.get("http://www.leafground.com/pages/selectable.html");
		WebElement item1 = driver.findElement(By.xpath("//ol[@id = 'selectable']/li[text()='Item 1']"));
		WebElement item3 = driver.findElement(By.xpath("//ol[@id = 'selectable']/li[text()='Item 3']"));
		WebElement item5 = driver.findElement(By.xpath("//ol[@id = 'selectable']/li[text()='Item 5']"));
		WebElement item7 = driver.findElement(By.xpath("//ol[@id = 'selectable']/li[text()='Item 7']"));
		
		/*
		 * builder.keyDown(Keys.CONTROL).click(item1).perform();
		 * builder.keyDown(Keys.CONTROL).click(item3).perform();
		 * builder.keyDown(Keys.CONTROL).click(item5).perform();
		 * builder.keyDown(Keys.CONTROL).click(item7).perform();
		 */
		builder.keyDown(Keys.CONTROL).click(item1).click(item3).click(item5).click(item7).perform();
		
		//do shift+select for your own
		
		driver.navigate().back();
		driver.get("http://www.leafground.com/pages/selectable.html");
		WebElement item_1 = driver.findElement(By.xpath("//ol[@id = 'selectable']/li[text()='Item 1']"));
		WebElement item4 = driver.findElement(By.xpath("//ol[@id = 'selectable']/li[text()='Item 4']"));
		
		builder.clickAndHold(item_1).release(item4).perform();
		
		
		
	}

}
