package sagar_selenium_base;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public interface SeleniumBase {
	/**
	 * This will launch the chrome browser with given URL
	 * @author Deepak
	 * @param url
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @exception NullPointerException
	 */
	
	void setUp(String url) throws InterruptedException, IOException;
	
	/**
	 * This method will launch the given browser with given URL
	 * @author Deepak
	 * @param browserName
	 * @param url
	 * @throws InterruptedException 
	 */
	
	void setUp(String browserName, String url) throws InterruptedException;
	
	void close();
	
	void quit();
	
	/**
	 * This method is used to find any webelement with in the page
	 * @param type - element type eg - id, name or linkText
	 * @param value - element value
	 * @return
	 */
	
	WebElement element(String type, String value);
	
	void switcToWindow(int i);
	
	void selectByvalue(WebElement ele, String value);
	
	void selectByVisibleText(WebElement ele, String text);
	
	void selectByIndex(WebElement ele, int position);
	
	void click(WebElement ele);
	
	void clear_text_and_type(WebElement ele, String testData);
	
	void sendkeys(WebElement ele, String testData);
	
	void clickAdmin();
	
	void FromDate() throws InterruptedException;
	
	void ToDate() throws InterruptedException;
	
	void EnterCategory(String ele) throws InterruptedException;
	
	void AdminSubmit() throws InterruptedException;
	
	void WindowApprove() throws InterruptedException;
	
	void houseType(String type);
	
	void AreaName(String areaname);
	
	void zone(String zone);
	
	void MeterType(String metertype);
	
	
	
	
	
	
	

}
