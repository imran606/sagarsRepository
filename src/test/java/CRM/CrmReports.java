package CRM;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import new_user_registration.New_User_Reg;

public class CrmReports  extends New_User_Reg{
	
	@Test
	public void crmReport() throws InterruptedException {
		
		//Click MIS Reports
		click(element("linkText", "MIS Reports"));
		
		//select from date
		FromDate();
		
		//select to date
		ToDate();
		
		//select category
		WebElement category=element("name", "category");
		selectByVisibleText(category, "ComplaintRegistered");
		
		//select type
		WebElement type=element("name", "type");
		selectByVisibleText(type, "Daily");
		
		//select department
		WebElement reportName=element("name", "reportName");
		//selectByVisibleText(reportName, "MAHALAKSHMI NAGARA");
		
		//Click generate
		click(element("xpath", "//input[@value='Generate']"));
		
	}

}
