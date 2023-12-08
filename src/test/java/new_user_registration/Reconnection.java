package new_user_registration;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Reconnection extends New_User_Reg {
	@DataProvider(name="Reconnection")
	public String[][] getData6() throws IOException{
		String[][] excelData6= New_User_Excel.getExcelData("Consumer_Id");
		
		return excelData6;}
	//
	//
	@Test(dataProvider="Reconnection")
	public void Re_connection(String data[]) throws InterruptedException {
		
		//Click Meter Management
		WebElement MeterManagement=element("linkText", "Meter Management");
		click(MeterManagement);
		
		//Click Reconnection Option
		WebElement Reconnection=element("classname", "c17");
		click(Reconnection);
		

		//Enter Consumer_id and click enter button
		WebElement consumerid=element("name", "rconsumerid");
		sendkeys_clickEnter(consumerid, data[0]);
		
		//Select Reconnected Date
		WebElement Click_Reconnected_Date=element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]");
		click(Click_Reconnected_Date);
		WebElement Select_Reconnected_Date=element("xpath", "(//a[@class='ui-state-default'])[2]");
		click(Select_Reconnected_Date);
		
		//Enter Reconnection fees
		WebElement ReConnFees=element("name", "reConnFees");
		sendkeys(ReConnFees, "1000");
		
		//Enter Order no
		WebElement orderNo=element("name", "rorderNo");
		sendkeys(orderNo, "12345");
		
		//Select Order date
		WebElement Click_Order_Date =element("xpath", "(//img[@class='ui-datepicker-trigger'])[2]");
		click(Click_Order_Date);
		WebElement Select_Order_Date=element("xpath", "(//a[@class='ui-state-default'])[3]");
		click(Select_Order_Date);
		
		//Select Reconnection Status
		WebElement Reconnection_Type=element("name", "reconnStatus");
		selectByVisibleText(Reconnection_Type, "Live");

		//Enter Remarks
		WebElement Remarks=element("name", "reRemarks");
		sendkeys(Remarks, "Connected");

		//Click submit button
		WebElement Submit=element("xpath", "//input[@value='Submit']");
		click(Submit);
		
		//Validate Reconnection message popup
		WebElement validation=element("xpath", "//font[@color='green']");
		String actual=validation.getText();
		Assert.assertEquals(actual, "Reconnection Details Inserted Successfully");
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
		WebElement ID=element("xpath", "//td[.='"+data[0]+"']/preceding-sibling::td/a");
		click(ID);

		//Click approve button
		WindowApprove();
	}

}
