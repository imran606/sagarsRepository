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

public class KhataChanges extends New_User_Reg {
	@DataProvider(name="KhataChanges")
	public String[][] getData2() throws IOException{
		String[][] excelData2= New_User_Excel.getExcelData("Consumer_Id");
		
		return excelData2;
	}
	@Test(dataProvider="KhataChanges")
	public void khata_changes(String data[]) throws InterruptedException {
		
		//Click Consumer Management
		WebElement Consumer_Management=element("linkText", "Consumer Management");
		click(Consumer_Management);
		
		//Click Khata changes
		WebElement khata_changes=element("xpath", "//a[@class='c3']");
		click(khata_changes);
		
		//Enter consumer id
		WebElement ConsumerId=element("name", "consumerid");
		sendkeys_clickEnter(ConsumerId, data[0]);
		
		//Enter first name
		WebElement conNewFirstName=element("name", "conNewFirstName");
		sendkeys(conNewFirstName, "surya");
		
		//Enter last name
		WebElement conNewLastName=element("name", "conNewLastName");
		sendkeys(conNewLastName, "y");
		
		//Select RelationType
		WebElement conNewRtype=element("name", "conNewRtype");
		selectByVisibleText(conNewRtype, "D/O");
		
		//Enter Relation name
		WebElement conNewRname=element("name","conNewRname");
		sendkeys(conNewRname, "brother");
		
		//Select Gender
		WebElement newConsGender=element("name", "newConsGender");
		selectByVisibleText(newConsGender, "Male");
		
		//Select Enter Date
		FromDate();
        
        //Enter Order no
        WebElement orderNumber=element("name", "orderNumber");
        sendkeys(orderNumber, "98765");
        
        //Select Order Date 
        ToDate();
        
        //Select Authorized By 
        WebElement approvedby=element("name", "approvedby");
        selectByVisibleText(approvedby, "Junior Engineer");
        
        //Select Document Upload Type
        WebElement docupload=element("name", "docupload");
        selectByVisibleText(docupload, "Driving License");
        
        //Enter Remarks
        WebElement remarksnew=element("name", "remarksnew");
        sendkeys(remarksnew, "changed2");
        
        //Click submit
        WebElement submit=element("xpath", "//input[@value='Submit']");
        click(submit);
        
        //validate khata changes
        String v=element("xpath", "//font[@color='green']").getText();
        Assert.assertEquals(v, "Khata Changes Data Submitted Successfully");
        System.out.println("khata changed");
        
        //Click Admin button
        clickAdmin();
        
        //Waiting for approvals-->From Date
        FromDate();
        
        //Select To Date
        ToDate();
        
        //Select Category
        EnterCategory("Khata change");
        
        //Click submit button
        AdminSubmit();
        
        //Click consumer Id
        WebElement consumer_Id=element("xpath", "//a[.='"+data[0]+"']");
        click(consumer_Id);
        
        //
        WindowApprove();
	}

}
