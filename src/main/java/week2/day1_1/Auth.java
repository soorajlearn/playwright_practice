package week2.day1_1;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Auth {
	
	@Test
	public void authTest() {
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext context = browser.newContext(
				new Browser.NewContextOptions().setHttpCredentials("admin", "admin"));
		Page page = context.newPage();
		page.navigate("https://the-internet.herokuapp.com/basic_auth");
		
	}

}
