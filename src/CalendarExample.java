import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CalendarExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
//		options.addExtensions(new File("./src/Extensions/AdBlock_Extension.crx"));
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		options.merge(capabilities);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.path2usa.com/travel-companion/");
//		driver.manage().window().maximize();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");

//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dateElement);
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(3000);
		WebElement dateElement = driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']"));
		dateElement.click();

		while (!driver.findElement(By.xpath("//div[@class='flatpickr-month']")).getText().contains("December"))

		{

			Thread.sleep(2000);

			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();

		}
		List<WebElement> dates = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
		int count = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).size();
		System.out.println(count);
//		driver.navigate().refresh(); 
		for (int i = 0; i < count; i++) {
			Thread.sleep(1000);
			String text = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();
			if (text.equalsIgnoreCase("2")) {
				driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
				System.out.println("The selected day is:" + text);
				break;
			}
		}
		
		String date = driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).getAttribute("value");

		System.out.println("The selected date is:"+date);

	}

}
