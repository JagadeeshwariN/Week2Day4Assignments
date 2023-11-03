package week2.day4assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookCreateAccount {

	public static void main(String[] args) throws InterruptedException {
	
		// Launch the chrome browser
		ChromeDriver driver= new ChromeDriver();

//		Load Url
		
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		// Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//- Click on the Create new account button.
		
		driver.findElement(By.linkText("Create new account")).click();
		
		/*- Click on the Create new account button.
		- Enter the First name.
		- Enter the Surname.
		- Enter the Mobile number or email address.
		- Enter the New password.
		- Handle all three dropdowns in Date of birth
		- Select the radio button in Gender.*/
		
		
		driver.findElement(By.name("firstname")).sendKeys("Jaga");
		driver.findElement(By.name("lastname")).sendKeys("N");
		driver.findElement(By.name("reg_email__")).sendKeys("123@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("123456");
		
		WebElement birthdayDD = driver.findElement(By.name("birthday_day"));
		Select birthday = new Select(birthdayDD);
		birthday.selectByIndex(3);
		
		WebElement monthDD = driver.findElement(By.id("month"));
		Select month= new Select(monthDD);
		month.selectByVisibleText("Jun");
		
		WebElement yearDD = driver.findElement(By.id("year"));
		Select year= new Select(yearDD);
		year.selectByValue("2017");
		
		//driver.findElement(By.linkText("Female")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("websubmit")).click();
		
		Thread.sleep(3000);
		
		driver.close();

	}

}
