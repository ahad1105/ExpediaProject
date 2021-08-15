package POM;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import fm.Excel;

public class ReserveRoomRunner {

	public WebDriver driver;
	ExtentReports ex=null;
	ExtentTest tc=null;
	
	@BeforeTest
	  public void beforeTest() {
		 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Sleenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			 ex= new ExtentReports();
			ex.attachReporter(new ExtentHtmlReporter("HotelRoom.html"));
			tc = ex.createTest("HotelRoom");
	  }
	
  @Test(description="Expedia Main Page")
  public void HomePage() throws Exception {
	   	
		
//		Properties prop=new Properties();
//		prop.load(new FileInputStream("src/test/resources/setting.property"));
//		ExtentTest tc=ex.createTest("OneWayFlightReport");
//		tc.info("Opening URL");
//		driver.get(prop.getProperty("url"));
//		tc.pass("Test Case Pass");
//		ex.flush();
	 
	  Properties prop = new Properties();
	  prop.load(new FileInputStream("src/test/resources/system.property"));
	  driver.get(prop.getProperty("stayPageUrl"));
	  tc.info("Opening URL");
	    HomePage e = new HomePage(driver);
		e.Stay(prop.getProperty("location"), prop.getProperty("checkindate"), prop.getProperty("checkoutdate"));
  }
  
  @Test(dependsOnMethods="HomePage",description="Checking list of Hotels")
  public void StayPage() throws Exception {
	  	
		StayPage s=new StayPage(driver);
		tc.info("List of Hotel names");	
		s.bookStay();
		
  }
  
  @Test(dependsOnMethods="StayPage",description="Selecting the Rooms")
  public void ReserveRoom() throws Exception {
	  
		ChooseRoom c=new ChooseRoom(driver);
		
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    
	    driver.switchTo().window(tabs2.get(1));
	    tc.info("Types of rooms");	
	    c.AllMethods_Rooms();
	    
	    //driver.getCurrentUrl();
  }
  
  @Test(dataProvider = "dp", description="payment page opens",dependsOnMethods="ReserveRoom")
  public void runKeyTest( String ContactName, String MobileNumber , String DebitCardNumber , String index, String index1, String SecurityCode , String email, String pass, String cpass) throws Exception {
	  System.out.println("ultimate");
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Sleenium\\chromedriver_win32\\chromedriver.exe");
		  //WebDriver driver=new ChromeDriver();
		  System.out.println("first");
		  driver.get("https://www.expedia.co.in/Checkout/V1/HotelCheckout?tripid=6b4c82ce-5682-5be4-b044-3a4f0bed0681&c=fe354f61-91d7-4ce7-a4af-5c82f313e88b&swpApplied=false");
		  System.out.println("second");
		  //driver.manage().window().maximize();
		  tc.info("Payment");	
		  payment pay = new payment(driver); 
		  pay.completePayment(ContactName,MobileNumber,DebitCardNumber,index,index1,SecurityCode,email,pass,cpass);
		  
		  driver.quit();
	  
	  
	  }


  @DataProvider
  public Object[][] dp()  {
   Object data[][] = new Object[1][9];
  
   Excel ex1 = new Excel("F:\\LTI\\Npax.xlsx");
  
   for(int i=1; i<=1; i++) {
	   
	   data[i-1][0] = ex1.readData("Sheet2", i, 0);
	   data[i-1][1] = ex1.readData("Sheet2", i, 1);
	   data[i-1][2] = ex1.readData("Sheet2", i, 2);
	   data[i-1][3] = ex1.readData("Sheet2", i, 3);
	   data[i-1][4] = ex1.readData("Sheet2", i, 4);
	   data[i-1][5] = ex1.readData("Sheet2", i, 5);
	   data[i-1][6] = ex1.readData("Sheet2", i, 6);
	   data[i-1][7] = ex1.readData("Sheet2", i, 7);
	   data[i-1][8] = ex1.readData("Sheet2", i, 8);
	   
   }
   return data;
  }
  
  

  @AfterTest
  public void afterTest() throws Exception {
	  Thread.sleep(10000);
	  driver.quit();
	  tc.pass("Test Case Pass");
	  ex.flush();
  }
}