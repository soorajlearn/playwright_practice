package week2.day1;

import java.nio.file.Paths;

import org.junit.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class UseLoginInfo {
	
	@Test
	public void useLoginInfo() {
		
		Playwright pw = Playwright.create();
		
		Browser browser = pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(
				new Browser.NewContextOptions().setStorageStatePath(Paths.get("login_leaftaps.json")));
		Page page = context.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
		

//		// Find the user name and enter the value
//		page.locator("id=username").type("demosalesmanager");
//		
//		// Find the password and enter the value
//		page.locator("id=password").type("crmsfa");
//				
//		// Find the login and click
//		page.locator(".decorativeSubmit").click();
				
		// Click on the CRM/SFA
		page.locator("text=CRM/SFA").click();
	}

}
