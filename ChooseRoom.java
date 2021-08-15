package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChooseRoom {

	WebDriver driver;
	WebDriverWait wt = null;
	
	public ChooseRoom(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ReserveRooms() {
		driver.findElement(By.cssSelector("button[data-stid='sticky-button']")).click();
	}
	
	public void Reserve() {
		driver.findElement(By.xpath("//body/div[@id='app']/div[@id='app-layer-manager']/div[@id='app-layer-base']/div[@class='page-container infosite']/main/div[@class='xl-x-margin-six l-x-margin-six m-x-margin-six']/div[@class='uitk-flex main-region']/div[@class='uitk-flex-item main-body m-t-margin-two l-t-margin-three xl-t-margin-three']/section[@class='main-region infosite__main']/div[@class='infosite__content infosite__content--details']/div[@data-stid='rooms-rates']/div[@id='Offers']/span/div[@class='uitk-spacing uitk-spacing-margin-blockend-three']/div[@class='uitk-layout-grid uitk-layout-grid-gap-three uitk-layout-grid-columns-auto_fill-seventy_six uitk-layout-grid-justify-content-start']/div[2]/div[2]/div[1]/div[1]/div[2]/button[1]")).click();
	}
	
	public void StayPayment() {
		driver.findElement(By.xpath("//button[normalize-space()='Pay now']")).click();
	}
	
	public void AllMethods_Rooms() {
		ReserveRooms();
		Reserve();
		StayPayment();
	}
}