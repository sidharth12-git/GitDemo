import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScopeLinksFooter {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerDriver =  driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		WebElement columnfooterDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int sizeColumnfooterDriver = columnfooterDriver.findElements(By.tagName("a")).size();
		System.out.println(sizeColumnfooterDriver);
		
		//click on each link on 1st column of footer to open new child window
		for(int i=1;i<sizeColumnfooterDriver;i++)
		{
			String clickonlinktab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnfooterDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
			Thread.sleep(5000L);
		}
		
		//get all child windows titles
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while(itr.hasNext())
		{
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
			
		}
		
		
		
		

	}

}
