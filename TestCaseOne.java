package week1.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCaseOne {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/account/login");
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com", Keys.TAB);
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		driver.findElement(By.id("buttonLogin")).click();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//button[text()[normalize-space()='Vendors']]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();
		driver.findElement(By.linkText("Search for Vendor")).click();
		driver.findElement(By.id("vendorName")).sendKeys("Blue Lagoon");
		driver.findElement(By.id("buttonSearch")).click();
		WebElement ele1 = driver.findElement(By.xpath("//td[text()='France']"));
		String text = ele1.getText();
		System.out.println("The Country Name is " + text);
		driver.findElement(By.linkText("Log Out")).click();
		driver.close();
		
		

	}

}
