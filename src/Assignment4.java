import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement checkBox=  driver.findElement(By.cssSelector("input#checkBoxOption2"));
		checkBox.click();
		////label[@for='benz']
		String textCheckBox = driver.findElement(By.xpath("//input[@name='checkBoxOption2']/..")).getText().trim();
		System.out.println(textCheckBox);
		
		WebElement dropDown = driver.findElement(By.cssSelector("select#dropdown-class-example"));
		Select selDropDown = new Select(dropDown);
		selDropDown.selectByVisibleText(textCheckBox);
		
		WebElement inputBox = driver.findElement(By.id("name"));
		inputBox.sendKeys(textCheckBox);
		
		WebElement alertBtn = driver.findElement(By.id("alertbtn"));
		alertBtn.click();
		
		Alert alert = driver.switchTo().alert();
		
		String alertMsg = driver.switchTo().alert().getText();
		System.out.println(alertMsg);	
        Thread.sleep(5000);
        
        if (alertMsg.contains(textCheckBox)) {
        	alert.accept();
        	System.out.println("Expected Text present in alert message");
		} else {
			System.out.println("text not present in alert message");
			System.out.println("text not present in alert message");
		}
        // Accepting alert
//        alert.accept();
//        String alertMsgSplitted = alertMsg.split(",")[0].split("Hello")[1].trim();
//        System.out.println(alertMsgSplitted);
//        Assert.assertEquals(textCheckBox, alertMsgSplitted);
        		
        
        
		
		
		

	}

}
