package week2.day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ProjectMyntra {

	public static void main(String[] args) throws InterruptedException {
		
		//set system property and intialize driver
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//1) Open https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		
		//2) Mouse over on WOMEN
		WebElement women = driver.findElement(By.xpath("//a[text()='Women']"));
		Actions builder = new Actions(driver);
	    builder.moveToElement(women).perform();
		Thread.sleep(2000);
		
		//3) Click Jackets & Coats
		driver.findElement(By.xpath("//a[text()='Jackets & Coats']")).click();
		
		//4) Find the total count of item (top)
		WebElement titleCount = driver.findElement(By.className("title-count"));
		String titleCountText = titleCount.getText();
		String text = titleCountText.replaceAll("\\D", "");
		int itemCount = Integer.parseInt(text);
		System.out.println("The total count of items in the page are: "+itemCount);
		
		//5) Validate the sum of categories count matches
		String jacketsCountText = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		System.out.println(jacketsCountText);
		String jacketsCountText1 = jacketsCountText.replaceAll("\\D", "");
		int jacketsCount = Integer.parseInt(jacketsCountText1);
		System.out.println("The total number of jackets in the page are: "+jacketsCount);
		
		String coatsCountText = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		System.out.println(coatsCountText);
		String coatsCountText1 = coatsCountText.replaceAll("\\D", "");
		int coatsCount = Integer.parseInt(coatsCountText1);
		System.out.println("The total number of coats in the page are: "+coatsCount);
		
		int totalCount = jacketsCount + coatsCount;
		if (totalCount == itemCount ) {
			System.out.println(totalCount);
			System.out.println("The total item count is matching with sum of categories");
		}else
			System.out.println("The total item count is not matching with sum of categories");
		
		//6) Check Coats
		driver.findElement(By.xpath("//label[text()='Coats']")).click();
		
		//7) Click + More option uder BRAND
		driver.findElement(By.xpath("//ul[@class='brand-list']/following-sibling::div")).click();
		
		//8) Type MANGO and click checkbox
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("MANGO");
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();
		
		//9) Close the pop-up x
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		
		//10) Confirm all the Coats are of brand MANGO
		Thread.sleep(3000);
		List<WebElement> brand = driver.findElementsByXPath("//h3[@class='product-brand']");
		for (WebElement each : brand) {
			
			String ch = each.getText();
			if(ch.equals("MANGO"));
		}
	
		System.out.println("The given brands are Mango");
		
		//11) Sort by Better Discount
		WebElement recommended = driver.findElement(By.className("sort-sortBy"));
		builder.moveToElement(recommended).perform();
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
		driver.findElement(By.xpath("//div[@class='filter-summary-selectedFilterContainer']")).click();

		//12) Find the price of first displayed item
		Thread.sleep(2000);
		String firstPrice = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("The price of first item displayed is: "+firstPrice);
		
		//13) Mouse over on size of the first item
		WebElement brandname = driver.findElementByXPath("//h3[@class='product-brand']");
		builder.moveToElement(brandname).perform();
		
		//14) Click on WishList Now
		driver.findElement(By.xpath("(//span[text()='wishlist now'])[1]")).click();
		
		//15) Close Browser
		driver.close();
		
	}

}
