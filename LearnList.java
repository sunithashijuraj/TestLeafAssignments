package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnList {
	
	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//get Url
		driver.get("https://erail.in/trains-between-stations/mgr-chennai-ctr-MAS/ksr-bengaluru-SBC");
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		
		List<WebElement> trainElements = driver.findElements(By.xpath(" //div[@id='divTrainsList']//td[@class=''][2] "));
		ArrayList<String> arrayList = new ArrayList<String>();
		for (WebElement train : trainElements) {
		arrayList.add(train.getText());
		}
		int size = arrayList.size();
		
		System.out.println("The number of trains available is: "+size);
		
		Collections.sort(arrayList);
		
		for (int i = 0; i < size; i++) {
			
			System.out.println(arrayList.get(i));
			
		}
		
		
		
		
		
	
		
		
		
		

	}

}
