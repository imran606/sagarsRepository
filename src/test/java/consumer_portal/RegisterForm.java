package consumer_portal;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import new_user_registration.New_User_Excel;
import new_user_registration.New_User_Reg;

public class RegisterForm extends New_User_Reg{
	@DataProvider(name="RegisterForm")
	public String[][] getData20() throws IOException{
		String[][] excelData20= New_User_Excel.getExcelData("Form");
		
		return excelData20;
		}
	
	
	@BeforeClass
	public void form() {
		//click consumer portal
		click(element("linkText", "Consumer Portal"));

		//click public complain
		click(element("linkText", "Registration Form"));
	}
		
	@Test(dataProvider="RegisterForm")
	public void publicCompaint(String data[]) throws InterruptedException {

		//Enter consumer id and click enter
		sendkeys_clickEnter(element("name", "consumerId"), data[0]);

		//Enter RR number (Electricity)
		sendkeys(element("name", "rrnumber"), data[1]);

		//select Ward number
		WebElement wardnumber=element("name", "wardnumber");
		selectByVisibleText(wardnumber, data[2]);

		//Enter Address
		sendkeys(element("name", "address"), data[3]);

		//click Register button
		click(element("name", "method"));

		//validation
		String successMessage=element("xpath", "//span[.='Consumer Registration Successfull...']").getText();
		Assert.assertEquals(successMessage, "Consumer Registration Successfull...");
		System.out.println("Consumer Registration Successfull...");

	}

}
