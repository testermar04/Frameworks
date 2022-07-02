package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {
	
	protected FileInputStream fis1;
	
	protected Properties pr1;
	
	protected FileInputStream fis2;
	
	protected XSSFWorkbook wb2;
	
	protected XSSFSheet ws2;
	
	public static WebDriver driver;
	
	public static ExtentReports reports;
	
	public static ExtentTest test;
	
	
	@BeforeTest
	public void reportSetUp()
	{
		
		
		String srcDirPath=System.getProperty("user.dir")+"\\Reports";
		
		File srcDir=new File(srcDirPath);
		
		srcDir.mkdir();
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		
		date=date.replace(":", "-");
		
		
		System.out.println(date);
		
		reports=new ExtentReports();
		
		test = reports.createTest("Regression Test");
		
		String reportFilePath=srcDirPath+"\\"+date+".html";
		
		ExtentSparkReporter extent=new ExtentSparkReporter(reportFilePath);
		
		extent.config().setDocumentTitle("Adactin Regression Test Reports ");
		
		extent.config().setReportName("Regression Report");
		
		extent.config().setTheme(Theme.DARK);
		
		reports.attachReporter(extent);
		
		
	}
	
	
	@AfterTest
	public void flushReports()
	{
		reports.flush();
	}
	
	
	@BeforeClass
	public void baseSetUp() throws IOException
	{
		
		fis1=new FileInputStream("Properties\\config.properties");
		
		pr1=new Properties();
		
		pr1.load(fis1);
		
		
		fis2=new FileInputStream("src\\test\\resources\\testdata\\excels\\LoginData.xlsx");
		
		wb2=new XSSFWorkbook(fis2);
		
		ws2=wb2.getSheet("credentials");
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		String browserName=pr1.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		
		driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
		
		System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
		
		driver=new FirefoxDriver();
		}
			
		
		driver.get(pr1.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Long.parseLong(pr1.getProperty("implicitWait")), TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		
		driver.quit();
	}
	

}
