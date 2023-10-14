import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		 // ChromeOptions code is used to resolve ConnectionFailedException- Starts 
		 ChromeOptions options = new ChromeOptions(); 
		 options.addArguments("--remote-allow-origins=*"); //
		 //ChromeOptions code is used to resolve ConnectionFailedException- Ends
		 WebDriver driver = new ChromeDriver(options);
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		 HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		 conn.setRequestMethod("HEAD");
		 conn.connect();
		 
		 int respCode = conn.getResponseCode();
		 System.out.println(respCode);

	}

}
