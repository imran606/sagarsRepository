package sagar_selenium_base;

import java.io.File;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Base implements SeleniumBase {

	long timeOuts = 10;
	long maxWaitTime = 10;

	protected RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	
	public void setUp(String url) throws InterruptedException, IOException {
		//ChromeOptions co= new ChromeOptions();
		//co.setBinary("C:\\Users\\DELL\\Downloads\\NewVersionChromeForTesting\\chrome-win64\\chrome.exe");
		ChromeOptions co = new ChromeOptions();
		co.setBrowserVersion("116");
		driver = new ChromeDriver(co);
		int width = 1366;
		int height = 768;
		Dimension dimension = new Dimension(width, height);
		driver.manage().window().setSize(dimension);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOuts));
		driver.get(url);
		wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTime));
	    driver.findElement(By.id("slidesli")).click();//Select billing img
		//driver.findElement(By.id("ubarmsli")).click(); //select crm img
		//click(element("id", "crmli")); //Cash Counter
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='loginbutton']")).click(); //Click login button

	}

	public void setUp(String browserName, String url) throws InterruptedException {
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.err.println("Driver is not defined");
			break;
		}
		int width = 1366;
		int height = 768;
		Dimension dimension = new Dimension(width, height);
		driver.manage().window().setSize(dimension);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTime));
		driver.findElement(By.id("slidesli")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='loginbutton']")).click();


	}

	public void close() {
		driver.close();
	}

	public void quit() {
		driver.quit();
	}

	public WebElement element(String type, String value) {
		switch (type) {
		case "id":
			return driver.findElement(By.id(value));
		case "name":
			return driver.findElement(By.name(value));
		case "xpath":
			return driver.findElement(By.xpath(value));	
		case "classname":
			return driver.findElement(By.className(value));
		case "linkText":
			return driver.findElement(By.linkText(value));

		default:
			break;
		}
		return null;
	}

	public void switcToWindow(int i) {

	}

	public void selectByvalue(WebElement ele, String value) {


	}

	public void selectByVisibleText(WebElement ele, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		Select select= new Select(ele);
		select.selectByVisibleText(text);
	}

	public void selectByIndex(WebElement ele, int position) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		Select select= new Select(ele);
		select.selectByIndex(position);


	}

	public void click(WebElement ele) {
		WebElement element=wait.withMessage("Element is not clickable").until(ExpectedConditions.elementToBeClickable(ele));
		element.click();

	}

	public void clear_text_and_type(WebElement ele, String testData) {
		WebElement element=wait.until(ExpectedConditions.visibilityOf(ele));
        element.clear();
        element.sendKeys(testData);

	}
	public void clear_text_and_type_clickEnter(WebElement ele, String testData) {
		WebElement element=wait.until(ExpectedConditions.visibilityOf(ele));
        element.clear();
        element.sendKeys(testData, Keys.ENTER);

	}
	public void sendkeys_clickEnter(WebElement ele, String testData) {
		WebElement element=wait.until(ExpectedConditions.visibilityOf(ele));
        element.sendKeys(testData, Keys.ENTER);
    }
	public void sendkeys(WebElement ele, String testData) {
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(ele));
        element.sendKeys(testData);
    }
	
	public void clickAdmin() {
		WebElement approve=driver.findElement(By.xpath("//img[@title='approvals']"));
	    wait.until(ExpectedConditions.elementToBeClickable(approve));
	    approve.click(); 
	}
	
	public void FromDate() throws InterruptedException {
		Thread.sleep(1000);
	   
	    WebElement date1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[1]");
	    click(date1);
	    
	    //If the month's second day comes mean use the below code by uncommenting them
	    WebElement date2=element("xpath", "(//a[@class='ui-state-default'])[1]");
	    click(date2);
	    
	    //If the month's first day comes mean use the below code by uncommenting them
	    //WebElement date2=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
	    //click(date2);
	    
	    
	}
	
	public void ToDate() throws InterruptedException {
		Thread.sleep(1000);
	    WebElement d1=element("xpath", "(//img[@class='ui-datepicker-trigger'])[2]");
	    click(d1);
	    WebElement d2=element("xpath", "//a[contains(concat(' ', normalize-space(@class), ' '), ' ui-state-default ui-state-highlight ')]");
	    click(d2);
	}
	
	public void EnterCategory(String ele) throws InterruptedException {
		Thread.sleep(2000);
		WebElement Category=element("name", "category");
		selectByVisibleText(Category, ele);
	}
	
	public void AdminSubmit() throws InterruptedException {
		Thread.sleep(1000);
	    //driver.findElement(By.xpath("//input[@value='Submit']")).click();
	    WebElement admin=element("xpath", "//input[@value='Submit']");
	    click(admin);
	}
	
	public void WindowApprove() throws InterruptedException {
		Thread.sleep(1000);
		Set<String> WindowHandles=driver.getWindowHandles();
		List<String> list = new ArrayList<String>(WindowHandles);

		//Approval page
		Thread.sleep(1000);
		driver.switchTo().window(list.get(1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@value='Approve'])[1]")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		driver.switchTo().window(list.get(0));
		Thread.sleep(1000);
	}
	
	public void houseType(String type) {
        WebElement HouseType=element("name", "hType");
        selectByVisibleText(HouseType, type);
	}
	
	public void AreaName(String areaname) {
        WebElement AreaName=element("name", "preAreaName");
        selectByVisibleText(AreaName, areaname);
	}
	
	public void zone(String zone) {
        WebElement Zone1=element("name", "preZone");
        selectByVisibleText(Zone1, zone);
	}
	public void MeterType(String metertype) {
        WebElement Meter_Type1=element("name", "meterType");
        selectByVisibleText(Meter_Type1, metertype);
	}
	
	//Mis reports Abstract --> Tariff Wise
	public void TariffReportcategory(String categoryname) {
		//Select reports
		WebElement reports=element("name", "category");
		selectByVisibleText(reports, categoryname);
	}
	
	public void Tariff(String tariff) {
		WebElement Tariff=element("xpath", "//select[@name='tariff']");
		selectByVisibleText(Tariff, tariff);
	}
	
	public void Tariffcutoff(String value) {
		sendkeys(element("name", "cutOffValue"),value);
	}
	
	public void GenerateTariffReport() {
		click(element("xpath", "(//input[@value='Generate'])[1]"));
	}
	
	
	
	//Mis reports Abstract --> Mrid Wise
	public void Mrid(String categoryname) {
		WebElement Mrid=element("name", "mrId");
		selectByVisibleText(Mrid, categoryname);
	}
	
	public void MRidReportcategory(String categoryname) {
		//Select reports
		WebElement reports=element("name", "category1");
		selectByVisibleText(reports, categoryname);
	}
	
	public void Mridcutoff(String value) {
		sendkeys(element("name", "cutOffValue1"),value);
	}
	
	public void GenerateMridReport() {
		click(element("xpath", "(//input[@value='Generate'])[2]"));
	}
	
	//Scroll option
	public void scroll(WebElement value) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",value);
		value.click();
	}
	
	//DMAWise Report 
	public void DMA_No(String DmaNo) {
		WebElement dma=element("name", "dma");
		selectByVisibleText(dma, DmaNo);
	}
	
	public void DMA_NoReportcategory(String categoryname) {
		//Select reports
		WebElement reports=element("name", "category2");
		selectByVisibleText(reports, categoryname);
	}
	
	public void DMA_Nocutoff(String value) {
		sendkeys(element("name", "cutOffValue2"),value);
	}
	
	public void GenerateDMA_NoReport() {
		click(element("xpath", "(//input[@value='Generate'])[3]"));
	}
	
	//WardWise Report
	public void WardNo(String WardNo) {
		WebElement wno=element("name", "ward");
		selectByVisibleText(wno, WardNo);
	}
	
	public void WardNoReportcategory(String categoryname) {
		//Select reports
		WebElement reports=element("name", "category3");
		selectByVisibleText(reports, categoryname);
	}
	
	public void WardNocutoff(String value) {
		sendkeys(element("name", "cutOffValue3"),value);
	}
	
	public void GenerateWardNoReport() {
		click(element("xpath", "(//input[@value='Generate'])[4]"));
	}
	
	//ZoneWise Report
	public void Zone(String zone) {
		WebElement z=element("name", "zone");
		selectByVisibleText(z, zone);
	}
	
	public void ZoneReportcategory(String categoryname) {
		//Select reports
		WebElement reports=element("name", "category4");
		selectByVisibleText(reports, categoryname);
	}
	
	public void Zonecutoff(String value) {
		sendkeys(element("name", "cutOffValue4"),value);
	}
	
	public void GenerateZoneReport() {
		click(element("xpath", "(//input[@value='Generate'])[5]"));
	}
	
	public void billed(String value) {
	    WebElement billed=driver.findElement(By.name("lntReport"));
	    selectByVisibleText(billed, value);
	}
	
	public void LNTReportcategory(String categoryname) {
		//Select reports
		WebElement reports=element("name", "category5");
		selectByVisibleText(reports, categoryname);
	}
	
	public void GenerateLNTReport() {
		click(element("xpath", "(//input[@value='Generate'])[6]"));
	}
	
    public String getFile(String filename) {
    	return new File("./Files/"+filename+"").getAbsolutePath();
    }
	
	
	
}
