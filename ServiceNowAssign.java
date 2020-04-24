package week4day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ServiceNowAssign {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//1. Launch the ServiceNow application URL:
		driver.get("https://dev92474.service-now.com/");
		driver.switchTo().frame(0);

		//2. Login with valid credentials username as admin and password as India@123
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();

		//3. Enter Incident in filter navigator and press enter
		driver.findElement(By.id("filter")).sendKeys("Change",Keys.ENTER);
		Thread.sleep(5000);

		//click on create New
		driver.findElement(By.xpath("(//div[text()='Create New'])[3]")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("gsft_main");
		
		//click on Normal Link
		driver.findElement(By.linkText("Normal: Changes without predefined plans require approval and/or CAB authorization.")).click();
		
		//Get the number in the changeNum field
		WebElement changeNum = driver.findElement(By.id("change_request.number"));
		String changeNumValue = changeNum.getAttribute("value");
		
		//Enter the short description
		driver.findElement(By.id("change_request.short_description")).sendKeys("This is short description value");
		
		//click on submit
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		Thread.sleep(2000);
		
		//Enter the changed Number
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(changeNumValue, Keys.ENTER);
		
		//compare the number values
		driver.findElementByClassName("linked formlink").click();
		String value = driver.findElement(By.id("change_request.number")).getAttribute("value");
		
		if(changeNumValue.equals(value)) {
			System.out.println("The change Number is Same");
		}
		
		
		}
		
		

	}


