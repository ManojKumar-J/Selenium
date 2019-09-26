package Seleniumprojec;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.google.common.io.Files;



public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

//Verify that the external links in “External links“ section work

	public void verifyexternallinks() {

		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (int i = 0; i < links.size(); i++) {
			String str1 = links.get(i).getAttribute("href");

			if (str1 == null) {

				i++;
			} else if (str1.startsWith("https://en.wikipedia.org/wiki/Selenium")) {

				i++;
			}

			else {

				System.out.println("Externallinks =" + str1);
				i++;

			}
		}

	}

//Click on the “Oxygen” link on the Periodic table at the bottom of the page

	public void clicklinktext() {
		driver.findElement(By.linkText("Oxygen")).click();
	}

//Count the number of pdf links in “References“

	public void countpdflinks() {

		List<WebElement> links = driver.findElements(By.tagName("a"));
		int f = 0, g = 1;
		for (int i = 0; i < links.size(); i++) {
			String str1 = links.get(i).getAttribute("href");

			if (str1 == null) {

				i++;
			} else if (str1.contains(".pdf")) {

				f = f + g;

				// System.out.println("count =" + f);

				// System.out.println("pdf =" + str1);
				i++;

			}

			else {
				i++;
			}

		}
		System.out.println("count =" + f);
		f++;

	}

//In the search bar on top right enter “pluto” and verify that the 2 nd suggestion is “Plutonium”

	public void searchbartopright() {

		WebElement element = driver.findElement(By.name("search"));
		element.sendKeys("pluto");
		String secondelement = driver.findElement(By.xpath("/html/body/div[7]/div/a[2]/div")).getText();
		System.out.println(secondelement);

		if (secondelement.equals("Plutonium")) {

			System.out.println("Testcase is Pass");
		} else {
			System.out.println("Testcase is Fail");
		}

	}

	// Verify that it is a “featured article”

	public void verifyfeaturedarticle() {
		if (driver.getPageSource().contains("featured article")) {
			System.out.println("Testcase is Pass");
		} else {
			System.out.println("Testcase is Fail");
		}
	}

	// Take a screenshot of the right hand box that contains element properties

	public void screenshotparticulararea() throws IOException {

		File screenshot = ((TakesScreenshot) driver
				.findElement(By.xpath("/html/body/div[3]/div[3]/div[4]/div/table[2]")))
						.getScreenshotAs(OutputType.FILE);
		File screenshotLocation = new File("E:\\screens\\div_element_1.png");
		Files.copy(screenshot, screenshotLocation);

	}

}
