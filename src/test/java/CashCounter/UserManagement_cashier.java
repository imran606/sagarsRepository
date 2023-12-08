package CashCounter;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import new_user_registration.New_User_Excel;
import new_user_registration.New_User_Reg;

public class UserManagement_cashier extends New_User_Reg{
	@DataProvider(name="User_Management_Cashier")
	public String[][] getData30() throws IOException{
		String[][] excelData30= New_User_Excel.getExcelData("CashierData");
		
		return excelData30;
		}
	
    //
	//
	//@Test(dataProvider="User_Management_Cashier", enabled=false)
	public void user_management_cashier(String data[]) throws InterruptedException{
		
		//Click user management
		click(element("linkText", "User Management"));
		
		//Select desingation
		WebElement desingation=element("name", "desingation");
		selectByVisibleText(desingation, data[0]);
		
		//Select counter
		WebElement counter=element("name", "counter");
		selectByVisibleText(counter, data[6]);
		
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
		selectByVisibleText(userRoll, "CASHIER");
		
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
		//click(element("xpath", "//img[@title='SignOut']"));
		

}
	@Test(dataProvider="User_Management_Cashier")
	public void CashCounter(String data[]) {

		//Click cash counter
		//click(element("id", "crmli"));
		
		//Select counter
		WebElement counterSelect=element("name", "counter");
		selectByVisibleText(counterSelect, data[6]);
		
		//Enter Username
		sendkeys(element("name", "userName"), data[1]);
		
		//Enter Password
		sendkeys(element("name", "password"), data[2]);
		
		//click login
		click(element("xpath", "//input[@value='Log in']"));
		
		//Validate the username
		String Username=element("name", "loginUser").getAttribute("value");
		Assert.assertEquals(Username, data[1]);
		
		//validate counter
		String counterName=element("name", "counterName").getAttribute("value");
		Assert.assertEquals(counterName, data[6]);
		
		//
		click(element("xpath", "//img[@title='SignOut']"));
		
	}
}
