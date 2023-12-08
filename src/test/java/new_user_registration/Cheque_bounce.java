package new_user_registration;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Cheque_bounce extends New_User_Reg {
	@DataProvider(name="Cheque")
	public String[][] getData11() throws IOException{
		String[][] excelData11= New_User_Excel.getExcelData("Consumer_Id");
		
		return excelData11;
		}
    //
	//
	@Test(dataProvider="Cheque")
	public void cheque(String data[]) throws InterruptedException{
		
		//Click Revenue Management
		WebElement revenue_management=element("linkText", "Revenue Management");
		click(revenue_management);
		
		//Click cheque bounce
		WebElement rebate=element("xpath", "//a[@class='c14']");
		click(rebate);
		
		//Enter consumer id and click
		sendkeys_clickEnter(element("name", "consumerId"), data[0]);
		
		//Click Id
		click(element("xpath", "//a[.='"+data[3]+"']"));
		
		//Enter Order Number 
		sendkeys(element("name", "chqOrderNo"), "12345");
		
		//Enter Cheque Bounce charges
		sendkeys(element("name", "chequeCharge"), "60");
		
		//Date Effect
		WebElement Cheque  =element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		click(Cheque);
		WebElement Cheque2=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
		click(Cheque2);
		
		//Enter Remarks
		sendkeys(element("name", "remarks"), "cheque bounce success");
		
		//Click submit
		click(element("xpath", "//input[@value='Submit']"));
		
		//validate
		String successMessage=element("classname", "successMessage").getText();
		Assert.assertEquals(successMessage, "Cheque Bounce Details Inserted Successfully");
		System.out.println("Cheque Bounce Details Inserted Successfully");
		
		//
		clickAdmin();
		
		//
		FromDate();
		
		//
		ToDate();
		
		//
		EnterCategory("Cheque Bounce");
		
		//
		AdminSubmit();
		
		//Click id
		click(element("xpath", "//td[.='"+data[0]+"']/preceding-sibling::td/a"));
		
		//
		WindowApprove();
		
	}

}
