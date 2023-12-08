package new_user_registration;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Disconnection extends New_User_Reg{
	@DataProvider(name="Disconnection")
	public String[][] getData5() throws IOException{
		String[][] excelData5= New_User_Excel.getExcelData("Consumer_Id");
		
		return excelData5;}
	//
	//
	@Test(dataProvider="Disconnection")
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
		WebElement Select_Order_Date=element("xpath", "(//a[@class='ui-state-default'])[3]");
		click(Select_Order_Date);
		
		//Select Disconnection Type
		WebElement Disconnection_Type=element("name", "toDisconn");
		selectByVisibleText(Disconnection_Type, "Permanent Disconnection");
		
		//Enter Remarks
		WebElement Remarks=element("name", "diRemarks");
		sendkeys(Remarks, "Permanent Disconnection");
		
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