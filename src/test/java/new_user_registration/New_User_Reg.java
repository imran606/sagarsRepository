package new_user_registration;

//import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import sagar_selenium_base.Base;

public class New_User_Reg extends Base {
	
	//static WebDriver driver;
	@DataProvider(name="new_user")
	public String[][] getData() throws IOException{
		String[][] excelData= New_User_Excel.getExcelData("CONSUMERS_NEW2");
		
		return excelData;
		}
	

	@BeforeTest
	public void LoginUser() throws InterruptedException, IOException, TesseractException {
	setUp("http://192.168.0.143:6060/ubarms/");
	//setUp("http://192.168.0.112:6060/ubarms/")	
}

	@Test(dataProvider="new_user", enabled=true                     )
	public void new_user_creation(String data[]) throws InterruptedException{
       
		//Click Consumer Management
		WebElement Consumer_Management=element("linkText", "Consumer Management");
		click(Consumer_Management);
		
		//Click the next button
		click(element("linkText", "Next"));
		
		//Enter firstname
		sendkeys(element("name", "firstName"), data[0]);
		
		//Enter Lastname
		sendkeys(element("name", "lastName"), data[1]);
		
		//Select Relation Type
		WebElement relation=element("name", "rType");
		selectByVisibleText(relation, data[2]);
		
		//Enter Relation Name 
        sendkeys(element("name", "rName"), data[3]);
        
        //Enter No of family Members  
        sendkeys(element("name", "noOfFamily"), data[4]);
        
        //Enter No of House hold
        sendkeys(element("name", "noOfhouseHold"), data[5]);
        
        //Select Aadhar 
        sendkeys(element("name", "adhaarNo"), data[6]);
        
        //Select Gender     
        WebElement gen=element("name", "gender");
        selectByVisibleText(gen, data[7]);
        
        //Select HouseType     
        WebElement houset=element("name", "hType");
        selectByVisibleText(houset, data[8]);
        
        //Enter Mobile Number
        sendkeys(element("name", "mobilenNo"), data[9]);
        
        //Enter Phone Number
        sendkeys(element("name", "phoneNo"), data[10]);;
        
        //Enter Email Id 
        sendkeys(element("name", "eMail"), data[11]);
        
        //Enter Ref.Contact No 
        sendkeys(element("name", "rContactNo"), data[12]);
        
        //Click Next button
        click(element("classname", "buttonNext"));
        
        //Address Info-->Present Address-->Enter House No
        sendkeys(element("name", "houseNo"), data[13]);
        
        //Enter Layout  
        sendkeys(element("name", "presLayout"), data[14]);
        
        //Enter Cross
        sendkeys(element("name", "preCross"), data[15]);
        
        //Enter Street
        sendkeys(element("name", "preStreet"),data[16]);
          
        //Enter Main
        sendkeys(element("name", "preMain"), data[17]);
        
        //Select Area Name    
        WebElement AreaName=element("name", "preAreaName");
        selectByVisibleText(AreaName, data[18]);
        
        //Select Ward Number
        WebElement ward=element("name", "preWardNumber");
        selectByVisibleText(ward, data[6]);
        
        //Select DMA NO
        WebElement dma=element("name", "presDmaNo");
        selectByVisibleText(dma, data[6]);
        
        //Select GIS Ward 
        WebElement gis=element("name", "preGisWard");
        selectByVisibleText(gis,  "05");
        
        //Select Election Ward 
        WebElement elec=element("name", "preElectionWard");
        selectByVisibleText(elec,  "05");
        
        //Select Revenue Ward
        WebElement rev=element("name", "preRevenueWard");
        selectByVisibleText(rev, "5");
        
        
        //Select Zone  
        WebElement Zone=element("name", "preZone");
        selectByVisibleText(Zone, data[21]);
        
        //Select city
        WebElement city=element("name", "preCity");
        selectByVisibleText(city, "Makronia");
        
        //Enter pincode
        sendkeys(element("name", "prePinCode"), data[22]);
        
        //Click Same as Present Address radio button
        click(element("name", "perSameAsPres"));
        
        //Click next button
        click(element("classname", "buttonNext"));
        
        //Tariff and ID Info-->Consumer Id numbers-->Consumer Type
        WebElement ConsumerType=element("name", "consumerType");
        selectByVisibleText(ConsumerType, "Authorized");
        
        //Enter PID No
        sendkeys(element("name", "pidNo"), "1234567890");
        
        //Enter Tap No 
        sendkeys(element("name", "tapNo"), "8743865154");
        
        //Click IMIS_ID
        click(element("name", "imisId"));
        
        //Select Waste Water  
        WebElement Waste_Water=element("name", "waste_Water");
        selectByVisibleText(Waste_Water, "No");
        
        //Select Tariff         
        WebElement Tariff=element("name", "tariff");
        selectByVisibleText(Tariff, data[23]);
        
        //Select Pipe Size    
        WebElement Pipe_Size=element("name", "pipeSize");
        selectByVisibleText(Pipe_Size, "1/2");
        
        //Enter Last 6 Month Average 
        sendkeys(element("name", "last6MonthAverage"), "6");
        
        //Select Meter Type       
        WebElement Meter_Type=element("name", "meterType");
        selectByVisibleText(Meter_Type, "NON AMR");
        
        //Click next button
        click(element("classname", "buttonNext"));
        
        //Select Application Date
        Thread.sleep(1000);
        FromDate();
        
        //Select Sanction Date
        ToDate();
        
        //Select Reading Day 
        WebElement Reading_Day = element("name", "readingDay");
        selectByVisibleText(Reading_Day, "11");
        
        //Click next button
        click(element("classname", "buttonNext"));
        
        //Select Ledger No
        WebElement Ledger_No=element("name", "ledgerNo");
        selectByVisibleText(Ledger_No, "1");
        
        //Enter Folio No 
        sendkeys(element("name", "folioNo"), data[24]);
        
        //Select Sub division
        WebElement Sub_division=element("name", "subDivision");
        selectByVisibleText(Sub_division, "Makronia");
        
        //Select Division 
        WebElement Division=element("name", "division");
        selectByVisibleText(Division, "Sagar");
        
        //Select AEE Name       
        WebElement AEE_Name=element("name", "aeeName");
        selectByVisibleText(AEE_Name, "Vikram Singh");
        
        //Select EE Name         
        WebElement EE_Name =element("name", "aeName");
        selectByVisibleText(EE_Name, "Ashif Khan");
        
        //Select MR Name
        WebElement MR_Name=element("name", "mrName");
        selectByVisibleText(MR_Name, "AKASH");
        
        //Enter Book No
        sendkeys(element("name", "bookNo"), data[25]);
        
        //Select Upload Documents Type  
        WebElement  Upload_Documents_Type=element("name", "uploadDocType");
        selectByVisibleText(Upload_Documents_Type, data[26]);
        
        //Upload Driving license document
        WebElement license=element("name", "file");
        sendkeys(license, getFile("DrivingLicense.png"));
        
        //Click Finish button
        click(element("classname", "buttonFinish"));
        
        //Validating wheather the user is created or not
        String text=element("classname", "successMessage").getText();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isDigit(c)) {
                number.append(c);
            } else if (number.length() > 0) {
                System.out.println(number.toString());
                number.setLength(0); // Reset the StringBuilder
            }
        }
        Assert.assertEquals(true, text.contains("Consumer Details Inserted Succesfully"));
        System.out.println("Consumer Details Inserted Succesfully");
        
        //Click Admin button
        clickAdmin();      		
        
        //Waiting for approvals-->From Date
        FromDate();
        
        //Select To Date
        ToDate();
        
        //Select Category     
        EnterCategory("New Consumer");
        
        //Click submit button
        AdminSubmit();
        
        //Click the TempId      
        click(element("xpath", "//a[text()='"+number+"']"));
        
        
        //
        Thread.sleep(3000);
        Set<String> WindowHandles=driver.getWindowHandles();

        List<String> list = new ArrayList<String>(WindowHandles);
        
        //Approval page
        driver.switchTo().window(list.get(1));
        //value = consumer id of the consumer
        String value=element("xpath", "(//input[@name='consumerIda'])[1]").getAttribute("value");
        //
        Thread.sleep(1000);
        click(element("xpath", "//a[@href='#step-5']"));
        click(element("xpath", "//img[@src='images/attachment.png']"));
        Thread.sleep(1000);
        click(element("xpath", "(//input[@value='Approve'])[5]"));
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.close();
        
        //------  Consumer creation finished -----//
       //------  Consumer creation finished -----//
      //------  Consumer creation finished -----//
        
        //Click Meter Management
        driver.switchTo().window(list.get(0));
        click(element("xpath", "(//a[@class='menuitem'])[6]"));
        
        //Enter ConsumerId  
        sendkeys_clickEnter(element("name", "consumerid"), value);
        
        //Validate  consumer is exist or not
        Thread.sleep(2000);
        String Valid_Record=element("xpath", "//font[@color='green']").getText();
        Assert.assertEquals(Valid_Record, "Record is Valid,This Consumer Exist");
        System.out.println("Consumer is exist");
        
        //Enter Device No
        sendkeys(element("name", "meterno"), data[27]);
        
        //Select Device type
        WebElement Device_type=element("name", "deviceType");
        selectByVisibleText(Device_type, "New");
        
        //Select Device Location      
        WebElement Device_Location=element("name", "devicelocation");
        selectByVisibleText(Device_Location, "Inside house");
        
        //Select devicemake
        WebElement devicemake=element("name", "devicemake");
        selectByVisibleText(devicemake, "Itron");
        
        //Select Device Ownership   
        WebElement 	Device_Ownership=element("name", "deviceownship");
        selectByVisibleText(Device_Ownership, "Board");
        
        //Select Plumber Name    
        WebElement Plumber_Name=element("name", "plumbername");
        selectByVisibleText(Plumber_Name, "Nirmal");
        
        //Enter Device Ref No
        sendkeys(element("name", "devicerefno"), "666");
        
        //Upload Document
        sendkeys(element("name", "file"), getFile("NewMeter.png"));
        
        //Enter Remark
        sendkeys(element("name", "remarksnew"), data[28]);
        
        //Click submit button
        WebElement Submit=element("xpath", "//input[@value='Submit']");
        
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",Submit);
        Submit.click();
        
        //Validate Wheather the user record updated or not
        String record_update=element("xpath", "//font[@color='green']").getText();
        Assert.assertEquals("Record Updated Successfully", record_update);
        System.out.println("New User Meter Device Entry Successfully Updated");
        
        //Click Admin button
        clickAdmin();
        
        //Waiting for approvals-->From Date
        FromDate();
        
        //Select To Date
        ToDate();
        
        //Select Category
        EnterCategory("New Device");
        
        //Click submit button
        AdminSubmit();
        
        //Click ConsumerId
        click(element("xpath", "//a[.='"+value+"']"));
        
        //
        Thread.sleep(1000);
		Set<String> WindowHandles1=driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(WindowHandles1);

		//Approval page
		Thread.sleep(1000);
		driver.switchTo().window(list1.get(1));
		Thread.sleep(1000);
		click(element("xpath", "(//img[@src='images/attachment.png'])[1]"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Approve'])[1]")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		driver.switchTo().window(list1.get(0));
		Thread.sleep(1000);
		
		// -------- New Device Entry Finsihed ----- //
	   // -------- New Device Entry Finsihed ----- //
	  // -------- New Device Entry Finsihed ----- //
        
        //Click Consumer Management
        WebElement Consumer_Management1=element("linkText", "Consumer Management");
        click(Consumer_Management1);

        //Click Consumer Details
        WebElement consumer_details=element("xpath", "//a[@class='c2']");
        click(consumer_details);

        //Enter Consumer_Id
        WebElement ConsumerId=element("name", "consumerId");
        sendkeys_clickEnter(ConsumerId, value);

        //Enter No.of family members
        WebElement No_family=element("name", "noOfFamily");
        clear_text_and_type(No_family, "15");

        //Enter No of house hold 
        WebElement noOfhouseHold=element("name", "noOfhouseHold");
        clear_text_and_type(noOfhouseHold, "15");

        //Select HouseType
        houseType("RCC");

        //Enter Mobile No      
        WebElement mobilenNo=element("name", "mobilenNo");
        clear_text_and_type(mobilenNo, "9786234106");

        //Enter Phone No   
        WebElement phoneNo=element("name", "phoneNo");
        clear_text_and_type(phoneNo, "9564346893");

        //Enter Email Id
        WebElement eMail=element("name", "eMail");
        clear_text_and_type(eMail, "dee@gmail.com");

        //Enter Ref.Contact No
        WebElement rContactNo=element("name", "rContactNo");
        clear_text_and_type(rContactNo, "9876987634");

        //Click Address Info
        WebElement Address_Info=element("xpath", "(//span[@class='stepDesc'])[2]");
        click(Address_Info);

        //Enter House No	
        WebElement preHouseNo=element("name", "preHouseNo");
        clear_text_and_type(preHouseNo, "80");

        //Enter Layout
        WebElement presLayout=element("name", "presLayout");
        clear_text_and_type(presLayout, "Rajaji layout");

        //Enter Cross	
        WebElement preCross=element("name", "preCross");
        clear_text_and_type(preCross, "5th Cross");

        //Enter Street	
        WebElement preStreet=element("name", "preStreet");
        clear_text_and_type(preStreet, "5th Street");

        //Enter Main 
        WebElement preMain=element("name", "preMain");
        clear_text_and_type(preMain, "14th main");


        //Select Area Name
        AreaName("Bheemsandra");

        ////Select Ward Number
        WebElement wardno=element("name", "preWardNumber");
        selectByVisibleText(wardno, "26");

        //Select DMA NO
        WebElement DMA=element("name", "presDmaNo");
        selectByVisibleText(DMA,  "34");

        //Select GIS Ward 
        WebElement GIS=element("name", "preGisWard");
        selectByVisibleText(GIS, "26");

        //Select Election Ward 
        WebElement Election=element("name", "preElectionWard");
        selectByVisibleText(Election, "26");

        //Select Revenue Ward
        WebElement Revenue=element("name", "preRevenueWard");
        selectByVisibleText(Revenue, "26");

        //Select Zone
        zone("North");

        //Enter State
        WebElement preState=element("name", "preState");
        clear_text_and_type(preState, "tamilnadu");

        //Enter Country
        WebElement preCountryRegion=element("name", "preCountryRegion");
        clear_text_and_type(preCountryRegion, "Indiaaa");

        //Enter pincode
        WebElement prePinCode=element("name", "prePinCode");
        clear_text_and_type(prePinCode, "632505");

        //Click copyAs
        WebElement perSameAsPres=element("name", "perSameAsPres");
        click(perSameAsPres);

        //Click Tariff & ID
        WebElement tariff_id=element("xpath", "(//span[@class='stepDesc'])[3]");
        click(tariff_id);

        //Tariff and ID Info-->Consumer Id numbers-->Consumer Type
        WebElement consumerType=element("name", "consumerType");
        selectByVisibleText(consumerType, "Authorized");

        //Enter PID No
        WebElement pidNo=element("name", "pidNo");
        clear_text_and_type(pidNo, "1234567899");

        //Enter Tap No 
        WebElement tapNo=element("name", "tapNo");
        clear_text_and_type(tapNo, "8989767654");

        //Select DMA_id
        WebElement dmaId=element("name", "dmaId");
        selectByVisibleText(dmaId, "20");

        //Select Waste Water
        WebElement waste_Water=element("name", "waste_Water");
        selectByVisibleText(waste_Water, "No");

        //enter last6MonthAverage
        WebElement last6MonthAverage=element("name", "last6MonthAverage");
        clear_text_and_type(last6MonthAverage, "4");

        //Select Meter Type  
        MeterType("NON AMR");

        //Click Dates Info    
        WebElement date=element("xpath", "(//span[@class='stepDesc'])[4]");
        click(date);

        //Select Reading Day     
        WebElement readingDay=element("name", "readingDay");
        selectByVisibleText(readingDay, "6");

        //Click dept Info
        WebElement dept_info=element("xpath", "(//span[@class='stepDesc'])[5]");
        click(dept_info);

        //Enter folio No
        WebElement folioNo=element("name", "folioNo");
        clear_text_and_type(folioNo, "800");

        //Select MR Name 
        WebElement mrName=element("name", "mrName");
        selectByVisibleText(mrName, "AKASH");

        //Enter book no
        WebElement bookNo=element("name", "bookNo");
        clear_text_and_type(bookNo, "500");

        //Click Modify button
        WebElement modify=element("xpath", "(//input[@value='Modify'])[5]");
        click(modify);

        //Validate consumer data modification
        String successMessage=element("classname", "successMessage").getText();
        Assert.assertEquals(successMessage, "Consumer Data Modified Successfully");
        System.out.println("Consumer Data Modified Successfully");

        //Click Admin button
        clickAdmin();      		

        //Waiting for approvals-->From Date
        FromDate(); 

        //Select To Date
        ToDate();

        //Select Category
        EnterCategory("Consumer Details");

        //Click submit button
        AdminSubmit();

        //Click consumer Id
        WebElement consumerid_click=element("xpath", "//a[.='"+value+"']");
        click(consumerid_click);


        //
        WindowApprove();
          
         //   ------Consumer Details Finished------ //
        //   ------Consumer Details Finished------ //
       //   ------Consumer Details Finished------ //
        
        //Click Consumer Management
        WebElement Consumer_Management21=element("linkText", "Consumer Management");
        click(Consumer_Management21);
        
        //Click ConsumerMasterHistory
        WebElement ConsumerMasterHistory=element("xpath", "//a[@class='c95']");
        click(ConsumerMasterHistory); 
        
        //Enter consumer id and click enter
        sendkeys_clickEnter(element("xpath", "//input[@name='consumerId']"), value);
        Thread.sleep(3000);
        
        //  ----- consumer master history finished ----- //
       //  ----- consumer master history finished ----- //
      //  ----- consumer master history finished ----- //
            
        //Click Consumer Management
        WebElement Consumer_Management2=element("linkText", "Consumer Management");
        click(Consumer_Management2);

        //Click Khata changes
        WebElement khata_changes=element("xpath", "//a[@class='c3']");
        click(khata_changes);

        //Enter consumer id
        WebElement ConsumerId1=element("name", "consumerid");
        sendkeys_clickEnter(ConsumerId1, value);

        //Enter first name
        WebElement conNewFirstName=element("name", "conNewFirstName");
        sendkeys(conNewFirstName, data[29]);

        //Enter last name
        WebElement conNewLastName=element("name", "conNewLastName");
        sendkeys(conNewLastName, data[30]);

        //Select RelationType
        WebElement conNewRtype=element("name", "conNewRtype");
        selectByVisibleText(conNewRtype, "D/O");

        //Enter Relation name
        WebElement conNewRname=element("name","conNewRname");
        sendkeys(conNewRname, "brother");

        //Select Gender
        WebElement newConsGender=element("name", "newConsGender");
        selectByVisibleText(newConsGender, "Male");
        
        //Enter mobile number
        sendkeys(element("name", "newMobileNo"), data[31]);
        
        //Enter email 
        sendkeys(element("name", "newEmailId"), data[32]);

        //Select Enter Date
        FromDate();

        //Enter Order no
        WebElement orderNumber=element("name", "orderNumber");
        sendkeys(orderNumber, "98765");

        //Select Order Date 
        ToDate();

        //Select Authorized By 
        WebElement approvedby=element("name", "approvedby");
        selectByVisibleText(approvedby, "Junior Engineer");

        //Select Document Upload Type
        WebElement docupload=element("name", "docupload");
        selectByVisibleText(docupload, "Driving License");
        
        //Upload Driving license document
        WebElement license1=element("name", "file");
        sendkeys(license1, getFile("DrivingLicense.png"));

        //Enter Remarks
        WebElement remarksnew=element("name", "remarksnew");
        sendkeys(remarksnew, "changed2");

        //Click submit
        WebElement submit=element("xpath", "//input[@value='Submit']");
        click(submit);

        //validate khata changes
        String v=element("xpath", "//font[@color='green']").getText();
        Assert.assertEquals(v, "Khata Changes Data Submitted Successfully");
        System.out.println("khata changed");

        //Click Admin button
        clickAdmin();

        //Waiting for approvals-->From Date
        FromDate();

        //Select To Date
        ToDate();

        //Select Category
        EnterCategory("Khata change");

        //Click submit button
        AdminSubmit();

        //Click consumer Id
        WebElement consumer_Id=element("xpath", "//a[.='"+value+"']");
        click(consumer_Id);

        //
        WindowApprove();
        
        //  ------ khaga change finished -----  //
       //  ------ khaga change finished -----  //
      //  ------ khaga change finished -----  //
        
        
        //Click Consumer Management
        WebElement Consumer_Management3=element("linkText", "Consumer Management");
        click(Consumer_Management3);

        //Click Tariff changes
        WebElement Tariff_changes=element("xpath", "//a[@class='c4']");
        click(Tariff_changes);

        //Enter consumer id
        WebElement tConsumerId=element("name", "tConsumerId");
        sendkeys_clickEnter(tConsumerId, value);

        //Select new Tariff 
        WebElement Tariff_new=element("name", "newtariff");
        selectByVisibleText(Tariff_new, "COMMERCIAL");

        //Select Authorized Date
        FromDate();

        //Select Authorized By
        WebElement approvedBy=element("name", "approvedBy");
        selectByVisibleText(approvedBy, "EE");

        //Enter Order Number 
        WebElement orderNumberA=element("name", "orderNumberA");
        sendkeys(orderNumberA, "54321");
        
        //Upload Driving license document
        WebElement Adhar=element("name", "file");
        sendkeys(Adhar, getFile("Adhar.png"));

        //Enter Remarks
        WebElement tRemarks=element("name", "tRemarks");
        sendkeys(tRemarks, "tariffchanged2");

        //Click Submit
        WebElement submit2=element("xpath", "//input[@value='Submit']");
        click(submit2);

        //validate tariff changes success or failure
        WebElement tariff=element("xpath", "//font[@color='green']");
        String tv2=tariff.getText();
        Assert.assertEquals(tv2, "Tariff Changes Data Submitted Successfully");

        //Click Admin button 
        clickAdmin(); 

        //Waiting for approvals-->From Date
        FromDate();

        //Select To Date
        ToDate();

        //Select Category
        EnterCategory("Tariff change");

        //Click submit button
        AdminSubmit();

        //Click consumer Id
        WebElement consumer_id=element("xpath", "//a[.='"+value+"']");
        click(consumer_id);

        //windowApprove
        WindowApprove();
        
        //  ----- Tariff change Finished -----  //
       //  ----- Tariff change Finished -----  //
      //  ----- Tariff change Finished -----  //
        
        
        //Click Consumer Management
        WebElement Consumer_Management4= element("linkText", "Consumer Management");
        click(Consumer_Management4);

        //Click Deposit details
        WebElement deposit_details=element("xpath", "//a[@class='c5']");
        click(deposit_details);

        //Enter consumer id
        WebElement dconsumerid=element("name", "dconsumerid");
        sendkeys_clickEnter(dconsumerid, value);

        //Select Deposit Type 
        WebElement depositType=element("name", "depositType");
        selectByVisibleText(depositType, "Bill");

        //Select Deposit Date
        FromDate();

        //Enter Deposit Amount
        WebElement depositeAmount=element("name", "depositeAmount");
        sendkeys(depositeAmount, "1500");

        //Enter Remarks
        WebElement dRemarks=element("name", "dRemarks");
        sendkeys(dRemarks, "Deposit Details changed");

        //Click submit button
        WebElement submit3=element("xpath", "//input[@value='Submit']");
        click(submit3);

        //Validate deposit success message
        WebElement successMessage1=element("classname", "successMessage");
        String DD=successMessage1.getText();
        Assert.assertEquals(DD, "Deposit Details Inserted Successfully");
        System.out.print("Deposit Details Inserted Successfully");
        
        // ----- Deposit Details Finished ----- //
       // ----- Deposit Details Finished ----- //
      // ----- Deposit Details Finished ----- //
        
        //Click Meter Management
        WebElement MeterManagement=element("linkText", "Meter Management");
        click(MeterManagement);

        //Click Disconnection Option
        WebElement Disconnection=element("classname", "c16");
        click(Disconnection);

        //Enter Consumer_id and click enter button
        WebElement consumerid=element("name", "consumerid");
        sendkeys_clickEnter(consumerid, value);

        //Select Disconnected Date
        FromDate();
        //WebElement Click_Disconnected_Date=element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]");
       // click(Click_Disconnected_Date);
       // WebElement Select_Disconnected_Date=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
       // click(Select_Disconnected_Date);

        //Enter Disconnection fees
        WebElement dissConnFees=element("name", "dissConnFees");
        sendkeys(dissConnFees, "500");

        //Enter Order no
        WebElement orderNo=element("name", "orderNo");
        sendkeys(orderNo, "12345");

        //Select Order date
        ToDate();
        //WebElement Click_Order_Date =element("xpath", "(//img[@class='ui-datepicker-trigger'])[2]");
        //click(Click_Order_Date);
        //WebElement Select_Order_Date=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
        //click(Select_Order_Date);

        //Select Disconnection Type
        WebElement Disconnection_Type=element("name", "toDisconn");
        selectByVisibleText(Disconnection_Type, "Temporary Disconnection");
        
        //Document Attach
        WebElement doc=element("name", "fileDisc");
        sendkeys(doc, getFile("DrivingLicense.png"));

        //Enter Remarks
        WebElement Remarks=element("name", "diRemarks");
        sendkeys(Remarks, "Temporary Disconnection");

        //Click submit button
        WebElement Submit4=element("xpath", "//input[@value='Submit']");
        click(Submit4);

        //Validate disconnection message popup
        WebElement validation=element("xpath", "//font[@color='green']");
        String actual=validation.getText();
        Assert.assertEquals(actual, "Dissconnection Details Inserted Successfully");
        System.out.println("Dissconnection Details Inserted Successfully");

        //click Admin
        clickAdmin();

        //From date default day 1
        FromDate();

        //To date default present day
        ToDate();

        //Select Category
        EnterCategory("Disconnection");

        //Click submit
        AdminSubmit();

        //Click Id
        WebElement ID=element("xpath", "//td[.='"+value+"']/preceding-sibling::td/a");
        click(ID);

        //Click approve button
        WindowApprove();
        
        //  ------ Disconnection Finished ------  //
       //  ------ Disconnection Finished ------  //
      //  ------ Disconnection Finished ------  //
        
        //Click Meter Management
        WebElement MeterManagement2=element("linkText", "Meter Management");
        click(MeterManagement2);

        //Click Reconnection Option
        WebElement Reconnection=element("classname", "c17");
        click(Reconnection);

        //Enter Consumer_id and click enter button
        WebElement consumerid1=element("name", "rconsumerid");
        sendkeys_clickEnter(consumerid1, value);

        //Select Reconnected Date
        WebElement Click_Reconnected_Date=element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]");
        click(Click_Reconnected_Date);
        WebElement Select_Reconnected_Date=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
        click(Select_Reconnected_Date);

        //Enter Reconnection fees
        WebElement ReConnFees=element("name", "reConnFees");
        sendkeys(ReConnFees, "1000");

        //Enter Order no
        WebElement orderNo1=element("name", "rorderNo");
        sendkeys(orderNo1, "12345");

        //Select Order date
        WebElement Click_Order_Date1 =element("xpath", "(//img[@class='ui-datepicker-trigger'])[2]");
        click(Click_Order_Date1);
        WebElement Select_Order_Date1=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
        click(Select_Order_Date1);

        //Select Reconnection Status
        WebElement Reconnection_Type=element("name", "reconnStatus");
        selectByVisibleText(Reconnection_Type, "Live");
        
        //Document Attach
        WebElement doc1=element("name", "fileRec");
        sendkeys(doc1, getFile("VoterId.png"));

        //Enter Remarks
        WebElement Remarks1=element("name", "reRemarks");
        sendkeys(Remarks1, "Connected");

        //Click submit button
        WebElement Submit3=element("xpath", "//input[@value='Submit']");
        click(Submit3);

        //Validate Reconnection message popup
        WebElement validation1=element("xpath", "//font[@color='green']");
        String actual1=validation1.getText();
        Assert.assertEquals(actual1, "Reconnection Details Inserted Successfully");
        System.out.println("Reconnection Details Inserted Successfully");

        //click Admin
        clickAdmin();

        //From date default day 1
        FromDate();

        //To date default present day
        ToDate();

        //Select Category
        EnterCategory("Reconnection");

        //Click submit
        AdminSubmit();

        //Click Id
        WebElement ID1=element("xpath", "//td[.='"+value+"']/preceding-sibling::td/a");
        click(ID1);

        //Click approve button
        WindowApprove();
        
        //   ----- Reconnection Finished ----- //
       //   ----- Reconnection Finished ----- //
      //   ----- Reconnection Finished ----- //
        
    	//Click Revenue Management
		WebElement revenue_management=element("linkText", "Revenue Management");
		click(revenue_management);
		
		//Click Rebate
		WebElement rebate=element("xpath", "//a[@class='c11']");
		click(rebate);
		
		//Enter consumerId
		WebElement consumer=element("name", "consumerId");
		sendkeys_clickEnter(consumer, value);
		
		//Enter Rebate on Arrears 
		WebElement Rebate_on_Arrears=element("name", "rebateOnArrears");
		sendkeys(Rebate_on_Arrears, "200");
		
		//Enter Rebate on Interest
		WebElement  Rebate_on_Interest=element("name", "rebateOnInterest");
		sendkeys(Rebate_on_Interest, "222");
		
		//Enter Rebate On Tax 
		WebElement Rebate_On_Tax =element("name", "rebateOnTax");
		sendkeys(Rebate_On_Tax, "333");
		
		//Enter Order Number 
		WebElement Order_Number = element("name", "orderNumber");
		sendkeys(Order_Number, "34562");
		
		//Select Order Date
		WebElement Order_Date1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]");
		click(Order_Date1);
		WebElement Order_Date2=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
		click(Order_Date2);
		
        //Document Attach
        WebElement doc2=element("name", "file");
        sendkeys(doc2, getFile("Adhar.png"));
		
		//Enter Remarks
		WebElement reRemarks=element("name", "reRemarks");
		sendkeys(reRemarks, "rebate updated");
		
		//Click submit
		WebElement submit5=element("xpath", "//input[@value='Submit']");
		click(submit5);
		
		//Validate Rebate data inserted succesfull or not
		String successMessage3=element("classname", "successMessage").getText();
		Assert.assertEquals(successMessage3, "Rebate data inserted succesfully");
		System.out.println("Rebate data inserted succesfully");
		
		//Click Admin
		clickAdmin();
		
		//Select from date
		FromDate();
		
		//Select to date
		ToDate();
		
		//Select category
		EnterCategory("Rebate Details");
		
		//Click submit
		AdminSubmit();
		
		//Click Id
		WebElement ID2=element("xpath", "//td[.='"+value+"']/preceding-sibling::td/a");
		click(ID2);
		
		//Click approve button
		WindowApprove();
		
		//   ------ Rebate  finished ------ //
	   //   ------ Rebate  finished ------ //
	  //   ------ Rebate  finished ------ //
		
		
		//Click Revenue Management
		WebElement revenue_management3=element("linkText", "Revenue Management");
		click(revenue_management3);

		//Click Interest_wave_of
		WebElement Interest_wave_of=element("xpath", "//a[@class='c12']");
		click(Interest_wave_of);

		//Enter consumerId
		WebElement consumerid2=element("name", "iConsumerid");
		sendkeys_clickEnter(consumerid2, value);

		//Enter Arrears Pending
		WebElement arrearsPending=element("name", "arrearsPending");
		clear_text_and_type(arrearsPending, "180");

		//Enter interestPending
		WebElement interestPending=element("name", "interestPending");
		clear_text_and_type(interestPending, "154");

		//Enter taxPending
		WebElement taxPending=element("name", "taxPending");
		clear_text_and_type(taxPending, "300");

		//Enter iOrderNumber
		WebElement iOrderNumber=element("name", "iOrderNumber");
		sendkeys(iOrderNumber, "56789");

		//Select Order Date
		WebElement Order_Date3=element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]");
		click(Order_Date3);
		WebElement Order_Date4=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
		click(Order_Date4);
		
        //Document Attach
        WebElement doc3=element("name", "ifile");
        sendkeys(doc3, getFile("Adhar.png"));

		//Enter Remarks
		WebElement waRemarks=element("name", "waRemarks");
		sendkeys(waRemarks, "interest wave updated2");

		//Click submit
		WebElement sub=element("xpath", "//input[@value='Submit']");
		click(sub);

		//Validate Interest Wave-off data inserted succesfull or not
		String successMessage4=element("classname", "successMessage").getText();
		Assert.assertEquals(successMessage4, "Interest Wave-off data inserted succesfully");
		System.out.println("Interest Wave-off data inserted succesfully");


		//Click Admin
		clickAdmin();

		//Select from date
		FromDate();

		//Select to date
		ToDate();

		//Select category
		EnterCategory("Interest WaveOff Details");

		//Click submit
		AdminSubmit();

		//Click Id
		WebElement ID3=element("xpath", "//td[.='"+value+"']/preceding-sibling::td/a");
		click(ID3);

		//Click approve button
		WindowApprove();
		
		//  ----- Interest wave off finished ----- //
	   //  ----- Interest wave off finished ----- //
	  //  ----- Interest wave off finished ----- //
		
		//Click cash management
		click(element("linkText", "Cash Management"));

		//select book no
		click(element("linkText", "2"));

		//Enter Consumer ID
		sendkeys_clickEnter(element("name", "consumerid"),value);

		//Get receiptNo
		String receiptNo=element("name", "receiptNo").getAttribute("value");
		System.out.println(receiptNo);

		//Select Payment Towards
		WebElement Payment_Towards=element("name", "paymentTowards");
		selectByVisibleText(Payment_Towards, "Bill");

		//Select paymentMode
		WebElement paymentMode=element("name", "paymentMode");
		selectByVisibleText(paymentMode, "Cheque");

		//Cheque /DD / MO No
		sendkeys(element("name", "checkDDNo"), "12345");

		// Cheque /DD / MO Date	
		WebElement Cheque  =element("xpath", "(//img[@class='ui-datepicker-trigger'])[2]");
		click(Cheque);
		WebElement Cheque2=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
		click(Cheque2);

		//Bank Name
		WebElement  Bank_Name=element("name", "bankName");
		selectByVisibleText(Bank_Name, "Bank Of Baroda");

		//Enter Amount Paid
		sendkeys(element("name", "amountPaid"), "56");

		//Click Add button
		click(element("xpath", "//input[@value='Add']"));

		//ValidateData has been succesfully Added or Not
		String successMessage2=element("classname", "successMessage").getText();
		Assert.assertEquals(successMessage2, "Data has been succesfully Added,Please Click Next to go to Next Receipt");

		//Click Admin
		clickAdmin();

		//Select from date
		FromDate();

		//Select to date
		ToDate();

		//Select category
		EnterCategory("Manual Cash Entry");

		//Click admin button
		AdminSubmit();

		//click
		click(element("linkText", "Click here to go to Manual Cash Receipt Approval Screen"));

		//
		Set<String> WindowHandles2=driver.getWindowHandles();
		List<String> list2 = new ArrayList<String>(WindowHandles2);

		//Approval page
		Thread.sleep(1000);
		driver.switchTo().window(list2.get(1));
		Thread.sleep(1000);

		//From date
		WebElement date1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]");
		click(date1);
		click(element("xpath", "//span[.='Prev']"));
		WebElement date2=element("xpath", "(//a[@class='ui-state-default'])[1]");
		click(date2);

		//To date
		Thread.sleep(1000);
		WebElement d1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[2]");
		click(d1);
		WebElement d2=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		click(d2);

		//Select type
		WebElement type=element("name", "type");
		selectByVisibleText(type, "Day wise");

		//
		click(element("xpath", "(//input[@type='checkbox'])[2]"));
		click(element("xpath", "//input[@value='Approve']"));

		//
		Set<String> WindowHandles3=driver.getWindowHandles();
		List<String> list3 = new ArrayList<String>(WindowHandles3);
		driver.switchTo().window(list3.get(0));
		
		// ---- Manual Cash Entry Finished ---- //
		// ---- Manual Cash Entry Finished ---- //
		// ---- Manual Cash Entry Finished ---- //
		
		//Click Revenue Management
		WebElement revenue_management1=element("linkText", "Revenue Management");
		click(revenue_management1);

		//Click cheque bounce
		WebElement rebate1=element("xpath", "//a[@class='c14']");
		click(rebate1);

		//Enter consumer id and click
		sendkeys_clickEnter(element("name", "consumerId"),value);

		//Click Id
		click(element("xpath", "//td[.='"+value+"']/preceding-sibling::td/a"));

		//Enter Order Number 
		sendkeys(element("name", "chqOrderNo"), "12345");

		//Enter Cheque Bounce charges
		sendkeys(element("name", "chequeCharge"), "60");

		//Date Effect
		WebElement Cheque1  =element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		click(Cheque1);
		WebElement Cheque12=element("xpath", "//a[contains(@class, 'ui-state-default') and contains(@class, 'ui-state-highlight')]");
		click(Cheque12);

		//Enter Remarks
		sendkeys(element("name", "remarks"), "cheque bounce success");

		//Click submit
		click(element("xpath", "//input[@value='Submit']"));

		//validate
		String successMessage11=element("classname", "successMessage").getText();
		Assert.assertEquals(successMessage11, "Cheque Bounce Details Inserted Successfully");
		System.out.println("Cheque Bounce Details Inserted Successfully");

		//
		clickAdmin();

		//
		FromDate();

		//
		ToDate();

		//
		EnterCategory("Cheque Bounce");

		//
		AdminSubmit();

		//Click id
		click(element("xpath", "//td[.='"+value+"']/preceding-sibling::td/a"));

		//
		WindowApprove();
		
		// ---- cheque bounce finished ---- //
		// ---- cheque bounce finished ---- //
		// ---- cheque bounce finished ---- //
		
		
		//Click  MIS Reports
		click(element("linkText", "MIS Reports"));

		//Click MIS Report Abstract
		click(element("classname", "c44"));
		
		//For Tariff Wise
		List<String> list11 = new ArrayList<String>();
		list11.add("All");
		
		for (String tarifff : list11) {
			
			//Select From date
			FromDate();

			//Select To date
			ToDate();
			
			//Select Tariff 
			Tariff(tarifff);
			
			//Select reports
			TariffReportcategory("Cheque Bounce Report");
			
			//Enter cutoff value		
			Tariffcutoff("0");
			
			//Click generate button
			GenerateTariffReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuC=44#nbb");
			Thread.sleep(2000);
			
			//Select From date
			FromDate();

			//Select To date
			ToDate();
			
			//Select Tariff 
			Tariff(tarifff);
			
			//Select reports
			TariffReportcategory("Deposit Colletion Report");
			
			//Enter cutoff value		
			Tariffcutoff("0");
			
			//Click generate button
			GenerateTariffReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuC=44#nbb");
			Thread.sleep(2000);
			

			//Select From date
			FromDate();

			//Select To date
			ToDate();
			
			//Select Tariff 
			Tariff(tarifff);
			
			//Select reports
			TariffReportcategory("Disconnection Report");
			
			//Enter cutoff value		
			Tariffcutoff("0");
			
			//Click generate button
			GenerateTariffReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuC=44#nbb");
			Thread.sleep(2000);
			
			//Select From date
			FromDate();

			//Select To date
			ToDate();
			
			//Select Tariff 
			Tariff(tarifff);
			
			//Select reports
			TariffReportcategory("Interest Waveoff Report");
			
			//Enter cutoff value		
			Tariffcutoff("0");
			
			//Click generate button
			GenerateTariffReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuC=44#nbb");
			Thread.sleep(2000);
			
			//Select From date
			FromDate();

			//Select To date
			ToDate();
			
			//Select Tariff 
			Tariff(tarifff);
			
			//Select reports
			TariffReportcategory("Khata Change Report");
			
			//Enter cutoff value		
			Tariffcutoff("0");
			
			//Click generate button
			GenerateTariffReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuC=44#nbb");
			Thread.sleep(2000);
			

			//Select From date
			FromDate();

			//Select To date
			ToDate();
			
			//Select Tariff 
			Tariff(tarifff);
			
			//Select reports
			TariffReportcategory("Rebate Report");
			
			//Enter cutoff value		
			Tariffcutoff("0");
			
			//Click generate button
			GenerateTariffReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuC=44#nbb");
			Thread.sleep(2000);
			
			//Select From date
			FromDate();

			//Select To date
			ToDate();
			
			//Select Tariff 
			Tariff(tarifff);
			
			//Select reports
			TariffReportcategory("Reconnection Report");
			
			//Enter cutoff value		
			Tariffcutoff("0");
			
			//Click generate button
			GenerateTariffReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuC=44#nbb");
			Thread.sleep(2000);
			
			//Select From date
			FromDate();

			//Select To date
			ToDate();
			
			//Select Tariff 
			Tariff(tarifff);
			
			//Select reports
			TariffReportcategory("Tariff Change Report");
			
			//Enter cutoff value		
			Tariffcutoff("0");
			
			//Click generate button
			GenerateTariffReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuC=44#nbb");
			Thread.sleep(2000);
		}
        
		//  ---- MIS Report Abstract --> Tariff wise report finished ------ //
	   //  ---- MIS Report Abstract --> Tariff wise report finished ------ //
	  //  ---- MIS Report Abstract --> Tariff wise report finished ------ //
		
		//For Mr Wise
		List<String> list12 = new ArrayList<String>();
		list12.add("All");

		for (String MrId : list12) {
			
			//click MR wise
			click(element("xpath", "(//a[@class='closed'])[1]"));

			//Select From date
		    WebElement date11=element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		    click(date11);
		   
		    WebElement date12=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date12);
			
			//Select To date
			Thread.sleep(1000);
		    WebElement d11=element("xpath", "(//img[@class='ui-datepicker-trigger'])[4]");
		    click(d11);
		    WebElement d12=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d12);
		    
		    //Select MR id
			Mrid(MrId);
			
			//Select reports
			MRidReportcategory("Cheque Bounce Report");

			//Enter cutoff value		
			Mridcutoff("0");

			//Click generate button
			GenerateMridReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
			Thread.sleep(3000);
			
			//click MR wise
			click(element("xpath", "(//a[@class='closed'])[1]"));

			//Select From date
		    WebElement date13=element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		    click(date13);
		   
		    WebElement date14=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date14);
			
			//Select To date
			Thread.sleep(1000);
		    WebElement d15=element("xpath", "(//img[@class='ui-datepicker-trigger'])[4]");
		    click(d15);
		    WebElement d16=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d16);
		    
		    //Select MR id
			Mrid(MrId);
			
			//Select reports
			MRidReportcategory("Deposit Colletion Report");

			//Enter cutoff value		
			Mridcutoff("0");

			//Click generate button
			GenerateMridReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
			Thread.sleep(3000);
			
			//click MR wise
			click(element("xpath", "(//a[@class='closed'])[1]"));

			//Select From date
		    WebElement date17=element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		    click(date17);
		   
		    WebElement date18=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date18);
			
			//Select To date
			Thread.sleep(1000);
		    WebElement d19=element("xpath", "(//img[@class='ui-datepicker-trigger'])[4]");
		    click(d19);
		    WebElement d20=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d20);
		    
		    //Select MR id
			Mrid(MrId);
			
			//Select reports
			MRidReportcategory("Disconnection Report");

			//Enter cutoff value		
			Mridcutoff("0");

			//Click generate button
			GenerateMridReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
			Thread.sleep(3000);
			
			//click MR wise
			click(element("xpath", "(//a[@class='closed'])[1]"));

			//Select From date
		    WebElement date21=element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		    click(date21);
		   
		    WebElement date22=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date22);
			
			//Select To date
			Thread.sleep(1000);
		    WebElement d23=element("xpath", "(//img[@class='ui-datepicker-trigger'])[4]");
		    click(d23);
		    WebElement d24=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d24);
		    
		    //Select MR id
			Mrid(MrId);
			
			//Select reports
			MRidReportcategory("Khata Change Report");

			//Enter cutoff value		
			Mridcutoff("0");

			//Click generate button
			GenerateMridReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
			Thread.sleep(3000);
			
			//click MR wise
			click(element("xpath", "(//a[@class='closed'])[1]"));

			//Select From date
		    WebElement date25=element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		    click(date25);
		   
		    WebElement date26=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date26);
			
			//Select To date
			Thread.sleep(1000);
		    WebElement d27=element("xpath", "(//img[@class='ui-datepicker-trigger'])[4]");
		    click(d27);
		    WebElement d28=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d28);
		    
		    //Select MR id
			Mrid(MrId);
			
			//Select reports
			MRidReportcategory("Rebate Report");

			//Enter cutoff value		
			Mridcutoff("0");

			//Click generate button
			GenerateMridReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
			Thread.sleep(3000);
			
			//click MR wise
			click(element("xpath", "(//a[@class='closed'])[1]"));

			//Select From date
		    WebElement date29=element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		    click(date29);
		   
		    WebElement date30=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date30);
			
			//Select To date
			Thread.sleep(1000);
		    WebElement d31=element("xpath", "(//img[@class='ui-datepicker-trigger'])[4]");
		    click(d31);
		    WebElement d32=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d32);
		    
		    //Select MR id
			Mrid(MrId);
			
			//Select reports
			MRidReportcategory("Reconnection Report");

			//Enter cutoff value		
			Mridcutoff("0");

			//Click generate button
			GenerateMridReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
			Thread.sleep(3000);
			
			//click MR wise
			click(element("xpath", "(//a[@class='closed'])[1]"));

			//Select From date
		    WebElement date33=element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		    click(date33);
		   
		    WebElement date34=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date34);
			
			//Select To date
			Thread.sleep(1000);
		    WebElement d35=element("xpath", "(//img[@class='ui-datepicker-trigger'])[4]");
		    click(d35);
		    WebElement d36=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d36);
		    
		    //Select MR id
			Mrid(MrId);
			
			//Select reports
			MRidReportcategory("Tariff Change Report");

			//Enter cutoff value		
			Mridcutoff("0");

			//Click generate button
			GenerateMridReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
			Thread.sleep(3000);	
		}
		
		// -----  MIS Report Abstract --> Mr wise report finished ----- //
		// -----  MIS Report Abstract --> Mr wise report finished ----- //
		// -----  MIS Report Abstract --> Mr wise report finished ----- //
		
		//For DMA Wise
		List<String> list13 = new ArrayList<String>();
		list13.add("All");

		for (String DMAwise : list13) {
			
			//click DMA wise
			click(element("xpath", "(//a[@class='closed'])[2]"));

			//Select From date
			WebElement date37=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
			click(date37);

			WebElement date38=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date38);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d39=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
		    click(d39);
		    WebElement d40=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d40);
			
			//Select DMA_NO
			DMA_No(DMAwise);
			
			//Select reports
			DMA_NoReportcategory("Cheque Bounce Report");

			//Enter cutoff value		
			DMA_Nocutoff("0");

			//Click generate button
			GenerateDMA_NoReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
			Thread.sleep(3000);
			
			//click DMA wise
			click(element("xpath", "(//a[@class='closed'])[2]"));

			//Select From date
			WebElement date41=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
			click(date41);

			WebElement date42=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date42);
				
			//Select To date
			Thread.sleep(1000);
		    WebElement d43=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
		    click(d43);
		    WebElement d44=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d44);
			
			//Select DMA_NO
			DMA_No(DMAwise);
			
			//Select reports
			DMA_NoReportcategory("Deposit Colletion Report");

			//Enter cutoff value		
			DMA_Nocutoff("0");

			//Click generate button
			GenerateDMA_NoReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
			Thread.sleep(3000);
			
			//click DMA wise
			click(element("xpath", "(//a[@class='closed'])[2]"));

			//Select From date
			WebElement date45=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
			click(date45);

			WebElement date46=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date46);
				
			//Select To date
			Thread.sleep(1000);
		    WebElement d47=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
		    click(d47);
		    WebElement d48=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d48);
			
			//Select DMA_NO
			DMA_No(DMAwise);
			
			//Select reports
			DMA_NoReportcategory("Disconnection Report");

			//Enter cutoff value		
			DMA_Nocutoff("0");

			//Click generate button
			GenerateDMA_NoReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
			Thread.sleep(3000);
			
			//click DMA wise
			click(element("xpath", "(//a[@class='closed'])[2]"));

			//Select From date
			WebElement date49=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
			click(date49);

			WebElement date50=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date50);
				
			//Select To date
			Thread.sleep(1000);
		    WebElement d51=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
		    click(d51);
		    WebElement d52=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d52);
			
			//Select DMA_NO
			DMA_No(DMAwise);
			
			//Select reports
			DMA_NoReportcategory("Interest Waveoff Report");

			//Enter cutoff value		
			DMA_Nocutoff("0");

			//Click generate button
			GenerateDMA_NoReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
			Thread.sleep(3000);
			
			//click DMA wise
			click(element("xpath", "(//a[@class='closed'])[2]"));

			//Select From date
			WebElement date53=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
			click(date53);

			WebElement date54=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date54);
				
			//Select To date
			Thread.sleep(1000);
		    WebElement d55=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
		    click(d55);
		    WebElement d56=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d56);
			
			//Select DMA_NO
			DMA_No(DMAwise);
			
			//Select reports
			DMA_NoReportcategory("Khata Change Report");

			//Enter cutoff value		
			DMA_Nocutoff("0");

			//Click generate button
			GenerateDMA_NoReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
			Thread.sleep(3000);
			
			//click DMA wise
			click(element("xpath", "(//a[@class='closed'])[2]"));

			//Select From date
			WebElement date57=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
			click(date57);

			WebElement date58=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date58);
				
			//Select To date
			Thread.sleep(1000);
		    WebElement d59=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
		    click(d59);
		    WebElement d60=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d60);
			
			//Select DMA_NO
			DMA_No(DMAwise);
			
			//Select reports
			DMA_NoReportcategory("Rebate Report");

			//Enter cutoff value		
			DMA_Nocutoff("0");

			//Click generate button
			GenerateDMA_NoReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
			Thread.sleep(3000);
			
			//click DMA wise
			click(element("xpath", "(//a[@class='closed'])[2]"));

			//Select From date
			WebElement date61=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
			click(date61);

			WebElement date62=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date62);
				
			//Select To date
			Thread.sleep(1000);
		    WebElement d63=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
		    click(d63);
		    WebElement d64=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d64);
			
			//Select DMA_NO
			DMA_No(DMAwise);
			
			//Select reports
			DMA_NoReportcategory("Reconnection Report");

			//Enter cutoff value		
			DMA_Nocutoff("0");

			//Click generate button
			GenerateDMA_NoReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
			Thread.sleep(3000);
			
			//click DMA wise
			click(element("xpath", "(//a[@class='closed'])[2]"));

			//Select From date
			WebElement date65=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
			click(date65);

			WebElement date66=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date66);
				
			//Select To date
			Thread.sleep(1000);
		    WebElement d67=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
		    click(d67);
		    WebElement d68=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d68);
			
			//Select DMA_NO
			DMA_No(DMAwise);
			
			//Select reports
			DMA_NoReportcategory("Tariff Change Report");

			//Enter cutoff value		
			DMA_Nocutoff("0");

			//Click generate button
			GenerateDMA_NoReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
			Thread.sleep(3000);
		}
		
		//  ---  MIS report abstract DMA wise report finished --- //	
	//  ---  MIS report abstract DMA wise report finished --- //	
	//  ---  MIS report abstract DMA wise report finished --- //	

		//For Ward Wise
		List<String> list14 = new ArrayList<String>();
		list14.add("All");
		
		for (String WardWise : list14) {
			
			//click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));

			//Select From date
			WebElement date69=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
			click(date69);

			WebElement date70=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date70);
				
			//Select To date
			Thread.sleep(1000);
		    WebElement d71=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
		    click(d71);
		    WebElement d72=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d72);
			
			//Select ward no
		    WardNo(WardWise);
			
			//Select reports
		    WardNoReportcategory("Cheque Bounce Report");

			//Enter cutoff value		
		    WardNocutoff("0");

			//Click generate button
		    GenerateWardNoReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuC=44#nbb");
		    Thread.sleep(3000);
		    
		    //click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));

			//Select From date
			WebElement date73=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
			click(date73);

			WebElement date74=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date74);
				
			//Select To date
			Thread.sleep(1000);
		    WebElement d75=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
		    click(d75);
		    WebElement d76=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d76);
			
			//Select ward no
		    WardNo(WardWise);
			
			//Select reports
		    WardNoReportcategory("Deposit Colletion Report");

			//Enter cutoff value		
		    WardNocutoff("0");

			//Click generate button
		    GenerateWardNoReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuC=44#nbb");
		    Thread.sleep(3000);
		    
		    //click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));

			//Select From date
			WebElement date76=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
			click(date76);

			WebElement date77=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date77);
				
			//Select To date
			Thread.sleep(1000);
		    WebElement d78=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
		    click(d78);
		    WebElement d79=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d79);
			
			//Select ward no
		    WardNo(WardWise);
			
			//Select reports
		    WardNoReportcategory("Disconnection Report");

			//Enter cutoff value		
		    WardNocutoff("0");

			//Click generate button
		    GenerateWardNoReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuC=44#nbb");
		    Thread.sleep(3000);
		    
		    //click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));

			//Select From date
			WebElement date80=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
			click(date80);

			WebElement date81=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date81);
				
			//Select To date
			Thread.sleep(1000);
		    WebElement d82=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
		    click(d82);
		    WebElement d83=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d83);
			
			//Select ward no
		    WardNo(WardWise);
			
			//Select reports
		    WardNoReportcategory("Interest Waveoff Report");

			//Enter cutoff value		
		    WardNocutoff("0");

			//Click generate button
		    GenerateWardNoReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuC=44#nbb");
		    Thread.sleep(3000);
		    
		    //click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));

			//Select From date
			WebElement date84=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
			click(date84);

			WebElement date85=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date85);
				
			//Select To date
			Thread.sleep(1000);
		    WebElement d86=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
		    click(d86);
		    WebElement d87=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d87);
			
			//Select ward no
		    WardNo(WardWise);
			
			//Select reports
		    WardNoReportcategory("Khata Change Report");

			//Enter cutoff value		
		    WardNocutoff("0");

			//Click generate button
		    GenerateWardNoReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuC=44#nbb");
		    Thread.sleep(3000);
		    
		    //click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));

			//Select From date
			WebElement date88=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
			click(date88);

			WebElement date89=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date89);
				
			//Select To date
			Thread.sleep(1000);
		    WebElement d90=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
		    click(d90);
		    WebElement d91=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d91);
			
			//Select ward no
		    WardNo(WardWise);
			
			//Select reports
		    WardNoReportcategory("Rebate Report");

			//Enter cutoff value		
		    WardNocutoff("0");

			//Click generate button
		    GenerateWardNoReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuC=44#nbb");
		    Thread.sleep(3000);
		    
		    //click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));

			//Select From date
			WebElement date92=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
			click(date92);

			WebElement date93=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date93);
				
			//Select To date
			Thread.sleep(1000);
		    WebElement d94=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
		    click(d94);
		    WebElement d95=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d95);
			
			//Select ward no
		    WardNo(WardWise);
			
			//Select reports
		    WardNoReportcategory("Reconnection Report");

			//Enter cutoff value		
		    WardNocutoff("0");

			//Click generate button
		    GenerateWardNoReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuC=44#nbb");
		    Thread.sleep(3000);
		    
		    //click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));

			//Select From date
			WebElement date96=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
			click(date96);

			WebElement date97=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date97);
				
			//Select To date
			Thread.sleep(1000);
		    WebElement d98=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
		    click(d98);
		    WebElement d99=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d99);
			
			//Select ward no
		    WardNo(WardWise);
			
			//Select reports
		    WardNoReportcategory("Tariff Change Report");

			//Enter cutoff value		
		    WardNocutoff("0");

			//Click generate button
		    GenerateWardNoReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuC=44#nbb");
		    Thread.sleep(3000);	
		}
		
		//  ---- MIS Report abstract- ward wise report finished ---  //
		//  ---- MIS Report abstract- ward wise report finished ---  //
		//  ---- MIS Report abstract- ward wise report finished ---  //
		
		//For zone Wise
		List<String> list15 = new ArrayList<String>();
		list15.add("ALL");

		for (String zonewise : list15) {
			
			//click ZoneWise
			click(element("xpath", "(//a[@class='closed'])[4]"));

			//Select From date
			WebElement date100=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
			click(date100);

			WebElement date101=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date101);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d102=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
		    click(d102);
		    WebElement d103=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d103);
			
			//Select Zone
		    Zone(zonewise);
			
			//Select reports
		    ZoneReportcategory("Cheque Bounce Report");

			//Enter cutoff value		
		    Zonecutoff("0");

			//Click generate button
		    GenerateZoneReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
		    Thread.sleep(3000);
		    
		    //click ZoneWise
			click(element("xpath", "(//a[@class='closed'])[4]"));

			//Select From date
			WebElement date104=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
			click(date104);

			WebElement date105=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date105);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d106=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
		    click(d106);
		    WebElement d107=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d107);
			
			//Select Zone
		    Zone(zonewise);
			
			//Select reports
		    ZoneReportcategory("Deposit Colletion Report");

			//Enter cutoff value		
		    Zonecutoff("0");

			//Click generate button
		    GenerateZoneReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
		    Thread.sleep(3000);
		    
		    //click ZoneWise
			click(element("xpath", "(//a[@class='closed'])[4]"));

			//Select From date
			WebElement date108=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
			click(date108);

			WebElement date109=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date109);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d110=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
		    click(d110);
		    WebElement d111=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d111);
			
			//Select Zone
		    Zone(zonewise);
			
			//Select reports
		    ZoneReportcategory("Disconnection Report");

			//Enter cutoff value		
		    Zonecutoff("0");

			//Click generate button
		    GenerateZoneReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
		    Thread.sleep(3000);
		    
		    //click ZoneWise
			click(element("xpath", "(//a[@class='closed'])[4]"));

			//Select From date
			WebElement date112=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
			click(date112);

			WebElement date113=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date113);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d114=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
		    click(d114);
		    WebElement d115=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d115);
			
			//Select Zone
		    Zone(zonewise);
			
			//Select reports
		    ZoneReportcategory("Interest Waveoff Report");

			//Enter cutoff value		
		    Zonecutoff("0");

			//Click generate button
		    GenerateZoneReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
		    Thread.sleep(3000);
		    
		    //click ZoneWise
			click(element("xpath", "(//a[@class='closed'])[4]"));

			//Select From date
			WebElement date116=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
			click(date116);

			WebElement date117=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date117);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d118=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
		    click(d118);
		    WebElement d119=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d119);
			
			//Select Zone
		    Zone(zonewise);
			
			//Select reports
		    ZoneReportcategory("Khata Change Report");

			//Enter cutoff value		
		    Zonecutoff("0");

			//Click generate button
		    GenerateZoneReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
		    Thread.sleep(3000);
		    
		  //click ZoneWise
			click(element("xpath", "(//a[@class='closed'])[4]"));

			//Select From date
			WebElement date120=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
			click(date120);

			WebElement date121=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date121);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d122=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
		    click(d122);
		    WebElement d123=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d123);
			
			//Select Zone
		    Zone(zonewise);
			
			//Select reports
		    ZoneReportcategory("Rebate Report");

			//Enter cutoff value		
		    Zonecutoff("0");

			//Click generate button
		    GenerateZoneReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
		    Thread.sleep(3000);
		    
		    //click ZoneWise
			click(element("xpath", "(//a[@class='closed'])[4]"));

			//Select From date
			WebElement date124=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
			click(date124);

			WebElement date125=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date125);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d126=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
		    click(d126);
		    WebElement d127=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d127);
			
			//Select Zone
		    Zone(zonewise);
			
			//Select reports
		    ZoneReportcategory("Reconnection Report");

			//Enter cutoff value		
		    Zonecutoff("0");

			//Click generate button
		    GenerateZoneReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
		    Thread.sleep(3000);
		    
		  //click ZoneWise
			click(element("xpath", "(//a[@class='closed'])[4]"));

			//Select From date
			WebElement date128=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
			click(date128);

			WebElement date129=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date129);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d130=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
		    click(d130);
		    WebElement d131=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d131);
			
			//Select Zone
		    Zone(zonewise);
			
			//Select reports
		    ZoneReportcategory("Tariff Change Report");

			//Enter cutoff value		
		    Zonecutoff("0");

			//Click generate button
		    GenerateZoneReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/abstractReport.do?action=abstractReport&method=display&menuP=8&menuC=44#nbb");
		    Thread.sleep(3000);

		}
		
		
		//  ---- MIS Report abstract- zone wise report finished ---  //
		//  ---- MIS Report abstract- zone wise report finished ---  //
		//  ---- MIS Report abstract- zone wise report finished ---  //

		//For Tariff wise
		List<String> list16 = new ArrayList<String>();
		list16.add("All");

		for (String tariffff : list16) {
			
			//Click MIS report detail
			click(element("classname", "c94"));
			
			//Select From date
			FromDate();
			
			//Select To date
			ToDate();
			
			//Select Tariff 
			Tariff(tariffff);
			
			//Select reports
			TariffReportcategory("Cheque Bounce Report");

			//Enter cutoff value		
			Tariffcutoff("0");

			//Click generate button
			GenerateTariffReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//Select From date
			FromDate();
			
			//Select To date
			ToDate();
			
			//Select Tariff 
			Tariff(tariffff);
			
			//Select reports
			TariffReportcategory("Deposit Colletion Report");

			//Enter cutoff value		
			Tariffcutoff("0");

			//Click generate button
			GenerateTariffReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//Select From date
			FromDate();
			
			//Select To date
			ToDate();
			
			//Select Tariff 
			Tariff(tariffff);
			
			//Select reports
			TariffReportcategory("Disconnection Report");

			//Enter cutoff value		
			Tariffcutoff("0");

			//Click generate button
			GenerateTariffReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//Select From date
			FromDate();
			
			//Select To date
			ToDate();
			
			//Select Tariff 
			Tariff(tariffff);
			
			//Select reports
			TariffReportcategory("Interest Waveoff Report");

			//Enter cutoff value		
			Tariffcutoff("0");

			//Click generate button
			GenerateTariffReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//Select From date
			FromDate();
			
			//Select To date
			ToDate();
			
			//Select Tariff 
			Tariff(tariffff);
			
			//Select reports
			TariffReportcategory("Khata Change Report");

			//Enter cutoff value		
			Tariffcutoff("0");

			//Click generate button
			GenerateTariffReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//Select From date
			FromDate();
			
			//Select To date
			ToDate();
			
			//Select Tariff 
			Tariff(tariffff);
			
			//Select reports
			TariffReportcategory("Rebate Report");

			//Enter cutoff value		
			Tariffcutoff("0");

			//Click generate button
			GenerateTariffReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//Select From date
			FromDate();
			
			//Select To date
			ToDate();
			
			//Select Tariff 
			Tariff(tariffff);
			
			//Select reports
			TariffReportcategory("Reconnection Report");

			//Enter cutoff value		
			Tariffcutoff("0");

			//Click generate button
			GenerateTariffReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//Select From date
			FromDate();
			
			//Select To date
			ToDate();
			
			//Select Tariff 
			Tariff(tariffff);
			
			//Select reports
			TariffReportcategory("Tariff Change Report");

			//Enter cutoff value		
			Tariffcutoff("0");

			//Click generate button
			GenerateTariffReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
		}
		
		//  ----- Mis report details -> Tariff wise finished ---- //
	//  ----- Mis report details -> Tariff wise finished ---- //
	//  ----- Mis report details -> Tariff wise finished ---- //
		
		//For DMA wise
		List<String> list17 = new ArrayList<String>();
		list17.add("All");

		for (String DMA11 : list17) {
			
			//click DMA wise
			click(element("xpath", "(//a[@class='closed'])[2]"));

			//Select From date
			WebElement date132=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
			click(date132);

			WebElement date133=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date133);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d134=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
		    click(d134);
		    WebElement d135=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d135);
			
			//Select DMA_NO
			DMA_No(DMA11);
			
			//Select reports
			DMA_NoReportcategory("Cheque Bounce Report");

			//Enter cutoff value		
			DMA_Nocutoff("0");

			//Click generate button
			GenerateDMA_NoReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//click DMA wise
			click(element("xpath", "(//a[@class='closed'])[2]"));

			//Select From date
			WebElement date136=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
			click(date136);

			WebElement date137=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date137);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d138=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
		    click(d138);
		    WebElement d139=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d139);
			
			//Select DMA_NO
			DMA_No(DMA11);
			
			//Select reports
			DMA_NoReportcategory("Deposit Colletion Report");

			//Enter cutoff value		
			DMA_Nocutoff("0");

			//Click generate button
			GenerateDMA_NoReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//click DMA wise
			click(element("xpath", "(//a[@class='closed'])[2]"));

			//Select From date
			WebElement date140=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
			click(date140);

			WebElement date141=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date141);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d142=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
		    click(d142);
		    WebElement d143=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d143);
			
			//Select DMA_NO
			DMA_No(DMA11);
			
			//Select reports
			DMA_NoReportcategory("Disconnection Report");

			//Enter cutoff value		
			DMA_Nocutoff("0");

			//Click generate button
			GenerateDMA_NoReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//click DMA wise
			click(element("xpath", "(//a[@class='closed'])[2]"));

			//Select From date
			WebElement date144=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
			click(date144);

			WebElement date145=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date145);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d146=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
		    click(d146);
		    WebElement d147=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d147);
			
			//Select DMA_NO
			DMA_No(DMA11);
			
			//Select reports
			DMA_NoReportcategory("Interest Waveoff Report");

			//Enter cutoff value		
			DMA_Nocutoff("0");

			//Click generate button
			GenerateDMA_NoReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//click DMA wise
			click(element("xpath", "(//a[@class='closed'])[2]"));

			//Select From date
			WebElement date148=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
			click(date148);

			WebElement date149=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date149);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d150=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
		    click(d150);
		    WebElement d151=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d151);
			
			//Select DMA_NO
			DMA_No(DMA11);
			
			//Select reports
			DMA_NoReportcategory("Khata Change Report");

			//Enter cutoff value		
			DMA_Nocutoff("0");

			//Click generate button
			GenerateDMA_NoReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//click DMA wise
			click(element("xpath", "(//a[@class='closed'])[2]"));

			//Select From date
			WebElement date152=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
			click(date152);

			WebElement date153=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date153);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d154=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
		    click(d154);
		    WebElement d155=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d155);
			
			//Select DMA_NO
			DMA_No(DMA11);
			
			//Select reports
			DMA_NoReportcategory("Rebate Report");

			//Enter cutoff value		
			DMA_Nocutoff("0");

			//Click generate button
			GenerateDMA_NoReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//click DMA wise
			click(element("xpath", "(//a[@class='closed'])[2]"));

			//Select From date
			WebElement date156=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
			click(date156);

			WebElement date157=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date157);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d158=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
		    click(d158);
		    WebElement d159=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d159);
			
			//Select DMA_NO
			DMA_No(DMA11);
			
			//Select reports
			DMA_NoReportcategory("Reconnection Report");

			//Enter cutoff value		
			DMA_Nocutoff("0");

			//Click generate button
			GenerateDMA_NoReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			

			//click DMA wise
			click(element("xpath", "(//a[@class='closed'])[2]"));

			//Select From date
			WebElement date160=element("xpath", "(//img[@class='ui-datepicker-trigger'])[5]");
			click(date160);

			WebElement date161=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date161);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d162=element("xpath", "(//img[@class='ui-datepicker-trigger'])[6]");
		    click(d162);
		    WebElement d163=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d163);
			
			//Select DMA_NO
			DMA_No(DMA11);
			
			//Select reports
			DMA_NoReportcategory("Tariff Change Report");

			//Enter cutoff value		
			DMA_Nocutoff("0");

			//Click generate button
			GenerateDMA_NoReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
		}
		
		//  ----- Mis report details -> DMA wise finished ---- //
		//  ----- Mis report details -> DMA wise finished ---- //
		//  ----- Mis report details -> DMA wise finished ---- //
		

		//For MR wise
		List<String> list18 = new ArrayList<String>();
		list18.add("All");

		for (String MR11 : list18) {
			
			//click MR wise
			click(element("xpath", "(//a[@class='closed'])[1]"));

			//Select From date
		    WebElement date200=element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		    click(date200);
		   
		    WebElement date201=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date201);
			
			//Select To date
			Thread.sleep(1000);
		    WebElement d202=element("xpath", "(//img[@class='ui-datepicker-trigger'])[4]");
		    click(d202);
		    WebElement d203=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d203);
			
			//Select MR id
			Mrid(MR11);
			
			//Select reports
			MRidReportcategory("Cheque Bounce Report");

			//Enter cutoff value		
			Mridcutoff("0");

			//Click generate button
			GenerateMridReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//click MR wise
			click(element("xpath", "(//a[@class='closed'])[1]"));

			//Select From date
		    WebElement date204=element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		    click(date204);
		   
		    WebElement date205=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date205);
			
			//Select To date
			Thread.sleep(1000);
		    WebElement d206=element("xpath", "(//img[@class='ui-datepicker-trigger'])[4]");
		    click(d206);
		    WebElement d207=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d207);
			
			//Select MR id
			Mrid(MR11);
			
			//Select reports
			MRidReportcategory("Deposit Colletion Report");

			//Enter cutoff value		
			Mridcutoff("0");

			//Click generate button
			GenerateMridReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//click MR wise
			click(element("xpath", "(//a[@class='closed'])[1]"));

			//Select From date
		    WebElement date208=element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		    click(date208);
		   
		    WebElement date209=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date209);
			
			//Select To date
			Thread.sleep(1000);
		    WebElement d210=element("xpath", "(//img[@class='ui-datepicker-trigger'])[4]");
		    click(d210);
		    WebElement d211=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d211);
			
			//Select MR id
			Mrid(MR11);
			
			//Select reports
			MRidReportcategory("Disconnection Report");

			//Enter cutoff value		
			Mridcutoff("0");

			//Click generate button
			GenerateMridReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//click MR wise
			click(element("xpath", "(//a[@class='closed'])[1]"));

			//Select From date
		    WebElement date212=element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		    click(date212);
		   
		    WebElement date213=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date213);
			
			//Select To date
			Thread.sleep(1000);
		    WebElement d214=element("xpath", "(//img[@class='ui-datepicker-trigger'])[4]");
		    click(d214);
		    WebElement d215=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d215);
			
			//Select MR id
			Mrid(MR11);
			
			//Select reports
			MRidReportcategory("Interest Waveoff Report");

			//Enter cutoff value		
			Mridcutoff("0");

			//Click generate button
			GenerateMridReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			

			//click MR wise
			click(element("xpath", "(//a[@class='closed'])[1]"));

			//Select From date
		    WebElement date216=element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		    click(date216);
		   
		    WebElement date217=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date217);
			
			//Select To date
			Thread.sleep(1000);
		    WebElement d218=element("xpath", "(//img[@class='ui-datepicker-trigger'])[4]");
		    click(d218);
		    WebElement d219=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d219);
			
			//Select MR id
			Mrid(MR11);
			
			//Select reports
			MRidReportcategory("Khata Change Report");

			//Enter cutoff value		
			Mridcutoff("0");

			//Click generate button
			GenerateMridReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//click MR wise
			click(element("xpath", "(//a[@class='closed'])[1]"));

			//Select From date
		    WebElement date220=element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		    click(date220);
		   
		    WebElement date221=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date221);
			
			//Select To date
			Thread.sleep(1000);
		    WebElement d222=element("xpath", "(//img[@class='ui-datepicker-trigger'])[4]");
		    click(d222);
		    WebElement d223=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d223);
			
			//Select MR id
			Mrid(MR11);
			
			//Select reports
			MRidReportcategory("Rebate Report");

			//Enter cutoff value		
			Mridcutoff("0");

			//Click generate button
			GenerateMridReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//click MR wise
			click(element("xpath", "(//a[@class='closed'])[1]"));

			//Select From date
		    WebElement date224=element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		    click(date224);
		   
		    WebElement date225=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date225);
			
			//Select To date
			Thread.sleep(1000);
		    WebElement d226=element("xpath", "(//img[@class='ui-datepicker-trigger'])[4]");
		    click(d226);
		    WebElement d227=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d227);
			
			//Select MR id
			Mrid(MR11);
			
			//Select reports
			MRidReportcategory("Reconnection Report");

			//Enter cutoff value		
			Mridcutoff("0");

			//Click generate button
			GenerateMridReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
			
			//click MR wise
			click(element("xpath", "(//a[@class='closed'])[1]"));

			//Select From date
		    WebElement date228=element("xpath", "(//img[@class='ui-datepicker-trigger'])[3]");
		    click(date228);
		   
		    WebElement date229=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date229);
			
			//Select To date
			Thread.sleep(1000);
		    WebElement d230=element("xpath", "(//img[@class='ui-datepicker-trigger'])[4]");
		    click(d230);
		    WebElement d231=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d231);
			
			//Select MR id
			Mrid(MR11);
			
			//Select reports
			MRidReportcategory("Tariff Change Report");

			//Enter cutoff value		
			Mridcutoff("0");

			//Click generate button
			GenerateMridReport();
			Thread.sleep(6000);
			driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
			Thread.sleep(3000);
		}
		
		// ---- Mis report details -> Mr wise finished ---- //
		// ---- Mis report details -> Mr wise finished ---- //
		// ---- Mis report details -> Mr wise finished ---- //
		
		//For ward wise
		List<String> list19 = new ArrayList<String>();
		list19.add("All");

		for (String ward11 : list19) {

			//click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));

			//Select From date
			WebElement date232=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
			click(date232);

			WebElement date233=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date233);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d234=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
		    click(d234);
		    WebElement d235=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d235);
			
			//Select ward no
		    WardNo(ward11);
			
			//Select reports
		    WardNoReportcategory("Cheque Bounce Report");

			//Enter cutoff value		
		    WardNocutoff("0");

			//Click generate button
		    GenerateWardNoReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		    
		  //click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));

			//Select From date
			WebElement date236=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
			click(date236);

			WebElement date237=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date237);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d238=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
		    click(d238);
		    WebElement d239=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d239);
			
			//Select ward no
		    WardNo(ward11);
			
			//Select reports
		    WardNoReportcategory("Deposit Colletion Report");

			//Enter cutoff value		
		    WardNocutoff("0");

			//Click generate button
		    GenerateWardNoReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		    
		    //click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));

			//Select From date
			WebElement date240=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
			click(date240);

			WebElement date241=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date241);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d242=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
		    click(d242);
		    WebElement d243=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d243);
			
			//Select ward no
		    WardNo(ward11);
			
			//Select reports
		    WardNoReportcategory("Disconnection Report");

			//Enter cutoff value		
		    WardNocutoff("0");

			//Click generate button
		    GenerateWardNoReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		    
		  //click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));

			//Select From date
			WebElement date244=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
			click(date244);

			WebElement date245=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date245);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d246=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
		    click(d246);
		    WebElement d247=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d247);
			
			//Select ward no
		    WardNo(ward11);
			
			//Select reports
		    WardNoReportcategory("Interest Waveoff Report");

			//Enter cutoff value		
		    WardNocutoff("0");

			//Click generate button
		    GenerateWardNoReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		    
		  //click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));

			//Select From date
			WebElement date248=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
			click(date248);

			WebElement date249=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date249);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d250=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
		    click(d250);
		    WebElement d251=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d251);
			
			//Select ward no
		    WardNo(ward11);
			
			//Select reports
		    WardNoReportcategory("Khata Change Report");

			//Enter cutoff value		
		    WardNocutoff("0");

			//Click generate button
		    GenerateWardNoReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		    
		    //click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));

			//Select From date
			WebElement date252=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
			click(date252);

			WebElement date253=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date253);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d254=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
		    click(d254);
		    WebElement d255=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d255);
			
			//Select ward no
		    WardNo(ward11);
			
			//Select reports
		    WardNoReportcategory("Rebate Report");

			//Enter cutoff value		
		    WardNocutoff("0");

			//Click generate button
		    GenerateWardNoReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		    
		  //click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));

			//Select From date
			WebElement date256=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
			click(date256);

			WebElement date257=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date257);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d258=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
		    click(d258);
		    WebElement d259=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d259);
			
			//Select ward no
		    WardNo(ward11);
			
			//Select reports
		    WardNoReportcategory("Reconnection Report");

			//Enter cutoff value		
		    WardNocutoff("0");

			//Click generate button
		    GenerateWardNoReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		    
		    //click WardWise
			click(element("xpath", "(//a[@class='closed'])[3]"));

			//Select From date
			WebElement date260=element("xpath", "(//img[@class='ui-datepicker-trigger'])[7]");
			click(date260);

			WebElement date261=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date261);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d262=element("xpath", "(//img[@class='ui-datepicker-trigger'])[8]");
		    click(d262);
		    WebElement d263=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d263);
			
			//Select ward no
		    WardNo(ward11);
			
			//Select reports
		    WardNoReportcategory("Tariff Change Report");

			//Enter cutoff value		
		    WardNocutoff("0");

			//Click generate button
		    GenerateWardNoReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		}
		
		// Ward finished //
		// Ward finished //
		// Ward finished //
		
		//For zone wise
		List<String> list20 = new ArrayList<String>();
		list20.add("ALL");

		for (String zone11 : list20) {

			//click ZoneWise
			click(element("xpath", "(//a[@class='closed'])[4]"));

			//Select From date
			WebElement date264=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
			click(date264);

			WebElement date265=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date265);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d266=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
		    click(d266);
		    WebElement d267=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d267);
			
			//Select Zone
		    Zone(zone11);
			
			//Select reports
		    ZoneReportcategory("Cheque Bounce Report");

			//Enter cutoff value		
		    Zonecutoff("0");

			//Click generate button
		    GenerateZoneReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		    
		  //click ZoneWise
			click(element("xpath", "(//a[@class='closed'])[4]"));

			//Select From date
			WebElement date268=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
			click(date268);

			WebElement date269=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date269);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d270=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
		    click(d270);
		    WebElement d271=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d271);
			
			//Select Zone
		    Zone(zone11);
			
			//Select reports
		    ZoneReportcategory("Deposit Colletion Report");

			//Enter cutoff value		
		    Zonecutoff("0");

			//Click generate button
		    GenerateZoneReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		    
		    
		    //click ZoneWise
		    click(element("xpath", "(//a[@class='closed'])[4]"));

		    //Select From date
		    WebElement date272=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
		    click(date272);

		    WebElement date273=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date273);


		    //Select To date
		    Thread.sleep(1000);
		    WebElement d274=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
		    click(d274);
		    WebElement d275=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d275);

		    //Select Zone
		    Zone(zone11);

		    //Select reports
		    ZoneReportcategory("Disconnection Report");

		    //Enter cutoff value		
		    Zonecutoff("0");

		    //Click generate button
		    GenerateZoneReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		    
		  //click ZoneWise
		    click(element("xpath", "(//a[@class='closed'])[4]"));

		    //Select From date
		    WebElement date276=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
		    click(date276);

		    WebElement date277=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date277);


		    //Select To date
		    Thread.sleep(1000);
		    WebElement d278=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
		    click(d278);
		    WebElement d279=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d279);

		    //Select Zone
		    Zone(zone11);

		    //Select reports
		    ZoneReportcategory("Interest Waveoff Report");

		    //Enter cutoff value		
		    Zonecutoff("0");

		    //Click generate button
		    GenerateZoneReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		    
		  //click ZoneWise
		    click(element("xpath", "(//a[@class='closed'])[4]"));

		    //Select From date
		    WebElement date280=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
		    click(date280);

		    WebElement date281=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date281);


		    //Select To date
		    Thread.sleep(1000);
		    WebElement d282=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
		    click(d282);
		    WebElement d283=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d283);

		    //Select Zone
		    Zone(zone11);

		    //Select reports
		    ZoneReportcategory("Khata Change Report");

		    //Enter cutoff value		
		    Zonecutoff("0");

		    //Click generate button
		    GenerateZoneReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		    
		  //click ZoneWise
		    click(element("xpath", "(//a[@class='closed'])[4]"));

		    //Select From date
		    WebElement date284=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
		    click(date284);

		    WebElement date285=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date285); 


		    //Select To date
		    Thread.sleep(1000);
		    WebElement d286=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
		    click(d286);
		    WebElement d287=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d287);

		    //Select Zone
		    Zone(zone11);

		    //Select reports
		    ZoneReportcategory("Rebate Report");

		    //Enter cutoff value		
		    Zonecutoff("0");

		    //Click generate button
		    GenerateZoneReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		    
		  //click ZoneWise
		    click(element("xpath", "(//a[@class='closed'])[4]"));

		    //Select From date
		    WebElement date288=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
		    click(date288);

		    WebElement date289=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date289); 


		    //Select To date
		    Thread.sleep(1000);
		    WebElement d290=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
		    click(d290);
		    WebElement d291=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d291);

		    //Select Zone
		    Zone(zone11);

		    //Select reports
		    ZoneReportcategory("Reconnection Report");

		    //Enter cutoff value		
		    Zonecutoff("0");

		    //Click generate button
		    GenerateZoneReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		    
		    //click ZoneWise
		    click(element("xpath", "(//a[@class='closed'])[4]"));

		    //Select From date
		    WebElement date292=element("xpath", "(//img[@class='ui-datepicker-trigger'])[9]");
		    click(date292);

		    WebElement date293=element("xpath", "(//a[@class='ui-state-default'])[1]");
		    click(date293); 


		    //Select To date
		    Thread.sleep(1000);
		    WebElement d294=element("xpath", "(//img[@class='ui-datepicker-trigger'])[10]");
		    click(d294);
		    WebElement d295=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d295);

		    //Select Zone
		    Zone(zone11);

		    //Select reports
		    ZoneReportcategory("Tariff Change Report");

		    //Enter cutoff value		
		    Zonecutoff("0");

		    //Click generate button
		    GenerateZoneReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		}
		
		// For LNT wise
		List<String> list21 = new ArrayList<String>();
		list21.add("ALL");

		for (String LNT11 : list21) {
			
			//click LNT wise
			click(element("linkText", "LNT Report"));

			//Select From date
			WebElement date296=element("xpath", "(//img[@class='ui-datepicker-trigger'])[11]");
			click(date296);

			WebElement date297=element("xpath", "(//a[@class='ui-state-default'])[1]");
			click(date297);
				

			//Select To date
			Thread.sleep(1000);
		    WebElement d298=element("xpath", "(//img[@class='ui-datepicker-trigger'])[12]");
		    click(d298);
		    WebElement d299=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
		    click(d299);
			
			//Select billed
		    billed(LNT11);
		    
			//Select reports
		    LNTReportcategory("Daily Billed Consumer Report");

			//Click generate button
		    GenerateLNTReport();
		    Thread.sleep(6000);
		    driver.navigate().to("http://192.168.0.143:6060/ubarms/detailReport.do?action=detailReport&method=display&menuC=94#nbb");
		    Thread.sleep(3000);
		}


	}

	//@AfterTest
	public void signout(){
		 driver.findElement(By.xpath("//img[@title='SignOut']")).click();
	}
	}