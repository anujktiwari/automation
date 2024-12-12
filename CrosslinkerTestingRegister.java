package com.selenium.project.userleader;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class CrosslinkerTestingRegister {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		setExcelFile();
		int rowCount= getRowCount();
		for(int i=1;i<rowCount;i++)
		{
		WebDriver driver= new EdgeDriver();

			driver.manage().window().maximize();
			driver.get("https://testing.crosslinker.us/sign-up");

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.id("customer")).click();
			Thread.sleep(4000);

			driver.findElement(By.id("name")).sendKeys(getCellData(i,0));
			System.out.println(getCellData(i,0));
			driver.findElement(By.xpath("//button[@aria-controls='radix-:r0:']")).click();
			driver.findElement(By.id(":r6:")).click();
			driver.findElement(By.id("email")).sendKeys(getCellData(i,1));
			driver.findElement(By.id("password")).sendKeys(getCellData(i,2));
			driver.findElement(By.id("confirm password")).sendKeys(getCellData(i,3));
			driver.findElement(By.xpath("//button[@class='inline-flex items-center justify-center whitespace-nowrap font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 text-primary-foreground h-10 px-4 py-2 w-full rounded-sm text-lg bg-info hover:bg-slate-600']")).click();
			Thread.sleep(6000);

			driver.findElement(By.xpath("//input[@class='flex h-10 w-full rounded-md border border-input bg-background px-3 py-2 text-sm ring-offset-background file:border-0 file:bg-transparent file:text-sm file:font-medium placeholder:text-muted-foreground focus-visible:outline-none disabled:cursor-not-allowed disabled:opacity-50 focus-visible:ring-0']")).sendKeys("424242");
			driver.findElement(By.xpath("//button[@class='inline-flex items-center justify-center whitespace-nowrap font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 text-primary-foreground h-10 px-4 py-2 rounded-sm w-full text-lg bg-info hover:bg-slate-600']")).click();
			Thread.sleep(4000);

			driver.close();
		
		}
	}

static XSSFSheet sheet;
	
	public static void setExcelFile() throws IOException
	{
		FileInputStream fileInputStream= new FileInputStream("C:\\Users\\anuj\\Documents\\Clinker\\CL\\DataSet2k.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		 sheet= workbook.getSheet("Sheet2");
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
