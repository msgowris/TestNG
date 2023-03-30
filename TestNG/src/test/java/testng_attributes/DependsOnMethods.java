package testng_attributes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DependsOnMethods {
	public WebDriver driver;

	@BeforeClass
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
	public void admin() throws InterruptedException {

		WebElement admin = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a"));
		admin.click();
		Thread.sleep(2000);
		WebElement add_User = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
		add_User.click();
		Thread.sleep(2000);

	}

	@Test(dependsOnMethods = "admin")
	public void pim() throws InterruptedException {

		WebElement pim = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a"));
		pim.click();
		Thread.sleep(2000);
		WebElement add_Employee = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
		add_Employee.click();
		Thread.sleep(2000);

	}

	@Test(dependsOnMethods = { "admin", "pim" })
	public void my_Info() throws InterruptedException {

		WebElement my_info = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a"));
		my_info.click();
		Thread.sleep(2000);
	}

	@Test
	public void dashboard() throws InterruptedException {

		WebElement dashboard = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[8]/a/span"));
		dashboard.click();
		Thread.sleep(2000);
	}

	@Test
	public void leave() throws InterruptedException {

		WebElement leave = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a"));
		leave.click();
		Thread.sleep(2000);
	}

	@AfterClass
	public void logout() throws InterruptedException {
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
