package week3.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentWeek3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		//1. Launch the ServiceNow application URL: 
		driver.get("https://dev92474.service-now.com/");
		driver.switchTo().frame(0);
		
		//2. Login with valid credentials username as admin and password as India@123
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		
		//3. Enter Incident in filter navigator and press enter
		driver.findElement(By.id("filter")).sendKeys("Incident",Keys.ENTER);
		Thread.sleep(2000);
		
		//4. Click on Create new option Under Incident	
		driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("gsft_main");
		
		//5. Get the text of Number Field and Store it in a String
		String incidentNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentNumber);
		Thread.sleep(2000);
		
		//6. Click on the Search Button Available in the Caller Field & Choose First Value Opened in the new Window
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWin1 = driver.getWindowHandles();
		System.out.println("The count of active windows are: "+allWin1.size());
		ArrayList<String> lst1 = new ArrayList<String>(allWin1);
		driver.switchTo().window(lst1.get(1));
		driver.findElement(By.xpath("(//tr[@data-list_id='sys_user']//following-sibling::td/a)[1]")).click();
		driver.switchTo().window(parentWindow);
		System.out.println("Control moved back to parent window");
		driver.switchTo().frame(0);

		//7. Select the Value as Software in Category Field
		WebElement categoryEle = driver.findElement(By.id("incident.category"));
		Select category = new Select(categoryEle);
		category.selectByVisibleText("Software");
		
		//8. Select Email in Sub Category Field
		WebElement subCatEle = driver.findElement(By.id("incident.subcategory"));
		Select subCategory = new Select(subCatEle);
		subCategory.selectByVisibleText("Email");

		//9. Select Walk-in in Contact Type Field
		WebElement contactEle = driver.findElement(By.id("incident.contact_type"));
		Select contactType = new Select(contactEle);
		contactType.selectByVisibleText("Walk-in");

		//10. Select state as In-Progress
		WebElement stateEle = driver.findElement(By.id("incident.state"));
		Select state = new Select(stateEle);
		state.selectByVisibleText("In Progress");

		//11. Select Urgency as High
		WebElement urgencyEle = driver.findElement(By.id("incident.urgency"));
		Select urgency = new Select(urgencyEle);
		urgency.selectByValue("1");

		//12. Click on the Search Button Available in the Assignment Group & Choose Last Residing Value Opened in new Window
		Thread.sleep(2000);
		driver.findElement(By.id("lookup.incident.assignment_group")).click();

		Set<String> allWin2 = driver.getWindowHandles();
		ArrayList<String> lst2 = new ArrayList<String>(allWin2);
		System.out.println("The count of open windows are: "+lst2.size());
		driver.switchTo().window(lst2.get(1));

		List<WebElement> group = driver.findElements(By.xpath("//a[@class='glide_ref_item_link']"));
		WebElement assignGroup = group.get(group.size()-1);
		assignGroup.click();

		driver.switchTo().window(parentWindow);
		System.out.println("Control moved to parent window");
		driver.switchTo().frame(0);

		//13. Enter Short Description as "Creating Incident For the Purpose of Management"
		driver.findElement(By.id("incident.short_description")).sendKeys("Creating Incident For the Purpose of Management");
		
		//14. Click on the Submit Button
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		Thread.sleep(3000);
		
		//15. Enter The Incident Number Newly created in Search Field and Press Enter
		driver.findElementByXPath("(//label[text()='Search']//following::input)[1]").sendKeys(incidentNumber,Keys.ENTER);
		Thread.sleep(3000);
		
		//16. Click on the newly Created Incident Displayed
		String incident = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		System.out.println(incident);
		
		//17. Verify the Incident Number
		if (incident.equalsIgnoreCase(incidentNumber)) {
			System.out.println("Both the incident numbers are same");
		}
		
		//18. Update Impact as High
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		WebElement impactEle = driver.findElement(By.id("incident.impact"));
		Select impact = new Select(impactEle);
		impact.selectByValue("1");

		//19. Update Description as "Successfully Created an incident"
		driver.findElement(By.xpath
				("//textarea[@id='incident.description']")).sendKeys("Successfully Created an incident");
		
		//20. Enter Work Notes as "Done Right"
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Done Right");
		
		//21. Click on the Update button.
		driver.findElement(By.id("sysverb_update")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		//22. Logout and Close
		driver.findElement(By.xpath("//button[@id='user_info_dropdown']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.close();






	}

}
