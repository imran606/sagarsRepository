package MisReportDetail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import new_user_registration.New_User_Reg;

public class LNTReport extends New_User_Reg {
	

	@Test
	public void Lnt_Report() throws InterruptedException {

		//Click  MIS Reports
		click(element("linkText", "MIS Reports"));

		//Click MIS report detail
		click(element("classname", "c94"));

		
		//click ZoneWise
		click(element("linkText", "LNT Report"));

		//Select From date
		WebElement date1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[11]");
		click(date1);

		WebElement date2=element("xpath", "(//a[@class='ui-state-default'])[1]");
		click(date2);
			

		//Select To date
		Thread.sleep(1000);
	    WebElement d1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[12]");
	    click(d1);
	    WebElement d2=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
	    click(d2);
		
		//Select billed
	    billed("ALL");
	    
		//Select reports
	    LNTReportcategory("Daily Billed Consumer Report");

		//Click generate button
	    GenerateLNTReport();


	}

}
