package new_user_registration;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.TesseractException;

public class User_Management extends New_User_Reg {
	@DataProvider(name="User_Management")
	public String[][] getData9() throws IOException{
		String[][] excelData9= New_User_Excel.getExcelData("EMPLOYEES_NEW");
		
		return excelData9;
		}
	
    //
	//
	@Test(dataProvider="User_Management")
	public void user_management(String data[]) throws InterruptedException{
		
		//Click user management
		click(element("linkText", "User Management"));
		
		//Select desingation
		WebElement desingation=element("name", "desingation");
		selectByVisibleText(desingation, data[0]);
		
		//Select counter
		WebElement counter=element("name", "counter");
		selectByVisibleText(counter, "UBARMS-Billing");
		
		//Enter Employee Name
		sendkeys(element("name", "loginName"), data[1]);
		
		//Enter password
		sendkeys(element("name", "passwordu"), data[2]);
		
		//Enter contactNo
		sendkeys(element("name", "contactNo"), "1234567898");
		
		//select  Create Date 
		click(element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]"));
		click(element("xpath", "(//a[@class='ui-state-default'])[1]"));
		
		//Enter remarks
		sendkeys(element("name", "remarks"), data[3]);
		
		//Select userRoll
		WebElement userRoll=element("name", "userRoll");
		selectByVisibleText(userRoll, "ADMIN");
		
		//Enter User Name
		sendkeys(element("name", "userNameu"), data[1]);
		
		//Enter Confirm Password
		sendkeys(element("name", "confirmPassword"), data[2]);
		
		//Enter emailId
		sendkeys(element("name", "emailId"), data[4]);
		
		//Enter Password Hint 
		sendkeys(element("name", "passwordHint"), data[5]);
		
		//Click Submit
		click(element("xpath", "//input[@value='Submit']"));
		
		//Validate wheater user created or not
		String User_Created=element("classname", "successMessage").getText();
		Assert.assertEquals(User_Created, "User Created Successfully");
		
		//Click sign out button
		click(element("xpath", "//img[@title='SignOut']"));
		
		//Click Billing img
		click(element("id", "slidesli"));
		
		//Enter login name
		clear_text_and_type(element("name", "userName"), data[1]);
		
		//Enter password
		clear_text_and_type(element("name", "password"), data[2]);
		
		//Click Login button
		click(element("classname", "loginbutton"));
		
		//validate right user logged or not
		String value=element("name", "loginUser").getAttribute("value");
		Assert.assertEquals(value, data[1]);
		System.out.println("New User able to login");
	
	}

}
