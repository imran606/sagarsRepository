package CashCounter;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import new_user_registration.New_User_Excel;
import new_user_registration.New_User_Reg;

public class Payment_Entry extends New_User_Reg{
	@DataProvider(name="payment_Entry")
	public String[][] getData31() throws IOException{
		String[][] excelData31= New_User_Excel.getExcelData("PaymentEntry");
		
		return excelData31;
		}
	
	@Test(dataProvider="payment_Entry")
	public void paymentEntry(String data[]) throws InterruptedException {

		//Select counter
		WebElement counterSelect=element("name", "counter");
		selectByVisibleText(counterSelect, data[0]);

		//Enter Username
		sendkeys(element("name", "userName"), data[1]);

		//Enter Password
		sendkeys(element("name", "password"), data[2]);

		//click login
		click(element("xpath", "//input[@value='Log in']"));
		
		//Enter consumer Id and click enter
		sendkeys_clickEnter(element("name", "consumerid"), data[3]);
		
		//Select payment Towards
		WebElement paymentTowards=element("name", "paymentTowards");
		selectByVisibleText(paymentTowards, data[4]);
		
		//Select paymentMode
		WebElement paymentMode=element("name", "paymentMode");
		selectByVisibleText(paymentMode, data[5]);
		
		if(data[5].equals("Cheque") || data[5].equals("DD")) {
			
			//Enter Cheque /DD / MO No
			sendkeys(element("name", "checkDDNo"), "123456789");
			
			//select Cheque / DD/ MO Date date==1
			FromDate();
			
			//select Bank Name
			WebElement bankName=element("name", "bankName");
			selectByVisibleText(bankName, "Bank Of Baroda");
			
		}
		
		//Enter Amount
		sendkeys( element("name", "amountPaid"), data[6]);
		
		//Click Add
		click(element("xpath", "//input[@value='Add']"));
		
		//Click Signout
		click(element("xpath", "//img[@title='SignOut']"));
		Thread.sleep(2000);

	}

	

}
