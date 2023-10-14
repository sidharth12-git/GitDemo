import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		 // ChromeOptions code is used to resolve ConnectionFailedException- Starts 
		 ChromeOptions options = new ChromeOptions(); 
		 options.addArguments("--remote-allow-origins=*"); //
		 //ChromeOptions code is used to resolve ConnectionFailedException- Ends
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		WebElement userNameElement = driver.findElement(By.cssSelector("input#inputUsername"));
		userNameElement.sendKeys("abc");
		WebElement passswordElement = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		passswordElement.sendKeys("12345667798");
		//can use this xpath as well for below webelement : button[contains(text(),'Sign In')]
		WebElement signInBtnElement = driver.findElement(By.xpath("//button[text() ='Sign In']"));
		signInBtnElement.click();
		//Thread.sleep(6000);
		WebElement errorMessageSignIn = driver.findElement(By.cssSelector("p.error"));
		String text = errorMessageSignIn.getText();
		System.out.println(text);
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		WebElement frgtPwdNameElement = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		frgtPwdNameElement.sendKeys("John");
		
		//by sing cssSelector - finding email input box 
		WebElement frgtPwdEmailElement = driver.findElement(By.cssSelector("input[placeholder='Email']"));
		frgtPwdEmailElement.sendKeys("john@rsa.com");
		
		//by using xpath indexing - finding email input box 
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
		//by using cssSelector indexing - finding email input box
		WebElement frgtPwdMailElement = driver.findElement(By.cssSelector("input[type='text']:nth-child(3)"));
		frgtPwdMailElement.sendKeys("john@gmail.com");
		//frgtPwdMailElement.clear();
		
		//using parent to child traversing and indexing - using xpath	
		WebElement frgtPwdPhoneElement = driver.findElement(By.xpath("//form/input[3]"));
		frgtPwdPhoneElement.sendKeys("1234567899");
		
		//using cssSelector - classname- dot operator
		WebElement resetBtn  = driver.findElement(By.cssSelector("button.reset-pwd-btn"));
		resetBtn.click();
		
		//using cssSelector :  parent- child traversing - (parenttagname space childtagname)
		WebElement tempPwdElement = driver.findElement(By.cssSelector("form p"));
		String textPwd=  tempPwdElement.getText();
		System.out.println(textPwd);
		
		WebElement goToLoginElement = driver.findElement(By.xpath("//button[text()='Go to Login']"));
		goToLoginElement.click();
		// Thread sleep to avoid ElementClickInterceptedException
		Thread.sleep(2000);
		userNameElement.sendKeys("rahul");
		
//		WebElement passswordElement1 = driver.findElement(By.xpath("//input[@placeholder='Password']"));
//		passswordElement1.sendKeys("rahulshettyacademy");
		
		//regular expression using cssSelector
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
//		Thread.sleep(3000);
		driver.findElement(By.id("chkboxOne")).click();
		
		
		//regular expression using xpath
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		System.out.println("flow checking at last");
		
		
		
		
		
		
		
	
		
		
		
		
		

	}

}
