package CRM;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import new_user_registration.New_User_Excel;
import new_user_registration.New_User_Reg;

public class publicComplaint_inside extends New_User_Reg {
	 

	@DataProvider(name="Public_Consumer_complaint")
	public String[][] getData20() throws IOException{
		String[][] excelData20= New_User_Excel.getExcelData("public_complain_inside");

		return excelData20;
	}


	@Test(dataProvider="Public_Consumer_complaint")
	public void consumer_complaint(String data[]) throws InterruptedException {

		//click Consumer Complaint
		click(element("linkText", "Consumer Complaint"));

		//click next button
		click(element("linkText", "Next"));

		//select Complaint Type
		WebElement Complaint_Type=element("name", "complaintType");
		selectByVisibleText(Complaint_Type, "Public Complaint");
		
		//complaint date
		WebElement date1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]");
		click(date1);
		
		WebElement date2=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
	    click(date2);
		
		//complaintReceivedBy
		sendkeys(element("name", "complaintReceivedBy"), "ADMIN");
		
		//Enter firstName
		sendkeys(element("name", "firstName"), data[0]);
		
		//Enter lastName
		sendkeys(element("name", "lastName"), data[1]);
		
		//Enter houseNo
		sendkeys(element("name", "houseNo"), data[2]);
		
		//Enter cross
		sendkeys(element("name", "cross"), data[3]);
		
		//Enter main
		sendkeys(element("name", "main"), data[4]);

		//Enter landMark
		sendkeys(element("name", "landMark"), data[5]);
		
		//select zoneName
		WebElement zoneName=element("name", "zoneName");
		selectByVisibleText(zoneName, data[6]);	
		
		//select ward
		WebElement ward=element("name", "ward");
		selectByVisibleText(ward, data[7]);
		
		//select tarrif
		WebElement tarrif=element("name", "tarrif");
		selectByVisibleText(tarrif, data[8]);
		
		//select serviceLocation
		WebElement serviceLocation=element("name", "serviceLocation");
		selectByVisibleText(serviceLocation, data[9]);
		
		//select dma
		WebElement dma=element("name", "dma");
		selectByVisibleText(dma, data[10]);
		
		//Enter cityName
		sendkeys(element("name", "cityName"), data[11]);
		
		//Enter pincode
		sendkeys(element("name", "pincode"), data[12]);
		
		//select gender
		WebElement gender=element("name", "gender");
		selectByVisibleText(gender, data[13]);

		//Click next button
		WebElement next=element("linkText", "Next");
		scroll(next);
		//Thread.sleep(3000);
		//scroll(next);

		//Enter Contact No Mobile
		sendkeys(element("name", "mobileNo"), data[14]);
		
		//Enter landlineNo
		sendkeys(element("name", "landlineNo"), data[15]);
		
		//Enter refContactNo
		sendkeys(element("name", "refContactNo"), data[16]);
		
		//Enter emailId
		sendkeys(element("name", "emailId"), data[17]);
		
		//select regComplaint
		WebElement regComplaint=element("name", "regComplaint");
		selectByVisibleText(regComplaint, data[18]);

		//select Functional Business Department  
		WebElement funBusDep=element("name", "funBusDep");
		int j=Integer.parseInt(data[19]);
		selectByIndex(funBusDep, j);

		//select complaintCategory
		WebElement complaintCategory=element("name", "complaintCategory");
		selectByVisibleText(complaintCategory, data[20]);

		//select subcategory
		WebElement subCategory=element("name", "subCategory");
		selectByVisibleText(subCategory, data[21]);  

		//Enter Complaint Details 
		sendkeys(element("name", "complaintDesc"), data[22]);

		//select Job Code
		WebElement slgJobCode=element("name", "slgJobCode");
		selectByVisibleText(slgJobCode, data[23]);
		
		//Enter vehicleNo
		sendkeys(element("name", "vehicleNo"), data[24]);

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
		
		// ----- crm public complaint finished ----- //
		// ----- crm public complaint finished ----- //
		// ----- crm public complaint finished ----- //
		
		
		//click Manage Complaint 
		click(element("linkText", "Manage Complaint"));
				
		//click public
		click(element("xpath", "//label[.='Public']"));
		
		//click complain number
		WebElement c=element("xpath", "//a[.='"+number+"']");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",c);
		c.click();
		
		//select complaint status
		WebElement complStatus=element("name", "complStatus");
		selectByVisibleText(complStatus, "open");
		
		//select assignedTo
		WebElement assignedTo=element("name", "assignedTo");
		scroll(assignedTo);
		selectByVisibleText(assignedTo, data[25]);

		//select assignedToId
		WebElement assignedToId=element("name", "assignedToId");
		scroll(assignedToId);
		selectByVisibleText(assignedToId, data[26]);

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
		
		//If last option available then the below code will run
		//if pagination is not there comment the below code
		WebElement Last=element("linkText", "Last");
		boolean last=Last.isDisplayed();
		if(last==true) {
			click(Last);
			Thread.sleep(1000);
		}
		
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

	}}
