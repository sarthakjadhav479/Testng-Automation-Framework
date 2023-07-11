package com.fc.india.web.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brower_Login_Script 
{
	
	
	/*public static class SwitchTab 
	{
		static void SwitchingTab() throws InterruptedException   
	{ 
		WebDriver driver= new ChromeDriver();
		 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	      //switch to new tab
	     driver.switchTo().window(newTb.get(1));
	     Thread.sleep(2000);
	     driver.close();
	     driver.switchTo().window(newTb.get(0));
		 Thread.sleep(3000);
	}*/
	
	
	public static void main(String[] args) throws InterruptedException, MessagingException, IOException
	{
		
		System.setProperty("webdriver.chrome.driver","/home/sayali/driver/chromedriver");
		
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.firstcry.com/m/login?URL=https://www.firstcry.com/");
		driver.manage().window().maximize();
		//Enter email ID
		WebElement txtbox_email = driver.findElement(By.id("lemail"));
		driver.findElement(By.xpath("//*[@id=\"login\"]/div[3]")).click();
		Thread.sleep(2000);
		
		txtbox_email.sendKeys("sayalidaunde1997@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"login\"]/div[3]")).click();
		Thread.sleep(50000);
		
		
		driver.findElement(By.id("verfiedbtn")).click();
		Thread.sleep(3000);
		
		driver.get("https://www.firstcry.com/indiamyaccount/orderhistory");
		driver.findElement(By.id("widgetpopimgid")).click();
		Thread.sleep(12000);
		
		//Closing ticket pane
		//driver.findElement(By.xpath("(//*[@class=\"img-cross cross-on-pane\"])")).click();
		//Thread.sleep(60000);
		
		driver.findElement(By.xpath("(//*[@class=\"other-blk-se mrg-con M15_ff\"])")).click();
		Thread.sleep(3000);
		//Opening Other Query Intent
		driver.findElement(By.xpath("//span[normalize-space()='Other Queries']")).click();
		Thread.sleep(4000);
		//Opening Policies
		driver.findElement(By.xpath("//span[normalize-space()='Policies']")).click();
	    Thread.sleep(2000);
	    
	    //Opening Return Policy
	    driver.findElement(By.xpath("//span[normalize-space()='Return Policy']")).click();
	    Thread.sleep(2000);
	    //Verifying Return Policy Text Message
		String Expected_Return_Policy = "To know more about the Return Policy, please click on Return Policy";
		String Actual_Return_Policy = driver.findElement(By.xpath("(//*[@class=\"botboldtext R14_21\"])[7]")).getText();
		System.out.println(Actual_Return_Policy);
		 if(Expected_Return_Policy.equals(Actual_Return_Policy))
		 	{
		        System.out.println("Pass: Correct Retun Message");
		    }
		        else 
		    {
		        System.out.println("Fail: Incorrect Return Message");
		    }
		 //To verify that hyperlink is working or not
		 
		 driver.findElement(By.xpath("//a[normalize-space()='Return Policy']")).click();
		 Thread.sleep(2000);
		 
		 //SwitchingTab();
		 
		 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	      //switch to new tab
	     driver.switchTo().window(newTb.get(1));
	     Thread.sleep(2000);
	     driver.close();
	     driver.switchTo().window(newTb.get(0));
		 Thread.sleep(3000);
		 
		 //Handling Was This Helpful?
		 driver.findElement(By.xpath("//span[@class='other-blk-se mrg-con M15_ff']")).click();
		 Thread.sleep(4000);    
		 //Opening Cancellation Policy
		 driver.findElement(By.xpath("//span[normalize-space()='Policies']")).click();
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//span[contains(text(),'Cancellation Policy')]")).click();
		 Thread.sleep(4000);
	     //Verifying Cancellation Policy Text Message
	     String Expected_Cancel_Policy = "To know more about the Cancellation Policy, please click on Cancellation Policy";
	     List<WebElement> elements = driver.findElements(By.cssSelector("div.message.frombot"));

	        // Get the last element's text
	        WebElement lastElement = elements.get(elements.size() - 2);
	        String Actual_Cancel_Policy = lastElement.getText();
	        System.out.println("Text of the last element: " + Actual_Cancel_Policy);

	     if(Expected_Cancel_Policy.equals(Actual_Cancel_Policy))
	     	{
	    	 System.out.println("Pass: Correct Cancellation Message");
	     	}
		        else 
		    {
		        System.out.println("Fail: Incorrect Cancellation Message");
		    }
	     Thread.sleep(4000);
	    //To verify that hyperlink is working or not
	     //driver.findElement(By.xpath("//*[@id=\"cbmsg\"]/div[1]/div/div/span/div/a")).click();
	     driver.findElement(By.linkText("Cancellation Policy")).click();
	     Thread.sleep(2000);
	    
	     ArrayList<String> newTb1 = new ArrayList<String>(driver.getWindowHandles());
	      //switch to new tab
	     driver.switchTo().window(newTb1.get(1));
	     Thread.sleep(2000);
	     driver.close();
	     driver.switchTo().window(newTb1.get(0));
		 Thread.sleep(3000);
		 
		 //Handling Was This Helpful?
		 driver.findElement(By.xpath("//span[@class='other-blk-se mrg-con M15_ff']")).click();
		 Thread.sleep(2000);
		 
	     //Verifying Shipping Policy
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//*[@id=\"multiButton\"])[1]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[contains(text(),'Shipping Policy')]")).click();
		 Thread.sleep(2000);
		 //Verifying Text
		 String Expected_Text = "To know more about the Shipping Policy, please click on Shipping Policy";
		 List<WebElement> elements1 = driver.findElements(By.cssSelector("div.message.frombot"));

	        // Get the last element's text
	        WebElement lastElement1 = elements1.get(elements1.size() - 2);
	        String Actual_shipping_Policy = lastElement1.getText();
	        System.out.println("Text of the last element: " + Actual_shipping_Policy);
		 if(Expected_Text.equals(Actual_shipping_Policy))
		 {
			 System.out.println("Pass: Correct Shipping Message");
		 }
		 else
		 {
			 System.out.println("Fail : Incorrect Shipping Message");
		 }

		 Thread.sleep(2000);
		 
		 //To verify that hyperlink is working or not
		 driver.findElement(By.linkText("Shipping Policy")).click();
		 Thread.sleep(2000);
		    
	     // //switch to new tab
		 ArrayList<String> newTb2 = new ArrayList<String>(driver.getWindowHandles());
	     driver.switchTo().window(newTb2.get(1));
	     Thread.sleep(2000);
	     driver.close();
	     driver.switchTo().window(newTb2.get(0));
		 Thread.sleep(3000);
		 
		 //Handling Was This Helpful?
		 driver.findElement(By.xpath("//span[@class='other-blk-se mrg-con M15_ff']")).click();
		 Thread.sleep(3000);
		 
		//Verifying Payment Related Policy
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//*[@id=\"multiButton\"])[1]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//span[normalize-space()='Payment related policy']")).click();
		 Thread.sleep(2000);
		
		 //Verifying Text
		 String Expected_Text_Payment = "To know more about the Payment Related Policy, please click on Payment Related Policy";
		 List<WebElement> elements2 = driver.findElements(By.cssSelector("div.message.frombot"));

	        // Get the last element's text
	        WebElement lastElement2 = elements2.get(elements2.size() - 2);
	        String Actual_Payment_Policy = lastElement2.getText();
	        System.out.println("Text of the last element: " + Actual_Payment_Policy);
		 
		 if(Expected_Text_Payment.equals(Actual_Payment_Policy))
		 {
			 System.out.println("Pass Correct Payment Text");
		 }
		 else
		 {
			 System.out.println("Fail Incorrect Payment Text");
		 }
		 Thread.sleep(2000);
		 
		//To verify that hyperlink is working or not
		 driver.findElement(By.partialLinkText("Payment Related")).click();
		 
		 // //switch to new tab
		 ArrayList<String> newTb3 = new ArrayList<String>(driver.getWindowHandles());
	     driver.switchTo().window(newTb3.get(1));
	     Thread.sleep(2000);
	     driver.close();
	     driver.switchTo().window(newTb3.get(0));
		 Thread.sleep(3000);
		 
		 //Handling Was This Helpful?
		 driver.findElement(By.xpath("//span[@class='other-blk-se mrg-con M15_ff']")).click();
		 Thread.sleep(3000);
		 
		 //Verifying Terms and Use
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//*[@id=\"multiButton\"])[1]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[normalize-space()='Term of use']")).click();
		 Thread.sleep(2000);
		 
		 //Verifying Text
		 String Expected_Text_Terms = "To know more about the Terms of use, please click on Terms of use";
		 List<WebElement> elements3 = driver.findElements(By.cssSelector("div.message.frombot"));

	        // Get the last element's text
	        WebElement lastElement3 = elements3.get(elements3.size() - 2);
	        String Actual_Terms_Policy = lastElement3.getText();
	        System.out.println("Text of the last element: " + Actual_Terms_Policy);
		 if(Expected_Text_Terms.equals(Actual_Terms_Policy))
		 {
			 System.out.println("Pass Correct Terms Text");
		 }
		 else
		 {
			 System.out.println("Fail Incorrect Terms Text");
		 }
		 Thread.sleep(2000);
		 
		//To verify that hyperlink is working or not
		 driver.findElement(By.linkText("Terms of use")).click();
		 // //switch to new tab
		 ArrayList<String> newTb4 = new ArrayList<String>(driver.getWindowHandles());
	     driver.switchTo().window(newTb4.get(1));
	     Thread.sleep(2000);
	     driver.close();
	     driver.switchTo().window(newTb4.get(0));
		 Thread.sleep(3000);
		 
		//Handling Was This Helpful?
		 driver.findElement(By.xpath("//span[@class='other-blk-se mrg-con M15_ff']")).click();
		 Thread.sleep(3000);
		 
		 //Verifying Privacy Policy
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//*[@id=\"multiButton\"])[1]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[normalize-space()='Privacy policy']")).click();
		 
		//Verifying Text
		 String Expected_Text_Privacy = "To know more about the Privacy Policy, please click on Privacy Policy";
		 List<WebElement> elements4 = driver.findElements(By.cssSelector("div.message.frombot"));

	        // Get the last element's text
	        WebElement lastElement4 = elements4.get(elements4.size() - 1);
	        String Actual_Privacy_Policy = lastElement4.getText();
	        System.out.println("Text of the last element: " + Actual_Privacy_Policy);
		 if(Expected_Text_Privacy.equals(Actual_Privacy_Policy))
		 {
			 System.out.println("Pass Correct Privacy Text");
		 }
		 else
		 {
			 System.out.println("Fail Incorrect Privacy Text");
		 }
		 Thread.sleep(2000);
		 //To verify that hyperlink is working or not
		 driver.findElement(By.linkText("Privacy Policy")).click();
		 Thread.sleep(3000);
		 // //switch to new tab
		 ArrayList<String> newTb5 = new ArrayList<String>(driver.getWindowHandles());
	     driver.switchTo().window(newTb5.get(1));
	     Thread.sleep(2000);
	     driver.close();
	     driver.switchTo().window(newTb5.get(0));
		 Thread.sleep(3000);
		 
		//Handling Was This Helpful?
		 driver.findElement(By.xpath("//span[@class='other-blk-se mrg-con M15_ff']")).click();
		 Thread.sleep(3000);
		 
		 //Verifying FAQ
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//*[@id=\"multiButton\"])[1]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[normalize-space()='FAQ']")).click();
		 Thread.sleep(2000);
		 
		 //Verifying Text
		 String Expected_Text_FAQ = "To know more about the Terms of use, please click on FAQ";
		 List<WebElement> elements5 = driver.findElements(By.cssSelector("div.message.frombot"));

	        // Get the last element's text
	        WebElement lastElement5 = elements5.get(elements5.size() - 2);
	        String Actual_FAQ_Policy = lastElement5.getText();
	        System.out.println("Text of the last element: " + Actual_FAQ_Policy);
		 if(Expected_Text_FAQ.equals(Actual_FAQ_Policy))
		 {
			 System.out.println("Pass Correct FAQ Text");
		 }
		 else
		 {
			 System.out.println("Fail Incorrect FAQ Text");
		 }
		 Thread.sleep(2000);
		 
		 //To verify that hyperlink is working or not
		 driver.findElement(By.linkText("FAQ")).click();
		 Thread.sleep(3000);
		 // //switch to new tab
		 ArrayList<String> newTb6 = new ArrayList<String>(driver.getWindowHandles());
	     driver.switchTo().window(newTb6.get(1));
	     Thread.sleep(2000);
	     driver.close();
	     driver.switchTo().window(newTb6.get(0));
		 Thread.sleep(3000);
		
	}

	/*private static void SwitchingTab() throws InterruptedException 
	{
		 WebDriver driver= new ChromeDriver();
		 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	      //switch to new tab
	     driver.switchTo().window(newTb.get(1));
	     Thread.sleep(2000);
	     driver.close();
	     driver.switchTo().window(newTb.get(0));
		 Thread.sleep(3000);
		
	}*/
	
}
	
	
	
	

		
	

		
	
	
	
	

