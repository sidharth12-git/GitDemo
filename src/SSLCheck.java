import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./src/drivers/chromedriver.exe");
		 // ChromeOptions code is used to resolve ConnectionFailedException- Starts 
		 ChromeOptions options = new ChromeOptions(); 
		 options.addArguments("--remote-allow-origins=*"); //
		 //ChromeOptions code is used to resolve ConnectionFailedException- Ends
		 options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
