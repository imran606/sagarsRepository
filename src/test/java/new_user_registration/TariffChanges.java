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

public class TariffChanges extends New_User_Reg{
	@DataProvider(name="TariffChange")
	public String[][] getData3() throws IOException{
		String[][] excelData3= New_User_Excel.getExcelData("Consumer_Id");
		
		return excelData3;
	}
	@Test(dataProvider="TariffChange")
	public void Tariff_Change(String data[]) throws InterruptedException {

		//Click Consumer Management
		WebElement Consumer_Management=element("linkText", "Consumer Management");
		click(Consumer_Management);

		//Click Tariff changes
		WebElement Tariff_changes=element("xpath", "//a[@class='c4']");
		click(Tariff_changes);

		//Enter consumer id
		WebElement tConsumerId=element("name", "tConsumerId");
		sendkeys_clickEnter(tConsumerId, data[0]);

		//Select new Tariff 
		WebElement Tariff_new=element("name", "newtariff");
		selectByVisibleText(Tariff_new, "COMMERCIAL");

		//Select Authorized Date
		FromDate();

		//Select Authorized By
		WebElement approvedBy=element("name", "approvedBy");
		selectByVisibleText(approvedBy, "EE");

		//Enter Order Number 
		WebElement orderNumberA=element("name", "orderNumberA");
		sendkeys(orderNumberA, "54321");

		//Enter Remarks
		WebElement tRemarks=element("name", "tRemarks");
		sendkeys(tRemarks, "tariffchanged2");

		//Click Submit
		WebElement submit=element("xpath", "//input[@value='Submit']");
		click(submit);

		//validate tariff changes success or failure
		WebElement tariff=element("xpath", "//font[@color='green']");
		String tv2=tariff.getText();
		Assert.assertEquals(tv2, "Tariff Changes Data Submitted Successfully");

		//Click Admin button 
		clickAdmin(); 

		//Waiting for approvals-->From Date
		FromDate();

		//Select To Date
		ToDate();

		//Select Category
		EnterCategory("Tariff change");

		//Click submit button
		AdminSubmit();

		//Click consumer Id
		WebElement consumer_id=element("xpath", "//a[.='"+data[0]+"']");
		click(consumer_id);

		//windowApprove
		WindowApprove();
	}

}
