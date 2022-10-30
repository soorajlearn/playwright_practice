package week2.day1_1;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FCLogin {
	
	@Test
	public void login() {
		
		Playwright pw = Playwright.create();
		//Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Browser browser = pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://branch6-auto116.freshfonehello.com");
		

		// Find the user name and enter the value
		page.locator("id=username").type("freshcaller1@gmail.com");
		
		// Find the password and enter the value
		page.locator("id=password").type("test@123");
				
		// Find the login and click
		page.locator("[type=submit]").click();
		
		//Store login information
		context.storageState(
				new BrowserContext.StorageStateOptions().setPath(Paths.get("login_fc.json")));
		
	}

}
