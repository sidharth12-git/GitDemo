import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;



public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		
		String name ="rahul";
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		 // ChromeOptions code is used to resolve ConnectionFailedException- Starts 
		 ChromeOptions options = new ChromeOptions(); 
		 options.addArguments("--remote-allow-origins=*"); //
		 //ChromeOptions code is used to resolve ConnectionFailedException- Ends
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		WebElement userNameElement = driver.findElement(By.cssSelector("input#inputUsername"));
		userNameElement.sendKeys(name);
		WebElement passswordElement = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		passswordElement.sendKeys("rahulshettyacademy");
		//can use this xpath as well for below webelement : button[contains(text(),'Sign In')]
		WebElement signInBtnElement = driver.findElement(By.xpath("//button[text() ='Sign In']"));
		signInBtnElement.click();
		Thread.sleep(3000);
		String actualText = driver.findElement(By.tagName("p")).getText();
		System.out.println("Actual text is:  " + actualText);
		Assert.assertEquals(actualText, "You are successfully logged in.");
		
		//parent child traversing with help of space in css selector
		WebElement nameMatchElement = driver.findElement(By.cssSelector("div[class='login-container'] h2")) ;
		String nameMatchElementText = nameMatchElement.getText();
		Assert.assertEquals(nameMatchElementText, "Hello "+name+",");
		
		WebElement logOutBtnElement  = driver.findElement(By.xpath("//button[text()='Log Out']"));
		logOutBtnElement.click();
		Thread.sleep(3000);
		String homePageTextActual = driver.findElement(By.xpath("//input[@id='inputUsername']/../h1")).getText();
		System.out.println("Actual home page text is:  " + homePageTextActual);
		Assert.assertEquals(homePageTextActual, "Sign in");
		
		

	}

}
