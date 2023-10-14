import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTableAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		// ChromeOptions code is used to resolve ConnectionFailedException- Starts
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); //
		// ChromeOptions code is used to resolve ConnectionFailedException- Ends
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,550)");
		WebElement table = driver.findElement(By.id("product"));
		
		
//
//		System.out.println(table.findElements(By.tagName("tr")).size());
//
//		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
//
//		List<WebElement> secondrow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
//
//		System.out.println(secondrow.get(0).getText());
//
//		System.out.println(secondrow.get(1).getText());
//
//		System.out.println(secondrow.get(2).getText());
		
//		WebElement table1 = driver.findElement(By.name("courses"));
		WebElement TogetRows = driver.findElement(By.xpath("//table[@name='courses']/tbody"));
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		
		WebElement TogetColumns = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr"));
		List<WebElement>TotalColumnsList = TogetColumns.findElements(By.tagName("th"));
		System.out.println("Total number of columns in the table are : "+ TotalColumnsList.size());
		
//		List<WebElement> secondrow = TogetRows.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
//
//		System.out.println(secondrow.get(0).getText());
//
//		System.out.println(secondrow.get(1).getText());
//
//		System.out.println(secondrow.get(2).getText());
		
		WebElement SecondRow = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[3]"));
		
		System.out.println(SecondRow.getText());
		

	}

}
