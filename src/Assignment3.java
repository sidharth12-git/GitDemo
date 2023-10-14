import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		// ChromeOptions code is used to resolve ConnectionFailedException- Starts
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); //
		// ChromeOptions code is used to resolve ConnectionFailedException- Ends
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		////input username in textbox
		String userName = driver.findElement(By.xpath("//i[text()='rahulshettyacademy']")).getText();
		driver.findElement(By.cssSelector("input#username")).sendKeys(userName);
		//input password in textbox
		String  password = driver.findElement(By.xpath("//i[text()='learning']")).getText();
		driver.findElement(By.cssSelector("input#password")).sendKeys(password);
		//select radio button User
		driver.findElement(By.xpath("//span[text()=' User']/../span[@class='checkmark']")).click();
		//OK button click
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		//Dropdown select code
		WebElement dropDown = driver.findElement(By.cssSelector("select.form-control"));
		Select selDropDown = new Select(dropDown);
		selDropDown.selectByValue("consult");
		
		//selDropDown.selectByVisibleText("Consultant");
		
		//terms and conditions checkbox select
		driver.findElement(By.id("terms")).click();
		//signInBtn click
		driver.findElement(By.id("signInBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Shop Name']")));
		
		String[] itemsNeededArray = { "Samsung Note 8", "Blackberry", "Nokia Edge" };
		addItems(driver, itemsNeededArray);
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-success']")));
		String text = driver.findElement(By.xpath("//button[@class='btn btn-success']")).getText().trim();
		Assert.assertEquals(text, "Checkout");
		
		

	}
	public static void addItems(WebDriver driver, String[] itemsNeededArray)
	{
		//button[@class='btn btn-info']
		
		int counter = 0;
		// h4.product-name
		List<WebElement> listProducts = driver.findElements(By.xpath("//h4[@class='card-title']/a"));

		for (int i = 0; i < listProducts.size(); i++) {
			String productName = listProducts.get(i).getText();
			//String formattedProductName = productName[0].trim();
			// format/trim productName to get actual text
			// convert array into arraylist for easy search
			// check whether productname which you extracted is present in arraylist or not

			List itemsNeededArrayList = Arrays.asList(itemsNeededArray);
			if (itemsNeededArrayList.contains(productName)) {
				counter++;
				// to solve the problem of ADD TO CART to ADDED gets changed for short span of
				// time when clicked, we should not use xpath with text() - instead use dynamic
				// cssSelector or xpath- here we used xpath/css Selector of parent to child
				// traversing

				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();
				// I am using cssSelector, we can use xpath as well
				// xpath = "//div[@class='product-action']/button"
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
				if (counter == (itemsNeededArray.length)) {
					break;
				}
				// break;
			}
		}
	}

}
