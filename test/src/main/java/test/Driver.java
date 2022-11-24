package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
public static WebDriver launchbrowser() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("start-maximized"); //
		 * https://stackoverflow.com/a/26283818/1689770
		 * options.addArguments("enable-automation"); //
		 * https://stackoverflow.com/a/43840128/1689770
		 * options.addArguments("--ignore-certificate-errors"); // Ignore Certificate
		 * Errors options.addArguments("--no-sandbox");
		 * //https://stackoverflow.com/a/50725918/1689770
		 * options.addArguments("--disable-infobars");
		 * //https://stackoverflow.com/a/43840128/1689770
		 * options.addArguments("--disable-dev-shm-usage");
		 * //https://stackoverflow.com/a/50725918/1689770
		 * options.addArguments("--disable-browser-side-navigation");
		 * //https://stackoverflow.com/a/49123152/1689770
		 * options.addArguments("--disable-gpu");
		 * //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-
		 * chromedriver-timed-out-receiving-message-from-renderer-exc
		 */	
		return new ChromeDriver();

	}

}
