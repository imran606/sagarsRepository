package CashCounter;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import new_user_registration.New_User_Excel;
import new_user_registration.New_User_Reg;

public class ReceiptCancellation extends New_User_Reg{
	@DataProvider(name="ReceiptCancellation")
	public String[][] getData31() throws IOException{
		String[][] excelData31= New_User_Excel.getExcelData("ReceiptNoForCancellation");
		
		return excelData31;
		}
	
	@Test(dataProvider="ReceiptCancellation")
	public void Receiptcancel(String data[]) throws InterruptedException{
		

		//Select counter
		WebElement counterSelect=element("name", "counter");
		selectByVisibleText(counterSelect, data[0]);

		//Enter Username
		sendkeys(element("name", "userName"), data[1]);

		//Enter Password
		sendkeys(element("name", "password"), data[2]);

		//click login
		click(element("xpath", "//input[@value='Log in']"));
		
		//click Receipt Cancellations
		click(element("linkText", "Receipt Cancellations"));
		
		//Enter Receipt No and click enter
		sendkeys_clickEnter(element("name", "receiptNo"), data[3]);
		
		//Click cancel receipt
		click(element("name", "method"));
		Thread.sleep(1000);
		
		//Accept the alert
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		String successMessage=element("classname", "successMessage").getText();
		Assert.assertEquals(successMessage, "Receipt cancelled Successfully");
		System.out.println("Receipt cancelled Successfully for ReceiptNo: "+data[3]+"");
		
		//Click Signout
		click(element("xpath", "//img[@title='SignOut']"));
		Thread.sleep(2000);
	}

}
