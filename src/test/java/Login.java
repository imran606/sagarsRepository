
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.firefox.GeckoDriverService;

public class Login {
	RemoteWebDriver driver;
	
	@DataProvider(name="login")
	public String[][] getData() throws IOException{
		String[][] excelData= ReadExcel.getExcelData();
		
		return excelData;
		}
	

	@Test(dataProvider="login")
	public void Billing_Revenue_Management_Login(String data[]) throws InterruptedException, IOException, TesseractException {
		//System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.get("http://192.168.0.143:6060/ubarms/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("slidesli")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='userName']")).clear();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(data[0]);
		
		driver.findElement(By.xpath("//input[@name='password']")).clear();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data[1]);
		
		
		Thread.sleep(1000);
	    WebElement Img=driver.findElement(By.xpath("//input[@id='mainCaptcha']"));
		File src=Img.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Captcha/captcha.png";
		FileHandler.copy(src, new File(path));
		
		ITesseract image = new Tesseract();
		String imageText=image.doOCR(new File(path));
		imageText=imageText.substring(0,imageText.length()-2);

		
		driver.findElement(By.xpath("//input[@id='txtInput']")).sendKeys(imageText);
		driver.findElement(By.xpath("//div[@class='loginbutton']")).click();
		
		String UserName=driver.findElement(By.xpath("//input[@name='loginUser']")).getAttribute("value");
		Assert.assertEquals(data[0], UserName);
			  
	}
	
	

}
