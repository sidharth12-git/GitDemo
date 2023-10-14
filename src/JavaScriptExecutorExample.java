import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class JavaScriptExecutorExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		// ChromeOptions code is used to resolve ConnectionFailedException- Starts
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); //
		// ChromeOptions code is used to resolve ConnectionFailedException- Ends
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(4000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> table = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum =0;
		for(int i=0;i<table.size(); i++)
		{
			sum = sum + Integer.parseInt(table.get(i).getText());
		}
		System.out.println(sum);
		
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		System.out.println("Total is : " + total);
		Assert.assertEquals(sum, total);
	}

}
