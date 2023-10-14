import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		// ChromeOptions code is used to resolve ConnectionFailedException- Starts
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); //
		// ChromeOptions code is used to resolve ConnectionFailedException- Ends
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		Actions a = new Actions(driver);
		WebElement element = driver.findElement(By.cssSelector("span[id='nav-link-accountList-nav-line-1']"));
		WebElement textBox= driver.findElement(By.id("twotabsearchtextbox"));
		a.moveToElement(textBox).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		a.moveToElement(element).contextClick().build().perform();

	}

}
