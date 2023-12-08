package new_user_registration;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ConsumerDetails extends New_User_Reg {
	@DataProvider(name="Consumer_Id")
	public String[][] getData1() throws IOException{
		String[][] excelData1= New_User_Excel.getExcelData("Consumer_Id");
		
		return excelData1;
	}
	//(dataProvider="Consumer_Id")
	//String data[]
	//@Test(dataProvider="Consumer_Id")
	public void Modify_Consumer_Details(String data[]) throws InterruptedException{
		
		//Click Consumer Management
		WebElement Consumer_Management=element("linkText", "Consumer Management");
		click(Consumer_Management);
		
		//Click Consumer Details
		WebElement consumer_details=element("xpath", "//a[@class='c2']");
		click(consumer_details);
		
		//Enter Consumer_Id
		WebElement ConsumerId=element("name", "consumerId");
		sendkeys_clickEnter(ConsumerId, data[0]);
		
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
        selectByVisibleText(mrName, "UMESH");
          
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
        WebElement consumerid_click=element("xpath", "//a[.='"+data[0]+"']");
        click(consumerid_click);
        
        
        //
        WindowApprove();
     
        
        
	}
	
	
}
