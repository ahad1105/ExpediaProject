package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StayPage {

	WebDriver driver;
	WebDriverWait wt = null;
	
	public StayPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void bookStay() {
		driver.findElement(By.cssSelector("a[data-stid='open-hotel-information']")).click();
	}
}