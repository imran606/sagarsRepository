 
package CRM;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import new_user_registration.New_User_Excel;
import new_user_registration.New_User_Reg;

public class Consumer_complaint extends New_User_Reg{
	
	@DataProvider(name="Consumer_complaint")
	public String[][] getData20() throws IOException{
		String[][] excelData20= New_User_Excel.getExcelData("consumer_complaints");
		
		return excelData20;
		}
	
	@Test(dataProvider="Consumer_complaint")
	public void consumer_complaint(String data[]) throws InterruptedException {
		
		//click Consumer Complaint
		click(element("linkText", "Consumer Complaint"));
		
		//click next button
		click(element("linkText", "Next"));
		
		//select Complaint Type
		WebElement Complaint_Type=element("name", "complaintType");
		selectByVisibleText(Complaint_Type, "Consumer Complaint");
		
		//Enter consumer id
		sendkeys_clickEnter(element("name", "conId"), data[0]);
		
		//Enter main
		sendkeys(element("name", "main"), "6");
		
		//Enter landMark//
		sendkeys(element("name", "landMark"), data[1]);
		
		//select serviceLocation//
		WebElement serviceLocation=element("name", "serviceLocation");
		selectByVisibleText(serviceLocation, data[2]);
		
		
		//Click next button
		WebElement next=element("linkText", "Next");
		scroll(next);
		Thread.sleep(3000);
		scroll(next);
		
		//Enter Contact No Mobile//
		clear_text_and_type(element("name", "mobileNo"), data[3]);
		
		//select regComplaint//
		WebElement regComplaint=element("name", "regComplaint");
		selectByVisibleText(regComplaint, data[4]);
		
		//select Functional Business Department  //
		WebElement funBusDep=element("name", "funBusDep");
		int j = Integer.parseInt(data[5]);
		selectByIndex(funBusDep,j);
		
		
		//select complaintCategory department
		WebElement complaintCategory=element("name", "complaintCategory");
		selectByVisibleText(complaintCategory, data[6]);
		
		//select subcategory
		WebElement subCategory=element("name", "subCategory");
		selectByVisibleText(subCategory, data[7]);  
		
		//Enter Complaint Details 
		sendkeys(element("name", "complaintDesc"), data[8]);
		
		//select Job Code
		WebElement slgJobCode=element("name", "slgJobCode");
		selectByVisibleText(slgJobCode, data[9]);
		
		//Enter vehicleNo
		sendkeys(element("name", "vehicleNo"), data[10]);
		
		//Click next button
		WebElement next1=element("linkText", "Next");
		scroll(next1);
		Thread.sleep(3000);
		scroll(next1);
		Thread.sleep(3000);
		scroll(next1);
		
		//Upload Files
		WebElement fileOne=element("name", "fileOne");
		fileOne.sendKeys(getFile("TestDocument.docx"));
		
		
		WebElement fileTwo=element("name", "fileTwo");
		fileTwo.sendKeys(getFile("TestDocument.pdf"));
		
		WebElement fileThree=element("name", "fileThree");
		fileThree.sendKeys(getFile("TestDocument.xlsx"));
		
		WebElement fileFour=element("name", "fileFour");
		fileFour.sendKeys(getFile("NewMeter.png"));
		
		//click finish button
		WebElement fb=element("classname", "buttonFinish");
		scroll(fb);
		
		//
		String successMessage=element("classname", "successMessage").getText();
		StringBuilder number = new StringBuilder();

		for (int i = 0; i < 60; i++) {
			char c = successMessage.charAt(i);
			if (Character.isDigit(c)) {
				number.append(c);
			} 
		}
		
		// ---- crm consumer complaint finished ----- //
		// ---- crm consumer complaint finished ----- //
		// ---- crm consumer complaint finished ----- //
		
		//click Manage Complaint 
		click(element("linkText", "Manage Complaint"));
		
		//If last option available then the below code will run
		//if pagination is not there comment the below code
		WebElement Last=element("linkText", "Last");
		boolean last=Last.isDisplayed();
		if(last==true) {
			click(Last);
			Thread.sleep(1000);
		}
		
		//click Compl_No
		WebElement comp=element("xpath", "//a[text()='"+number+"']");
		//click(comp);
		scroll(comp);
		
		//select complaint status
		WebElement complStatus=element("name", "complStatus");
		selectByVisibleText(complStatus, "open");
		
		//select assignedTo
		WebElement assignedTo=element("name", "assignedTo");
		scroll(assignedTo);
		selectByVisibleText(assignedTo, data[11]);
		
		//select assignedToId
		WebElement assignedToId=element("name", "assignedToId");
		scroll(assignedToId);
		selectByVisibleText(assignedToId, data[12]);
		
		//select Assigned Date
		WebElement assignedDate=element("name", "assignedDate");
		scroll(assignedDate);
		WebElement Assigned_Date=element("xpath", "//img[@class='ui-datepicker-trigger']");
		click(Assigned_Date);
		click(element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]"));
		
		//select priority
		WebElement priority=element("name", "priority");
		selectByVisibleText(priority, "High"); 
		
		//click submit
		click(element("xpath", "//input[@value='Submit']"));
		
		//click job card
		click(element("linkText", "Job Card"));
		
		//click Compl_No
		WebElement complNo=element("xpath", "//a[text()='"+number+"']");
		//click(complNo);
		scroll(complNo);
		
		//select Job_Card_Generation_Date
		WebElement 	Job_Card_Generation_Date=element("xpath", "(//img[@class='ui-datepicker-trigger'])[2]");
		click(Job_Card_Generation_Date);
		click(element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]"));
		
		//click submit
		click(element("xpath", "//input[@value='Submit']"));
		
	}
}
