package MisReportDetail;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import new_user_registration.New_User_Reg;

public class TariffWise extends New_User_Reg{
	
	@Test
	public void Tariff_wise() throws InterruptedException{

		//Click  MIS Reports
		click(element("linkText", "MIS Reports"));
		
		//Click MIS report detail
		click(element("classname", "c94"));
		
		//Select From date
		FromDate();
		
		//Select To date
		ToDate();
		
		//Select Tariff 
		Tariff("All");
		
		//Select reports
		TariffReportcategory("Cheque Bounce Report");

		//Enter cutoff value		
		Tariffcutoff("0");

		//Click generate button
		GenerateTariffReport();
				
		
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
		
		for (String Tariff : list) {
			//Select Tariff 
			Tariff("All");
			
			//Select reports
			TariffReportcategory(Tariff);
			
			//Click generate button
			GenerateTariffReport();	
		}
		

}
}