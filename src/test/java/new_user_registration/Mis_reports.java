package new_user_registration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Mis_reports extends New_User_Reg{
	@DataProvider(name="Mis_reports")
	public String[][] getData21() throws IOException{
		String[][] excelData21= New_User_Excel.getExcelData("Disconnection_ids");
		
		return excelData21;
	}
	

	@Test(dataProvider="Mis_reports", priority=1, enabled=false)
	public void reports(String data[]) throws InterruptedException{
		
		//Click Consumer Management
		WebElement Consumer_Management=element("linkText", "Consumer Management");
		click(Consumer_Management);

		//Click Khata changes
		WebElement khata_changes=element("xpath", "//a[@class='c3']");
		click(khata_changes);

		//Enter consumer id
		WebElement ConsumerId=element("name", "consumerid");
		sendkeys_clickEnter(ConsumerId, data[0]);

		//Enter first name
		WebElement conNewFirstName=element("name", "conNewFirstName");
		sendkeys(conNewFirstName, data[1]);

		//Enter last name
		WebElement conNewLastName=element("name", "conNewLastName");
		sendkeys(conNewLastName, data[2]);

		//Select RelationType
		WebElement conNewRtype=element("name", "conNewRtype");
		selectByVisibleText(conNewRtype, "D/O");

		//Enter Relation name
		WebElement conNewRname=element("name","conNewRname");
		sendkeys(conNewRname, "brother");

		//Select Gender
		WebElement newConsGender=element("name", "newConsGender");
		selectByVisibleText(newConsGender, "Male");

		//Select Enter Date
		FromDate();

		//Enter Order no
		WebElement orderNumber=element("name", "orderNumber");
		sendkeys(orderNumber, "98765");

		//Select Order Date 
		ToDate();

		//Select Authorized By 
		WebElement approvedby=element("name", "approvedby");
		selectByVisibleText(approvedby, "Junior Engineer");

		//Select Document Upload Type
		WebElement docupload=element("name", "docupload");
		selectByVisibleText(docupload, "Driving License");

		//Enter Remarks
		WebElement remarksnew=element("name", "remarksnew");
		sendkeys(remarksnew, "changed2");

		//Click submit
		WebElement submit=element("xpath", "//input[@value='Submit']");
		click(submit);

		//validate khata changes
		String v=element("xpath", "//font[@color='green']").getText();
		Assert.assertEquals(v, "Khata Changes Data Submitted Successfully");
		System.out.println("khata changed");

		//Click Admin button
		clickAdmin();

		//Waiting for approvals-->From Date
		FromDate();

		//Select To Date
		ToDate();

		//Select Category
		EnterCategory("Khata change");

		//Click submit button
		AdminSubmit();

		//Click consumer Id
		WebElement consumer_Id=element("xpath", "//a[.='"+data[0]+"']");
		click(consumer_Id);

		//
		WindowApprove();
		
		//Click Consumer Management
		WebElement Consumer_Management1=element("linkText", "Consumer Management");
		click(Consumer_Management1);

		//Click Tariff changes
		WebElement Tariff_changes=element("xpath", "//a[@class='c4']");
		click(Tariff_changes);

		//Enter consumer id
		WebElement tConsumerId=element("name", "tConsumerId");
		sendkeys_clickEnter(tConsumerId, data[0]);

		//Select new Tariff 
		WebElement Tariff_new=element("name", "newtariff");
		selectByVisibleText(Tariff_new, "COMMERCIAL");

		//Select Authorized Date
		FromDate();

		//Select Authorized By
		WebElement approvedBy=element("name", "approvedBy");
		selectByVisibleText(approvedBy, "EE");

		//Enter Order Number 
		WebElement orderNumberA=element("name", "orderNumberA");
		sendkeys(orderNumberA, "54321");

		//Enter Remarks
		WebElement tRemarks=element("name", "tRemarks");
		sendkeys(tRemarks, "tariffchanged");

		//Click Submit
		WebElement submit1=element("xpath", "//input[@value='Submit']");
		click(submit1);

		//validate tariff changes success or failure
		WebElement tariff=element("xpath", "//font[@color='green']");
		String tv2=tariff.getText();
		Assert.assertEquals(tv2, "Tariff Changes Data Submitted Successfully");

		//Click Admin button 
		clickAdmin(); 

		//Waiting for approvals-->From Date
		FromDate();

		//Select To Date
		ToDate();

		//Select Category
		EnterCategory("Tariff change");

		//Click submit button
		AdminSubmit();

		//Click consumer Id
		WebElement consumer_id=element("xpath", "//a[.='"+data[0]+"']");
		click(consumer_id);

		//windowApprove
		WindowApprove();
		
		//Click Consumer Management
		WebElement Consumer_Management2= element("linkText", "Consumer Management");
		click(Consumer_Management2);

		//Click Deposit details
		WebElement deposit_details=element("xpath", "//a[@class='c5']");
		click(deposit_details);

		//Enter consumer id
		WebElement dconsumerid=element("name", "dconsumerid");
		sendkeys_clickEnter(dconsumerid, data[0]);

		//Select Deposit Type 
		WebElement depositType=element("name", "depositType");
		selectByVisibleText(depositType, "Bill");

		//Select Deposit Date
		FromDate();

		//Enter Deposit Amount
		WebElement depositeAmount=element("name", "depositeAmount");
		sendkeys(depositeAmount, "1500");

		//Enter Remarks
		WebElement dRemarks=element("name", "dRemarks");
		sendkeys(dRemarks, "Deposit Details changed");

		//Click submit button
		WebElement submit2=element("xpath", "//input[@value='Submit']");
		click(submit2);

		//Validate deposit success message
		WebElement successMessage=element("classname", "successMessage");
		String DD=successMessage.getText();
		Assert.assertEquals(DD, "Deposit Details Inserted Successfully");
		System.out.println("Deposit Details Inserted Successfully");
		
		//Click Revenue Management
		WebElement revenue_management=element("linkText", "Revenue Management");
		click(revenue_management);

		//Click Rebate
		WebElement rebate=element("xpath", "//a[@class='c11']");
		click(rebate);

		//Enter consumerId
		WebElement consumer=element("name", "consumerId");
		sendkeys_clickEnter(consumer, data[0]);

		//Enter Rebate on Arrears 
		WebElement Rebate_on_Arrears=element("name", "rebateOnArrears");
		sendkeys(Rebate_on_Arrears, "200");

		//Enter Rebate on Interest
		WebElement  Rebate_on_Interest=element("name", "rebateOnInterest");
		sendkeys(Rebate_on_Interest, "222");

		//Enter Rebate On Tax 
		WebElement Rebate_On_Tax =element("name", "rebateOnTax");
		sendkeys(Rebate_On_Tax, "333");

		//Enter Order Number 
		WebElement Order_Number = element("name", "orderNumber");
		sendkeys(Order_Number, "34562");

		//Select Order Date
		WebElement Order_Date1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]");
		click(Order_Date1);
		WebElement Order_Date2=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
		click(Order_Date2);

		//Enter Remarks
		WebElement reRemarks=element("name", "reRemarks");
		sendkeys(reRemarks, "rebate updated");

		//Click submit
		WebElement submit3=element("xpath", "//input[@value='Submit']");
		click(submit3);

		//Validate Rebate data inserted succesfull or not
		WebElement s=element("classname", "successMessage");
		String S=s.getText();
		Assert.assertEquals(S, "Rebate data inserted succesfully");
		System.out.println("Rebate data inserted succesfully");

		//Click Admin
		clickAdmin();

		//Select from date
		FromDate();

		//Select to date
		ToDate();

		//Select category
		EnterCategory("Rebate Details");

		//Click submit
		AdminSubmit();

		//Click Id
		WebElement ID=element("xpath", "//td[.='"+data[0]+"']/preceding-sibling::td/a");
		click(ID);

		//Click approve button
		WindowApprove();
		
		//Click Revenue Management
		WebElement revenue_management1=element("linkText", "Revenue Management");
		click(revenue_management1);

		//Click Interest_wave_of
		WebElement Interest_wave_of=element("xpath", "//a[@class='c12']");
		click(Interest_wave_of);

		//Enter consumerId
		WebElement consumerid=element("name", "iConsumerid");
		sendkeys_clickEnter(consumerid, data[0]);

		//Enter Arrears Pending
		WebElement arrearsPending=element("name", "arrearsPending");
		clear_text_and_type(arrearsPending, "180");

		//Enter interestPending
		WebElement interestPending=element("name", "interestPending");
		clear_text_and_type(interestPending, "154");

		//Enter taxPending
		WebElement taxPending=element("name", "taxPending");
		clear_text_and_type(taxPending, "300");

		//Enter iOrderNumber
		WebElement iOrderNumber=element("name", "iOrderNumber");
		sendkeys(iOrderNumber, "56789");

		//Select Order Date
		WebElement Order_Date3=element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]");
		click(Order_Date3);
		WebElement Order_Date4=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
		click(Order_Date4);

		//Enter Remarks
		WebElement waRemarks=element("name", "waRemarks");
		sendkeys(waRemarks, "interest wave updated2");

		//Click submit
		WebElement sub=element("xpath", "//input[@value='Submit']");
		click(sub);

		//Validate Interest Wave-off data inserted succesfull or not
		String successMessage4=element("classname", "successMessage").getText();
		Assert.assertEquals(successMessage4, "Interest Wave-off data inserted succesfully");
		System.out.println("Interest Wave-off data inserted succesfully");


		//Click Admin
		clickAdmin();

		//Select from date
		FromDate();

		//Select to date
		ToDate();

		//Select category
		EnterCategory("Interest WaveOff Details");

		//Click submit
		AdminSubmit();

		//Click Id
		WebElement ID1=element("xpath", "//td[.='"+data[0]+"']/preceding-sibling::td/a");
		click(ID1);

		//Click approve button
		WindowApprove();
		
		//Click Meter Management
		WebElement MeterManagement=element("linkText", "Meter Management");
		click(MeterManagement);

		//Click Disconnection Option
		WebElement Disconnection=element("classname", "c16");
		click(Disconnection);

		//Enter Consumer_id and click enter button
		WebElement consumerid1=element("name", "consumerid");
		sendkeys_clickEnter(consumerid1, data[0]);

		//Select Disconnected Date
		WebElement Click_Disconnected_Date=element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]");
		click(Click_Disconnected_Date);
		WebElement Select_Disconnected_Date=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
		click(Select_Disconnected_Date);

		//Enter Disconnection fees
		WebElement dissConnFees=element("name", "dissConnFees");
		sendkeys(dissConnFees, "500");

		//Enter Order no
		WebElement orderNo=element("name", "orderNo");
		sendkeys(orderNo, "12345");

		//Select Order date
		WebElement Click_Order_Date =element("xpath", "(//img[@class='ui-datepicker-trigger'])[2]");
		click(Click_Order_Date);
		WebElement Select_Order_Date=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
		click(Select_Order_Date);

		//Select Disconnection Type
		WebElement Disconnection_Type=element("name", "toDisconn");
		selectByVisibleText(Disconnection_Type, "Temporary Disconnection");

		//Enter Remarks
		WebElement Remarks=element("name", "diRemarks");
		sendkeys(Remarks, "Temporary Disconnection");

		//Click submit button
		WebElement Submit=element("xpath", "//input[@value='Submit']");
		click(Submit);

		//Validate disconnection message popup
		WebElement validation=element("xpath", "//font[@color='green']");
		String actual=validation.getText();
		Assert.assertEquals(actual, "Dissconnection Details Inserted Successfully");
		System.out.println("Dissconnection Details Inserted Successfully");

		//click Admin
		clickAdmin();

		//From date default day 1
		FromDate();

		//To date default present day
		ToDate();

		//Select Category
		EnterCategory("Disconnection");

		//Click submit
		AdminSubmit();

		//Click Id
		WebElement ID2=element("xpath", "//td[.='"+data[0]+"']/preceding-sibling::td/a");
		click(ID2);

		//Click approve button
		WindowApprove();
		

		//Click Meter Management
		WebElement MeterManagement2=element("linkText", "Meter Management");
		click(MeterManagement2);
		
		//Click Reconnection Option
		WebElement Reconnection=element("classname", "c17");
		click(Reconnection);
		

		//Enter Consumer_id and click enter button
		WebElement consumerid2=element("name", "rconsumerid");
		sendkeys_clickEnter(consumerid2, data[0]);
		
		//Select Reconnected Date
		WebElement Click_Reconnected_Date=element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]");
		click(Click_Reconnected_Date);
		WebElement Select_Reconnected_Date=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
		click(Select_Reconnected_Date);
		
		//Enter Reconnection fees
		WebElement ReConnFees=element("name", "reConnFees");
		sendkeys(ReConnFees, "1000");
		
		//Enter Order no
		WebElement orderNo1=element("name", "rorderNo");
		sendkeys(orderNo1, "12345");
		
		//Select Order date
		WebElement Click_Order_Date2 =element("xpath", "(//img[@class='ui-datepicker-trigger'])[2]");
		click(Click_Order_Date2);
		WebElement Select_Order_Date2=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
		click(Select_Order_Date2);
		
		//Select Reconnection Status
		WebElement Reconnection_Type=element("name", "reconnStatus");
		selectByVisibleText(Reconnection_Type, "Live");

		//Enter Remarks
		WebElement Remarks1=element("name", "reRemarks");
		sendkeys(Remarks1, "Connected");

		//Click submit button
		WebElement Submit1=element("xpath", "//input[@value='Submit']");
		click(Submit1);
		
		//Validate Reconnection message popup
		WebElement validation1=element("xpath", "//font[@color='green']");
		String actual1=validation1.getText();
		Assert.assertEquals(actual1, "Reconnection Details Inserted Successfully");
		System.out.println("Reconnection Details Inserted Successfully");
		
		//click Admin
		clickAdmin();

		//From date default day 1
		FromDate();

		//To date default present day
		ToDate();

		//Select Category
		EnterCategory("Reconnection");

		//Click submit
		AdminSubmit();

		//Click Id
		WebElement ID3=element("xpath", "//td[.='"+data[0]+"']/preceding-sibling::td/a");
		click(ID3);

		//Click approve button
		WindowApprove();
		

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
		String successMessage3=element("classname", "successMessage").getText();
		Assert.assertEquals(successMessage3, "Data has been succesfully Added,Please Click Next to go to Next Receipt");
		
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
		Thread.sleep(4000);
		
		//
		Set<String> WindowHandles1=driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(WindowHandles1);
		driver.switchTo().window(list1.get(0));
		
		
		
		
	}
	
	@Test(dataProvider="Mis_reports", enabled=false)
	public void Dis_connection(String data[]) throws InterruptedException {
		
		//Click Meter Management
		WebElement MeterManagement=element("linkText", "Meter Management");
		click(MeterManagement);
		
		//Click Disconnection Option
		WebElement Disconnection=element("classname", "c16");
		click(Disconnection);
		
		//Enter Consumer_id and click enter button
		WebElement consumerid=element("name", "consumerid");
		sendkeys_clickEnter(consumerid, data[0]);
		
		//Select Disconnected Date
		WebElement Click_Disconnected_Date=element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]");
		click(Click_Disconnected_Date);
		WebElement Select_Disconnected_Date=element("xpath", "(//a[@class='ui-state-default'])[2]");
		click(Select_Disconnected_Date);
		
		//Enter Disconnection fees
		WebElement dissConnFees=element("name", "dissConnFees");
		sendkeys(dissConnFees, "500");
		
		//Enter Order no
		WebElement orderNo=element("name", "orderNo");
		sendkeys(orderNo, "12345");
		
		//Select Order date
		WebElement Click_Order_Date =element("xpath", "(//img[@class='ui-datepicker-trigger'])[2]");
		click(Click_Order_Date);
		WebElement Select_Order_Date=element("xpath", "(//a[@class='ui-state-default'])[2]");
		click(Select_Order_Date);
		
		//Select Disconnection Type
		WebElement Disconnection_Type=element("name", "toDisconn");
		selectByVisibleText(Disconnection_Type, "Temporary Disconnection");
		
		//Enter Remarks
		WebElement Remarks=element("name", "diRemarks");
		sendkeys(Remarks, "Temporary Disconnection");
		
		//Click submit button
		WebElement Submit=element("xpath", "//input[@value='Submit']");
		click(Submit);
		
		//Validate disconnection message popup
		WebElement validation=element("xpath", "//font[@color='green']");
		String actual=validation.getText();
		Assert.assertEquals(actual, "Dissconnection Details Inserted Successfully");
		System.out.println("Dissconnection Details Inserted Successfully");
		
		//click Admin
		clickAdmin();
		
		//From date default day 1
		FromDate();
		
		//To date default present day
		ToDate();
		
		//Select Category
		EnterCategory("Disconnection");
		
		//Click submit
		AdminSubmit();
		
		//Click Id
		WebElement ID=element("xpath", "//td[.='"+data[0]+"']/preceding-sibling::td/a");
		click(ID);
		
		//Click approve button
		WindowApprove();
	
}
	

}
