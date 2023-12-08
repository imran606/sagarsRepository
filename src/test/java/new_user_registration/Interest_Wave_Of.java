package new_user_registration;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Interest_Wave_Of extends New_User_Reg {
	@DataProvider(name="Interest_wave_of")
	public String[][] getData8() throws IOException{
		String[][] excelData8= New_User_Excel.getExcelData("Consumer_Id");
		
		return excelData8;}
	//
	//
	@Test(dataProvider="Interest_wave_of")
	public void interest(String data[]) throws InterruptedException{
		//Click Revenue Management
		WebElement revenue_management=element("linkText", "Revenue Management");
		click(revenue_management);
		
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
		WebElement Order_Date1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]");
		click(Order_Date1);
		WebElement Order_Date2=element("xpath", "(//a[@class='ui-state-default'])[2]");
		click(Order_Date2);
		
		//Enter Remarks
		WebElement waRemarks=element("name", "waRemarks");
		sendkeys(waRemarks, "interest wave updated2");
		
		//Click submit
		WebElement sub=element("xpath", "//input[@value='Submit']");
		click(sub);
		
		//Validate Interest Wave-off data inserted succesfull or not
		String successMessage=element("classname", "successMessage").getText();
		Assert.assertEquals(successMessage, "Interest Wave-off data inserted succesfully");
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
		WebElement ID=element("xpath", "//td[.='"+data[0]+"']/preceding-sibling::td/a");
		click(ID);

		//Click approve button
		WindowApprove();
				
				
		
	}
}
