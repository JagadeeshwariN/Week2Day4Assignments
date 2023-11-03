package week2.day4assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		
// Launch the chrome browser
		
		ChromeDriver driver= new ChromeDriver();

//		Load Url
		
		driver.get("http://leaftaps.com/opentaps/");
		
// Maximize Window	
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
	// Enter username password and click Login	
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// Click Button CRM/SFA
		
		driver.findElement(By.linkText("CRM/SFA")).click();
	
		// Click Accounts tab	and Click CreateAccount Button
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.linkText("Create Account")).click();
		
		//Enter Account name & Description
		WebElement accountName = driver.findElement(By.id("accountName"));
		accountName.sendKeys("Jagadeeshwari_Test Leaf");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		
		/*
		 * - Select "ComputerSoftware" as the industry.
		 *  - Select "S-Corporation" as ownership using SelectByVisibleText. 
		 *  - Select "Employee" as the source using SelectByValue. 
		 *  - Select "eCommerce Site Internal Campaign" as the marketing campaign using SelectByIndex. 
		 *  - Select "Texas" as the state/province using SelectByValue.
		 */
		Thread.sleep(3000);
		
		WebElement industryDD = driver.findElement(By.name("industryEnumId"));
		Select industry =new Select(industryDD);
		industry.selectByIndex(3);
		
		Thread.sleep(3000);
		WebElement ownershipDD = driver.findElement(By.name("ownershipEnumId"));
		Select ownership = new Select(ownershipDD);
		ownership.selectByVisibleText("S-Corporation");
		
		WebElement sourceDD = driver.findElement(By.id("dataSourceId"));
		Select source = new Select(sourceDD);
		source.selectByValue("LEAD_EMPLOYEE");
		
		WebElement marketingCampaignDD = driver.findElement(By.id("marketingCampaignId"));
		Select marketingCampaign = new Select(marketingCampaignDD);
		marketingCampaign.selectByIndex(6);
		
		WebElement stateOrProvinceDD = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select stateOrProvince =  new Select(stateOrProvinceDD);
		stateOrProvince.selectByValue("TX");
		
		//Click Create Account Button
		
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(3000);
		
		// System.out.println(accountName);
        driver.close();
        		
	}

}
