package MisReportDetail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import new_user_registration.New_User_Reg;

public class MRWise extends New_User_Reg {
	

	@Test
	public void Mr_Wise() throws InterruptedException {

		//Click  MIS Reports
		click(element("linkText", "MIS Reports"));

		//Click MIS report detail
		click(element("classname", "c94"));
		
		//click MR wise
		click(element("xpath", "(//a[@class='closed'])[1]"));

		//Select From date
	    WebElement date1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
	    click(date1);
	   
	    WebElement date2=element("xpath", "(//a[@class='ui-state-default'])[1]");
	    click(date2);
		
		//Select To date
		Thread.sleep(1000);
	    WebElement d1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[4]");
	    click(d1);
	    WebElement d2=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
	    click(d2);
		
		//Select MR id
		Mrid("All");
		
		//Select reports
		MRidReportcategory("Cheque Bounce Report");

		//Enter cutoff value		
		Mridcutoff("0");

		//Click generate button
		GenerateMridReport();

		List<String> list = new ArrayList<String>();
		//list.add("Cheque Bounce Report");
		//list.add("Daily Billed Consumer Report");
		list.add("Deposit Colletion Report");
		list.add("Disconnection Report");
		list.add("Interest Waveoff Report");
		list.add("Khata Change Report");
		list.add("Rebate Report");
		list.add("Reconnection Report");
		list.add("Tariff Change Report");
		//list.add("Unbilled Consumer Report");

		for (String Mrid : list) {
			
			//click MR wise
			click(element("xpath", "(//a[@class='closed'])[1]"));
			
			//Select Mrid 
			Mrid("All");

			//Select reports
			MRidReportcategory(Mrid);

			//Click generate button
			GenerateMridReport();	
		}

	}

}
