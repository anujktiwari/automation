package com.selenium.project.userleader;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class UserleaderApplication {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new EdgeDriver();

		driver.get("https://service.crosslinker.us/register");
		/*
		WebDriverWait wait = new WebDriverWait (driver, 30);
		*/
		driver.manage().window().maximize();

		FileInputStream fis = new FileInputStream("C:\\Users\\anuj\\Documents\\UserEntryData.xlsx");

		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = xssfWorkbook.getSheet("Sheet1");

		int rowCount = sheet.getLastRowNum();

		int colCount = sheet.getRow(1).getLastCellNum();

		System.out.println("Row Count = " + rowCount + " Column count = " + colCount);

		for(int row=0; row<=rowCount; row++){

			XSSFRow cellData = sheet.getRow(row);

			String firstName = cellData.getCell(0).getStringCellValue();
			String lastName = cellData.getCell(1).getStringCellValue();
			String email = cellData.getCell(2).getStringCellValue();
			String password = cellData.getCell(3).getStringCellValue();
			String confirmPassword = cellData.getCell(4).getStringCellValue();

			driver.findElement(By.name("#first_name")).clear();
			driver.findElement(By.name("#first_name")).sendKeys(firstName);
			driver.findElement(By.name("#last_name")).clear();
			driver.findElement(By.name("#last_name")).sendKeys(lastName);
			driver.findElement(By.name("#email")).clear();
			driver.findElement(By.name("#email")).sendKeys(email);
			driver.findElement(By.name("#password")).clear();
			driver.findElement(By.name("#password")).sendKeys(password);
			driver.findElement(By.name("#confirm_password")).clear();
			driver.findElement(By.name("#confirm_password")).sendKeys(confirmPassword);


			driver.findElement(By.xpath("//*[@type='submit']")).click();


			System.out.println(firstName + "||" + lastName + "||" + email +"||"+ password+"||"+ confirmPassword);

		}

		/* driver.quit(); */
	}
}
