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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class RegisterMultipleUserService {
	

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
        setExcelFile();
		
		
        int rowcount= getRowCount();
        
		for(int row=1; row<rowcount; row++) {
				
				WebDriver driver= new ChromeDriver();
				driver.get("https://service.crosslinker.us/register");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			
				System.out.println(getCellData(row, 0));

				driver.findElement(By.name("first_name")).sendKeys(getCellData(row, 0));
				driver.findElement(By.name("last_name")).sendKeys(getCellData(row, 1));
				driver.findElement(By.name("email")).sendKeys(getCellData(row, 2));
				driver.findElement(By.name("password")).sendKeys(getCellData(row, 3));
				driver.findElement(By.name("confirm_password")).sendKeys(getCellData(row, 4));

				driver.findElement(By.xpath("//img[@alt=\"Uncheck checkbox\"]")).click();
				driver.findElement(By.xpath("//button[@class='auth-btn w-full']")).click();		
				Thread.sleep(2000);				
				
				driver.quit();			
				
			
		}		

	}
	
	
	static XSSFSheet sheet;
	
	public static void setExcelFile() throws IOException
	{
		FileInputStream fileInputStream= new FileInputStream("C:\\Users\\anuj\\Documents\\UserEntryData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		 sheet= workbook.getSheet("Sheet1");
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
