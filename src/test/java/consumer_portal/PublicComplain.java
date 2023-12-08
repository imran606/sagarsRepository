package consumer_portal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import new_user_registration.New_User_Excel;
import new_user_registration.New_User_Reg;

public class PublicComplain extends New_User_Reg {
	@DataProvider(name="public_complaint")
	public String[][] getData20() throws IOException{
		String[][] excelData20= New_User_Excel.getExcelData("public_complain");
		
		return excelData20;
		}
	
	@BeforeClass
	public void complaint() {
		//click consumer portal
		click(element("linkText", "Consumer Portal"));

		//click public complain
		click(element("xpath", "//font[.='Public Complain ']"));
	}
	@Test(dataProvider="public_complaint")
	public void publicCompaint(String data[]) throws InterruptedException {
		
		
		//Enter Name
		sendkeys(element("name", "publicName"), data[0]);
		
		//Enter Email
		sendkeys(element("name", "publicEmail"), data[1]);
		
		//Enter Contact number
		sendkeys(element("name", "publicMobile"), data[2]);
		
		//select complain related to 
		WebElement publicComplainType=element("name", "publicComplainType");
		selectByVisibleText(publicComplainType, data[3]);
		
		//Enter site of action
		sendkeys(element("name", "publicComplainSite"), data[4]);
		
		//Enter complain Details
		sendkeys(element("name", "publicComplainDetail"), data[5]);
		
		//Click Register
		click(element("name", "method"));
		
		//Validation
		String successMessage=element("xpath", "//span[.='Complaint Registered Successfully']").getText();
		Assert.assertEquals(successMessage, "Complaint Registered Successfully");
		System.out.println("Complaint Registered Successfully");
	}
}
