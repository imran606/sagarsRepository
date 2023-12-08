package CashCounter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import new_user_registration.New_User_Excel;
import new_user_registration.New_User_Reg;

public class RunAllCashCounter extends New_User_Reg{
	
	@DataProvider(name="RunAll_CC")
	public String[][] getData50() throws IOException{
		String[][] excelData50= New_User_Excel.getExcelData("RunAllCashCounter");
		
		return excelData50;
		}
	
	@BeforeClass
	public void cashcounter1() {
		
		//Select counter
		WebElement counterSelect=element("name", "counter");
		selectByVisibleText(counterSelect, "Counter1");

		//Enter Username
		sendkeys(element("name", "userName"), "CASH1");

		//Enter Password
		sendkeys(element("name", "password"), "Cash1@123");
		
		//click login
		click(element("xpath", "//input[@value='Log in']"));
	}
	@Test(dataProvider="RunAll_CC")
	public void RunAll_CashCounter(String data[]) throws InterruptedException {
		
		//Enter consumer Id and click enter
		sendkeys_clickEnter(element("name", "consumerid"), data[0]);
		
		//Get Receipt No
		String RN=element("name", "receiptNo").getAttribute("value");

		//Select payment Towards
		WebElement paymentTowards=element("name", "paymentTowards");
		selectByVisibleText(paymentTowards, data[1]);

		//Select paymentMode
		WebElement paymentMode=element("name", "paymentMode");
		selectByVisibleText(paymentMode, data[2]);

		if(data[2].equals("Cheque") || data[2].equals("DD")) {

			//Enter Cheque /DD / MO No
			sendkeys(element("name", "checkDDNo"), "123456789");

			//select Cheque / DD/ MO Date date==1
			FromDate();

			//select Bank Name
			WebElement bankName=element("name", "bankName");
			selectByVisibleText(bankName, "Bank Of Baroda");

		}

		//Enter Amount
		sendkeys( element("name", "amountPaid"), data[3]);

		//Click Add
		click(element("xpath", "//input[@value='Add']"));
		
		//click account history
		click(element("xpath", "(//a[@class='menuitem'])[3]"));
		
		//Enter consumer id and click enter
		sendkeys_clickEnter(element("name", "consumerId"),data[0]);
		Thread.sleep(2000);
		
		//Scroll till device history visible
		WebElement DeviceHistory=element("xpath", "//div[contains(text(), 'Device History')]");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",DeviceHistory);
		Thread.sleep(2000);
		
		//click consumer information
		click(element("xpath", "(//a[@class='menuitem'])[4]"));
		
		//Enter consumer id and click enter
		sendkeys_clickEnter(element("xpath", "(//input[@value='Enter ConsumerID Here'])[1]"), data[0]);
		
		//
		click(element("xpath", "//a[@rel='2']"));
		Thread.sleep(1000);
		click(element("xpath", "//a[@rel='3']"));
		Thread.sleep(1000);
		click(element("xpath", "//a[@rel='4']"));
		Thread.sleep(1000);
		click(element("xpath", "//a[@rel='5']"));
		Thread.sleep(1000);
		
		//Click Bill Estimate
		click(element("linkText", "Bill Estimate"));
		
		//Enter consumerId and click Enter
		clear_text_and_type_clickEnter(element("name", "consumerId"), data[0]);

		//Previous Reading
		String previousRead=element("name", "previousRead").getAttribute("value");
		int previous=Integer.parseInt(previousRead);
		int presentRead=previous+Integer.parseInt(data[4]);
		String s=String.valueOf(presentRead);

		//Enter present reading
		clear_text_and_type(element("name", "presentRead"), s);

		//click calculate
		click(element("name", "method"));
		Thread.sleep(3000);

		//validate consumption amount
		String consumption=element("name", "consumption").getAttribute("value");
		int consumptionAmount=Integer.parseInt(consumption);

		int result= presentRead-previous;
		Assert.assertEquals(consumptionAmount, result);
		System.out.println("Showing correct consumption amount");

		//validate Estimated Water Charge
		String tariffType=element("name", "tariffType").getAttribute("value");
		String Estimated_Water_Charge=element("name", "amount").getAttribute("value");
		int i=Integer.parseInt(Estimated_Water_Charge); 

		if (tariffType.equals("DOMESTIC")) { 
			if (i>=56) {
				System.out.println("Minimum Amount for Domestic is correct || consumerId: "+data[0]+"");
			}
			else {
				System.err.println("Minimum Amount for Domestic is Incorrect || consumerId: "+data[0]+"");}
		}
		else if(tariffType.equals("NON DOMESTIC")) {
			if (i>=112) {
				System.out.println("Minimum Amount for Non Domestic is correct || consumerId: "+data[0]+"");
			}
			else {
				System.err.println("Minimum Amount for Non Domestic is Incorrect || consumerId: "+data[0]+"");
			}
		}
		else if(tariffType.equals("COMMERCIAL")) {
			if (i>=224) {
				System.out.println("Minimum Amount for Commercial is correct || consumerId: "+data[0]+"");
			}
			else {
				System.err.println("Minimum Amount for Commercial is Incorrect || consumerId: "+data[0]+"");
			}
		}
		
		//click system configuration
		click(element("xpath", "(//a[@class='menuitem'])[6]"));
		Thread.sleep(1000);
		
		//click role master
		click(element("id","allMastersList"));
		Thread.sleep(1000);
		
		//click Receipt cancellations
		click(element("xpath", "(//a[@class='menuitem'])[2]"));
		
		//Enter consumer id and click enter
		sendkeys_clickEnter(element("name", "receiptNo"),RN);
		
		//Enter Remarks
		sendkeys(element("name", "remarks"), "Receipt cancelled");
		System.out.println("Receipt cancelled for consumerId: "+data[0]+"");
		
		//click cancel receipt
		click(element("xpath", "//input[@value='Cancel Receipt']"));
		
		//Accept Alert 
		driver.switchTo().alert().accept();
		
		//Click MIS report
		click(element("xpath", "(//a[@class='menuitem'])[7]"));
		
		List<String> list = new ArrayList<String>();
		list.add("Daily");
		list.add("Monthly");
		list.add("Yearly");
		
		for (String report : list) {

			//select from date
			FromDate();
			
			//select to date
			ToDate();
			
			//select Report type
			WebElement reportType=element("name", "reportType");
			selectByVisibleText(reportType, report);
			
			//click Generate report button
			click(element("xpath", "//input[@value='Generate Report']"));
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/irevColl/reports.do?action=reports&method=display#nbb");
			Thread.sleep(3000);
			
			//select from date
			FromDate();
			
			//select to date
			ToDate();
			
			//select Report type
			WebElement reportType11=element("name", "reportType");
			selectByVisibleText(reportType11, report);

			//Select report
			WebElement reportName1=element("name", "reportName");
			selectByVisibleText(reportName1, "Cash Cancelled Summary");
			
			//click generate button
			click(element("name", "method"));
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/irevColl/reports.do?action=reports&method=display#nbb");
			Thread.sleep(3000);
			
			//select from date
			FromDate();
			
			//select to date
			ToDate();
			
			//select Report type
			WebElement reportType12=element("name", "reportType");
			selectByVisibleText(reportType12, report);
			
			//Select report
			WebElement reportName2=element("name", "reportName");
			selectByVisibleText(reportName2, "HeadWise Cash Summary");
			
			//click generate button
			click(element("name", "method"));
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/irevColl/reports.do?action=reports&method=display#nbb");
			Thread.sleep(3000);
			
		}
			
	}


}
