import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	

	WebDriver driver = new ChromeDriver();

	String myWebsite = "https://magento.softwaretestingboard.com/";
	String singUpPage = "https://magento.softwaretestingboard.com/customer/account/create/";
	String myWebsite1 = "https://www.google.co.uk/";
	String[] firstNames = { "ahmad", "ali", "anas", "omar", "ayat", "alaa", "marah", "rama" };
	String[] LastNames = { "osama", "zain", "mo7md", "leen", "asma" ,"ABOOL"};
	Random rand = new Random();
	// int mynumber = rand.nextInt(8);

	@BeforeTest
	public void mySetup() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(myWebsite);
//		driver.navigate().to(myWebsite1);
//		driver.navigate().back();
//		driver.navigate().forward();
//		System.out.println(driver.getCurrentUrl().toUpperCase());
//		System.out.println(driver.getTitle());
//		Thread.sleep(5000);
//		driver.navigate().refresh();
	}

	@Test(priority = 1, invocationCount = 1)
	public void singUp() throws InterruptedException {

		// driver.findElement(By.partialLinkText("Create")).click();
		int RandomIndexForTheFirstName = rand.nextInt(firstNames.length);
		int RandomIndexForTheLastName = rand.nextInt(LastNames.length);

		String UserFirstName = firstNames[RandomIndexForTheFirstName];
		String UserLastName = LastNames[RandomIndexForTheLastName];
		int randomNumberForTheEmail = rand.nextInt(564548);
		String domainName = "@gmail.com";

		driver.findElement(By.linkText("Create an Account")).click();
		WebElement FirstNameInput = driver.findElement(By.id("firstname"));
		FirstNameInput.sendKeys(UserFirstName);
		WebElement LastNameInput = driver.findElement(By.id("lastname"));
		LastNameInput.sendKeys(UserLastName);
		WebElement EmailInput = driver.findElement(By.id("email_address"));
		EmailInput.sendKeys(UserFirstName + UserLastName + randomNumberForTheEmail + domainName);
		WebElement PasswordInput = driver.findElement(By.id("password"));
		PasswordInput.sendKeys("123aaa%aaa");
		WebElement ConfrimPasswordInput = driver.findElement(By.id("password-confirmation"));
		ConfrimPasswordInput.sendKeys("123aaa%aaa");
		WebElement CreateAnAccountInput = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
		CreateAnAccountInput.click();

	}

	@Test(priority = 2)
	public void Logout() {

		String LogoutURL = "https://magento.softwaretestingboard.com/customer/account/logoutSuccess/";
		driver.get(LogoutURL);
	}
	@Test(priority = 3)
	public void singin () {
		
	}
}
