package week3.day3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//Get url
		driver.get("http://leaftaps.com/opentaps/control/main");

		//Login into Leaf taps
		WebElement userName = driver.findElementById("username");
		userName.sendKeys("DemoSalesManager");
		WebElement pwdValue = driver.findElementById("password");
		pwdValue.sendKeys("crmsfa");
		WebElement loginButton = driver.findElementByClassName("decorativeSubmit");
		loginButton.click();

		//click on crmsfa
		WebElement crmLink = driver.findElementByLinkText("CRM/SFA");
		crmLink.click();

		//Lead Link		
		driver.findElement(By.linkText("Leads")).click();

		//Find From Lead from Merge Leads
		driver.findElement(By.linkText("Merge Leads")).click();
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();

		//Get all the active windows
		Set<String> allWin_FrmLead = driver.getWindowHandles();
		ArrayList<String> lst_FrmLead = new ArrayList<String>(allWin_FrmLead);
		System.out.println(lst_FrmLead.size());
		String firstWin_FrmLead = lst_FrmLead.get(0);
		String scndWin_FrmLead = lst_FrmLead.get(1);
		driver.switchTo().window((scndWin_FrmLead));
		driver.findElement(By.name("firstName")).sendKeys("Gopi");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String fromLead = driver.findElement(By.xpath("(//div[@class ='x-grid3-body']//table//tr/td)[1]")).getText();
		System.out.println(fromLead);
		driver.findElement(By.xpath("(//div[@class ='x-grid3-body']//table//tr/td)[1]//a")).click();
		Thread.sleep(2000);
		driver.switchTo().window(firstWin_FrmLead);

		//Find To Lead from Merge Leads
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();

		Set<String> allWin_ToLead = driver.getWindowHandles();
		ArrayList<String> lst_ToLead = new ArrayList<String>(allWin_ToLead);
		System.out.println(lst_ToLead.size());
		String firstWin_ToLead = lst_ToLead.get(0);
		String scndWin_ToLead = lst_ToLead.get(1);
		driver.switchTo().window((scndWin_ToLead));

		driver.findElement(By.name("lastName")).sendKeys("Babu");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String toLead = driver.findElement(By.xpath("(//div[@class='x-grid3-body']//table//tr/td)[1]")).getText();
		System.out.println(toLead);
		driver.findElement(By.xpath("(//div[@class='x-grid3-body']//table//tr/td)[1]//a")).click();
		driver.switchTo().window(firstWin_ToLead);

		driver.findElement(By.linkText("Merge")).click();
		driver.switchTo().alert().accept();

		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(fromLead);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String finalValue = driver.findElement(By.className("x-paging-info")).getText();
		System.out.println(finalValue);
		if (finalValue.contains("No records to display")) {
			System.out.println("There is no such records to Display");
		}

		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/img1.png");
		FileUtils.copyFile(src, dest);

		driver.close();
	}

}
