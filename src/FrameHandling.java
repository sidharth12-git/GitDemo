import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		// ChromeOptions code is used to resolve ConnectionFailedException- Starts
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); //
		// ChromeOptions code is used to resolve ConnectionFailedException- Ends
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.findElements(By.tagName("iframe")).size();
		WebElement frameElement =  driver.findElement(By.cssSelector("iframe.demo-frame"));
		//In frames, we use concept of Method overloading- frame(index), frame(String frameId), frame(WebElement element)
		driver.switchTo().frame(frameElement);
		Actions a = new Actions(driver);
		WebElement source=  driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Accept']")).click();

	}

}
