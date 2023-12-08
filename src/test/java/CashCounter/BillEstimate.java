package CashCounter;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import new_user_registration.New_User_Excel;
import new_user_registration.New_User_Reg;

public class BillEstimate  extends New_User_Reg{
	@DataProvider(name="BillEstimate")
	public String[][] getData31() throws IOException{
		String[][] excelData31= New_User_Excel.getExcelData("ConsumerIdBill");
		
		return excelData31;
		}
	
	//
	//
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

		//Click Bill Estimate
		click(element("linkText", "Bill Estimate"));
	}
	
	@Test(dataProvider="BillEstimate")
	public void BillEstimation(String data[]) throws InterruptedException{
		//Enter consumerId and click Enter
		clear_text_and_type_clickEnter(element("name", "consumerId"), data[0]);
		
		//Previous Reading
		String previousRead=element("name", "previousRead").getAttribute("value");
		int previous=Integer.parseInt(previousRead);
		int presentRead=previous+Integer.parseInt(data[1]);
		String s=String.valueOf(presentRead);
		
		//Enter present reading
		clear_text_and_type(element("name", "presentRead"), s);
		
		//click calculate
		click(element("name", "method"));
		
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
		
	}

}
