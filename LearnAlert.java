package week3.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//get Url
		driver.get("http://www.leafground.com/pages/Alert.html");
		//click alert box
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();;
		//switch to alert
		Alert alert = driver.switchTo().alert();
		
		String text = alert.getText();
		System.out.println(text);
		
		//close the alert
		alert.accept();
		
		//click on confirm box
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		String text2 = alert.getText();
		System.out.println(text2);
		
		//cancel the alert
		alert.dismiss();
		
		
		  //click prompt box
		  driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		  String text3 = alert.getText();
		  System.out.println(text3);
		  //type in alert 
		  alert.sendKeys("HP");
		  
		  //close the alert 
		  alert.accept();
		  
		  driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		  String text4 = driver.findElement(By.xpath("//div[text()='Happy Coding!']")).getText();
		  System.out.println(text4);
		  driver.findElement(By.xpath("//button[text()='OK']")).click();
		 

	}

}
