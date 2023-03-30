package testng_annotations;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name = "LoginData")
	public Object[][] loginData() {
		
		Object[][] login_data = { { "Admin", "admin123" }, { "Admin", "admin123" } };
		return login_data;
	}
}
