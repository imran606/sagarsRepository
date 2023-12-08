package CashCounter;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import new_user_registration.New_User_Reg;

public class CashCounterMisReport  extends New_User_Reg{
	@Test
	public void CashCounterReport() throws InterruptedException {
		
		//Select counter
		WebElement counterSelect=element("name", "counter");
		selectByVisibleText(counterSelect, "Counter9");

		//Enter Username
		sendkeys(element("name", "userName"), "SHARAT");

		//Enter Password
		sendkeys(element("name", "password"), "SHARAT");

		//click login
		click(element("xpath", "//input[@value='Log in']"));
		
		//click MIS Report
		click(element("linkText", "MIS Report"));

		//Select From date
		WebElement date1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]");
		click(date1);

		WebElement date2=element("xpath", "(//a[@class='ui-state-default'])[1]");
		click(date2);
			

		//Select To date
		Thread.sleep(1000);
	    WebElement d1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[2]");
	    click(d1);
	    WebElement d2=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
	    click(d2);
				
		List<String> list = new ArrayList<String>();
		list.add("Daily");
		list.add("Monthly");
		list.add("Yearly");
		
		for (String report : list) {
			
			//Select report type
			WebElement reportType=element("name", "reportType");
			selectByVisibleText(reportType, report);
			
			//Select report
			WebElement reportName=element("name", "reportName");
			selectByVisibleText(reportName, "Cash Collected Summary");
			
			
			//click generate button
			click(element("name", "method"));
		
			
			//Select report type
			WebElement reportType1=element("name", "reportType");
			selectByVisibleText(reportType1, report);
			
			//Select report
			WebElement reportName1=element("name", "reportName");
			selectByVisibleText(reportName1, "Cash Cancelled Summary");
			
			//click generate button
			click(element("name", "method"));
		
			
			//Select report type
			WebElement reportType2=element("name", "reportType");
			selectByVisibleText(reportType2, report);
			
			//Select report
			WebElement reportName2=element("name", "reportName");
			selectByVisibleText(reportName2, "HeadWise Cash Summary");
			
			//click generate button
			click(element("name", "method"));
			
		}
		
	}


}
