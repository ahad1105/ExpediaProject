package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class payment {
	WebDriver driver;
	public payment(WebDriver driver) {
		this.driver = driver;
	}
	
	By e_un = By.cssSelector("#hotel-contact-name0");
    By e_mob = By.cssSelector("input[placeholder='So the property can reach you']");
    
    By e_txal = By.cssSelector("#confirmation-sms-provider-checkbox");
            
    //By e_cna = By.cssSelector("input[name='creditCards[0].cardholder_name'][type='text']");

    By e_cno = By.id("creditCardInput");

	//By exp_month = By.className("cko-field cc-expiry-month gb-whitelist");
	
	//By exp_year = By.name("creditCards[0].expiration_year");


	By e_sec = By.cssSelector("#new_cc_security_code");
	
	By e_ml = By.cssSelector("input[name='email'][type='email']");
	
	By e_spal = By.cssSelector("input[name='opt_in_1st']");

	By pwd = By.cssSelector("input[placeholder='6 - 30 characters, no spaces']");

	By cpwd = By.cssSelector("input[title=\"Please make sure 'Password' and 'Confirm Password' are the same.\"]");

	By bk    = By.cssSelector("#complete-booking");
						
	

	
	
	
	public void completePayment(String user ,String mobNum,String cardNum, String index , String index1, String seccode, String email, String pass, String cpass)
	{
		driver.findElement(e_un).sendKeys(user);                  //for contact name
		
		driver.findElement(e_mob).sendKeys(mobNum);               //for mobile number
		
		
		boolean x = driver.findElement(By.cssSelector("#confirmation-sms-provider-checkbox")).isSelected();
		if(x==true)
		{
			driver.findElement(By.cssSelector("#confirmation-sms-provider-checkbox")).click();
		}
		
		//driver.findElement(e_cna).sendKeys(Cname);                //for card name
		
		driver.findElement(e_cno).sendKeys(cardNum);            //for card number
		
//		 WebElement ele = driver.findElement(exp_month);           //for exp month
//		 Select drop = new Select(ele);
//		
//		 Integer j = Integer.valueOf(index);
//		 drop.selectByIndex(j);                              
		
		//WebElement ele1 = driver.findElement(exp_year);          //for exp year
		//Select drop1 = new Select(ele1);
		//int i = Integer.parseInt(index1);
		//drop1.selectByIndex(i);
		
		driver.findElement(e_sec).sendKeys(seccode);             //for security code
		
		driver.findElement(e_ml).sendKeys(email);                //for email
		
		
		boolean x1 = driver.findElement(By.cssSelector("input[name='opt_in_1st']")).isSelected();
		if(x1==true)
		{
			driver.findElement(By.cssSelector("input[name='opt_in_1st']")).click();
		}
		
		
		
		driver.findElement(pwd).sendKeys(pass);                 //for password
		
		driver.findElement(cpwd).sendKeys(cpass);               //to confirm password
		
		driver.findElement(bk).click();                        //to click on the button 
		
		
		
		
		
		
	}
	
}

	

