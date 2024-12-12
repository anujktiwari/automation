package com.selenium.project.userleader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CrosslinkerProjectRegister {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		setExcelFile();
		int rowCount= getRowCount();
		for(int i=621;i>1;i--)
		{
		WebDriver driver= new EdgeDriver();		
		
//		driver.manage().window().maximize();
		driver.get("https://projects.crosslinker.us/register");				
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("name")).sendKeys(getCellData(i,0));
		driver.findElement(By.id("email")).sendKeys(getCellData(i,1));
		driver.findElement(By.id("password")).sendKeys(getCellData(i,2));
		driver.findElement(By.id("password2")).sendKeys(getCellData(i,3));
		driver.findElement(By.xpath("//button[@class='bg-[#FFCC40] border-0 py-2 px-8 focus:outline-none rounded text-lg hover:bg-[#FFCC40] text-black']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class='bg-gray-100 rounded py-2 outline-none px-4']")).sendKeys("424242");
		driver.findElement(By.xpath("//button[@class='bg-[#FFCC40] px-7 py-2 text-black rounded']")).click();
		Thread.sleep(5000);
		driver.quit();
		
		}
	}

static XSSFSheet sheet;
	
	public static void setExcelFile() throws IOException
	{
		FileInputStream fileInputStream= new FileInputStream("C:\\Users\\anuj\\Documents\\Clinker\\CL\\DataSet2k.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		 sheet= workbook.getSheet("Sheet4");
	}
		
		 public static int getRowCount() {
			return sheet.getPhysicalNumberOfRows(); 
			//System.out.println(sheet.getPhysicalNumberOfRows());
		 }
		 public static int getColumnCount() {
			return sheet.getRow(0).getPhysicalNumberOfCells();
		 }		 
		
		
	
	
	public static String getCellData(int rowNum, int colNum) {
        XSSFRow row = sheet.getRow(rowNum);
        XSSFCell cell = row.getCell(colNum);
        return cell.getStringCellValue();
        
    }
}
