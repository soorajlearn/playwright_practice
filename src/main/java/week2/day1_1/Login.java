package week2.day1_1;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Login {
	
	@Test
	public void login() {
		
		Playwright pw = Playwright.create();
		//Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Browser browser = pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
		

		// Find the user name and enter the value
		page.locator("id=username").type("demosalesmanager");
		
		// Find the password and enter the value
		page.locator("id=password").type("crmsfa");
				
		// Find the login and click
		page.locator(".decorativeSubmit").click();
		
		//Store login information
		context.storageState(
				new BrowserContext.StorageStateOptions().setPath(Paths.get("login_leaftaps.json")));
		
	}

}
