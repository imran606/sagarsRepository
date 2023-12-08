package new_user_registration;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DepositDetails extends New_User_Reg{
	@DataProvider(name="DepositDetails")
	public String[][] getData4() throws IOException{
		String[][] excelData4= New_User_Excel.getExcelData("Consumer_Id");
		
		return excelData4;}
	@Test(dataProvider="DepositDetails")
	public void Deposit_Details(String data[]) throws InterruptedException {
		
		//Click Consumer Management
		WebElement Consumer_Management= element("linkText", "Consumer Management");
		click(Consumer_Management);
		
		//Click Deposit details
		WebElement deposit_details=element("xpath", "//a[@class='c5']");
		click(deposit_details);
		
		//Enter consumer id
		WebElement dconsumerid=element("name", "dconsumerid");
		sendkeys_clickEnter(dconsumerid, data[0]);
		
		//Select Deposit Type 
		WebElement depositType=element("name", "depositType");
		selectByVisibleText(depositType, "Bill");
		
		//Select Deposit Date
	    FromDate();
	    
	    //Enter Deposit Amount
	    WebElement depositeAmount=element("name", "depositeAmount");
	    sendkeys(depositeAmount, "1500");
	    
	    //Enter Remarks
	    WebElement dRemarks=element("name", "dRemarks");
	    sendkeys(dRemarks, "Deposit Details changed");
	    
	    //Click submit button
	    WebElement submit=element("xpath", "//input[@value='Submit']");
	    click(submit);
	    
	    //Validate deposit success message
	    WebElement successMessage=element("classname", "successMessage");
	    String DD=successMessage.getText();
	    Assert.assertEquals(DD, "Deposit Details Inserted Successfully");
	    System.out.print("Deposit Details Inserted Successfully");

}
}
