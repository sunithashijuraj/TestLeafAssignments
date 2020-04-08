package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiElemtsAssignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.leafground.com/pages/Link.html");
		/*
		 * 1. how many images are available 2. clicking on the last one using sendkeys
		 * 3. going to radio button, find out how many radio buttins are available> ->
		 * 4. go to the check box, check all the check box using findelements
		 */
		// 1. how many images are available
		
		//Click on Image in the home page
				driver.findElementByXPath("//h5[text()='Image']").click();
				
				//Find the total no of image in the page
				List<WebElement> totalImages = driver.findElementsByTagName("img");
				System.out.println("Total no of Images - "+totalImages.size());
				Thread.sleep(2000);
				
				//Click on the last keyboard based on the title of it
				driver.findElementByXPath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img").click();
				System.out.println("Keyboard Image is clicked");
				
				
				//Click on the Radio button image in the home page
				driver.findElementByXPath("//h5[text()='Radio Button']").click();
				
				
				//Find total radio buttons in the page
				List<WebElement> totalRadioButton = driver.findElementsByXPath("//input[@type='radio']");
				System.out.println("Total no of Radio Button - "+totalRadioButton.size()); 
				
				driver.navigate().back();
				//Thread.sleep(3000);
				
				//Click on Checkbox	
				driver.findElementByXPath("//h5[text()='Checkbox']").click();
				//Thread.sleep(3000);
				
				List<WebElement> radBut = driver.findElementsByXPath("//label[contains(text(),'Select all below checkboxes ')]//following-sibling::div//input[@type='checkbox']");
				for (int i = 0; i < radBut.size(); i++) {
					radBut.get(i).click();
				}
	}

}
