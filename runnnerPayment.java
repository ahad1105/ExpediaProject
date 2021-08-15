package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class runnnerPayment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Sleenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.expedia.co.in/Checkout/V1/HotelCheckout?tripid=a1a3667f-da13-5cf0-b3a0-38df0fa5af32&c=e70a6e90-a8d6-4354-8397-0e3ca82bc527&swpApplied=false");
		//driver.get("https://www.expedia.co.in/Checkout/V1/FlightCheckout?tripid=0deb8044-9117-529b-a21a-99880023b988&c=1bf11493-45c5-45e6-819f-4d2465917a00");
		payment pay = new payment(driver);
		
		//pay.setUserName("Ahad Khan");
		
		//pay.setMobileNumber("8291729433");
		
		//pay.cardName("Ahad Khan");
		
		//pay.cardNumber("123434568768");
		
		//pay.monthDrop(2);
		
		//pay.yearDrop(4);
		
		//pay.securityCode("234");
		
		//pay.emailID("ahad70429@gmail.com");
		
		//pay.createPassword("abcd1234");
		
		//pay.confirmPassword("abcd1234");
		
		//pay.completeBooking();
		
		pay.completePayment("Ahad Khan","8291729433","34445",2,4,"234","ahad70429@gmail.com","abcd1234","abcd1234");
		

	}

}
