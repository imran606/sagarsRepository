package new_user_registration;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Rebate extends New_User_Reg  {
	@DataProvider(name="Rebate")
	public String[][] getData7() throws IOException{
		String[][] excelData7= New_User_Excel.getExcelData("Consumer_Id");
		
		return excelData7;}
	//
	//
	//@Test(dataProvider="Rebate")
	public void rebate(String data[]) throws InterruptedException{
		
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
		WebElement Order_Date2=element("xpath", "(//a[@class='ui-state-default'])[1]");
		click(Order_Date2);
		
		//Enter Remarks
		WebElement reRemarks=element("name", "reRemarks");
		sendkeys(reRemarks, "rebate updated");
		
		//Click submit
		WebElement submit=element("xpath", "//input[@value='Submit']");
		click(submit);
		
		//Validate Rebate data inserted succesfull or not
		String successMessage=element("classname", "successMessage").getText();
		Assert.assertEquals(successMessage, "Rebate data inserted succesfully");
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
	}
		

}
