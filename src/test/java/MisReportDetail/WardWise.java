package MisReportDetail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import new_user_registration.New_User_Reg;

public class WardWise extends New_User_Reg{

	@Test
	public void Wardwise() throws InterruptedException {

		//Click  MIS Reports
		click(element("linkText", "MIS Reports"));

		//Click MIS report detail
		click(element("classname", "c94"));
		
		//click WardWise
		click(element("xpath", "(//a[@class='closed'])[3]"));

		//Select From date
		WebElement date1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
		click(date1);

		WebElement date2=element("xpath", "(//a[@class='ui-state-default'])[1]");
		click(date2);
			

		//Select To date
		Thread.sleep(1000);
	    WebElement d1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
	    click(d1);
	    WebElement d2=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
	    click(d2);
		
		//Select ward no
	    WardNo("All");
		
		//Select reports
	    WardNoReportcategory("Cheque Bounce Report");

		//Enter cutoff value		
	    WardNocutoff("0");

		//Click generate button
	    GenerateWardNoReport();

		List<String> list = new ArrayList<String>();
		//list.add("Cheque Bounce Report");
		//list.add("Daily Billed Consumer Report");
		list.add("Deposit Colletion Report");
		list.add("Disconnection Report");
		list.add("Interest Waveoff Report");
		list.add("Khata Change Report");
		//list.add("New Consumer Report");
		list.add("Rebate Report");
		list.add("Reconnection Report");
		list.add("Tariff Change Report");
		//list.add("Unbilled Consumer Report");

		for (String WardNo : list) {
			
			
			//click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));
			
			//Select Ward No 
			WardNo("All");

			//Select reports
			WardNoReportcategory(WardNo);

			//Click generate button
			GenerateWardNoReport();	
		}

	}

}
