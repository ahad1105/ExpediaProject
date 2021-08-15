package POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fm.Excel;

public class excelPayment {
  @Test(dataProvider = "dp")
  public void runKeyTest( String ContactName, String MobileNumber , String DebitCardNumber , String index, String index1, String SecurityCode , String email, String pass, String cpass) throws Exception {
	  
	  System.out.println("ultimate");
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Sleenium\\chromedriver_win32\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  
	  System.out.println("first");
	  driver.get("https://www.expedia.co.in/Checkout/V1/HotelCheckout?tripid=6b4c82ce-5682-5be4-b044-3a4f0bed0681&c=fe354f61-91d7-4ce7-a4af-5c82f313e88b&swpApplied=false");
	  System.out.println("second");
	  //driver.manage().window().maximize();
	  payment pay = new payment(driver); 
	  pay.completePayment(ContactName,MobileNumber,DebitCardNumber,index,index1,SecurityCode,email,pass,cpass);
	  }


  @DataProvider
  public Object[][] dp()  {
   Object data[][] = new Object[6][9];
  
   Excel ex1 = new Excel("F:\\LTI\\Npax.xlsx");
  
   for(int i=1; i<=6; i++) {
	   
	   data[i-1][0] = ex1.readData("Sheet1", i, 0);
	   data[i-1][1] = ex1.readData("Sheet1", i, 1);
	   data[i-1][2] = ex1.readData("Sheet1", i, 2);
	   data[i-1][3] = ex1.readData("Sheet1", i, 3);
	   data[i-1][4] = ex1.readData("Sheet1", i, 4);
	   data[i-1][5] = ex1.readData("Sheet1", i, 5);
	   data[i-1][6] = ex1.readData("Sheet1", i, 6);
	   data[i-1][7] = ex1.readData("Sheet1", i, 7);
	   data[i-1][8] = ex1.readData("Sheet1", i, 8);
	   
   }
   return data;
  }
}