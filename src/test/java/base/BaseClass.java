package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	
	protected FileInputStream fis1;
	protected Properties pr1;
	
	protected FileInputStream fis2;
	protected XSSFWorkbook wb2;
	protected XSSFSheet ws2;
	
	protected FileInputStream fis3;
	protected Properties pr3;
	
	protected FileInputStream fis4;
	protected XSSFWorkbook wb4;
	protected XSSFSheet ws4;
	
	@BeforeClass
	public void fileSetUp() throws IOException
	{
		
		fis1=new FileInputStream("Properties\\config.properties");
		
		pr1=new Properties();
		
		pr1.load(fis1);
		
		
		fis2=new FileInputStream("src\\test\\resources\\testdata\\excels\\LoginKeywords.xlsx");
		
		wb2=new XSSFWorkbook(fis2);
		
		ws2=wb2.getSheet("Sheet1");
		
		fis3=new FileInputStream("Properties\\locators.properties");
		
		pr3=new Properties();
		
		pr3.load(fis3);
		
		fis4=new FileInputStream("src\\test\\resources\\testdata\\excels\\LoginData.xlsx");
		
		wb4=new XSSFWorkbook(fis4);
		
		ws4=wb4.getSheet("credentials");
		
		
	}

}
