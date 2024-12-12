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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class RegisterMultipleUser {
	

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
        setExcelFile();
		
		
        int rowcount= getRowCount();
        
		for(int i=1; i<rowcount; i++) {			
				
				WebDriver driver= new EdgeDriver();		
				
//				driver.manage().window().maximize();
				driver.get("https://projects.crosslinker.us/register");
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);			
				
				driver.findElement(By.name("first_name")).sendKeys(getCellData(i, 0));				
				driver.findElement(By.name("last_name")).sendKeys(getCellData(i, 1));
				driver.findElement(By.name("email")).sendKeys(getCellData(i, 2));
				driver.findElement(By.name("password")).sendKeys(getCellData(i, 3));
				driver.findElement(By.name("confirm_password")).sendKeys(getCellData(i, 4));		
				
				driver.findElement(By.xpath("//img[@src='/src/assets/images/unchecked.svg']")).click();
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
