package Seleniumprojec;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import Seleniumprojec.LoginPage;


public class Testcases {

	@Test
	public void verifyValidLogin() throws IOException {
		// config.properties

		Properties prop = new Properties();

		FileInputStream ip = new FileInputStream(
				"C:\\Users\\Admin\\eclipse-workspace\\newproj\\src\\test\\java\\config.properties");

		prop.load(ip);

		// Open the WEB PAGE using Chrome browser

		System.setProperty("webdriver.chrome.driver", prop.getProperty("driverpath"));
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

		LoginPage login = new LoginPage(driver);
		login.countpdflinks();
		login.verifyexternallinks();
		login.verifyfeaturedarticle();
		login.searchbartopright();
		login.screenshotparticulararea();
		login.clicklinktext();

		//driver.close();
	}
}