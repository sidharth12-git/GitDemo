import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowActivities {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		 // ChromeOptions code is used to resolve ConnectionFailedException- Starts 
		 ChromeOptions options = new ChromeOptions(); 
		 options.addArguments("--remote-allow-origins=*"); //
		 //ChromeOptions code is used to resolve ConnectionFailedException- Ends
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.google.com");
		driver.navigate().to("https://rahulshettyacademy.com");
		driver.navigate().back();
		driver.navigate().forward();
	

	}

}
