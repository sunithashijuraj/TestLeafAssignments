package week2.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropdown{

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://www.leafground.com/pages/Link.html");
  
	//1. Find the dropdown element
	WebElement dropdown = driver.findElement(By.id("dropdown1"));
	
	//2. convert the webElemt
	Select dd = new Select(dropdown);
	//3. interact with Dropdown using method
	
	dd.selectByVisibleText("UFT/QTP");
	dd.selectByValue("2");
	dd.selectByIndex(3);
		/*
		 * visibletext (black color inside the tag option) value (attribute of the
		 * option tag) index (number starting from 0 -> count of option tags inside the
		 * select)
		 */
	//I want to pick the last drop down item
	//How to find how many options are available
	List<WebElement> options = dd.getOptions();
	//Find the count of the list items
	int count = options.size();
	
	//pick the last one
	
	dd.selectByIndex(count-1);
   
	}

}
