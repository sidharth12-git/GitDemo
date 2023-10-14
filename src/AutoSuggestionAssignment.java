import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoSuggestionAssignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		 // ChromeOptions code is used to resolve ConnectionFailedException- Starts 
		 ChromeOptions options = new ChromeOptions(); 
		 options.addArguments("--remote-allow-origins=*"); //
		 //ChromeOptions code is used to resolve ConnectionFailedException- Ends
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement textBox = driver.findElement(By.id("autocomplete"));
		textBox.sendKeys("uni");
		Thread.sleep(3000);
		
		List <WebElement> drpDwnCountries = driver.findElements(By.cssSelector("li.ui-menu-item div"));
		for(WebElement country : drpDwnCountries)
		{
			if(country.getText().equalsIgnoreCase("United States (USA)"))
			{
				country.click();
				break;
			}
		}

	}

}
