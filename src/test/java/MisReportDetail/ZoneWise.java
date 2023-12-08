package MisReportDetail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import new_user_registration.New_User_Reg;

public class ZoneWise  extends New_User_Reg{
	
	@Test
	public void zardwise() throws InterruptedException {

		//Click  MIS Reports
		click(element("linkText", "MIS Reports"));

		//Click MIS report detail
		click(element("classname", "c94"));

		
		//click ZoneWise
		click(element("xpath", "(//a[@class='closed'])[4]"));

		//Select From date
		WebElement date1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
		click(date1);

		WebElement date2=element("xpath", "(//a[@class='ui-state-default'])[1]");
		click(date2);
			

		//Select To date
		Thread.sleep(1000);
	    WebElement d1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
	    click(d1);
	    WebElement d2=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
	    click(d2);
		
		//Select Zone
	    Zone("ALL");
		
		//Select reports
	    ZoneReportcategory("Cheque Bounce Report");

		//Enter cutoff value		
	    Zonecutoff("0");

		//Click generate button
	    GenerateZoneReport();

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

		for (String zone : list) {
			
			//click ZoneWise
			click(element("xpath", "(//a[@class='closed'])[4]"));
			
			//Select Zone
		    Zone("ALL");
			
			//Select reports
		    ZoneReportcategory(zone);

			//Click generate button
		    GenerateZoneReport();
		}

	}

}
