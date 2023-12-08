package new_user_registration;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Wrong_Posting extends New_User_Reg{
	@DataProvider(name="Wrong_Posting")
	public String[][] getData11() throws IOException{
		String[][] excelData11= New_User_Excel.getExcelData("Wrong_posting");
		
		return excelData11;
		}
	@Test(dataProvider="Wrong_Posting")
	public void wrong_posting(String data[]) throws InterruptedException{
		
		//Click Revenue Management
		WebElement revenue_management=element("linkText", "Revenue Management");
		click(revenue_management);
		
		//Click Wrong posting
		WebElement wrong_posting=element("xpath", "//a[@class='c13']");
		click(wrong_posting);
		
		
		//Enter From consumer id
		sendkeys_clickEnter(element("name", "fromConsumerId"), data[0]);
		
		//Click Id
		click(element("xpath", "//a[.='"+data[1]+"']"));
		
		//Enter Remarks
		sendkeys(element("name", "remarks"), "Transfer 1");
		
		//Select Date effect
		WebElement Date_Effect1 =element("xpath", "(//img[@class='ui-datepicker-trigger'])[2]");
		click(Date_Effect1);
		WebElement Date_Effect2=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
		click(Date_Effect2);
		
		//To Consumer ID
		sendkeys_clickEnter(element("name", "toConsumerId"), data[2]);
		
		//Click Transfer button
		click(element("xpath", "//input[@value='Transfer']"));
		
		//Validate
		String successMessage=element("classname", "successMessage").getText();
		Assert.assertEquals(successMessage, "Wrong Posting Details Inserted Successfully");
		System.out.println("Wrong Posting Details Inserted Successfully");
		
		//click admin
		clickAdmin();
		
		//
		FromDate();
		
		//
		ToDate();
		
		//
		EnterCategory("Wrong Posting");
		
		//
		AdminSubmit();
		
		//Click Id
		WebElement ID=element("xpath", "//td[.='"+data[0]+"']/preceding-sibling::td/a");
		click(ID);
		
		//
		WindowApprove();
	}

}
