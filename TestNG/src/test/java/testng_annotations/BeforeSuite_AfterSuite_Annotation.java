package testng_annotations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BeforeSuite_AfterSuite_Annotation {
	public WebDriver driver;

	@BeforeSuite
	public void login() throws InterruptedException {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement username = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		username.sendKeys("Admin");
		Thread.sleep(2000);
		WebElement password = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		password.sendKeys("admin123");
		Thread.sleep(2000);
		WebElement login = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		login.click();
		Thread.sleep(2000);
	}

	@Test
	public void add_User() throws InterruptedException {

		WebElement admin = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a"));
		admin.click();
		Thread.sleep(2000);
		WebElement add_User = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
		add_User.click();
		Thread.sleep(2000);
	}

	@Test
	public void add_Employee() throws InterruptedException {

		WebElement pim = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
		pim.click();
		Thread.sleep(2000);
		WebElement add_Employee = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
		add_Employee.click();
		Thread.sleep(2000);

	}
	@AfterSuite
	public void close_Browser() throws InterruptedException {
		WebElement user_id = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p"));
		user_id.click();
		Thread.sleep(2000);
		WebElement logout = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]"));
		logout.click();
		Thread.sleep(2000);
		driver.close();
	}
}