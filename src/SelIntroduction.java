import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SelIntroduction {

	public static void main(String[] args) {
		//Invoking browser
		//Chrome-> ChromeDriver -> Methods ex: close
		//Firefox-> GeckoDriver -> Methods ex: close
		//chromedriver.exe -> 
		
		
		 System.setProperty("webdriver.chrome.driver","./src/drivers/chromedriver.exe"); 
		 // ChromeOptions code is used to resolve ConnectionFailedException- Starts 
		 ChromeOptions options = new ChromeOptions(); 
		 options.addArguments("--remote-allow-origins=*"); //
		 //ChromeOptions code is used to resolve ConnectionFailedException- Ends
		 WebDriver driver = new ChromeDriver(options);
		 
		
//		System.setProperty("webdriver.gecko.driver", "./src/drivers/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
//		System.setProperty("webdriver.edge.driver", "./src/drivers/msedgedriver.exe");
//		EdgeOptions edgeOptions = new EdgeOptions();
//		edgeOptions.addArguments("--remote-allow-origins=*");
//		WebDriver driver = new EdgeDriver(edgeOptions);
		
		
		
		driver.get("https://rahulshettyacademy.com/");
		String title =  driver.getTitle();
		System.out.println(title);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		System.out.println("Page source: " + driver.getPageSource());
		
		driver.close();//close current window
		driver.quit();//close multiple windows - say if multiple links are opened from current window, so all windows will be closed by quit() method
		
		
		
		
	}

}
