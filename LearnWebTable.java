package week2.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		// Open chrome browser
		//chromedriver (is a class) > written by selenium team
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//get url
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("SBC", Keys.TAB);
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MAS", Keys.TAB);
		WebElement table1 = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
		//Find the list of Rows in the table
		List<WebElement> allRows = table1.findElements(By.tagName("tr"));
		int numberOfRows = allRows.size();
		System.out.println(numberOfRows);
		for (int i = 0; i < numberOfRows; i++) {
			WebElement row1 = allRows.get(i);
				    //Find the list of columns in the given row
					List<WebElement> allCol = row1.findElements(By.tagName("td"));
					//System.out.println(allCol.size());
					WebElement col2 = allCol.get(1);	
					System.out.println(col2.getText());	
		}
		
		
	}

}
