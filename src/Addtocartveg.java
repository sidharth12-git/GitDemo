import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Addtocartveg {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		// ChromeOptions code is used to resolve ConnectionFailedException- Starts
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); //
		// ChromeOptions code is used to resolve ConnectionFailedException- Ends
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		

		String[] itemsNeededArray = { "Cucumber", "Beetroot", "Brocolli", "Tomato" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		addItems(driver, itemsNeededArray);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//span.promoInfo
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

	public static void addItems(WebDriver driver, String[] itemsNeededArray) {
		int counter = 0;
		// h4.product-name
		List<WebElement> listProducts = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < listProducts.size(); i++) {
			String[] productName = listProducts.get(i).getText().split("-");
			String formattedProductName = productName[0].trim();
			// format/trim productName to get actual text
			// convert array into arraylist for easy search
			// check whether productname which you extracted is present in arraylist or not

			List itemsNeededArrayList = Arrays.asList(itemsNeededArray);
			if (itemsNeededArrayList.contains(formattedProductName)) {
				counter++;
				// to solve the problem of ADD TO CART to ADDED gets changed for short span of
				// time when clicked, we should not use xpath with text() - instead use dynamic
				// cssSelector or xpath- here we used xpath/css Selector of parent to child
				// traversing

				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();
				// I am using cssSelector, we can use xpath as well
				// xpath = "//div[@class='product-action']/button"
				driver.findElements(By.cssSelector("div.product-action button")).get(i).click();
				if (counter == (itemsNeededArray.length)) {
					break;
				}
				// break;
			}
		}

	}
}
