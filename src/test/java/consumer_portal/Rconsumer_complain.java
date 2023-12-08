package consumer_portal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import new_user_registration.New_User_Excel;
import new_user_registration.New_User_Reg;

public class Rconsumer_complain extends New_User_Reg {
	
	@DataProvider(name="Rconsumer_complaint")
	public String[][] getData20() throws IOException{
		String[][] excelData20= New_User_Excel.getExcelData("Form");
		
		return excelData20;
		}

	@BeforeClass
	public void form() {
		//click consumer portal
		click(element("linkText", "Consumer Portal"));
	}
		
	@Test(dataProvider="Rconsumer_complaint")
	public void publicCompaint(String data[]) throws InterruptedException {
		
		//Enter Consumer Id
		sendkeys(element("name", "username"), data[0]);
		
		//Enter Password
		sendkeys(element("name", "password"), "user");
		
		//Enter Login
		click(element("xpath", "//img[@alt='login']"));
		
		//Click Register Complaint
		click(element("xpath", "//img[@alt='Register Complaint']"));
		
		//Enter Address
		sendkeys(element("name", "address"), data[3]);
		
		//Select complaint type
		WebElement complaintType=element("name", "complaintType");
		selectByVisibleText(complaintType, data[4]);
		
		//Describe your complaint
		sendkeys(element("name", "complaintDetails"), data[5]);
		
		//click register
		click(element("name", "method"));
		
		//validation
		String success=element("xpath", "//div[contains(text(), 'Complaint Registered Successfully')]").getText();
		if(success.contains("Complaint Registered Successfully")) {
			System.out.println("Complaint Registered Successfully for consumer Id: "+data[0]+"");
		}
		
		//click signout
		click(element("xpath", "//img[@alt='exit']"));

	}
	

}
