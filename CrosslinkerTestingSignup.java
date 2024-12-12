package com.selenium.project.userleader;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CrosslinkerTestingSignup {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

WebDriver driver= new EdgeDriver();		
		
		driver.manage().window().maximize();
		driver.get("https://testing.crosslinker.us/sign-up");				
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("customer")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("name")).sendKeys("test name");
		driver.findElement(By.xpath("//button[@aria-controls='radix-:r0:']")).click();
		driver.findElement(By.id(":r6:")).click();
		driver.findElement(By.id("email")).sendKeys("test@test.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.id("confirm password")).sendKeys("Password@123");
		driver.findElement(By.xpath("//button[@class='inline-flex items-center justify-center whitespace-nowrap font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 text-primary-foreground h-10 px-4 py-2 w-full rounded-sm text-lg bg-info hover:bg-slate-600']")).click();
	Thread.sleep(4000);
	driver.close();
	}

}
