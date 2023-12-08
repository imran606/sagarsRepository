package new_user_registration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Manual_Cash_Entry extends New_User_Reg {
	@DataProvider(name="Manual_Cash_Entry")
	public String[][] getData10() throws IOException{
		String[][] excelData10= New_User_Excel.getExcelData("Consumer_Id");
		
		return excelData10;
		}
	//@Test(dataProvider="Manual_Cash_Entry")
	public void manual_cash_entry(String data[]) throws InterruptedException{
		
		//Click cash management
		click(element("linkText", "Cash Management"));
		
		//
		click(element("linkText", "2"));
		
		//Enter Consumer ID
		sendkeys_clickEnter(element("name", "consumerid"),data[0]);
		
		//Get receiptNo
		String receiptNo=element("name", "receiptNo").getAttribute("value");
		System.out.println(receiptNo);
		
		//Select Payment Towards
		WebElement Payment_Towards=element("name", "paymentTowards");
		selectByVisibleText(Payment_Towards, "Bill");
		
		//Select paymentMode
		WebElement paymentMode=element("name", "paymentMode");
		selectByVisibleText(paymentMode, "Cheque");
		
		//Cheque /DD / MO No
		sendkeys(element("name", "checkDDNo"), "12345");
		
		// Cheque /DD / MO Date	
		WebElement Cheque  =element("xpath", "(//img[@class='ui-datepicker-trigger'])[2]");
		click(Cheque);
		WebElement Cheque2=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
		click(Cheque2);
		
		//Bank Name
		WebElement  Bank_Name=element("name", "bankName");
		selectByVisibleText(Bank_Name, "Bank Of Baroda");

		//Enter Amount Paid
		sendkeys(element("name", "amountPaid"), "56");
		
		//Click Add button
		click(element("xpath", "//input[@value='Add']"));
		
		//ValidateData has been succesfully Added or Not
		String successMessage=element("classname", "successMessage").getText();
		Assert.assertEquals(successMessage, "Data has been succesfully Added,Please Click Next to go to Next Receipt");
		
		//Click Admin
		clickAdmin();
		
		//Select from date
		FromDate();
		
		//Select to date
		ToDate();
		
		//Select category
		EnterCategory("Manual Cash Entry");
		
		//Click admin button
		AdminSubmit();
		
		//click
		click(element("linkText", "Click here to go to Manual Cash Receipt Approval Screen"));
		
		//
		Set<String> WindowHandles=driver.getWindowHandles();
		List<String> list = new ArrayList<String>(WindowHandles);

		//Approval page
		Thread.sleep(1000);
		driver.switchTo().window(list.get(1));
		Thread.sleep(1000);
		
		//From date
		WebElement date1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]");
		click(date1);
		click(element("xpath", "//span[.='Prev']"));
		WebElement date2=element("xpath", "(//a[@class='ui-state-default'])[1]");
		click(date2);
		
		//To date
		Thread.sleep(1000);
	    WebElement d1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[2]");
	    click(d1);
	    WebElement d2=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
	    click(d2);
	    
	    //Select type
	    WebElement type=element("name", "type");
		selectByVisibleText(type, "Day wise");
		
		//
		click(element("xpath", "(//input[@type='checkbox'])[2]"));
		click(element("xpath", "//input[@value='Approve']"));
		
		//
		Set<String> WindowHandles1=driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(WindowHandles1);
		driver.switchTo().window(list1.get(0));
		
	}

}
