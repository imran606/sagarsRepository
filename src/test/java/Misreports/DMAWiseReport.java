package Misreports;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import new_user_registration.New_User_Reg;

public class DMAWiseReport  extends New_User_Reg{
	
	@Test
	public void DMAWise() throws InterruptedException {

		//Click  MIS Reports
		click(element("linkText", "MIS Reports"));

		//Click MIS Report Abstract
		click(element("classname", "c44"));
		
		//click DMA NO
		click(element("xpath", "(//a[@class='closed'])[2]"));

		//Select From date
		WebElement date1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
		click(date1);

		WebElement date2=element("xpath", "(//a[@class='ui-state-default'])[1]");
		click(date2);
			

		//Select To date
		Thread.sleep(1000);
	    WebElement d1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
	    click(d1);
	    WebElement d2=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
	    click(d2);
		
		//Select DMA_NO
		DMA_No("All");
		
		//Select reports
		DMA_NoReportcategory("Cheque Bounce Report");

		//Enter cutoff value		
		DMA_Nocutoff("0");

		//Click generate button
		GenerateDMA_NoReport();

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

		for (String DMA : list) {
			
			//click DMA NO
			click(element("xpath", "(//a[@class='closed'])[2]"));
			
			//Select DMA No
			DMA_No("All");

			//Select reports
			DMA_NoReportcategory(DMA);

			//Click generate button
			GenerateDMA_NoReport();	
		}

	}

}
