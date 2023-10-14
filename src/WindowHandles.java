import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandles {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		// ChromeOptions code is used to resolve ConnectionFailedException- Starts
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); //
		// ChromeOptions code is used to resolve ConnectionFailedException- Ends
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		String fullText= driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(fullText);
		String emailText = fullText.split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailText);
		
		

	}

}
