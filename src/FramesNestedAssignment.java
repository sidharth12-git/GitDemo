import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FramesNestedAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Nested Frames")).click();
		System.out.println(driver.findElements(By.tagName("frameset")).size());
		// frameset[name='frameset-middle']
		WebElement frameTop = driver.findElement(By.cssSelector("frameset frame[name='frame-top']"));
		driver.switchTo().frame(frameTop);
		WebElement frameMiddle = driver
				.findElement(By.cssSelector("frameset[name='frameset-middle'] frame[name='frame-middle']"));
		driver.switchTo().frame(frameMiddle);
		String textMiddle = driver.findElement(By.cssSelector("div[id='content']")).getText();
		System.out.println(textMiddle);
		driver.switchTo().defaultContent();

		// WebElement frameLeft =
		// driver.findElement(By.cssSelector("frameset[name='frameset-middle']
		// frame[name='frame-left']"));
		// driver.switchTo().frame(frameLeft);
		// String textLeft =
		// driver.findElement(By.cssSelector("div[id='content']")).getText();
		// System.out.println(textLeft);
		// driver.switchTo().defaultContent();
		// driver.switchTo().defaultContent();

	}

}
